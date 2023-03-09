﻿--
-- if you change here, make sure saldobilanz_Report is also up to date !
--
DROP FUNCTION IF EXISTS report.saldobilanz_summary_Report_sub (IN Date, IN defaultAcc character varying, IN showCurrencyExchange character varying, IN ad_org_id numeric(10,0), IN p_IncludePostingTypeStatistical char(1));
DROP FUNCTION IF EXISTS report.saldobilanz_summary_Report_sub (IN Date, IN defaultAcc character varying, IN showCurrencyExchange character varying, IN ad_org_id numeric(10,0), IN p_IncludePostingTypeStatistical char(1), IN p_ExcludePostingTypeYearEnd char(1));

DROP TABLE IF EXISTS report.saldobilanz_summary_Report_Sub;



CREATE TABLE report.saldobilanz_summary_Report_Sub
(
	parentname1 character varying(60),
	parentvalue1 character varying(60),	

	L1_sameyearsum numeric,
	L1_lastyearsum numeric,
	
	ad_org_id numeric,
	currency character(3)
)
WITH (
	OIDS=FALSE
);

CREATE FUNCTION report.saldobilanz_summary_Report_sub(IN Date Date, IN defaultAcc character varying, IN showCurrencyExchange character varying, IN ad_org_id numeric(10,0), IN p_IncludePostingTypeStatistical char(1) = 'N',  p_ExcludePostingTypeYearEnd char(1) = 'N') RETURNS SETOF report.saldobilanz_summary_Report_sub AS
$BODY$
SELECT
	parentname1,
	parentvalue1,
	SUM(CASE WHEN ParentValue1 IS NOT NULL THEN SameYearSum ELSE NULL END) AS L1_SameYearSum,
	SUM(CASE WHEN ParentValue1 IS NOT NULL THEN LastYearSum ELSE NULL END) AS L1_LastYearSum,
	
	$4 as ad_org_id,
	a.iso_code


FROM
	(
		SELECT
			lvl.Lvl1_name as ParentName1
			, lvl.Lvl1_value as ParentValue1
			, ev.AccountType
			
			, (de_metas_acct.acctBalanceToDate(ev.C_ElementValue_ID, acs.C_AcctSchema_ID, $1::date, $4, $5, $6)).Balance * ev.Multiplicator as SameYearSum
			, (de_metas_acct.acctBalanceToDate(ev.C_ElementValue_ID, acs.C_AcctSchema_ID, period_LastYearEnd.EndDate::date, $4, $5, $6)).Balance * ev.Multiplicator as LastYearSum
			, c.iso_code	
		FROM
			C_Period p 
				-- Get last period of previous year
				LEFT OUTER JOIN C_Period period_LastYearEnd ON (period_LastYearEnd.C_Period_ID = report.Get_Predecessor_Period_Recursive (p.C_Period_ID, p.PeriodNo::int)) AND period_LastYearEnd.isActive = 'Y'
			--
			, C_Element_Levels lvl
				INNER JOIN (
					SELECT C_ElementValue_ID
					-- NOTE: by customer requirement, we are not considering the account sign but always DR - CR
					, 1 as Multiplicator
					-- , acctBalance(C_ElementValue_ID, 1, 0) AS Multiplicator
					, ad_client_id
					, AccountType
					FROM C_ElementValue
					WHERE isActive = 'Y'
				) ev ON (lvl.C_ElementValue_ID = ev.C_ElementValue_ID)
				LEFT OUTER JOIN AD_ClientInfo ci ON (ci.AD_Client_ID=ev.AD_Client_ID) AND ci.isActive = 'Y'
				LEFT OUTER JOIN C_AcctSchema acs ON (acs.C_AcctSchema_ID=ci.C_AcctSchema1_ID) AND acs.isActive = 'Y'
				LEFT OUTER JOIN C_Currency c ON acs.C_Currency_ID=c.C_Currency_ID AND c.isActive = 'Y'
		--
		WHERE true
			-- Period: determine it by DateAcct
			AND p.C_Period_ID = report.Get_Period( ci.C_Calendar_ID, $1 ) 
			-- Shall we Show default accounts?
			AND (CASE WHEN $2='Y' THEN true ELSE lvl1_value != 'ZZ' END)
			AND p.isActive = 'Y'
	) a
GROUP BY 	
parentname1,
	parentvalue1,
	ad_org_id,
	iso_code	
ORDER BY
	parentValue1
$BODY$
LANGUAGE sql STABLE;