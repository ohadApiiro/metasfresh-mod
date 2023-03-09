DROP FUNCTION IF EXISTS de_metas_endcustomer_fresh_reports.Docs_Sales_Customs_Invoice_Root ( IN Record_ID numeric, IN AD_Language Character Varying (6) );
CREATE OR REPLACE FUNCTION de_metas_endcustomer_fresh_reports.Docs_Sales_Customs_Invoice_Root ( IN Record_ID numeric, IN AD_Language Character Varying (6) )
RETURNS TABLE 
	(AD_Org_ID numeric,
	DocStatus character(2),
	PrintName character varying(60),
	countrycode character(2),
	displayhu text
	)
AS
$$	
SELECT
	i.AD_Org_ID,
	i.DocStatus,
	dt.PrintName,
	c.countrycode,
	CASE
		WHEN
		EXISTS(
			SELECT 0
			FROM C_Customs_Invoice_Line il
			INNER JOIN M_Product p ON il.M_Product_ID = p.M_Product_ID AND p.isActive = 'Y'
			INNER JOIN M_Product_Category pc ON p.M_Product_Category_ID = pc.M_Product_Category_ID AND pc.isActive = 'Y'
			WHERE pc.M_Product_Category_ID = getSysConfigAsNumeric('PackingMaterialProductCategoryID', il.AD_Client_ID, il.AD_Org_ID)
			AND il.C_Customs_Invoice_ID = i.C_Customs_Invoice_ID AND il.isActive = 'Y'
		)
		THEN 'Y'
		ELSE 'N'
	END as displayhu
FROM
	C_Customs_Invoice  i
	INNER JOIN C_DocType dt ON i.C_DocType_ID = dt.C_DocType_ID AND dt.isActive = 'Y'
	LEFT OUTER JOIN C_DocType_Trl dtt ON i.C_DocType_ID = dtt.C_DocType_ID AND dtt.AD_Language = $2 AND dtt.isActive = 'Y'

	LEFT OUTER JOIN AD_OrgInfo orginfo ON orginfo.ad_org_id = i.ad_org_id AND orginfo.isActive = 'Y'
	LEFT OUTER JOIN C_BPartner_Location org_loc ON orginfo.Orgbp_Location_ID = org_loc.C_BPartner_Location_ID AND org_loc.isActive = 'Y'
	LEFT OUTER JOIN C_Location org_l ON org_loc.C_Location_ID = org_l.C_Location_ID AND org_l.isActive = 'Y'
	LEFT OUTER JOIN C_Country c ON org_l.C_Country_ID = c.C_Country_ID AND c.isActive = 'Y'
WHERE
	i.C_Customs_Invoice_ID = $1 AND i.isActive = 'Y'
$$
LANGUAGE sql STABLE	
;