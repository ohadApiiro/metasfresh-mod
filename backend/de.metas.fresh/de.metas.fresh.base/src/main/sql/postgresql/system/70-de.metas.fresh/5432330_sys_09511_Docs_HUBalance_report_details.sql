

DROP FUNCTION IF EXISTS de_metas_endcustomer_fresh_reports.Docs_HUBalance_Report_Details(numeric, numeric, date, date, date);

DROP TABLE IF EXISTS de_metas_endcustomer_fresh_reports.Docs_HUBalance_Report_Details;

-- Table: de_metas_endcustomer_fresh_reports.docs_hubalance_report_details

CREATE TABLE de_metas_endcustomer_fresh_reports.Docs_HUBalance_Report_Details
(
  documentno character varying,
  printname character varying,
  movementdate date,
  "name" character varying,
  outgoing numeric,
  incoming numeric,
  carryoutgoing numeric,
  carryincoming numeric,
  uomsymbol character varying
)
WITH (
  OIDS=FALSE
);


-- Function: de_metas_endcustomer_fresh_reports.docs_hubalance_report_details(numeric, numeric, date, date, date)

CREATE OR REPLACE FUNCTION de_metas_endcustomer_fresh_reports.Docs_HUBalance_Report_Details(m_material_balance_config_id numeric, c_bpartner_id numeric, startdate date, enddate date, refdate date)
  RETURNS SETOF de_metas_endcustomer_fresh_reports.Docs_HUBalance_Report_Details AS
$BODY$
SELECT
	mbd.DocumentNo,
	dt.PrintName,
	mbd.MovementDate::date,
	p.Name, --Product
	SUM (mbd.QtyOutgoing) AS Outgoing,
	SUM (mbd.QtyIncoming) AS Incoming,
	COALESCE( CarryOutgoing, 0 ) AS CarryOutgoing,
	COALESCE( CarryIncoming, 0 ) AS CarryIncoming,
	UOMSymbol
FROM
	M_Material_Balance_Config mbc
	INNER JOIN M_Material_Balance_Detail mbd ON mbc.M_Material_Balance_Config_ID = mbd.M_Material_Balance_Config_ID
	INNER JOIN C_UOM uom ON mbd.C_UOM_ID = uom.C_UOM_ID
	INNER JOIN C_DocType dt ON mbd.C_DocType_ID = dt.C_DocType_ID
	INNER JOIN M_Product p ON mbd.M_Product_ID = p.M_Product_ID
	INNER JOIN M_InOutLine iol ON mbd.M_InOutLine_ID = iol.M_InOutLine_ID
	LEFT OUTER JOIN (
		SELECT	SUM( QtyIncoming ) AS CarryIncoming, SUM( QtyOutgoing ) AS CarryOutgoing, mbd.M_Product_ID, mbd.C_BPartner_ID
		FROM	M_Material_Balance_Detail mbd
			INNER JOIN M_Material_Balance_Config mbc ON mbd.M_Material_Balance_Config_ID = mbc.M_Material_Balance_Config_ID
		WHERE	MovementDate <= $3 AND ( mbd.IsReset = 'N' OR ( mbd.IsReset = 'Y' AND mbd.ResetDateEffective > $5 ))
		GROUP BY mbd.M_Product_ID, mbd.C_BPartner_ID
	) carry ON mbd.C_BPartner_ID = carry.C_BPartner_ID AND mbd.M_Product_ID = carry.M_Product_ID
WHERE
	mbc.M_Material_Balance_Config_ID = $1
	AND mbd.isActive = 'Y'
	AND ( mbd.IsReset = 'N' OR ( mbd.IsReset = 'Y' AND mbd.ResetDateEffective > $5 ))
	AND mbd.C_BPartner_ID = $2
	AND COALESCE( mbd.MovementDate >= $3, true )
	AND COALESCE( mbd.MovementDate <= $4, true )
GROUP BY
	mbd.DocumentNo,
	dt.PrintName,
	mbd.MovementDate,
	p.Name,
	CarryIncoming,
	CarryOutgoing,
	UOMSymbol
ORDER BY
	p.Name, mbd.MovementDate, mbd.DocumentNo
$BODY$
  LANGUAGE sql VOLATILE
  COST 100
  ROWS 1000;
