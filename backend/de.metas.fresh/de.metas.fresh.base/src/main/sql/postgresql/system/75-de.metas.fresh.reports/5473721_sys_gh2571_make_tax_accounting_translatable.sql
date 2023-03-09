﻿DROP FUNCTION IF EXISTS report.tax_accounting_report(IN c_period_id numeric, IN vatcode numeric, IN account_id numeric, IN org_id numeric, IN showdetails character varying);
DROP FUNCTION IF EXISTS report.tax_accounting_report(IN c_period_id numeric, IN vatcode numeric, IN account_id numeric, IN org_id numeric, IN showdetails character varying, IN ad_language character varying (6));
CREATE OR REPLACE FUNCTION report.tax_accounting_report(IN c_period_id numeric, IN vatcode numeric, IN account_id numeric, IN org_id numeric, IN showdetails character varying, IN ad_language character varying (6))
RETURNS TABLE ( 
kontono character varying(40),
kontoname character varying(60),
dateacct date,
documentno character varying(40),
taxname character varying(60),
taxrate numeric,
taxamt numeric, 
taxbaseamt numeric, 
vatcode character varying(10),
doctype character varying,
endsaldo numeric,
param_startdate date,
param_enddate date,
param_konto character varying,
param_vatcode character varying,
param_org character varying,

ad_org_id numeric
) 
AS
$$

SELECT 
	x.kontono,x.kontoname,
	x.dateacct::date, x.documentno, x.taxname, x.taxrate,
	x.amt , 
	COALESCE(COALESCE(coalesce(x.inv_baseamt, x.gl_baseamt), x.hdr_baseamt,0::numeric)) as taxbaseamt, 

	x.vatcode, x.DocType_DisplayName,
	x.endsaldo AS endsaldo,
	x.startdate::date as param_startdate, x.enddate::date as param_endtdate,
	x.param_konto, x.param_vatcode, x.param_org,
	
	x.ad_org_id

FROM
(
SELECT 
	ev.value AS kontono,
	ev.name AS kontoname,
	fa.dateacct,
	fa.documentno,
	
	tax.name AS taxname,
	tax.rate AS taxrate,

	
	i.taxbaseamt AS inv_baseamt,
	gl.taxbaseamt AS gl_baseamt,
	hdr.taxbaseamt AS hdr_baseamt,

	fa.vatcode AS vatcode,
	( 	CASE WHEN (fa.C_DocType_ID!=0 AND fa.C_DocType_ID IS NOT NULL) THEN
			(SELECT COALESCE(dtt.Name, dt.Name) AS Name 
			FROM C_DocType dt 
			LEFT JOIN C_DocType_Trl dtt ON dt.C_DocType_ID = dtt.C_DocType_ID AND dtt.ad_language = $6 AND dtt.isActive = 'Y'
			WHERE dt.C_DocType_ID=fa.C_DocType_ID and dt.isActive = 'Y') 
		ELSE
			(SELECT COALESCE(rlt.Name, rl.Name) AS Name 
			FROM AD_Ref_List rl
			LEFT JOIN AD_Ref_List_Trl rlt ON rl.AD_Ref_List_ID = rlt.AD_Ref_List_ID AND rlt.ad_language = $6 AND rlt.isActive = 'Y'
			WHERE rl.AD_Reference_ID=183 AND rl.Value=fa.DocBaseType AND rl.isActive = 'Y') 
		END
	) AS DocType_DisplayName,

	(fa.amtacctdr - fa.amtacctcr) AS amt,
	
	de_metas_acct.Fact_Acct_EndingBalance(fa) as endsaldo,
	
	p.startdate::date, p.enddate::date,
	(CASE WHEN $3 IS NULL THEN NULL ELSE (SELECT value||' - '||name from C_ElementValue WHERE C_ElementValue_ID = $3 and isActive = 'Y') END) AS param_konto, 
	(CASE WHEN $2 IS NULL THEN NULL ELSE (SELECT vatcode FROM C_Vat_Code WHERE C_Vat_Code_ID = $2 and isActive = 'Y') END) AS param_vatcode,
	(CASE WHEN $4 IS NULL THEN NULL ELSE (SELECT name from ad_org where ad_org_id = $4 and isActive = 'Y') END) AS param_org,
	
	fa.ad_org_id
	
FROM public.fact_acct fa -- gh #489: explicitly select from public.fact_acct, bacause the function de_metas_acct.Fact_Acct_EndingBalance expects it.

JOIN c_elementvalue ev ON ev.c_elementvalue_id = fa.account_id and ev.isActive = 'Y'
JOIN ad_table t ON fa.ad_table_id=t.ad_table_id and t.isActive = 'Y'
JOIN c_tax tax ON fa.c_tax_id = tax.c_tax_id and tax.isActive = 'Y'
JOIN c_period p ON p.c_period_id=$1 and p.isActive = 'Y'

--Show only tax accounts
JOIN (select distinct vc.Account_ID as C_ElementValue_ID
from C_Tax_Acct ta
inner join C_ValidCombination vc on (vc.C_ValidCombination_ID in (ta.T_Liability_Acct, ta.T_Receivables_Acct, ta.T_Due_Acct, ta.T_Credit_Acct,ta.T_Expense_Acct)) and vc.isActive = 'Y'
where ta.isActive = 'Y'
) ta ON ta.C_ElementValue_ID=ev.C_ElementValue_ID

--if invoice
LEFT OUTER JOIN
( SELECT inv_tax.taxbaseamt, i.c_invoice_id, inv_tax.c_tax_id FROM c_invoice i
  JOIN C_InvoiceTax inv_tax on i.c_invoice_id=inv_tax.c_invoice_id and inv_tax.isActive = 'Y'
  WHERE i.isActive = 'Y'
 ) i ON fa.record_id = i.c_invoice_id AND fa.ad_table_id = get_Table_Id('C_Invoice') AND i.c_tax_id = fa.c_tax_id

--if gl journal
LEFT OUTER JOIN (SELECT
(CASE WHEN gll.dr_autotaxaccount='Y' THEN gll.dr_taxbaseamt WHEN cr_autotaxaccount='Y' THEN gll.cr_taxbaseamt END) AS taxbaseamt,
gl.gl_journal_id, gll.gl_journalline_id, COALESCE (gll.dr_tax_id, gll.cr_tax_id) AS tax_id
FROM gl_journal gl
JOIN GL_JournalLine gll ON gl.gl_journal_id = gll.gl_journal_id and gll.isActive = 'Y'
WHERE gl.isActive = 'Y'
)gl ON fa.record_id = gl.gl_journal_id AND fa.ad_table_id = get_Table_Id('GL_Journal') AND gl.gl_journalline_id=fa.line_id AND gl.tax_id = fa.c_tax_id

--if allocationHdr
LEFT OUTER JOIN (
SELECT hdr.C_AllocationHdr_ID, hdrl.C_AllocationLine_ID, 0::numeric as taxbaseamt -- leave taxbaseamt empty for now in allocationhdr
FROM C_AllocationHdr hdr
JOIN C_AllocationLine hdrl on hdr.C_AllocationHdr_ID = hdrl.C_AllocationHdr_ID and hdrl.isActive = 'Y'
WHERE hdr.isActive = 'Y'
) hdr ON hdr.C_AllocationHdr_ID = fa.record_id AND fa.ad_table_id = get_Table_Id('C_AllocationHdr') AND fa.line_id = hdr.C_AllocationLine_ID 

LEFT OUTER JOIN C_Vat_Code vat on vat.C_Vat_Code_ID = $2 and vat.isActive = 'Y'

WHERE fa.c_period_id = $1
      AND fa.postingtype IN ('A', 'Y')
      AND  fa.ad_org_id = $4
      AND ( CASE WHEN vat.vatcode IS NULL THEN TRUE ELSE vat.vatcode = fa.VatCode END )
      AND ( CASE WHEN $3 IS NULL THEN TRUE ELSE $3 = fa.account_id END )
	  AND fa.isActive = 'Y'


)x
WHERE 
x.amt IS NOT NULL 

GROUP BY
	x.kontono,x.kontoname,
	x.dateacct::date, x.documentno, x.taxname, x.taxrate,
	x.amt , 
	COALESCE(COALESCE(coalesce(x.inv_baseamt, x.gl_baseamt), x.hdr_baseamt,0::numeric)), 

	x.vatcode, x.DocType_DisplayName, x.endsaldo,
	x.startdate::date , x.enddate::date,
	x.param_konto, x.param_vatcode, x.param_org,
	
	x.ad_org_id

ORDER BY vatcode,kontono,documentno

$$ 
LANGUAGE sql STABLE;