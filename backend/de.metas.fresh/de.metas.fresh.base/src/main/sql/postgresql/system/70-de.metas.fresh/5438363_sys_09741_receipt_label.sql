DROP FUNCTION IF EXISTS report.receipt_label(IN M_HU_ID numeric);

CREATE FUNCTION report.receipt_label(IN M_HU_ID numeric) RETURNS TABLE
	(
	vendoraddress text, 
	vendorgap Character Varying, 
	produceraddress text,
	producergap Character Varying,
	Herkunft Character Varying,
	Charge Character Varying,
	Label Character Varying,
	Anbau Character Varying,
	LotNumberDate Character Varying,
	orderdocNo Character Varying,
	p_name Character Varying,
	adr Character Varying,
	receiptdate Date,
	Beurteilung numeric,
	notiz Character Varying,
	zusatz Character Varying,
	tracking Character Varying,
	mhd Character Varying,
	receiptdocno Character Varying,
	PackingInstruction Character Varying,
	deliverydate timestamp without time zone
	)
AS 
$$

SELECT distinct
(SELECT DISTINCT Regexp_Replace(o.BPartnerAddress, E'\n', ', ', 'g')
		FROM C_OrderLine ol
		INNER JOIN C_Order o ON ol.C_Order_ID = o.C_Order_ID
		WHERE ol.C_OrderLine_ID = (t.TU_Attrs).PurchaseOrderLine_Value
)  AS vendoraddress

  ,vendorbp.naics AS vendorgap
 	,(
		SELECT	COALESCE(bp.name||', ', '') || Regexp_Replace(address, E'\n', ', ', 'g')
		FROM	C_BPartner bp
			INNER JOIN C_BPartner_Location bpl ON bp.C_BPartner_ID = bpl.C_BPartner_ID
		WHERE	bpl.C_BPartner_ID =  (t.TU_Attrs).SubProducerBPartner_Value
		LIMIT 1
	) AS produceraddress
	,producerbp.naics AS producergap
 , (t.TU_Attrs).herkunft_name AS Herkunft
 , (t.TU_Attrs).lotnumber_value AS Charge
  ,(t.TU_Attrs).label_name AS Label
  ,(t.TU_Attrs).produktionsart_name AS Anbau
   ,"de.metas.handlingunits".HU_LotNumberDate_ToString((t.TU_Attrs).lotnumberdate_value::date) AS LotNumberDate
  ,(
		SELECT DISTINCT o.documentno
		FROM C_OrderLine ol
		INNER JOIN C_Order o ON ol.C_Order_ID = o.C_Order_ID
		WHERE ol.C_OrderLine_ID = (t.TU_Attrs).PurchaseOrderLine_Value
		LIMIT 1
	) AS orderdocNo
  ,p.name AS p_name
  ,(t.TU_Attrs).adr_name AS adr
  ,(SELECT created FROM M_HU WHERE M_HU_ID=TU_HU_ID)::date AS receiptdate
  ,(t.TU_Attrs).qualitydiscountpercent_value AS Beurteilung
  ,(t.TU_Attrs).qualitynotice_name AS notiz
  ,(t.TU_Attrs).zitrus_name AS zusatz
  ,tr.lot AS tracking
  ,(t.TU_Attrs).mhd_value AS mhd
  ,COALESCE(luvalue,tuvalue) AS receiptdocno
  ,hu_piip.Name AS PackingInstruction

	,(
		SELECT DISTINCT io.movementdate
		FROM M_InOutLine iol
		INNER JOIN M_InOut io on iol.M_InOut_ID = io.M_InOut_ID
		WHERE iol.M_InOutLine_ID=(t.TU_Attrs).ReceiptInOutLine_Value
	) AS deliverydate
FROM (
 SELECT
  lu.M_HU_ID as LU_HU_ID
  , tu.M_HU_ID as TU_HU_ID
  , lu.value as luvalue, tu.value as tuvalue
  , "de.metas.handlingunits".getHUAttributes(tu.M_HU_ID, p_FillPurchaseDocInfo := true) as TU_Attrs
  ,lu.C_BPartner_ID as C_BPartner_ID
 FROM
 "de.metas.handlingunits".get_All_TUs($1) tu
 left outer join M_HU_Item lui on (lui.M_HU_Item_ID=tu.M_HU_Item_Parent_ID)
 left outer join M_HU lu on (lu.M_HU_ID=lui.M_HU_ID)
) t
LEFT OUTER JOIN C_BPartner vendorbp ON (SELECT C_BPartner_ID FROM M_HU WHERE M_HU_ID = TU_HU_ID) =vendorbp.C_BPartner_ID
LEFT OUTER JOIN C_BPartner producerbp ON (t.TU_Attrs).SubProducerBPartner_Value = producerbp.C_BPartner_ID
INNER JOIN M_HU_Storage lus ON TU_HU_ID = lus.M_HU_ID
INNER JOIN M_Product p ON lus.M_product_ID = p.M_Product_ID
LEFT OUTER JOIN M_Material_Tracking tr ON (t.TU_Attrs).materialtracking_value = tr.M_Material_Tracking_ID
LEFT OUTER JOIN M_HU_PI_Item_Product hu_piip ON hu_piip.M_HU_PI_Item_Product_ID = (SELECT M_HU_PI_Item_Product_ID FROM M_HU WHERE M_HU_ID=TU_HU_ID)


$$
  LANGUAGE sql STABLE