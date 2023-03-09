DROP FUNCTION IF EXISTS de_metas_endcustomer_fresh_reports.Docs_HUBalance_Report_General_Day(date, numeric, numeric, numeric, numeric, character varying, numeric);
DROP FUNCTION IF EXISTS de_metas_endcustomer_fresh_reports.Docs_HUBalance_Report_General_Day(date, numeric, numeric, numeric, numeric, character varying, numeric, character varying(6));

CREATE OR REPLACE FUNCTION de_metas_endcustomer_fresh_reports.Docs_HUBalance_Report_General_Day(refdate date, C_BPartner_ID numeric, C_BP_Group_ID numeric, M_Product_ID numeric, m_material_balance_config_id numeric, isGebindeFlatrate character varying, IN ad_org_id numeric, IN ad_language character varying(6)) RETURNS TABLE
	(
  bpartnerno character varying, 
  bpartner character varying, 	
  bpartner_group character varying,	
  art_contract character varying, 
  art_name character varying,
  outgoing numeric,
  incoming numeric,	
  bpartner_param character varying, 	
  bpartner_group_param character varying, 
  product_param character varying,	
  ad_org_id numeric 
	)
AS 
$$
SELECT
	bp.value as bpartnerno,
	bp.name as bpartner, 
	bpg.Name as bpartner_group,
	CASE WHEN fm.C_Flatrate_Matching_ID IS NOT NULL THEN fc.name ELSE NULL END as art_contract,
	COALESCE(pt.Name, p.Name) as art_name, --Product
	SUM (mbd.QtyOutgoing) AS Outgoing,
	SUM (mbd.QtyIncoming) AS Incoming,

	(select name from C_BPartner where C_BPartner_ID = $2 AND isActive = 'Y') as bpartner_param,
	(select name from C_BP_Group where C_BP_Group_ID = $3 AND isActive = 'Y') as bpartner_group_param,
	(select COALESCE(pt.name, p.Name) 
		from M_Product p
		left join m_product_trl pt on p.m_product_id = pt.m_product_id and pt.ad_language=$8 and pt.isActive = 'Y'
		where p.M_Product_ID = $4 AND p.isActive = 'Y') as product_param,

	mbd.ad_org_id	
FROM
	M_Material_Balance_Config mbc
	INNER JOIN M_Material_Balance_Detail mbd ON mbc.M_Material_Balance_Config_ID = mbd.M_Material_Balance_Config_ID
	INNER JOIN C_BPartner bp on mbd.C_BPartner_ID = bp.C_BPartner_ID AND bp.isActive = 'Y'
	INNER JOIN M_Product p ON mbd.M_Product_ID = p.M_Product_ID and case when  $4 >0 then p.M_Product_ID = $4 else 1=1 end AND p.isActive = 'Y'
	LEFT JOIN M_Product_Trl pt ON p.M_Product_ID = pt.M_Product_ID AND pt.ad_language = $8 AND pt.isActive = 'Y'
	INNER JOIN M_InOutLine iol ON mbd.M_InOutLine_ID = iol.M_InOutLine_ID AND iol.isActive = 'Y'
	LEFT OUTER JOIN c_bp_group bpg on bpg.c_bp_group_id = bp.c_bp_group_id AND bpg.isActive = 'Y'
	LEFT OUTER JOIN C_FLatrate_Data fd on fd.C_BPartner_ID = mbd.C_BPartner_ID AND fd.isActive = 'Y'
	LEFT OUTER JOIN C_FLatrate_Term ft ON ft.C_Flatrate_Data_ID = fd.C_Flatrate_Data_ID  and (ft.M_Product_ID is null or ft.M_Product_ID = p.M_Product_ID) and ft.startdate<=$1 and ft.enddate>=$1  AND ft.isActive = 'Y'
	LEFT OUTER JOIN C_FLatrate_Conditions fc on ft.C_FLatrate_Conditions_ID = fc.C_FLatrate_Conditions_ID and fc.Type_Conditions = 'Refundable' AND fc.isActive = 'Y'
	LEFT OUTER JOIN C_Flatrate_Matching fm on fm.C_FLatrate_Conditions_ID = fc.C_FLatrate_Conditions_ID AND  (fm.M_Product_ID = p.M_Product_ID OR ft.M_Product_ID = p.M_Product_ID OR (fm.M_Product_Category_Matching_ID  = p.M_Product_Category_ID AND fm.M_Product_ID IS NULL)) AND fm.isActive = 'Y'
WHERE
	mbc.M_Material_Balance_Config_ID = $5 AND mbc.isActive = 'Y'
	AND mbd.isActive = 'Y'
	AND ( mbd.IsReset = 'N' OR ( mbd.IsReset = 'Y' AND mbd.ResetDateEffective::date > $1 ))
	AND (
		case when $2 > 0 
		then mbd.C_BPartner_ID = $2
		else
		1=1
		end
		)
	AND (
		case when $3 > 0
		then bpg.C_BP_Group_ID = $3
		else 1=1
		end
		)
	AND (
		case when $4 > 0 
		then mbd.M_Product_ID = $4
		else
		1=1
		end
		)	
	AND COALESCE( mbd.MovementDate::date <= $1, true )
	AND (
		case when $6 = 'Y' 
		then fm.C_Flatrate_Matching_ID IS NOT NULL
		when $6 = 'N'
		then fm.C_Flatrate_Matching_ID IS NULL
		else
		1=1
		end
		)
	AND mbd.ad_org_id = $7
GROUP BY
	bp.value,
	bp.name, 
	bpg.Name,
	fc.name,
	COALESCE(pt.Name, p.Name),
	fm.C_Flatrate_Matching_ID,
	mbd.ad_org_id

ORDER BY
    bp.name,
    COALESCE(pt.Name, p.Name)
			
$$
  LANGUAGE sql STABLE


