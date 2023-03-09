DROP FUNCTION IF EXISTS report.fresh_pricelist_details_template_report(NUMERIC, NUMERIC, CHARACTER VARYING, NUMERIC);
CREATE OR REPLACE FUNCTION report.fresh_pricelist_details_template_report(IN p_c_bpartner_id NUMERIC, IN p_m_pricelist_version_id NUMERIC, IN p_ad_language CHARACTER VARYING,
                                                                          IN p_c_bpartner_location_id NUMERIC)
    RETURNS TABLE
            (
                prodvalue               text,
                customerproductnumber   text,
                productcategory         text,
                productname             text,
                attributes              text,
                itemproductname         text,
                qty                     numeric,
                uomsymbol               text,
                pricestd                numeric,
                m_productprice_id       integer,
                c_bpartner_id           numeric,
                m_hu_pi_item_product_id integer,
                uom_x12de355            text,
                c_bpartner_location_id  numeric,
                qtycuspertu             numeric,
                m_product_id            integer,
                bp_value                text,
                bp_name                 text,
                reportfilename          text
            )

AS
$BODY$
--

SELECT plc.value                                                                                                          AS prodvalue,
       plc.customerproductnumber                                                                                          as customerproductnumber,
       plc.productcategory                                                                                                as productcategory,
       plc.productname                                                                                                    as productname,
       plc.attributes                                                                                                     as attributes,
       coalesce(hupiv.description, hupip.name, plc.uomsymbol)                                                             as itemproductname,
       NULL::numeric                                                                                                      as qty,
       plc.uomsymbol                                                                                                      as uomsymbol,
       round(plc.pricestd, cur.stdprecision)                                                                              as pricestd,
       plc.M_ProductPrice_ID                                                                                              as m_productprice_id,
       p_c_bpartner_id                                                                                                    as c_bpartner_id,
       plc.M_HU_PI_Item_Product_ID                                                                                        as m_hu_pi_item_product_id,
       case when plc.m_hu_pi_item_product_id is not null then 'COLI' else plc.uom_x12de355 end                            as uom_x12de355,
       p_c_bpartner_location_id                                                                                           as c_bpartner_location_id,
       plc.qtycuspertu                                                                                                    as qtycuspertu,
       plc.m_product_id                                                                                                   as m_product_id,
       plc.BP_Value                                                                                                       as bp_value,
       plc.BP_Name                                                                                                        as bp_name,
       CONCAT(bp_value, '_', bp_name, '_', case when prlv.isactive = 'Y' then prlv.validfrom::date else null end, '.xls') as reportfilename

FROM report.fresh_PriceList_Details_Report(p_c_bpartner_id, p_m_pricelist_version_id, NULL, p_ad_language) plc
         LEFT OUTER JOIN M_HU_PI_Item_Product hupip on hupip.M_HU_PI_Item_Product_ID = plc.M_HU_PI_Item_Product_ID
         LEFT OUTER JOIN M_HU_PI_Item hupii on hupii.M_HU_PI_Item_ID = hupip.M_HU_PI_Item_ID
         LEFT OUTER JOIN M_HU_PI_Version hupiv on hupiv.M_HU_PI_Version_ID = hupii.M_HU_PI_Version_ID
         LEFT OUTER JOIN M_Pricelist_Version prlv on prlv.m_pricelist_version_id = p_m_pricelist_version_id
         LEFT OUTER JOIN M_Pricelist prl on prlv.m_pricelist_id = prl.m_pricelist_id
         LEFT OUTER JOIN C_Currency cur on prl.c_currency_id = cur.c_currency_id
--


$BODY$
    LANGUAGE sql STABLE
                 COST 100
                 ROWS 1000;

-- 2020-03-26T17:22:12.638Z
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Val_Rule (AD_Client_ID,AD_Org_ID,AD_Val_Rule_ID,Code,Created,CreatedBy,EntityType,IsActive,Name,Type,Updated,UpdatedBy) VALUES (0,0,540493,'EXISTS ( select 1 from Report.Fresh_PriceList_Version_Val_Rule plv
where M_PriceList_Version.M_PriceList_Version_ID=plv.M_PriceList_Version_ID
 AND plv.C_BPartner_ID=@C_BPartner_ID@ and plv.issotrx = ''Y'') ',TO_TIMESTAMP('2020-03-26 19:22:12','YYYY-MM-DD HH24:MI:SS'),100,'U','Y','Fresh_SO_PriceList_Version_of_BPartner','S',TO_TIMESTAMP('2020-03-26 19:22:12','YYYY-MM-DD HH24:MI:SS'),100)
;

-- 2020-03-26T17:24:14.428Z
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Process_Para SET AD_Val_Rule_ID=NULL,Updated=TO_TIMESTAMP('2020-03-26 19:24:14','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Process_Para_ID=541645
;

-- 2020-03-26T17:24:23.291Z
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Process_Para SET AD_Val_Rule_ID=540493,Updated=TO_TIMESTAMP('2020-03-26 19:24:23','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Process_Para_ID=541645
;

-- 2020-03-26T17:27:26.218Z
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Process_Para SET AD_Val_Rule_ID=540243,Updated=TO_TIMESTAMP('2020-03-26 19:27:26','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Process_Para_ID=541645
;

-- 2020-03-26T17:27:42.723Z
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Process_Para SET AD_Val_Rule_ID=540493,Updated=TO_TIMESTAMP('2020-03-26 19:27:42','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Process_Para_ID=541733
;