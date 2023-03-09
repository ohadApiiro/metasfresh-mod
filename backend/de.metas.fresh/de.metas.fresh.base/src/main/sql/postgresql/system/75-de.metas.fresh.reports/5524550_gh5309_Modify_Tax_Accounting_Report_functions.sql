DROP FUNCTION IF EXISTS report.tax_accounting_report_recap( IN c_period_id numeric, IN vatcode numeric, IN account_id numeric, IN org_id numeric );
CREATE OR REPLACE FUNCTION report.tax_accounting_report_recap(IN c_period_id numeric, IN vatcode numeric,
                                                              IN account_id  numeric, IN org_id numeric)
  RETURNS TABLE(
    taxname    character varying,
    taxrate    numeric,
    vatcode    character varying,
    taxbaseamt numeric,
    taxamt     numeric
  )
AS
$$
select
  taxname,
  taxrate,
  vatcode,
  sum(taxbaseamt),
  sum(taxamt)
FROM
  (
    SELECT
      documentno,
      taxname,
      taxrate,
      x.vatcode,
      COALESCE(COALESCE(coalesce(x.inv_baseamt, x.gl_baseamt), x.hdr_baseamt, 0 :: numeric)) as taxbaseamt,
      COALESCE(COALESCE(coalesce(x.inv_taxamt, x.gl_taxamt), x.hdr_taxamt, 0 :: numeric))    as taxamt
    FROM
      (
        SELECT
          fa.documentno,
          tax.name       AS taxname,
          tax.rate       AS taxrate,
          i.taxbaseamt   AS inv_baseamt,
          gl.taxbaseamt  AS gl_baseamt,
          hdr.taxbaseamt AS hdr_baseamt,
          i.taxamt       AS inv_taxamt,
          gl.taxamt      AS gl_taxamt,
          hdr.taxamt     AS hdr_taxamt,
          fa.vatcode     AS vatcode

        FROM public.fact_acct fa
          -- gh #489: explicitly select from public.fact_acct, bacause the function de_metas_acct.Fact_Acct_EndingBalance expects it.
          JOIN c_tax tax ON fa.c_tax_id = tax.c_tax_id and tax.isActive = 'Y'
          JOIN c_period p ON p.c_period_id = $1 and p.isActive = 'Y'

          --if invoice
          LEFT OUTER JOIN
          (SELECT
             (case when dt.docbasetype <> 'APC'
               then inv_tax.taxbaseamt
              else (-1) * inv_tax.taxbaseamt
              end) as taxbaseamt,
             (case when dt.docbasetype <> 'APC'
               then inv_tax.taxamt
              else (-1) * inv_tax.taxamt
              end) as taxamt,
             i.c_invoice_id,
             inv_tax.c_tax_id
           FROM c_invoice i
             JOIN C_InvoiceTax inv_tax on i.c_invoice_id = inv_tax.c_invoice_id and inv_tax.isActive = 'Y'
             join C_DocType dt on dt.C_DocType_ID = i.C_DocTypeTarget_id
           WHERE i.isActive = 'Y'
          ) i
            ON fa.record_id = i.c_invoice_id AND fa.ad_table_id = get_Table_Id('C_Invoice') AND i.c_tax_id = fa.c_tax_id

          --if gl journal
          LEFT OUTER JOIN (SELECT
                             (CASE WHEN gll.dr_autotaxaccount = 'Y'
                               THEN gll.dr_taxbaseamt
                              WHEN cr_autotaxaccount = 'Y'
                                THEN gll.cr_taxbaseamt END)         AS taxbaseamt,
                             (CASE WHEN gll.dr_autotaxaccount = 'Y'
                               THEN gll.dr_taxamt
                              WHEN cr_autotaxaccount = 'Y'
                                THEN gll.cr_taxamt END)             AS taxamt,
                             gl.gl_journal_id,
                             gll.gl_journalline_id,
                             COALESCE(gll.dr_tax_id, gll.cr_tax_id) AS tax_id
                           FROM gl_journal gl
                             JOIN GL_JournalLine gll ON gl.gl_journal_id = gll.gl_journal_id and gll.isActive = 'Y'
                           WHERE gl.isActive = 'Y'
                          ) gl ON fa.record_id = gl.gl_journal_id AND fa.ad_table_id = get_Table_Id('GL_Journal') AND
                                  gl.gl_journalline_id = fa.line_id AND gl.tax_id = fa.c_tax_id

          --if allocationHdr
          LEFT OUTER JOIN (
                            SELECT
                              hdr.C_AllocationHdr_ID,
                              hdrl.C_AllocationLine_ID,
                              0 :: numeric as taxbaseamt,
                              -- leave taxbaseamt empty for now in allocationhdr
                              0 :: numeric as taxamt -- leave taxamt empty for now in allocationhdr
                            FROM C_AllocationHdr hdr
                              JOIN C_AllocationLine hdrl
                                on hdr.C_AllocationHdr_ID = hdrl.C_AllocationHdr_ID and hdrl.isActive = 'Y'
                            WHERE hdr.isActive = 'Y'
                          ) hdr
            ON hdr.C_AllocationHdr_ID = fa.record_id AND fa.ad_table_id = get_Table_Id('C_AllocationHdr') AND
               fa.line_id = hdr.C_AllocationLine_ID

          LEFT OUTER JOIN C_Vat_Code vat on vat.C_Vat_Code_ID = $2 and vat.isActive = 'Y'

        WHERE fa.line_id is null and fa.C_Tax_id is not null
              AND fa.c_period_id = $1
              AND fa.postingtype IN ('A', 'Y')
              AND fa.ad_org_id = $4
              AND (CASE WHEN vat.vatcode IS NULL
          THEN TRUE
                   ELSE vat.vatcode = fa.VatCode END)
              AND (CASE WHEN $3 IS NULL
          THEN TRUE
                   ELSE $3 = fa.account_id END)
              AND fa.isActive = 'Y'


      ) x
    GROUP BY vatcode, taxrate, taxname, documentno,
      COALESCE(COALESCE(coalesce(x.inv_baseamt, x.gl_baseamt), x.hdr_baseamt, 0 :: numeric)),
      COALESCE(COALESCE(coalesce(x.inv_taxamt, x.gl_taxamt), x.hdr_taxamt, 0 :: numeric))
    ORDER BY vatcode, taxrate, documentno
  ) s
GROUP BY vatcode, taxname, taxrate
$$
LANGUAGE sql
STABLE;



DROP FUNCTION IF EXISTS report.tax_accounting_report( IN c_period_id numeric, IN vatcode numeric, IN account_id numeric, IN org_id numeric, IN showdetails character varying, IN ad_language character varying(6) );
CREATE OR REPLACE FUNCTION report.tax_accounting_report(IN c_period_id numeric, IN vatcode numeric,
                                                        IN account_id  numeric, IN org_id numeric,
                                                        IN showdetails character varying,
                                                        IN ad_language character varying(6))
  RETURNS TABLE(
    vatcode          character varying(10),
    kontono          character varying(40),
    kontoname        character varying(60),
    dateacct         date,
    documentno       character varying(40),
    taxname          character varying(60),
    taxrate          numeric,
    bpName           character varying,
    taxbaseamt       numeric,
    taxamt           numeric,
    taxamtperaccount numeric,
    IsTaxLine        character varying,
    param_startdate  date,
    param_enddate    date,
    param_konto      character varying,
    param_vatcode    character varying,
    param_org        character varying,
    ad_org_id        numeric
  )
AS
$$

SELECT
  DISTINCT ON (x.vatcode, x.kontono, x.kontoname, x.dateacct, x.documentno, x.taxname, x.taxrate, x.bpName, x.IsTaxLine)

  x.vatcode,
  x.kontono,
  x.kontoname,
  x.dateacct :: date,
  x.documentno,
  x.taxname,
  x.taxrate,
  x.bpName,
  COALESCE(COALESCE(coalesce(x.inv_baseamt, x.gl_baseamt), x.hdr_baseamt, 0 :: numeric)) as taxbaseamt,
  COALESCE(COALESCE(coalesce(x.inv_taxamt, x.gl_taxamt), x.hdr_taxamt, 0 :: numeric))    as taxamt,
  taxamtperaccount,
  IsTaxLine,
  x.startdate :: date                                                                    as param_startdate,
  x.enddate :: date                                                                      as param_endtdate,
  x.param_konto,
  x.param_vatcode,
  x.param_org,
  x.ad_org_id
FROM
  (
    SELECT
      ev.value                                                     AS kontono,
      ev.name                                                      AS kontoname,
      fa.dateacct,
      fa.documentno,

      tax.name                                                     AS taxname,
      tax.rate                                                     AS taxrate,

      bp.name                                                      as bpName,

      i.taxbaseamt                                                 AS inv_baseamt,
      gl.taxbaseamt                                                AS gl_baseamt,
      hdr.taxbaseamt                                               AS hdr_baseamt,

      i.taxamt                                                     AS inv_taxamt,
      gl.taxamt                                                    AS gl_taxamt,
      hdr.taxamt                                                   AS hdr_taxamt,

      (case
       when fa.line_id is null and fa.C_Tax_id is not null
         then (fa.amtacctdr - fa.amtacctcr)
       else 0
       end)                                                        AS taxamtperaccount,


      (case
       when fa.line_id is null and fa.C_Tax_id is not null
         then 'Y'
       else 'N'
       end)                                                        AS IsTaxLine,

      fa.vatcode                                                   AS vatcode,
      p.startdate :: date,
      p.enddate :: date,
      (CASE WHEN $3 IS NULL
        THEN NULL
       ELSE (SELECT value || ' - ' || name
             from C_ElementValue
             WHERE C_ElementValue_ID = $3 and isActive = 'Y') END) AS param_konto,
      (CASE WHEN $2 IS NULL
        THEN NULL
       ELSE (SELECT vatcode
             FROM C_Vat_Code
             WHERE C_Vat_Code_ID = $2 and isActive = 'Y') END)     AS param_vatcode,
      (CASE WHEN $4 IS NULL
        THEN NULL
       ELSE (SELECT name
             from ad_org
             where ad_org_id = $4 and isActive = 'Y') END)         AS param_org,

      fa.ad_org_id

    FROM public.fact_acct fa
      -- gh #489: explicitly select from public.fact_acct, bacause the function de_metas_acct.Fact_Acct_EndingBalance expects it.

      JOIN c_elementvalue ev ON ev.c_elementvalue_id = fa.account_id and ev.isActive = 'Y'
      JOIN c_tax tax ON fa.c_tax_id = tax.c_tax_id and tax.isActive = 'Y'
      JOIN c_period p ON p.c_period_id = $1 and p.isActive = 'Y'

      LEFT OUTER JOIN c_bpartner bp on fa.c_bpartner_id = bp.c_bpartner_id

      --Show all accounts, not only tax accounts
      LEFT OUTER JOIN (select distinct vc.Account_ID as C_ElementValue_ID
                       from C_Tax_Acct ta
                         inner join C_ValidCombination vc on (vc.C_ValidCombination_ID in
                                                              (ta.T_Liability_Acct, ta.T_Receivables_Acct, ta.T_Due_Acct, ta.T_Credit_Acct, ta.T_Expense_Acct))
                                                             and vc.isActive = 'Y'
                       where ta.isActive = 'Y'
                      ) ta ON ta.C_ElementValue_ID = ev.C_ElementValue_ID

      --if invoice
      LEFT OUTER JOIN
      (SELECT
         (case when dt.docbasetype <> 'APC'
           then inv_tax.taxbaseamt
          else (-1) * inv_tax.taxbaseamt
          end) as taxbaseamt,
         (case when dt.docbasetype <> 'APC'
           then inv_tax.taxamt
          else (-1) * inv_tax.taxamt
          end) as taxamt,
         i.c_invoice_id,
         inv_tax.c_tax_id
       FROM c_invoice i
         JOIN C_InvoiceTax inv_tax on i.c_invoice_id = inv_tax.c_invoice_id and inv_tax.isActive = 'Y'
         join C_DocType dt on dt.C_DocType_ID = i.C_DocTypeTarget_id
       WHERE i.isActive = 'Y'
      ) i ON fa.record_id = i.c_invoice_id AND fa.ad_table_id = get_Table_Id('C_Invoice') AND i.c_tax_id = fa.c_tax_id

      --if gl journal
      LEFT OUTER JOIN (SELECT
                         (CASE WHEN gll.dr_autotaxaccount = 'Y'
                           THEN gll.dr_taxbaseamt
                          WHEN cr_autotaxaccount = 'Y'
                            THEN gll.cr_taxbaseamt END)         AS taxbaseamt,
                         (CASE WHEN gll.dr_autotaxaccount = 'Y'
                           THEN gll.dr_taxamt
                          WHEN cr_autotaxaccount = 'Y'
                            THEN gll.cr_taxamt END)             AS taxamt,
                         gl.gl_journal_id,
                         gll.gl_journalline_id,
                         COALESCE(gll.dr_tax_id, gll.cr_tax_id) AS tax_id
                       FROM gl_journal gl
                         JOIN GL_JournalLine gll ON gl.gl_journal_id = gll.gl_journal_id and gll.isActive = 'Y'
                       WHERE gl.isActive = 'Y'
                      ) gl ON fa.record_id = gl.gl_journal_id AND fa.ad_table_id = get_Table_Id('GL_Journal') AND
                              gl.gl_journalline_id = fa.line_id AND gl.tax_id = fa.c_tax_id

      --if allocationHdr
      LEFT OUTER JOIN (
                        SELECT
                          hdr.C_AllocationHdr_ID,
                          hdrl.C_AllocationLine_ID,
                          0 :: numeric as taxbaseamt,
                          -- leave taxbaseamt empty for now in allocationhdr
                          0 :: numeric as taxamt -- leave taxamt empty for now in allocationhdr
                        FROM C_AllocationHdr hdr
                          JOIN C_AllocationLine hdrl
                            on hdr.C_AllocationHdr_ID = hdrl.C_AllocationHdr_ID and hdrl.isActive = 'Y'
                        WHERE hdr.isActive = 'Y'
                      ) hdr
        ON hdr.C_AllocationHdr_ID = fa.record_id AND fa.ad_table_id = get_Table_Id('C_AllocationHdr') AND
           fa.line_id = hdr.C_AllocationLine_ID

      LEFT OUTER JOIN C_Vat_Code vat on vat.C_Vat_Code_ID = $2 and vat.isActive = 'Y'

    WHERE fa.c_period_id = $1
          AND fa.postingtype IN ('A', 'Y')
          AND fa.ad_org_id = $4
          AND (CASE WHEN vat.vatcode IS NULL
      THEN TRUE
               ELSE vat.vatcode = fa.VatCode END)
          AND (CASE WHEN $3 IS NULL
      THEN TRUE
               ELSE $3 = fa.account_id END)
          AND fa.isActive = 'Y'


  ) x

ORDER BY x.vatcode, x.kontono, x.kontoname, x.dateacct, x.documentno, x.taxname, x.taxrate, x.bpName
$$
LANGUAGE sql
STABLE;