DROP FUNCTION IF EXISTS ProductsTopRevenue(numeric, numeric, date, date, numeric);

DROP FUNCTION IF EXISTS ProductsTopRevenue(numeric, numeric, date, date, numeric, character varying);

CREATE OR REPLACE FUNCTION ProductsTopRevenue
(p_AD_Client_ID numeric,
 p_AD_Org_ID numeric,
 p_DateFrom date,
 p_DateTo date,
 p_Limit numeric,
 p_AD_Language character varying)

    RETURNS TABLE
            (
                Rang                integer,
                ProductValue        character varying,
                Name                character varying,
                Revenue             numeric,
                ISO_Code            character(3),
                QtyOnHandStock      numeric,
                SalesPercentOfTotal numeric
            )
AS
$$

SELECT ROW_NUMBER() OVER (ORDER BY t.Revenue DESC NULLS LAST, t.ProductValue) :: integer AS Rang,
       t.ProductValue,
       t.Name,
       t.Revenue,
       accounting.Iso_Code,
       t.QtyOnHandStock,
       round((CASE
                  WHEN totals.totalRevenueAmt != 0 THEN (t.Revenue * 100) / totals.totalRevenueAmt
                  ELSE 0 END), 2)                                                        AS SalesPercentOfTotal


FROM (
         SELECT p.value                                                                              AS ProductValue,
                COALESCE(trl.Name, p.Name)                                                           AS Name,
                getProductRevenue(p.M_Product_ID, p_AD_Client_ID, p_AD_Org_ID, p_DateFrom, p_DateTo) AS Revenue,
                getProductCurrentStock(p.M_Product_ID, p_AD_Client_ID, p_AD_Org_ID)                  AS QtyOnHandStock
         FROM M_Product p
                  LEFT JOIN M_Product_TRL trl ON p.M_Product_ID = trl.M_Product_ID AND trl.ad_language = p_AD_Language
     ) t,
     (
         SELECT COALESCE(getTotalRevenue(p_AD_Client_ID, p_AD_Org_ID, p_DateFrom, p_DateTo), 0) AS totalRevenueAmt
     ) totals,
     (
         SELECT ISO_Code
         FROM C_Currency c
                  JOIN C_AcctSchema acc ON c.c_currency_id = acc.c_currency_id
                  JOIN AD_ClientInfo ci ON ci.C_AcctSchema1_ID = acc.C_AcctSchema_ID
         WHERE ci.AD_Client_ID = p_AD_Client_ID
     ) accounting
ORDER BY Rang
LIMIT (CASE
           WHEN p_Limit > 0 THEN p_Limit
           ELSE 999999999999999 END)

$$
    LANGUAGE SQL STABLE;
	
	
	
	
	
	
	
	
	
	
	---------------------
	
	
	
	
	
	-- 2020-02-19T13:45:21.763Z
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Process SET SQLStatement='select * from ProductsTopRevenue(@AD_Client_ID@, @AD_Org_ID@, ''@DateFrom/1900-01-01@''::date , ''@DateTo/9999-12-31@''::date , @Limit/-1@, @#AD_Language@)',Updated=TO_TIMESTAMP('2020-02-19 15:45:21','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Process_ID=584651
;

-- 2020-02-19T13:45:39.474Z
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Process SET SQLStatement='select * from ProductsTopRevenue(@AD_Client_ID@, @AD_Org_ID@, ''@DateFrom/1900-01-01@''::date , ''@DateTo/9999-12-31@''::date , @Limit/-1@, ''@#AD_Language@'')',Updated=TO_TIMESTAMP('2020-02-19 15:45:39','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Process_ID=584651
;


	