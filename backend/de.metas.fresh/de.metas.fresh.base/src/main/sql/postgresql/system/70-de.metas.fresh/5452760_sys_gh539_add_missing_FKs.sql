
--
-- DDL
--
-- needed to make sure the FK we are gong to create doesn't brak the wholse DB
CREATE INDEX m_receiptschedule_alloc_vhu_id
  ON m_receiptschedule_alloc
  USING btree(vhu_id);


-- fix for a missing physical column
-- 28.10.2016 08:16
-- URL zum Konzept
ALTER TABLE C_RecurrentPaymentLine ADD C_BP_BankAccount_Own_ID NUMERIC(10) NOT NULL
;

COMMIT;

--
-- DML: number of fixes for known problems
--
UPDATE AD_Scheduler SET EntityType='de.metas.invoicecandidate' WHERE EntityType='de.metas.i'; -- manual fix

DELETE FROM c_advcomsystem WHERE (c_sponsor_root_id)=(1000002);
DELETE FROM c_contract_change where (c_flatrate_transition_id)=(10001);
DELETE FROM c_contract_change where (c_flatrate_transition_id)=(10002);
DELETE FROM c_contract_change where (c_flatrate_transition_id)=(10003);
DELETE FROM c_contract_change where (c_flatrate_transition_id)=(10012);
DELETE FROM c_contract_change where (c_flatrate_transition_id)=(10013);

UPDATE c_invoice_detail id SET C_InvoiceLine_ID=NULL WHERE C_InvoiceLine_ID IS NOT NULL AND NOT EXISTS (select 1 from C_InvoiceLine il where il.C_InvoiceLine_ID=id.C_InvoiceLine_ID);
UPDATE c_olcand olc SET m_productprice_attribute_id=NULL WHERE olc.m_productprice_attribute_id IS NOT NULL AND NOT EXISTS (select 1 from m_productprice_attribute ppa where ppa.m_productprice_attribute_id=olc.m_productprice_attribute_id);
UPDATE c_payment_request pr SET C_BP_Bankaccount_ID=NULL WHERE pr.c_bp_bankaccount_id Is NOT NULL AND NOT EXISTS (select 1 from c_bp_bankaccount pa where pa.c_bp_bankaccount_id=pr.c_bp_bankaccount_id);
UPDATE c_poskey k SET ad_val_rule_id=NULL WHERE k.ad_val_rule_id Is NOT NULL AND NOT EXISTS (select 1 from ad_val_rule r where r.ad_val_rule_id=k.ad_val_rule_id);
UPDATE C_Tax_Acct ta SET t_revenue_acct=NULL WHERE t_revenue_acct Is NOT NULL AND NOT EXISTS (select 1 from c_validcombination vc where vc.c_validcombination_ID=ta.t_revenue_acct);
UPDATE PP_Order_ProductAttribute pa SET M_HU_ID=null WHERE pa.M_HU_ID IS NOT null AND NOT EXISTS (select 1 from m_hu hu where hu.M_HU_ID=pa.M_HU_ID);

UPDATE M_InOut io SET m_shippertransportation_ID=NULL WHERE io.m_shippertransportation_ID Is NOT NULL AND NOT EXISTS (select 1 from m_shippertransportation s where s.m_shippertransportation_ID=io.m_shippertransportation_ID);

DELETE FROM c_taxdeclarationacct t WHERE NOT EXISTS (select 1 from fact_acct f where f.fact_Acct_id=t.fact_acct_id);


UPDATE m_receiptschedule_alloc a SET vhu_id=NULL WHERE a.vhu_id IS NOT NULL AND NOT EXISTS (select 1 from m_hu hu where a.vhu_id=hu.m_hu_id);

UPDATE c_async_batch_type t SET AD_BoilerPlate_ID=null WHERE AD_BoilerPlate_ID IS NOT NULL AND NOT EXISTS (select 1 from AD_BoilerPlate p where p.AD_BoilerPlate_ID=t.AD_BoilerPlate_ID);

DELETE FROM c_bp_docline_sort s WHERE NOT EXISTS (select 1 from C_BPartner p where p.C_BPartner_ID=s.C_BPartner_ID);

DELETE FROM Fact_Acct_ActivityChangeRequest s WHERE NOT EXISTS (select 1 from fact_Acct a where a.fact_Acct_id=s.fact_Acct_id);

UPDATE c_olcand s SET Exp_replicationtrx_id=NULL WHERE NOT EXISTS (select 1 from Exp_replicationtrx p where p.Exp_replicationtrx_id=s.Exp_replicationtrx_id);

--
-- fixing references from Table Direct to Table or Search 
--
-- 28.10.2016 08:42
-- URL zum Konzept
UPDATE AD_Column SET AD_Reference_ID=18, AD_Reference_Value_ID=276,Updated=TO_TIMESTAMP('2016-10-28 08:42:07','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Column_ID=57593
;

-- 28.10.2016 08:44
-- URL zum Konzept
UPDATE AD_Column SET AD_Reference_ID=30, AD_Reference_Value_ID=133,Updated=TO_TIMESTAMP('2016-10-28 08:44:19','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Column_ID=57598
;

-- 28.10.2016 08:44
-- URL zum Konzept
UPDATE AD_Column SET AD_Reference_ID=30, AD_Reference_Value_ID=133,Updated=TO_TIMESTAMP('2016-10-28 08:44:31','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Column_ID=57597
;

--
-- no FK contraints for I_ tables
--
-- 28.10.2016 08:47
-- URL zum Konzept
UPDATE AD_Column SET DDL_NoForeignKey='Y',Updated=TO_TIMESTAMP('2016-10-28 08:47:03','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Column_ID=55994
;

-- 28.10.2016 08:47
-- URL zum Konzept
UPDATE AD_Column SET DDL_NoForeignKey='Y',Updated=TO_TIMESTAMP('2016-10-28 08:47:03','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Column_ID=55985
;

-- 28.10.2016 08:47
-- URL zum Konzept
UPDATE AD_Column SET DDL_NoForeignKey='Y',Updated=TO_TIMESTAMP('2016-10-28 08:47:04','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Column_ID=55986
;

-- 28.10.2016 08:47
-- URL zum Konzept
UPDATE AD_Column SET DDL_NoForeignKey='Y',Updated=TO_TIMESTAMP('2016-10-28 08:47:05','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Column_ID=56057
;

-- 28.10.2016 08:47
-- URL zum Konzept
UPDATE AD_Column SET DDL_NoForeignKey='Y',Updated=TO_TIMESTAMP('2016-10-28 08:47:11','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Column_ID=56059
;

-- 28.10.2016 08:47
-- URL zum Konzept
UPDATE AD_Column SET DDL_NoForeignKey='Y',Updated=TO_TIMESTAMP('2016-10-28 08:47:15','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Column_ID=56042
;

-- 28.10.2016 10:19
-- URL zum Konzept
UPDATE AD_Column SET DDL_NoForeignKey='Y',Updated=TO_TIMESTAMP('2016-10-28 10:19:15','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Column_ID=56061
;

-- 28.10.2016 10:19
-- URL zum Konzept
UPDATE AD_Column SET DDL_NoForeignKey='Y',Updated=TO_TIMESTAMP('2016-10-28 10:19:29','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Column_ID=56064
;

-- X_MRP_ProductInfo_Detail_MV.M_AttributeSetInstance_ID
UPDATE AD_Column SET DDL_NoForeignKey='Y',Updated=TO_TIMESTAMP('2016-10-28 10:19:29','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_column_ID=555102
;

COMMIT;

--
-- DDL to create the FKs
--

ALTER TABLE AD_ColumnCallout DROP CONSTRAINT IF EXISTS EntityT_ADColumnCallout;
ALTER TABLE AD_JavaClass DROP CONSTRAINT IF EXISTS ADEntityType_ADJavaClass;
ALTER TABLE AD_JavaClass_Type DROP CONSTRAINT IF EXISTS ADEntityType_ADJavaClassType;
ALTER TABLE AD_JAXRS_Endpoint DROP CONSTRAINT IF EXISTS ADJavaClass_ADJAXRSEndpoint;
ALTER TABLE AD_JAXRS_Endpoint DROP CONSTRAINT IF EXISTS EntityT_ADJAXRSEndpoint;
ALTER TABLE AD_MailConfig DROP CONSTRAINT IF EXISTS ADMailBox_ADMailConfig;
ALTER TABLE AD_MailConfig DROP CONSTRAINT IF EXISTS ADProcess_ADMailConfig;
ALTER TABLE AD_Migration DROP CONSTRAINT IF EXISTS EntityT_ADMigration;
ALTER TABLE AD_MigrationData DROP CONSTRAINT IF EXISTS ADColumn_ADMigrationData;
ALTER TABLE AD_MigrationStep DROP CONSTRAINT IF EXISTS ADTable_ADMigrationStep;
ALTER TABLE AD_Package_Exp_Detail DROP CONSTRAINT IF EXISTS ADEntityType_ADPackageExpDetai;

ALTER TABLE AD_ProcessablePO DROP CONSTRAINT IF EXISTS ADIssue_ADProcessablePO;
ALTER TABLE AD_ProcessablePO DROP CONSTRAINT IF EXISTS ADTable_ADProcessablePO;
ALTER TABLE AD_Registration DROP CONSTRAINT IF EXISTS CLocation_ADRegistration;
ALTER TABLE AD_Scheduler DROP CONSTRAINT IF EXISTS EntityT_ADScheduler;
ALTER TABLE AD_User DROP CONSTRAINT IF EXISTS ADUserInCharge_ADUser;
ALTER TABLE AD_User_Login DROP CONSTRAINT IF EXISTS ADRole_ADUserLogin;
ALTER TABLE AD_User_Login DROP CONSTRAINT IF EXISTS ADSession_ADUserLogin;
ALTER TABLE AD_User_Login DROP CONSTRAINT IF EXISTS ADUser_ADUserLogin;
ALTER TABLE C_AcctSchema_Default DROP CONSTRAINT IF EXISTS CReceivableServicesA_CAcctSche;
ALTER TABLE C_AcctSchema_Default DROP CONSTRAINT IF EXISTS PCostAdjustmentA_CAcctSchemaDe;
ALTER TABLE C_AcctSchema_Default DROP CONSTRAINT IF EXISTS PInventoryClearingA_CAcctSchem;
ALTER TABLE C_AcctSchema_GL DROP CONSTRAINT IF EXISTS CommitmentOffsetA_CAcctSchemaG;
ALTER TABLE C_AcctSchema_GL DROP CONSTRAINT IF EXISTS CommitmentOffsetSalesA_CAcctSc;
ALTER TABLE C_AdvComCorrection DROP CONSTRAINT IF EXISTS ADTable_CAdvComCorrection;
ALTER TABLE C_AdvComCorrection DROP CONSTRAINT IF EXISTS CSponsorCustomer_CAdvComCorrec;
ALTER TABLE C_AdvComCorrection DROP CONSTRAINT IF EXISTS CSponsorSalesRep_CAdvComCorrec;
ALTER TABLE C_AdvComDoc DROP CONSTRAINT IF EXISTS ADTable_CAdvComDoc;
ALTER TABLE C_AdvComDoc DROP CONSTRAINT IF EXISTS CAllocationLine_CAdvComDoc;
ALTER TABLE C_AdvComDoc DROP CONSTRAINT IF EXISTS CDocTypeRef_CAdvComDoc;
ALTER TABLE C_AdvComInstanceParam DROP CONSTRAINT IF EXISTS ADReference_CAdvComInstancePar;
ALTER TABLE C_AdvComInstanceParam DROP CONSTRAINT IF EXISTS ADReferenceValue_CAdvComInstan;
ALTER TABLE C_AdvComInstanceParam DROP CONSTRAINT IF EXISTS CAdvComSystemType_CAdvComInsta;
ALTER TABLE C_AdvCommissionCondition DROP CONSTRAINT IF EXISTS CAdvComSystem_CAdvCommissionCo;
ALTER TABLE C_AdvCommissionCondition DROP CONSTRAINT IF EXISTS CDoctypePayroll_CAdvCommission;
ALTER TABLE C_AdvCommissionCondition DROP CONSTRAINT IF EXISTS HRPayroll_CAdvCommissionCondit;
ALTER TABLE C_AdvCommissionCondition DROP CONSTRAINT IF EXISTS MProductCategory_CAdvCommissio;
ALTER TABLE C_AdvCommissionFact DROP CONSTRAINT IF EXISTS ADPInstance_CAdvCommissionFact;
ALTER TABLE C_AdvCommissionFact DROP CONSTRAINT IF EXISTS CAdvCommissionFactCand_CAdvCom;
ALTER TABLE C_AdvCommissionFact DROP CONSTRAINT IF EXISTS CIncidentLineFact_CAdvCommissi;
ALTER TABLE C_AdvCommissionFactCand DROP CONSTRAINT IF EXISTS CAdvComFactCandCause_CAdvCommi;
ALTER TABLE C_AdvCommissionFactCand DROP CONSTRAINT IF EXISTS CAdvCommissionRelevantPO_CAdvC;
ALTER TABLE C_AdvCommissionInstance DROP CONSTRAINT IF EXISTS ADPInstance_CAdvCommissionInst;
ALTER TABLE C_AdvCommissionInstance DROP CONSTRAINT IF EXISTS CAdvCommissionRelevantPO_CAdvC;
ALTER TABLE C_AdvCommissionInstance DROP CONSTRAINT IF EXISTS CAdvComSystemType_CAdvCommissi;
ALTER TABLE C_AdvCommissionInstance DROP CONSTRAINT IF EXISTS CIncidentLine_CAdvCommissionIn;
ALTER TABLE C_AdvCommissionRelevantPO DROP CONSTRAINT IF EXISTS BPartnerColumn_CAdvCommissionR;
ALTER TABLE C_AdvCommissionRelevantPO DROP CONSTRAINT IF EXISTS DateDocColumn_CAdvCommissionRe;
ALTER TABLE C_AdvCommissionSalaryGroup DROP CONSTRAINT IF EXISTS CAdvComRankCollection_CAdvComm;
ALTER TABLE C_AdvCommissionTerm DROP CONSTRAINT IF EXISTS CAdvComSystemType_CAdvCommissi;
ALTER TABLE C_AdvCommissionTerm DROP CONSTRAINT IF EXISTS CAdvComTermSRFCollector_CAdvCo;
ALTER TABLE C_AdvCommissionTerm DROP CONSTRAINT IF EXISTS MProductCategory_CAdvCommissio;
ALTER TABLE C_AdvComRankForecast DROP CONSTRAINT IF EXISTS CAdvCommissionSalaryGroup_CAdv;
ALTER TABLE C_AdvComRankForecast DROP CONSTRAINT IF EXISTS CAdvComRankNext_CAdvComRankFor;
ALTER TABLE C_AdvComRankForecast DROP CONSTRAINT IF EXISTS CAdvComSystem_CAdvComRankForec;
ALTER TABLE C_AdvComRankForecast DROP CONSTRAINT IF EXISTS CBPartner_CAdvComRankForecast;
ALTER TABLE C_AdvComRankForecast DROP CONSTRAINT IF EXISTS CPeriodSince_CAdvComRankForeca;
ALTER TABLE C_AdvComRankForecast DROP CONSTRAINT IF EXISTS CPeriodUntil_CAdvComRankForeca;
ALTER TABLE C_AdvComRankForecast DROP CONSTRAINT IF EXISTS CSponsor_CAdvComRankForecast;
ALTER TABLE C_AdvComRelevantPO_Type DROP CONSTRAINT IF EXISTS CAdvCommissionRelevantPO_CAdvC;
ALTER TABLE C_AdvComRelevantPO_Type DROP CONSTRAINT IF EXISTS CAdvComSystem_CAdvComRelevantP;
ALTER TABLE C_AdvComRelevantPO_Type DROP CONSTRAINT IF EXISTS CAdvComSystemType_CAdvComRelev;
ALTER TABLE C_AdvComSalesRepFact DROP CONSTRAINT IF EXISTS CAdvCommissionSalaryGroup_CAdv;
ALTER TABLE C_AdvComSalesRepFact DROP CONSTRAINT IF EXISTS CAdvComSystem_CAdvComSalesRepF;
ALTER TABLE C_AdvComSalesRepFact DROP CONSTRAINT IF EXISTS CPeriod_CAdvComSalesRepFact;
ALTER TABLE C_AdvComSalesRepFact DROP CONSTRAINT IF EXISTS CSponsor_CAdvComSalesRepFact;
ALTER TABLE C_AdvComSponsorParam DROP CONSTRAINT IF EXISTS ADReference_CAdvComSponsorPara;
ALTER TABLE C_AdvComSponsorParam DROP CONSTRAINT IF EXISTS ADReferenceValue_CAdvComSponso;
ALTER TABLE C_AdvComSponsorParam DROP CONSTRAINT IF EXISTS CAdvCommissionTerm_CAdvComSpon;
ALTER TABLE C_AdvComSystem DROP CONSTRAINT IF EXISTS ADRoleAdmin_CAdvComSystem;
ALTER TABLE C_AdvComSystem DROP CONSTRAINT IF EXISTS ADUserAdmin_CAdvComSystem;
ALTER TABLE C_AdvComSystem DROP CONSTRAINT IF EXISTS CAdvComRankCollection_CAdvComS;
ALTER TABLE C_AdvComSystem DROP CONSTRAINT IF EXISTS CSponsorRoot_CAdvComSystem;
ALTER TABLE C_AdvComSystem_Type DROP CONSTRAINT IF EXISTS CAdvCommissionType_CAdvComSyst;
ALTER TABLE C_AdvComSystem_Type DROP CONSTRAINT IF EXISTS CAdvComRankMin_CAdvComSystemTy;
ALTER TABLE C_AdvComSystem_Type DROP CONSTRAINT IF EXISTS CAdvComSystem_CAdvComSystemTyp;
ALTER TABLE C_AdvComSystem_Type DROP CONSTRAINT IF EXISTS MProductCategory_CAdvComSystem;

ALTER TABLE C_Async_Batch DROP CONSTRAINT IF EXISTS ADPInstance_CAsyncBatch;
ALTER TABLE C_Async_Batch DROP CONSTRAINT IF EXISTS CAsyncBatchType_CAsyncBatch;
ALTER TABLE C_Async_Batch_Type DROP CONSTRAINT IF EXISTS ADBoilerPlate_CAsyncBatchType;
ALTER TABLE C_BankAccountDoc DROP CONSTRAINT IF EXISTS CBPBankAccount_CBankAccountDoc;
ALTER TABLE C_BPartner DROP CONSTRAINT IF EXISTS CustomerGroup_CBPartner;
ALTER TABLE C_BPartner_Product DROP CONSTRAINT IF EXISTS CBPartnerVendor_CBPartnerProdu;
ALTER TABLE C_BP_BankAccount DROP CONSTRAINT IF EXISTS CCurrency_CBPBankAccount;
ALTER TABLE C_BP_BankAccount_Acct DROP CONSTRAINT IF EXISTS BAssetA_CBPBankAccountAcct;
ALTER TABLE C_BP_BankAccount_Acct DROP CONSTRAINT IF EXISTS BExpenseA_CBPBankAccountAcct;
ALTER TABLE C_BP_BankAccount_Acct DROP CONSTRAINT IF EXISTS BInterestExpA_CBPBankAccountAc;
ALTER TABLE C_BP_BankAccount_Acct DROP CONSTRAINT IF EXISTS BInterestRevA_CBPBankAccountAc;
ALTER TABLE C_BP_BankAccount_Acct DROP CONSTRAINT IF EXISTS BInTransitA_CBPBankAccountAcct;
ALTER TABLE C_BP_BankAccount_Acct DROP CONSTRAINT IF EXISTS BPaymentSelectA_CBPBankAccount;
ALTER TABLE C_BP_BankAccount_Acct DROP CONSTRAINT IF EXISTS BRevaluationGainA_CBPBankAccou;
ALTER TABLE C_BP_BankAccount_Acct DROP CONSTRAINT IF EXISTS BRevaluationLossA_CBPBankAccou;
ALTER TABLE C_BP_BankAccount_Acct DROP CONSTRAINT IF EXISTS BSettlementGainA_CBPBankAccoun;
ALTER TABLE C_BP_BankAccount_Acct DROP CONSTRAINT IF EXISTS BSettlementLossA_CBPBankAccoun;
ALTER TABLE C_BP_BankAccount_Acct DROP CONSTRAINT IF EXISTS BUnallocatedCashA_CBPBankAccou;
ALTER TABLE C_BP_BankAccount_Acct DROP CONSTRAINT IF EXISTS BUnidentifiedA_CBPBankAccountA;
ALTER TABLE C_BP_Customer_Acct DROP CONSTRAINT IF EXISTS CReceivableServicesA_CBPCustom;
ALTER TABLE C_BP_DocLine_Sort DROP CONSTRAINT IF EXISTS CBPartner_CBPDocLineSort;
ALTER TABLE C_BP_DocLine_Sort DROP CONSTRAINT IF EXISTS CDocLineSort_CBPDocLineSort;
ALTER TABLE C_BP_Group_Acct DROP CONSTRAINT IF EXISTS CReceivableServicesA_CBPGroupA;
ALTER TABLE C_BP_PrintFormat DROP CONSTRAINT IF EXISTS ADPrintFormat_CBPPrintFormat;
ALTER TABLE C_BP_PrintFormat DROP CONSTRAINT IF EXISTS ADTable_CBPPrintFormat;
ALTER TABLE C_BP_PrintFormat DROP CONSTRAINT IF EXISTS CBPartner_CBPPrintFormat;
ALTER TABLE C_BP_PrintFormat DROP CONSTRAINT IF EXISTS CDocType_CBPPrintFormat;
ALTER TABLE C_CashLine DROP CONSTRAINT IF EXISTS CBPBankAccount_CCashLine;
ALTER TABLE C_Contract_Change DROP CONSTRAINT IF EXISTS CFlatrateTransition_CContractC;
ALTER TABLE C_DocLine_Sort_Item DROP CONSTRAINT IF EXISTS CDocLineSort_CDocLineSortItem;
ALTER TABLE C_DocLine_Sort_Item DROP CONSTRAINT IF EXISTS MProduct_CDocLineSortItem;
ALTER TABLE C_Dunning_Candidate DROP CONSTRAINT IF EXISTS CBPartner_CDunningCandidate;
ALTER TABLE C_DunningDoc DROP CONSTRAINT IF EXISTS CBPartner_CDunningDoc;
ALTER TABLE C_DunningDoc_Line DROP CONSTRAINT IF EXISTS CBPartner_CDunningDocLine;
ALTER TABLE C_ElementValue DROP CONSTRAINT IF EXISTS CBPBankAccount_CElementValue;
ALTER TABLE C_ElementValue DROP CONSTRAINT IF EXISTS CTax_CElementValue;
ALTER TABLE C_ElementValue DROP CONSTRAINT IF EXISTS ForeignCurrency_CElementValue;
ALTER TABLE C_Flatrate_Conditions DROP CONSTRAINT IF EXISTS CFlatrateTransition_CFlatrateC;
ALTER TABLE C_Flatrate_Term DROP CONSTRAINT IF EXISTS CCurrency_CFlatrateTerm;
ALTER TABLE C_Flatrate_Term DROP CONSTRAINT IF EXISTS CUOM_CFlatrateTerm;
ALTER TABLE C_IncidentLineFact DROP CONSTRAINT IF EXISTS ADTable_CIncidentLineFact;
ALTER TABLE C_IncidentLineFact DROP CONSTRAINT IF EXISTS CAdvCommissionFactCand_CIncide;
ALTER TABLE C_IncidentLineFact DROP CONSTRAINT IF EXISTS CAdvCommissionRelevantPO_CInci;
ALTER TABLE C_IncidentLineFact DROP CONSTRAINT IF EXISTS CBPartner_CIncidentLineFact;
ALTER TABLE C_IncidentLineFact DROP CONSTRAINT IF EXISTS CIncidentLine_CIncidentLineFac;
ALTER TABLE C_Invoice_Detail DROP CONSTRAINT IF EXISTS CInvoice_CInvoiceDetail;
ALTER TABLE C_Invoice_Detail DROP CONSTRAINT IF EXISTS CInvoiceLine_CInvoiceDetail;
ALTER TABLE C_Invoice_Detail DROP CONSTRAINT IF EXISTS CUOM_CInvoiceDetail;
ALTER TABLE C_Invoice_Detail DROP CONSTRAINT IF EXISTS MAttributeSetInstance_CInvoice;
ALTER TABLE C_Invoice_Detail DROP CONSTRAINT IF EXISTS MHUPIItemProduct_CInvoiceDetai;
ALTER TABLE C_Invoice_Detail DROP CONSTRAINT IF EXISTS MProduct_CInvoiceDetail;
ALTER TABLE C_Invoice_Detail DROP CONSTRAINT IF EXISTS MTUHUPI_CInvoiceDetail;
ALTER TABLE C_Invoice_Detail DROP CONSTRAINT IF EXISTS PriceUOM_CInvoiceDetail;
ALTER TABLE C_InvoiceLine DROP CONSTRAINT IF EXISTS COrder_CInvoiceLine;
ALTER TABLE C_InvoiceLine DROP CONSTRAINT IF EXISTS MHUPIItemProduct_CInvoiceLine;
ALTER TABLE CM_Media DROP CONSTRAINT IF EXISTS ADImage_CMMedia;
ALTER TABLE C_OLCand DROP CONSTRAINT IF EXISTS CUOMInternal_COLCand;
ALTER TABLE C_OLCand DROP CONSTRAINT IF EXISTS DropShipBPartnerOverride_COLCa;
ALTER TABLE C_OLCand DROP CONSTRAINT IF EXISTS DropShipLocationOverride_COLCa;
ALTER TABLE C_OLCand DROP CONSTRAINT IF EXISTS EXPReplicationTrx_COLCand;
ALTER TABLE C_OLCand DROP CONSTRAINT IF EXISTS HandOverLocationOverride_COLCa;
ALTER TABLE C_OLCand DROP CONSTRAINT IF EXISTS HandOverPartnerOverride_COLCan;
ALTER TABLE C_OLCand DROP CONSTRAINT IF EXISTS MHUPIItemProductOverride_COLCa;
ALTER TABLE C_OLCand DROP CONSTRAINT IF EXISTS MProductOverride_COLCand;
ALTER TABLE C_OLCand DROP CONSTRAINT IF EXISTS MProductPriceAttribute_COLCand;
ALTER TABLE C_OLCand DROP CONSTRAINT IF EXISTS MProductPrice_COLCand;
ALTER TABLE C_OLCand DROP CONSTRAINT IF EXISTS PriceUOMInternal_COLCand;
ALTER TABLE C_OLCandAggAndOrder DROP CONSTRAINT IF EXISTS ADInputDataSource_COLCandAggAn;
ALTER TABLE C_PaymentProcessor DROP CONSTRAINT IF EXISTS CBPBankAccount_CPaymentProcess;
ALTER TABLE C_Payment_Request DROP CONSTRAINT IF EXISTS CBPBankAccount_CPaymentRequest;
ALTER TABLE C_Payment_Request DROP CONSTRAINT IF EXISTS CInvoice_CPaymentRequest;
ALTER TABLE C_PaySelection DROP CONSTRAINT IF EXISTS LastExportBy_CPaySelection;
ALTER TABLE C_POS DROP CONSTRAINT IF EXISTS CBPBankAccount_CPOS;
ALTER TABLE C_POS_HUEditor_Filter DROP CONSTRAINT IF EXISTS ADJavaClass_CPOSHUEditorFilter;
ALTER TABLE C_POS_HUEditor_Filter DROP CONSTRAINT IF EXISTS ADReference_CPOSHUEditorFilter;
ALTER TABLE C_POS_HUEditor_Filter DROP CONSTRAINT IF EXISTS ADReferenceValue_CPOSHUEditorF;
ALTER TABLE C_POSKey DROP CONSTRAINT IF EXISTS ADValRule_CPOSKey;
ALTER TABLE C_Queue_Block DROP CONSTRAINT IF EXISTS ADPInstanceCreator_CQueueBlock;
ALTER TABLE C_RecurrentPaymentLine DROP CONSTRAINT IF EXISTS CBPBankAccountOwn_CRecurrentPa;
ALTER TABLE C_Sponsor DROP CONSTRAINT IF EXISTS CAdvCommissionSalaryGroup_CSpo;
ALTER TABLE C_Sponsor DROP CONSTRAINT IF EXISTS CAdvComRankSystem_CSponsor;
ALTER TABLE C_Sponsor_SalesRep DROP CONSTRAINT IF EXISTS CAdvCommissionCondition_CSpons;
ALTER TABLE C_Sponsor_SalesRep DROP CONSTRAINT IF EXISTS CAdvComSystem_CSponsorSalesRep;
ALTER TABLE C_SubscriptionProgress DROP CONSTRAINT IF EXISTS CFlatrateTerm_CSubscriptionPro;
ALTER TABLE C_SubscriptionProgress DROP CONSTRAINT IF EXISTS DropShipBPartner_CSubscription;
ALTER TABLE C_Tax_Acct DROP CONSTRAINT IF EXISTS TPayDiscountExpA_CTaxAcct;
ALTER TABLE C_Tax_Acct DROP CONSTRAINT IF EXISTS TPayDiscountRevA_CTaxAcct;
ALTER TABLE C_Tax_Acct DROP CONSTRAINT IF EXISTS TRevenueA_CTaxAcct;
ALTER TABLE C_TaxDeclarationAcct DROP CONSTRAINT IF EXISTS FactAcct_CTaxDeclarationAcct;
ALTER TABLE DD_OrderLine DROP CONSTRAINT IF EXISTS MHUPIItemProduct_DDOrderLine;
ALTER TABLE DD_OrderLine_Alternative DROP CONSTRAINT IF EXISTS MAttributeSetInstance_DDOrderL;
ALTER TABLE DIM_Dimension_Spec DROP CONSTRAINT IF EXISTS DIMDimensionType_DIMDimensionS;
ALTER TABLE DIM_Dimension_Spec_Assignment DROP CONSTRAINT IF EXISTS ADColumn_DIMDimensionSpecAssig;
ALTER TABLE DIM_Dimension_Spec_Assignment DROP CONSTRAINT IF EXISTS DIMDimensionSpec_DIMDimensionS;
ALTER TABLE DIM_Dimension_Spec_Attribute DROP CONSTRAINT IF EXISTS DIMDimensionSpec_DIMDimensionS;
ALTER TABLE DIM_Dimension_Spec_Attribute DROP CONSTRAINT IF EXISTS MAttribute_DIMDimensionSpecAtt;
ALTER TABLE DIM_Dimension_Spec_AttributeValue DROP CONSTRAINT IF EXISTS DIMDimensionSpecAttribute_DIMD;
ALTER TABLE DIM_Dimension_Spec_AttributeValue DROP CONSTRAINT IF EXISTS MAttributeValue_DIMDimensionSp;
ALTER TABLE ESR_Import DROP CONSTRAINT IF EXISTS CBPBankAccount_ESRImport;
ALTER TABLE ESR_ImportLine DROP CONSTRAINT IF EXISTS CBPartner_ESRImportLine;
ALTER TABLE ESR_ImportLine DROP CONSTRAINT IF EXISTS CBPBankAccount_ESRImportLine;
ALTER TABLE ESR_ImportLine DROP CONSTRAINT IF EXISTS CInvoice_ESRImportLine;
ALTER TABLE ESR_ImportLine DROP CONSTRAINT IF EXISTS CPayment_ESRImportLine;
ALTER TABLE ESR_ImportLine DROP CONSTRAINT IF EXISTS CReferenceNo_ESRImportLine;
ALTER TABLE EXP_Format DROP CONSTRAINT IF EXISTS ADSequence_EXPFormat;
ALTER TABLE EXP_Format DROP CONSTRAINT IF EXISTS EntityT_EXPFormat;
ALTER TABLE EXP_Format DROP CONSTRAINT IF EXISTS IMPRequestHandler_EXPFormat;
ALTER TABLE EXP_FormatLine DROP CONSTRAINT IF EXISTS ADReferenceOverride_EXPFormatL;
ALTER TABLE EXP_FormatLine DROP CONSTRAINT IF EXISTS EntityT_EXPFormatLine;
ALTER TABLE EXP_ReplicationTrxLine DROP CONSTRAINT IF EXISTS ADTable_EXPReplicationTrxLine;
ALTER TABLE EXP_ReplicationTrxLine DROP CONSTRAINT IF EXISTS EXPReplicationTrx_EXPReplicati;
ALTER TABLE Fact_Acct_ActivityChangeRequest DROP CONSTRAINT IF EXISTS Account_FactAcctActivityChange;
ALTER TABLE Fact_Acct_ActivityChangeRequest DROP CONSTRAINT IF EXISTS ADTable_FactAcctActivityChange;
ALTER TABLE Fact_Acct_ActivityChangeRequest DROP CONSTRAINT IF EXISTS CAcctSchema_FactAcctActivityCh;
ALTER TABLE Fact_Acct_ActivityChangeRequest DROP CONSTRAINT IF EXISTS CActivity_FactAcctActivityChan;
ALTER TABLE Fact_Acct_ActivityChangeRequest DROP CONSTRAINT IF EXISTS CActivityOverride_FactAcctActi;
ALTER TABLE Fact_Acct_ActivityChangeRequest DROP CONSTRAINT IF EXISTS CBPartner_FactAcctActivityChan;
ALTER TABLE Fact_Acct_ActivityChangeRequest DROP CONSTRAINT IF EXISTS CCurrency_FactAcctActivityChan;
ALTER TABLE Fact_Acct_ActivityChangeRequest DROP CONSTRAINT IF EXISTS CDocType_FactAcctActivityChang;
ALTER TABLE Fact_Acct_ActivityChangeRequest DROP CONSTRAINT IF EXISTS CPeriod_FactAcctActivityChange;
ALTER TABLE Fact_Acct_ActivityChangeRequest DROP CONSTRAINT IF EXISTS CUOM_FactAcctActivityChangeReq;
ALTER TABLE Fact_Acct_ActivityChangeRequest DROP CONSTRAINT IF EXISTS FactAcct_FactAcctActivityChang;
ALTER TABLE Fact_Acct_ActivityChangeRequest DROP CONSTRAINT IF EXISTS MProduct_FactAcctActivityChang;
ALTER TABLE Fact_Acct_EndingBalance DROP CONSTRAINT IF EXISTS Account_FactAcctEndingBalance;
ALTER TABLE Fact_Acct_EndingBalance DROP CONSTRAINT IF EXISTS CAcctSchema_FactAcctEndingBala;
ALTER TABLE Fact_Acct_Log DROP CONSTRAINT IF EXISTS CAcctSchema_FactAcctLog;
ALTER TABLE Fact_Acct_Log DROP CONSTRAINT IF EXISTS CElementValue_FactAcctLog;
ALTER TABLE Fact_Acct_Log DROP CONSTRAINT IF EXISTS CPeriod_FactAcctLog;
ALTER TABLE Fact_Acct_Summary DROP CONSTRAINT IF EXISTS ADOrgTrx_FactAcctSummary;
ALTER TABLE Fact_Acct_Summary DROP CONSTRAINT IF EXISTS CLocFrom_FactAcctSummary;
ALTER TABLE Fact_Acct_Summary DROP CONSTRAINT IF EXISTS CLocTo_FactAcctSummary;
ALTER TABLE Fact_Acct_Summary DROP CONSTRAINT IF EXISTS CYear_FactAcctSummary;
ALTER TABLE Fresh_QtyOnHand_Line DROP CONSTRAINT IF EXISTS PPPlant_FreshQtyOnHandLine;
ALTER TABLE HR_Attribute DROP CONSTRAINT IF EXISTS HRAttributeA_HRAttribute;
ALTER TABLE HR_Concept_Acct DROP CONSTRAINT IF EXISTS HRExpenseA_HRConceptAcct;
ALTER TABLE HR_Concept_Acct DROP CONSTRAINT IF EXISTS HRRevenueA_HRConceptAcct;
ALTER TABLE HR_Concept_Acct DROP CONSTRAINT IF EXISTS User2_HRConceptAcct;
ALTER TABLE HR_Concept_Category DROP CONSTRAINT IF EXISTS HRConceptA_HRConceptCategory;
ALTER TABLE I_Asset DROP CONSTRAINT IF EXISTS AAccumdepreciationA_IAsset;
ALTER TABLE I_Asset DROP CONSTRAINT IF EXISTS AAssetA_IAsset;
ALTER TABLE I_Asset DROP CONSTRAINT IF EXISTS AAssetSpreadT_IAsset;
ALTER TABLE I_Asset DROP CONSTRAINT IF EXISTS ADepreciationA_IAsset;
ALTER TABLE I_Asset DROP CONSTRAINT IF EXISTS ADepreciationCalcT_IAsset;
ALTER TABLE I_Asset DROP CONSTRAINT IF EXISTS ADisposalL_IAsset;
ALTER TABLE I_Asset DROP CONSTRAINT IF EXISTS ADisposalReve_IAsset;
ALTER TABLE I_Asset DROP CONSTRAINT IF EXISTS ARevalAccumdepOffset_IAsset;
ALTER TABLE I_Asset DROP CONSTRAINT IF EXISTS ARevalAccumdepOffsetPr_IAsset;
ALTER TABLE I_Asset DROP CONSTRAINT IF EXISTS ARevalCostOff_IAsset;
ALTER TABLE I_Asset DROP CONSTRAINT IF EXISTS ARevalCostOffsetPr_IAsset;
ALTER TABLE I_Asset DROP CONSTRAINT IF EXISTS ARevalDepexpOff_IAsset;
ALTER TABLE I_Asset DROP CONSTRAINT IF EXISTS ConventionT_IAsset;
ALTER TABLE I_Asset DROP CONSTRAINT IF EXISTS DepreciationT_IAsset;
ALTER TABLE I_Asset DROP CONSTRAINT IF EXISTS MAttributeSetInstance_IAsset;
ALTER TABLE I_BankStatement DROP CONSTRAINT IF EXISTS CBPBankAccount_IBankStatement;
ALTER TABLE I_GLJournal DROP CONSTRAINT IF EXISTS AccountFrom_IGLJournal;
ALTER TABLE I_GLJournal DROP CONSTRAINT IF EXISTS AccountTo_IGLJournal;
ALTER TABLE I_GLJournal DROP CONSTRAINT IF EXISTS CValidCombinationFrom_IGLJourn;
ALTER TABLE I_GLJournal DROP CONSTRAINT IF EXISTS CValidCombinationTo_IGLJournal;
ALTER TABLE I_Payment DROP CONSTRAINT IF EXISTS CBPBankAccount_IPayment;
ALTER TABLE I_Product DROP CONSTRAINT IF EXISTS CTaxCategory_IProduct;
ALTER TABLE I_Product DROP CONSTRAINT IF EXISTS MPriceListVersion_IProduct;
ALTER TABLE M_DiscountSchemaBreak DROP CONSTRAINT IF EXISTS MAttribute_MDiscountSchemaBrea;
ALTER TABLE M_DiscountSchemaBreak DROP CONSTRAINT IF EXISTS MAttributeValue_MDiscountSchem;
ALTER TABLE M_DiscountSchemaLine DROP CONSTRAINT IF EXISTS CTaxCategory_MDiscountSchemaLi;
ALTER TABLE M_DiscountSchemaLine DROP CONSTRAINT IF EXISTS CTaxCategoryTarget_MDiscountSc;
ALTER TABLE M_MatchInv DROP CONSTRAINT IF EXISTS CInvoice_MMatchInv;
ALTER TABLE M_Material_Balance_Config DROP CONSTRAINT IF EXISTS CBPartner_MMaterialBalanceConf;
ALTER TABLE M_Material_Balance_Config DROP CONSTRAINT IF EXISTS CBPGroup_MMaterialBalanceConfi;
ALTER TABLE M_Material_Balance_Config DROP CONSTRAINT IF EXISTS CCalendar_MMaterialBalanceConf;
ALTER TABLE M_Material_Balance_Config DROP CONSTRAINT IF EXISTS MProductCategory_MMaterialBala;
ALTER TABLE M_Material_Balance_Config DROP CONSTRAINT IF EXISTS MProduct_MMaterialBalanceConfi;
ALTER TABLE M_Material_Balance_Config DROP CONSTRAINT IF EXISTS MWarehouse_MMaterialBalanceCon;
ALTER TABLE M_Material_Balance_Detail DROP CONSTRAINT IF EXISTS CBPartner_MMaterialBalanceDeta;
ALTER TABLE M_Material_Balance_Detail DROP CONSTRAINT IF EXISTS CDocType_MMaterialBalanceDetai;
ALTER TABLE M_Material_Balance_Detail DROP CONSTRAINT IF EXISTS CPeriod_MMaterialBalanceDetail;
ALTER TABLE M_Material_Balance_Detail DROP CONSTRAINT IF EXISTS CUOM_MMaterialBalanceDetail;
ALTER TABLE M_Material_Balance_Detail DROP CONSTRAINT IF EXISTS MInOut_MMaterialBalanceDetail;
ALTER TABLE M_Material_Balance_Detail DROP CONSTRAINT IF EXISTS MInOutLine_MMaterialBalanceDet;
ALTER TABLE M_Material_Balance_Detail DROP CONSTRAINT IF EXISTS MMaterialBalanceConfig_MMateri;
ALTER TABLE M_Material_Balance_Detail DROP CONSTRAINT IF EXISTS MProduct_MMaterialBalanceDetai;
ALTER TABLE M_Material_Tracking_Report_Line_Alloc DROP CONSTRAINT IF EXISTS MInOutLine_MMaterialTrackingRe;
ALTER TABLE M_Material_Tracking_Report_Line_Alloc DROP CONSTRAINT IF EXISTS PPOrder_MMaterialTrackingRepor;
ALTER TABLE M_Product DROP CONSTRAINT IF EXISTS CTaxCategory_MProduct;
ALTER TABLE M_Product DROP CONSTRAINT IF EXISTS SalesgroupUOM_MProduct;
ALTER TABLE P_AdvCommissionDetails DROP CONSTRAINT IF EXISTS CAdvCommissionInstance_PAdvCom;
ALTER TABLE P_AdvCommissionDetails DROP CONSTRAINT IF EXISTS CAdvCommissionTerm_PAdvCommiss;
ALTER TABLE P_AdvCommissionDetails DROP CONSTRAINT IF EXISTS CDocType_PAdvCommissionDetails;
ALTER TABLE P_AdvCommissionDetails DROP CONSTRAINT IF EXISTS CSponsor_PAdvCommissionDetails;
ALTER TABLE P_AdvCommissionDetails DROP CONSTRAINT IF EXISTS MProduct_PAdvCommissionDetails;
ALTER TABLE Pay_OnlinePaymentHistory DROP CONSTRAINT IF EXISTS CPayment_PayOnlinePaymentHisto;
ALTER TABLE PP_Cost_Collector DROP CONSTRAINT IF EXISTS PPCostCollectorParent_PPCostCo;
ALTER TABLE PP_Order_ProductAttribute DROP CONSTRAINT IF EXISTS MAttribute_PPOrderProductAttri;
ALTER TABLE PP_Order_ProductAttribute DROP CONSTRAINT IF EXISTS MAttributeValue_PPOrderProduct;
ALTER TABLE PP_Order_ProductAttribute DROP CONSTRAINT IF EXISTS MHU_PPOrderProductAttribute;
ALTER TABLE PP_Order_ProductAttribute DROP CONSTRAINT IF EXISTS PPCostCollector_PPOrderProduct;
ALTER TABLE PP_Order_ProductAttribute DROP CONSTRAINT IF EXISTS PPOrder_PPOrderProductAttribut;
ALTER TABLE R_Group DROP CONSTRAINT IF EXISTS RCategory_RGroup;
ALTER TABLE R_Group_Prospect DROP CONSTRAINT IF EXISTS Locke_RGroupProspect;
ALTER TABLE SEPA_Export DROP CONSTRAINT IF EXISTS ADTable_SEPAExport;
ALTER TABLE SEPA_Export_Line DROP CONSTRAINT IF EXISTS ADTable_SEPAExportLine;
ALTER TABLE SEPA_Export_Line DROP CONSTRAINT IF EXISTS CBPartner_SEPAExportLine;
ALTER TABLE SEPA_Export_Line DROP CONSTRAINT IF EXISTS CBPBankAccount_SEPAExportLine;
ALTER TABLE SEPA_Export_Line DROP CONSTRAINT IF EXISTS CCurrency_SEPAExportLine;
ALTER TABLE SEPA_Export_Line DROP CONSTRAINT IF EXISTS SEPAExport_SEPAExportLine;
ALTER TABLE SEPA_Export_Line DROP CONSTRAINT IF EXISTS SEPAExportLineRetry_SEPAExport;
ALTER TABLE X_MRP_ProductInfo_Detail_MV DROP CONSTRAINT IF EXISTS MAttributeSetInstance_XMRPProd;

----------------------


DELETE FROM AD_ColumnCallout WHERE EntityType='de.metas.bdk';
ALTER TABLE AD_ColumnCallout ADD CONSTRAINT EntityT_ADColumnCallout FOREIGN KEY (EntityType) REFERENCES AD_EntityType DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE AD_JAXRS_Endpoint ADD CONSTRAINT ADJavaClass_ADJAXRSEndpoint FOREIGN KEY (AD_JavaClass_ID) REFERENCES AD_JavaClass DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE AD_JAXRS_Endpoint ADD CONSTRAINT EntityT_ADJAXRSEndpoint FOREIGN KEY (EntityType) REFERENCES AD_EntityType DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE AD_MailConfig ADD CONSTRAINT ADMailBox_ADMailConfig FOREIGN KEY (AD_MailBox_ID) REFERENCES AD_MailBox DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE AD_MailConfig ADD CONSTRAINT ADProcess_ADMailConfig FOREIGN KEY (AD_Process_ID) REFERENCES AD_Process DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE AD_Migration ADD CONSTRAINT EntityT_ADMigration FOREIGN KEY (EntityType) REFERENCES AD_EntityType DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE AD_MigrationData ADD CONSTRAINT ADColumn_ADMigrationData FOREIGN KEY (AD_Column_ID) REFERENCES AD_Column DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE AD_MigrationStep ADD CONSTRAINT ADTable_ADMigrationStep FOREIGN KEY (AD_Table_ID) REFERENCES AD_Table DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE AD_ProcessablePO ADD CONSTRAINT ADIssue_ADProcessablePO FOREIGN KEY (AD_Issue_ID) REFERENCES AD_Issue DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE AD_ProcessablePO ADD CONSTRAINT ADTable_ADProcessablePO FOREIGN KEY (AD_Table_ID) REFERENCES AD_Table DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE AD_Registration ADD CONSTRAINT CLocation_ADRegistration FOREIGN KEY (C_Location_ID) REFERENCES C_Location DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE AD_Scheduler ADD CONSTRAINT EntityT_ADScheduler FOREIGN KEY (EntityType) REFERENCES AD_EntityType DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE AD_User ADD CONSTRAINT ADUserInCharge_ADUser FOREIGN KEY (AD_User_InCharge_ID) REFERENCES AD_User DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE AD_User_Login ADD CONSTRAINT ADRole_ADUserLogin FOREIGN KEY (AD_Role_ID) REFERENCES AD_Role DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE AD_User_Login ADD CONSTRAINT ADSession_ADUserLogin FOREIGN KEY (AD_Session_ID) REFERENCES AD_Session DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE AD_User_Login ADD CONSTRAINT ADUser_ADUserLogin FOREIGN KEY (AD_User_ID) REFERENCES AD_User DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE C_AcctSchema_Default ADD CONSTRAINT CReceivableServicesA_CAcctSche FOREIGN KEY (C_Receivable_Services_Acct) REFERENCES C_ValidCombination DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE C_AcctSchema_Default ADD CONSTRAINT PCostAdjustmentA_CAcctSchemaDe FOREIGN KEY (P_CostAdjustment_Acct) REFERENCES C_ValidCombination DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE C_AcctSchema_Default ADD CONSTRAINT PInventoryClearingA_CAcctSchem FOREIGN KEY (P_InventoryClearing_Acct) REFERENCES C_ValidCombination DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE C_AcctSchema_GL ADD CONSTRAINT CommitmentOffsetA_CAcctSchemaG FOREIGN KEY (CommitmentOffset_Acct) REFERENCES C_ValidCombination DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE C_AcctSchema_GL ADD CONSTRAINT CommitmentOffsetSalesA_CAcctSc FOREIGN KEY (CommitmentOffsetSales_Acct) REFERENCES C_ValidCombination DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE C_AdvComCorrection ADD CONSTRAINT ADTable_CAdvComCorrection FOREIGN KEY (AD_Table_ID) REFERENCES AD_Table DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE C_AdvComCorrection ADD CONSTRAINT CSponsorCustomer_CAdvComCorrec FOREIGN KEY (C_Sponsor_Customer_ID) REFERENCES C_Sponsor DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE C_AdvComCorrection ADD CONSTRAINT CSponsorSalesRep_CAdvComCorrec FOREIGN KEY (C_Sponsor_SalesRep_ID) REFERENCES C_Sponsor DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE C_AdvComDoc ADD CONSTRAINT ADTable_CAdvComDoc FOREIGN KEY (AD_Table_ID) REFERENCES AD_Table DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE C_AdvComDoc ADD CONSTRAINT CAllocationLine_CAdvComDoc FOREIGN KEY (C_AllocationLine_ID) REFERENCES C_AllocationLine DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE C_AdvComDoc ADD CONSTRAINT CDocTypeRef_CAdvComDoc FOREIGN KEY (C_DocType_Ref_ID) REFERENCES C_DocType DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE C_AdvComInstanceParam ADD CONSTRAINT ADReference_CAdvComInstancePar FOREIGN KEY (AD_Reference_ID) REFERENCES AD_Reference DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE C_AdvComInstanceParam ADD CONSTRAINT ADReferenceValue_CAdvComInstan FOREIGN KEY (AD_Reference_Value_ID) REFERENCES AD_Reference DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE C_AdvComInstanceParam ADD CONSTRAINT CAdvComSystemType_CAdvComInsta FOREIGN KEY (C_AdvComSystem_Type_ID) REFERENCES C_AdvComSystem_Type DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE C_AdvCommissionCondition ADD CONSTRAINT CAdvComSystem_CAdvCommissionCo FOREIGN KEY (C_AdvComSystem_ID) REFERENCES C_AdvComSystem DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE C_AdvCommissionCondition ADD CONSTRAINT CDoctypePayroll_CAdvCommission FOREIGN KEY (C_Doctype_Payroll_ID) REFERENCES C_DocType DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE C_AdvCommissionCondition ADD CONSTRAINT HRPayroll_CAdvCommissionCondit FOREIGN KEY (HR_Payroll_ID) REFERENCES HR_Payroll DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE C_AdvCommissionCondition ADD CONSTRAINT MProductCategory_CAdvCommissio FOREIGN KEY (M_Product_Category_ID) REFERENCES M_Product_Category DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE C_AdvCommissionFact ADD CONSTRAINT ADPInstance_CAdvCommissionFact FOREIGN KEY (AD_PInstance_ID) REFERENCES AD_PInstance DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE C_AdvCommissionFact ADD CONSTRAINT CAdvCommissionFactCand_CAdvCom FOREIGN KEY (C_AdvCommissionFactCand_ID) REFERENCES C_AdvCommissionFactCand DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE C_AdvCommissionFact ADD CONSTRAINT CIncidentLineFact_CAdvCommissi FOREIGN KEY (C_IncidentLineFact_ID) REFERENCES C_IncidentLineFact DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE C_AdvCommissionFactCand ADD CONSTRAINT CAdvComFactCandCause_CAdvCommi FOREIGN KEY (C_AdvComFactCand_Cause_ID) REFERENCES C_AdvCommissionFactCand DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE C_AdvCommissionFactCand ADD CONSTRAINT CAdvCommissionRelevantPO_CAdvC FOREIGN KEY (C_AdvCommissionRelevantPO_ID) REFERENCES C_AdvCommissionRelevantPO DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE C_AdvCommissionInstance ADD CONSTRAINT ADPInstance_CAdvCommissionInst FOREIGN KEY (AD_PInstance_ID) REFERENCES AD_PInstance DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE C_AdvCommissionInstance ADD CONSTRAINT CAdvCommissionRelevantPO_CAdvC FOREIGN KEY (C_AdvCommissionRelevantPO_ID) REFERENCES C_AdvCommissionRelevantPO DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE C_AdvCommissionInstance ADD CONSTRAINT CAdvComSystemType_CAdvCommissi FOREIGN KEY (C_AdvComSystem_Type_ID) REFERENCES C_AdvComSystem_Type DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE C_AdvCommissionInstance ADD CONSTRAINT CIncidentLine_CAdvCommissionIn FOREIGN KEY (C_IncidentLine_ID) REFERENCES C_IncidentLine DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE C_AdvCommissionRelevantPO ADD CONSTRAINT BPartnerColumn_CAdvCommissionR FOREIGN KEY (BPartnerColumn_ID) REFERENCES AD_Column DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE C_AdvCommissionRelevantPO ADD CONSTRAINT DateDocColumn_CAdvCommissionRe FOREIGN KEY (DateDocColumn_ID) REFERENCES AD_Column DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE C_AdvCommissionSalaryGroup ADD CONSTRAINT CAdvComRankCollection_CAdvComm FOREIGN KEY (C_AdvComRankCollection_ID) REFERENCES C_AdvComRankCollection DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE C_AdvCommissionTerm ADD CONSTRAINT CAdvComSystemType_CAdvCommissi FOREIGN KEY (C_AdvComSystem_Type_ID) REFERENCES C_AdvComSystem_Type DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE C_AdvCommissionTerm ADD CONSTRAINT CAdvComTermSRFCollector_CAdvCo FOREIGN KEY (C_AdvComTermSRFCollector_ID) REFERENCES C_AdvCommissionTerm DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE C_AdvCommissionTerm ADD CONSTRAINT MProductCategory_CAdvCommissio FOREIGN KEY (M_Product_Category_ID) REFERENCES M_Product_Category DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE C_AdvComRankForecast ADD CONSTRAINT CAdvCommissionSalaryGroup_CAdv FOREIGN KEY (C_AdvCommissionSalaryGroup_ID) REFERENCES C_AdvCommissionSalaryGroup DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE C_AdvComRankForecast ADD CONSTRAINT CAdvComRankNext_CAdvComRankFor FOREIGN KEY (C_AdvComRank_Next_ID) REFERENCES C_AdvCommissionSalaryGroup DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE C_AdvComRankForecast ADD CONSTRAINT CAdvComSystem_CAdvComRankForec FOREIGN KEY (C_AdvComSystem_ID) REFERENCES C_AdvComSystem DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE C_AdvComRankForecast ADD CONSTRAINT CBPartner_CAdvComRankForecast FOREIGN KEY (C_BPartner_ID) REFERENCES C_BPartner DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE C_AdvComRankForecast ADD CONSTRAINT CPeriodSince_CAdvComRankForeca FOREIGN KEY (C_Period_Since_ID) REFERENCES C_Period DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE C_AdvComRankForecast ADD CONSTRAINT CPeriodUntil_CAdvComRankForeca FOREIGN KEY (C_Period_Until_ID) REFERENCES C_Period DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE C_AdvComRankForecast ADD CONSTRAINT CSponsor_CAdvComRankForecast FOREIGN KEY (C_Sponsor_ID) REFERENCES C_Sponsor DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE C_AdvComRelevantPO_Type ADD CONSTRAINT CAdvCommissionRelevantPO_CAdvC FOREIGN KEY (C_AdvCommissionRelevantPO_ID) REFERENCES C_AdvCommissionRelevantPO DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE C_AdvComRelevantPO_Type ADD CONSTRAINT CAdvComSystem_CAdvComRelevantP FOREIGN KEY (C_AdvComSystem_ID) REFERENCES C_AdvComSystem DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE C_AdvComRelevantPO_Type ADD CONSTRAINT CAdvComSystemType_CAdvComRelev FOREIGN KEY (C_AdvComSystem_Type_ID) REFERENCES C_AdvComSystem_Type DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE C_AdvComSalesRepFact ADD CONSTRAINT CAdvCommissionSalaryGroup_CAdv FOREIGN KEY (C_AdvCommissionSalaryGroup_ID) REFERENCES C_AdvCommissionSalaryGroup DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE C_AdvComSalesRepFact ADD CONSTRAINT CAdvComSystem_CAdvComSalesRepF FOREIGN KEY (C_AdvComSystem_ID) REFERENCES C_AdvComSystem DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE C_AdvComSalesRepFact ADD CONSTRAINT CPeriod_CAdvComSalesRepFact FOREIGN KEY (C_Period_ID) REFERENCES C_Period DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE C_AdvComSalesRepFact ADD CONSTRAINT CSponsor_CAdvComSalesRepFact FOREIGN KEY (C_Sponsor_ID) REFERENCES C_Sponsor DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE C_AdvComSponsorParam ADD CONSTRAINT ADReference_CAdvComSponsorPara FOREIGN KEY (AD_Reference_ID) REFERENCES AD_Reference DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE C_AdvComSponsorParam ADD CONSTRAINT ADReferenceValue_CAdvComSponso FOREIGN KEY (AD_Reference_Value_ID) REFERENCES AD_Reference DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE C_AdvComSponsorParam ADD CONSTRAINT CAdvCommissionTerm_CAdvComSpon FOREIGN KEY (C_AdvCommissionTerm_ID) REFERENCES C_AdvCommissionTerm DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE C_AdvComSystem ADD CONSTRAINT ADRoleAdmin_CAdvComSystem FOREIGN KEY (AD_Role_Admin_ID) REFERENCES AD_Role DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE C_AdvComSystem ADD CONSTRAINT ADUserAdmin_CAdvComSystem FOREIGN KEY (AD_User_Admin_ID) REFERENCES AD_User DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE C_AdvComSystem ADD CONSTRAINT CAdvComRankCollection_CAdvComS FOREIGN KEY (C_AdvComRankCollection_ID) REFERENCES C_AdvComRankCollection DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE C_AdvComSystem ADD CONSTRAINT CSponsorRoot_CAdvComSystem FOREIGN KEY (C_Sponsor_Root_ID) REFERENCES C_Sponsor DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE C_AdvComSystem_Type ADD CONSTRAINT CAdvCommissionType_CAdvComSyst FOREIGN KEY (C_AdvCommissionType_ID) REFERENCES C_AdvCommissionType DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE C_AdvComSystem_Type ADD CONSTRAINT CAdvComRankMin_CAdvComSystemTy FOREIGN KEY (C_AdvComRank_Min_ID) REFERENCES C_AdvCommissionSalaryGroup DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE C_AdvComSystem_Type ADD CONSTRAINT CAdvComSystem_CAdvComSystemTyp FOREIGN KEY (C_AdvComSystem_ID) REFERENCES C_AdvComSystem DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE C_AdvComSystem_Type ADD CONSTRAINT MProductCategory_CAdvComSystem FOREIGN KEY (M_Product_Category_ID) REFERENCES M_Product_Category DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE C_Async_Batch ADD CONSTRAINT ADPInstance_CAsyncBatch FOREIGN KEY (AD_PInstance_ID) REFERENCES AD_PInstance DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE C_Async_Batch ADD CONSTRAINT CAsyncBatchType_CAsyncBatch FOREIGN KEY (C_Async_Batch_Type_ID) REFERENCES C_Async_Batch_Type DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE C_Async_Batch_Type ADD CONSTRAINT ADBoilerPlate_CAsyncBatchType FOREIGN KEY (AD_BoilerPlate_ID) REFERENCES AD_BoilerPlate DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE C_BankAccountDoc ADD CONSTRAINT CBPBankAccount_CBankAccountDoc FOREIGN KEY (C_BP_BankAccount_ID) REFERENCES C_BP_BankAccount DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE C_BPartner ADD CONSTRAINT CustomerGroup_CBPartner FOREIGN KEY (Customer_Group_ID) REFERENCES C_BP_Group DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE C_BPartner_Product ADD CONSTRAINT CBPartnerVendor_CBPartnerProdu FOREIGN KEY (C_BPartner_Vendor_ID) REFERENCES C_BPartner DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE C_BP_BankAccount ADD CONSTRAINT CCurrency_CBPBankAccount FOREIGN KEY (C_Currency_ID) REFERENCES C_Currency DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE C_BP_BankAccount_Acct ADD CONSTRAINT BAssetA_CBPBankAccountAcct FOREIGN KEY (B_Asset_Acct) REFERENCES C_ValidCombination DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE C_BP_BankAccount_Acct ADD CONSTRAINT BExpenseA_CBPBankAccountAcct FOREIGN KEY (B_Expense_Acct) REFERENCES C_ValidCombination DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE C_BP_BankAccount_Acct ADD CONSTRAINT BInterestExpA_CBPBankAccountAc FOREIGN KEY (B_InterestExp_Acct) REFERENCES C_ValidCombination DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE C_BP_BankAccount_Acct ADD CONSTRAINT BInterestRevA_CBPBankAccountAc FOREIGN KEY (B_InterestRev_Acct) REFERENCES C_ValidCombination DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE C_BP_BankAccount_Acct ADD CONSTRAINT BInTransitA_CBPBankAccountAcct FOREIGN KEY (B_InTransit_Acct) REFERENCES C_ValidCombination DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE C_BP_BankAccount_Acct ADD CONSTRAINT BPaymentSelectA_CBPBankAccount FOREIGN KEY (B_PaymentSelect_Acct) REFERENCES C_ValidCombination DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE C_BP_BankAccount_Acct ADD CONSTRAINT BRevaluationGainA_CBPBankAccou FOREIGN KEY (B_RevaluationGain_Acct) REFERENCES C_ValidCombination DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE C_BP_BankAccount_Acct ADD CONSTRAINT BRevaluationLossA_CBPBankAccou FOREIGN KEY (B_RevaluationLoss_Acct) REFERENCES C_ValidCombination DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE C_BP_BankAccount_Acct ADD CONSTRAINT BSettlementGainA_CBPBankAccoun FOREIGN KEY (B_SettlementGain_Acct) REFERENCES C_ValidCombination DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE C_BP_BankAccount_Acct ADD CONSTRAINT BSettlementLossA_CBPBankAccoun FOREIGN KEY (B_SettlementLoss_Acct) REFERENCES C_ValidCombination DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE C_BP_BankAccount_Acct ADD CONSTRAINT BUnallocatedCashA_CBPBankAccou FOREIGN KEY (B_UnallocatedCash_Acct) REFERENCES C_ValidCombination DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE C_BP_BankAccount_Acct ADD CONSTRAINT BUnidentifiedA_CBPBankAccountA FOREIGN KEY (B_Unidentified_Acct) REFERENCES C_ValidCombination DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE C_BP_Customer_Acct ADD CONSTRAINT CReceivableServicesA_CBPCustom FOREIGN KEY (C_Receivable_Services_Acct) REFERENCES C_ValidCombination DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE C_BP_DocLine_Sort ADD CONSTRAINT CBPartner_CBPDocLineSort FOREIGN KEY (C_BPartner_ID) REFERENCES C_BPartner DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE C_BP_DocLine_Sort ADD CONSTRAINT CDocLineSort_CBPDocLineSort FOREIGN KEY (C_DocLine_Sort_ID) REFERENCES C_DocLine_Sort DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE C_BP_Group_Acct ADD CONSTRAINT CReceivableServicesA_CBPGroupA FOREIGN KEY (C_Receivable_Services_Acct) REFERENCES C_ValidCombination DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE C_BP_PrintFormat ADD CONSTRAINT ADPrintFormat_CBPPrintFormat FOREIGN KEY (AD_PrintFormat_ID) REFERENCES AD_PrintFormat DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE C_BP_PrintFormat ADD CONSTRAINT ADTable_CBPPrintFormat FOREIGN KEY (AD_Table_ID) REFERENCES AD_Table DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE C_BP_PrintFormat ADD CONSTRAINT CBPartner_CBPPrintFormat FOREIGN KEY (C_BPartner_ID) REFERENCES C_BPartner DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE C_BP_PrintFormat ADD CONSTRAINT CDocType_CBPPrintFormat FOREIGN KEY (C_DocType_ID) REFERENCES C_DocType DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE C_CashLine ADD CONSTRAINT CBPBankAccount_CCashLine FOREIGN KEY (C_BP_BankAccount_ID) REFERENCES C_BP_BankAccount DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE C_Contract_Change ADD CONSTRAINT CFlatrateTransition_CContractC FOREIGN KEY (C_Flatrate_Transition_ID) REFERENCES C_Flatrate_Transition DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE C_DocLine_Sort_Item ADD CONSTRAINT CDocLineSort_CDocLineSortItem FOREIGN KEY (C_DocLine_Sort_ID) REFERENCES C_DocLine_Sort DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE C_DocLine_Sort_Item ADD CONSTRAINT MProduct_CDocLineSortItem FOREIGN KEY (M_Product_ID) REFERENCES M_Product DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE C_Dunning_Candidate ADD CONSTRAINT CBPartner_CDunningCandidate FOREIGN KEY (C_BPartner_ID) REFERENCES C_BPartner DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE C_DunningDoc ADD CONSTRAINT CBPartner_CDunningDoc FOREIGN KEY (C_BPartner_ID) REFERENCES C_BPartner DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE C_DunningDoc_Line ADD CONSTRAINT CBPartner_CDunningDocLine FOREIGN KEY (C_BPartner_ID) REFERENCES C_BPartner DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE C_ElementValue ADD CONSTRAINT CBPBankAccount_CElementValue FOREIGN KEY (C_BP_BankAccount_ID) REFERENCES C_BP_BankAccount DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE C_ElementValue ADD CONSTRAINT CTax_CElementValue FOREIGN KEY (C_Tax_ID) REFERENCES C_Tax DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE C_ElementValue ADD CONSTRAINT ForeignCurrency_CElementValue FOREIGN KEY (Foreign_Currency_ID) REFERENCES C_Currency DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE C_Flatrate_Conditions ADD CONSTRAINT CFlatrateTransition_CFlatrateC FOREIGN KEY (C_Flatrate_Transition_ID) REFERENCES C_Flatrate_Transition DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE C_Flatrate_Term ADD CONSTRAINT CCurrency_CFlatrateTerm FOREIGN KEY (C_Currency_ID) REFERENCES C_Currency DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE C_Flatrate_Term ADD CONSTRAINT CUOM_CFlatrateTerm FOREIGN KEY (C_UOM_ID) REFERENCES C_UOM DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE C_IncidentLineFact ADD CONSTRAINT ADTable_CIncidentLineFact FOREIGN KEY (AD_Table_ID) REFERENCES AD_Table DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE C_IncidentLineFact ADD CONSTRAINT CAdvCommissionFactCand_CIncide FOREIGN KEY (C_AdvCommissionFactCand_ID) REFERENCES C_AdvCommissionFactCand DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE C_IncidentLineFact ADD CONSTRAINT CAdvCommissionRelevantPO_CInci FOREIGN KEY (C_AdvCommissionRelevantPO_ID) REFERENCES C_AdvCommissionRelevantPO DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE C_IncidentLineFact ADD CONSTRAINT CBPartner_CIncidentLineFact FOREIGN KEY (C_BPartner_ID) REFERENCES C_BPartner DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE C_IncidentLineFact ADD CONSTRAINT CIncidentLine_CIncidentLineFac FOREIGN KEY (C_IncidentLine_ID) REFERENCES C_IncidentLine DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE C_Invoice_Detail ADD CONSTRAINT CInvoice_CInvoiceDetail FOREIGN KEY (C_Invoice_ID) REFERENCES C_Invoice DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE C_Invoice_Detail ADD CONSTRAINT CInvoiceLine_CInvoiceDetail FOREIGN KEY (C_InvoiceLine_ID) REFERENCES C_InvoiceLine DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE C_Invoice_Detail ADD CONSTRAINT CUOM_CInvoiceDetail FOREIGN KEY (C_UOM_ID) REFERENCES C_UOM DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE C_Invoice_Detail ADD CONSTRAINT MAttributeSetInstance_CInvoice FOREIGN KEY (M_AttributeSetInstance_ID) REFERENCES M_AttributeSetInstance DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE C_Invoice_Detail ADD CONSTRAINT MHUPIItemProduct_CInvoiceDetai FOREIGN KEY (M_HU_PI_Item_Product_ID) REFERENCES M_HU_PI_Item_Product DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE C_Invoice_Detail ADD CONSTRAINT MProduct_CInvoiceDetail FOREIGN KEY (M_Product_ID) REFERENCES M_Product DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE C_Invoice_Detail ADD CONSTRAINT MTUHUPI_CInvoiceDetail FOREIGN KEY (M_TU_HU_PI_ID) REFERENCES M_HU_PI DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE C_Invoice_Detail ADD CONSTRAINT PriceUOM_CInvoiceDetail FOREIGN KEY (Price_UOM_ID) REFERENCES C_UOM DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE C_InvoiceLine ADD CONSTRAINT COrder_CInvoiceLine FOREIGN KEY (C_Order_ID) REFERENCES C_Order DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE C_InvoiceLine ADD CONSTRAINT MHUPIItemProduct_CInvoiceLine FOREIGN KEY (M_HU_PI_Item_Product_ID) REFERENCES M_HU_PI_Item_Product DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE CM_Media ADD CONSTRAINT ADImage_CMMedia FOREIGN KEY (AD_Image_ID) REFERENCES AD_Image DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE C_OLCand ADD CONSTRAINT CUOMInternal_COLCand FOREIGN KEY (C_UOM_Internal_ID) REFERENCES C_UOM DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE C_OLCand ADD CONSTRAINT DropShipBPartnerOverride_COLCa FOREIGN KEY (DropShip_BPartner_Override_ID) REFERENCES C_BPartner DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE C_OLCand ADD CONSTRAINT DropShipLocationOverride_COLCa FOREIGN KEY (DropShip_Location_Override_ID) REFERENCES C_BPartner_Location DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE C_OLCand ADD CONSTRAINT EXPReplicationTrx_COLCand FOREIGN KEY (EXP_ReplicationTrx_ID) REFERENCES EXP_ReplicationTrx DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE C_OLCand ADD CONSTRAINT HandOverLocationOverride_COLCa FOREIGN KEY (HandOver_Location_Override_ID) REFERENCES C_BPartner_Location DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE C_OLCand ADD CONSTRAINT HandOverPartnerOverride_COLCan FOREIGN KEY (HandOver_Partner_Override_ID) REFERENCES C_BPartner DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE C_OLCand ADD CONSTRAINT MHUPIItemProductOverride_COLCa FOREIGN KEY (M_HU_PI_Item_Product_Override_ID) REFERENCES M_HU_PI_Item_Product DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE C_OLCand ADD CONSTRAINT MProductOverride_COLCand FOREIGN KEY (M_Product_Override_ID) REFERENCES M_Product DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE C_OLCand ADD CONSTRAINT MProductPriceAttribute_COLCand FOREIGN KEY (M_ProductPrice_Attribute_ID) REFERENCES M_ProductPrice_Attribute DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE C_OLCand ADD CONSTRAINT MProductPrice_COLCand FOREIGN KEY (M_ProductPrice_ID) REFERENCES M_ProductPrice DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE C_OLCand ADD CONSTRAINT PriceUOMInternal_COLCand FOREIGN KEY (Price_UOM_Internal_ID) REFERENCES C_UOM DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE C_OLCandAggAndOrder ADD CONSTRAINT ADInputDataSource_COLCandAggAn FOREIGN KEY (AD_InputDataSource_ID) REFERENCES AD_InputDataSource DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE C_PaymentProcessor ADD CONSTRAINT CBPBankAccount_CPaymentProcess FOREIGN KEY (C_BP_BankAccount_ID) REFERENCES C_BP_BankAccount DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE C_Payment_Request ADD CONSTRAINT CBPBankAccount_CPaymentRequest FOREIGN KEY (C_BP_BankAccount_ID) REFERENCES C_BP_BankAccount DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE C_Payment_Request ADD CONSTRAINT CInvoice_CPaymentRequest FOREIGN KEY (C_Invoice_ID) REFERENCES C_Invoice DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE C_PaySelection ADD CONSTRAINT LastExportBy_CPaySelection FOREIGN KEY (LastExportBy_ID) REFERENCES AD_User DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE C_POS ADD CONSTRAINT CBPBankAccount_CPOS FOREIGN KEY (C_BP_BankAccount_ID) REFERENCES C_BP_BankAccount DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE C_POS_HUEditor_Filter ADD CONSTRAINT ADJavaClass_CPOSHUEditorFilter FOREIGN KEY (AD_JavaClass_ID) REFERENCES AD_JavaClass DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE C_POS_HUEditor_Filter ADD CONSTRAINT ADReference_CPOSHUEditorFilter FOREIGN KEY (AD_Reference_ID) REFERENCES AD_Reference DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE C_POS_HUEditor_Filter ADD CONSTRAINT ADReferenceValue_CPOSHUEditorF FOREIGN KEY (AD_Reference_Value_ID) REFERENCES AD_Reference DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE C_POSKey ADD CONSTRAINT ADValRule_CPOSKey FOREIGN KEY (AD_Val_Rule_ID) REFERENCES AD_Val_Rule DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE C_Queue_Block ADD CONSTRAINT ADPInstanceCreator_CQueueBlock FOREIGN KEY (AD_PInstance_Creator_ID) REFERENCES AD_PInstance DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE C_RecurrentPaymentLine ADD CONSTRAINT CBPBankAccountOwn_CRecurrentPa FOREIGN KEY (C_BP_BankAccount_Own_ID) REFERENCES C_BP_BankAccount DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE C_Sponsor ADD CONSTRAINT CAdvCommissionSalaryGroup_CSpo FOREIGN KEY (C_AdvCommissionSalaryGroup_ID) REFERENCES C_AdvCommissionSalaryGroup DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE C_Sponsor ADD CONSTRAINT CAdvComRankSystem_CSponsor FOREIGN KEY (C_AdvComRank_System_ID) REFERENCES C_AdvCommissionSalaryGroup DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE C_Sponsor_SalesRep ADD CONSTRAINT CAdvCommissionCondition_CSpons FOREIGN KEY (C_AdvCommissionCondition_ID) REFERENCES C_AdvCommissionCondition DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE C_Sponsor_SalesRep ADD CONSTRAINT CAdvComSystem_CSponsorSalesRep FOREIGN KEY (C_AdvComSystem_ID) REFERENCES C_AdvComSystem DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE C_SubscriptionProgress ADD CONSTRAINT CFlatrateTerm_CSubscriptionPro FOREIGN KEY (C_Flatrate_Term_ID) REFERENCES C_Flatrate_Term DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE C_SubscriptionProgress ADD CONSTRAINT DropShipBPartner_CSubscription FOREIGN KEY (DropShip_BPartner_ID) REFERENCES C_BPartner DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE C_Tax_Acct ADD CONSTRAINT TPayDiscountExpA_CTaxAcct FOREIGN KEY (T_PayDiscount_Exp_Acct) REFERENCES C_ValidCombination DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE C_Tax_Acct ADD CONSTRAINT TPayDiscountRevA_CTaxAcct FOREIGN KEY (T_PayDiscount_Rev_Acct) REFERENCES C_ValidCombination DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE C_Tax_Acct ADD CONSTRAINT TRevenueA_CTaxAcct FOREIGN KEY (T_Revenue_Acct) REFERENCES C_ValidCombination DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE C_TaxDeclarationAcct ADD CONSTRAINT FactAcct_CTaxDeclarationAcct FOREIGN KEY (Fact_Acct_ID) REFERENCES Fact_Acct DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE DD_OrderLine ADD CONSTRAINT MHUPIItemProduct_DDOrderLine FOREIGN KEY (M_HU_PI_Item_Product_ID) REFERENCES M_HU_PI_Item_Product DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE DD_OrderLine_Alternative ADD CONSTRAINT MAttributeSetInstance_DDOrderL FOREIGN KEY (M_AttributeSetInstance_ID) REFERENCES M_AttributeSetInstance DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE DIM_Dimension_Spec ADD CONSTRAINT DIMDimensionType_DIMDimensionS FOREIGN KEY (DIM_Dimension_Type_ID) REFERENCES DIM_Dimension_Type DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE DIM_Dimension_Spec_Assignment ADD CONSTRAINT ADColumn_DIMDimensionSpecAssig FOREIGN KEY (AD_Column_ID) REFERENCES AD_Column DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE DIM_Dimension_Spec_Assignment ADD CONSTRAINT DIMDimensionSpec_DIMDimensionS FOREIGN KEY (DIM_Dimension_Spec_ID) REFERENCES DIM_Dimension_Spec DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE DIM_Dimension_Spec_Attribute ADD CONSTRAINT DIMDimensionSpec_DIMDimensionS FOREIGN KEY (DIM_Dimension_Spec_ID) REFERENCES DIM_Dimension_Spec DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE DIM_Dimension_Spec_Attribute ADD CONSTRAINT MAttribute_DIMDimensionSpecAtt FOREIGN KEY (M_Attribute_ID) REFERENCES M_Attribute DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE DIM_Dimension_Spec_AttributeValue ADD CONSTRAINT DIMDimensionSpecAttribute_DIMD FOREIGN KEY (DIM_Dimension_Spec_Attribute_ID) REFERENCES DIM_Dimension_Spec_Attribute DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE DIM_Dimension_Spec_AttributeValue ADD CONSTRAINT MAttributeValue_DIMDimensionSp FOREIGN KEY (M_AttributeValue_ID) REFERENCES M_AttributeValue DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE ESR_Import ADD CONSTRAINT CBPBankAccount_ESRImport FOREIGN KEY (C_BP_BankAccount_ID) REFERENCES C_BP_BankAccount DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE ESR_ImportLine ADD CONSTRAINT CBPartner_ESRImportLine FOREIGN KEY (C_BPartner_ID) REFERENCES C_BPartner DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE ESR_ImportLine ADD CONSTRAINT CBPBankAccount_ESRImportLine FOREIGN KEY (C_BP_BankAccount_ID) REFERENCES C_BP_BankAccount DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE ESR_ImportLine ADD CONSTRAINT CInvoice_ESRImportLine FOREIGN KEY (C_Invoice_ID) REFERENCES C_Invoice DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE ESR_ImportLine ADD CONSTRAINT CPayment_ESRImportLine FOREIGN KEY (C_Payment_ID) REFERENCES C_Payment DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE ESR_ImportLine ADD CONSTRAINT CReferenceNo_ESRImportLine FOREIGN KEY (C_ReferenceNo_ID) REFERENCES C_ReferenceNo DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE EXP_Format ADD CONSTRAINT ADSequence_EXPFormat FOREIGN KEY (AD_Sequence_ID) REFERENCES AD_Sequence DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE EXP_Format ADD CONSTRAINT EntityT_EXPFormat FOREIGN KEY (EntityType) REFERENCES AD_EntityType DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE EXP_Format ADD CONSTRAINT IMPRequestHandler_EXPFormat FOREIGN KEY (IMP_RequestHandler_ID) REFERENCES IMP_RequestHandler DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE EXP_FormatLine ADD CONSTRAINT ADReferenceOverride_EXPFormatL FOREIGN KEY (AD_Reference_Override_ID) REFERENCES AD_Reference DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE EXP_FormatLine ADD CONSTRAINT EntityT_EXPFormatLine FOREIGN KEY (EntityType) REFERENCES AD_EntityType DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE EXP_ReplicationTrxLine ADD CONSTRAINT ADTable_EXPReplicationTrxLine FOREIGN KEY (AD_Table_ID) REFERENCES AD_Table DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE EXP_ReplicationTrxLine ADD CONSTRAINT EXPReplicationTrx_EXPReplicati FOREIGN KEY (EXP_ReplicationTrx_ID) REFERENCES EXP_ReplicationTrx DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE Fact_Acct_ActivityChangeRequest ADD CONSTRAINT Account_FactAcctActivityChange FOREIGN KEY (Account_ID) REFERENCES C_ElementValue DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE Fact_Acct_ActivityChangeRequest ADD CONSTRAINT ADTable_FactAcctActivityChange FOREIGN KEY (AD_Table_ID) REFERENCES AD_Table DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE Fact_Acct_ActivityChangeRequest ADD CONSTRAINT CAcctSchema_FactAcctActivityCh FOREIGN KEY (C_AcctSchema_ID) REFERENCES C_AcctSchema DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE Fact_Acct_ActivityChangeRequest ADD CONSTRAINT CActivity_FactAcctActivityChan FOREIGN KEY (C_Activity_ID) REFERENCES C_Activity DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE Fact_Acct_ActivityChangeRequest ADD CONSTRAINT CActivityOverride_FactAcctActi FOREIGN KEY (C_Activity_Override_ID) REFERENCES C_Activity DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE Fact_Acct_ActivityChangeRequest ADD CONSTRAINT CBPartner_FactAcctActivityChan FOREIGN KEY (C_BPartner_ID) REFERENCES C_BPartner DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE Fact_Acct_ActivityChangeRequest ADD CONSTRAINT CCurrency_FactAcctActivityChan FOREIGN KEY (C_Currency_ID) REFERENCES C_Currency DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE Fact_Acct_ActivityChangeRequest ADD CONSTRAINT CDocType_FactAcctActivityChang FOREIGN KEY (C_DocType_ID) REFERENCES C_DocType DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE Fact_Acct_ActivityChangeRequest ADD CONSTRAINT CPeriod_FactAcctActivityChange FOREIGN KEY (C_Period_ID) REFERENCES C_Period DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE Fact_Acct_ActivityChangeRequest ADD CONSTRAINT CUOM_FactAcctActivityChangeReq FOREIGN KEY (C_UOM_ID) REFERENCES C_UOM DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE Fact_Acct_ActivityChangeRequest ADD CONSTRAINT FactAcct_FactAcctActivityChang FOREIGN KEY (Fact_Acct_ID) REFERENCES Fact_Acct DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE Fact_Acct_ActivityChangeRequest ADD CONSTRAINT MProduct_FactAcctActivityChang FOREIGN KEY (M_Product_ID) REFERENCES M_Product DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE Fact_Acct_EndingBalance ADD CONSTRAINT Account_FactAcctEndingBalance FOREIGN KEY (Account_ID) REFERENCES C_ElementValue DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE Fact_Acct_EndingBalance ADD CONSTRAINT CAcctSchema_FactAcctEndingBala FOREIGN KEY (C_AcctSchema_ID) REFERENCES C_AcctSchema DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE Fact_Acct_Log ADD CONSTRAINT CAcctSchema_FactAcctLog FOREIGN KEY (C_AcctSchema_ID) REFERENCES C_AcctSchema DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE Fact_Acct_Log ADD CONSTRAINT CElementValue_FactAcctLog FOREIGN KEY (C_ElementValue_ID) REFERENCES C_ElementValue DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE Fact_Acct_Log ADD CONSTRAINT CPeriod_FactAcctLog FOREIGN KEY (C_Period_ID) REFERENCES C_Period DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE Fact_Acct_Summary ADD CONSTRAINT CYear_FactAcctSummary FOREIGN KEY (C_Year_ID) REFERENCES C_Year DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE Fresh_QtyOnHand_Line ADD CONSTRAINT PPPlant_FreshQtyOnHandLine FOREIGN KEY (PP_Plant_ID) REFERENCES S_Resource DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE HR_Attribute ADD CONSTRAINT HRAttributeA_HRAttribute FOREIGN KEY (HR_Attribute_Acct) REFERENCES C_ValidCombination DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE HR_Concept_Acct ADD CONSTRAINT HRExpenseA_HRConceptAcct FOREIGN KEY (HR_Expense_Acct) REFERENCES C_ValidCombination DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE HR_Concept_Acct ADD CONSTRAINT HRRevenueA_HRConceptAcct FOREIGN KEY (HR_Revenue_Acct) REFERENCES C_ValidCombination DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE HR_Concept_Acct ADD CONSTRAINT User2_HRConceptAcct FOREIGN KEY (User2_ID) REFERENCES C_ValidCombination DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE HR_Concept_Category ADD CONSTRAINT HRConceptA_HRConceptCategory FOREIGN KEY (HR_Concept_Acct) REFERENCES C_ValidCombination DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE M_DiscountSchemaBreak ADD CONSTRAINT MAttribute_MDiscountSchemaBrea FOREIGN KEY (M_Attribute_ID) REFERENCES M_Attribute DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE M_DiscountSchemaBreak ADD CONSTRAINT MAttributeValue_MDiscountSchem FOREIGN KEY (M_AttributeValue_ID) REFERENCES M_AttributeValue DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE M_DiscountSchemaLine ADD CONSTRAINT CTaxCategory_MDiscountSchemaLi FOREIGN KEY (C_TaxCategory_ID) REFERENCES C_TaxCategory DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE M_DiscountSchemaLine ADD CONSTRAINT CTaxCategoryTarget_MDiscountSc FOREIGN KEY (C_TaxCategory_Target_ID) REFERENCES C_TaxCategory DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE M_MatchInv ADD CONSTRAINT CInvoice_MMatchInv FOREIGN KEY (C_Invoice_ID) REFERENCES C_Invoice DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE M_Material_Balance_Config ADD CONSTRAINT CBPartner_MMaterialBalanceConf FOREIGN KEY (C_BPartner_ID) REFERENCES C_BPartner DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE M_Material_Balance_Config ADD CONSTRAINT CBPGroup_MMaterialBalanceConfi FOREIGN KEY (C_BP_Group_ID) REFERENCES C_BP_Group DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE M_Material_Balance_Config ADD CONSTRAINT CCalendar_MMaterialBalanceConf FOREIGN KEY (C_Calendar_ID) REFERENCES C_Calendar DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE M_Material_Balance_Config ADD CONSTRAINT MProductCategory_MMaterialBala FOREIGN KEY (M_Product_Category_ID) REFERENCES M_Product_Category DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE M_Material_Balance_Config ADD CONSTRAINT MProduct_MMaterialBalanceConfi FOREIGN KEY (M_Product_ID) REFERENCES M_Product DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE M_Material_Balance_Config ADD CONSTRAINT MWarehouse_MMaterialBalanceCon FOREIGN KEY (M_Warehouse_ID) REFERENCES M_Warehouse DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE M_Material_Balance_Detail ADD CONSTRAINT CBPartner_MMaterialBalanceDeta FOREIGN KEY (C_BPartner_ID) REFERENCES C_BPartner DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE M_Material_Balance_Detail ADD CONSTRAINT CDocType_MMaterialBalanceDetai FOREIGN KEY (C_DocType_ID) REFERENCES C_DocType DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE M_Material_Balance_Detail ADD CONSTRAINT CPeriod_MMaterialBalanceDetail FOREIGN KEY (C_Period_ID) REFERENCES C_Period DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE M_Material_Balance_Detail ADD CONSTRAINT CUOM_MMaterialBalanceDetail FOREIGN KEY (C_UOM_ID) REFERENCES C_UOM DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE M_Material_Balance_Detail ADD CONSTRAINT MInOut_MMaterialBalanceDetail FOREIGN KEY (M_InOut_ID) REFERENCES M_InOut DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE M_Material_Balance_Detail ADD CONSTRAINT MInOutLine_MMaterialBalanceDet FOREIGN KEY (M_InOutLine_ID) REFERENCES M_InOutLine DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE M_Material_Balance_Detail ADD CONSTRAINT MMaterialBalanceConfig_MMateri FOREIGN KEY (M_Material_Balance_Config_ID) REFERENCES M_Material_Balance_Config DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE M_Material_Balance_Detail ADD CONSTRAINT MProduct_MMaterialBalanceDetai FOREIGN KEY (M_Product_ID) REFERENCES M_Product DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE M_Material_Tracking_Report_Line_Alloc ADD CONSTRAINT MInOutLine_MMaterialTrackingRe FOREIGN KEY (M_InOutLine_ID) REFERENCES M_InOutLine DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE M_Material_Tracking_Report_Line_Alloc ADD CONSTRAINT PPOrder_MMaterialTrackingRepor FOREIGN KEY (PP_Order_ID) REFERENCES PP_Order DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE M_Product ADD CONSTRAINT SalesgroupUOM_MProduct FOREIGN KEY (Salesgroup_UOM_ID) REFERENCES C_UOM DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE P_AdvCommissionDetails ADD CONSTRAINT CAdvCommissionInstance_PAdvCom FOREIGN KEY (C_AdvCommissionInstance_ID) REFERENCES C_AdvCommissionInstance DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE P_AdvCommissionDetails ADD CONSTRAINT CAdvCommissionTerm_PAdvCommiss FOREIGN KEY (C_AdvCommissionTerm_ID) REFERENCES C_AdvCommissionTerm DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE P_AdvCommissionDetails ADD CONSTRAINT CDocType_PAdvCommissionDetails FOREIGN KEY (C_DocType_ID) REFERENCES C_DocType DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE P_AdvCommissionDetails ADD CONSTRAINT CSponsor_PAdvCommissionDetails FOREIGN KEY (C_Sponsor_ID) REFERENCES C_Sponsor DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE P_AdvCommissionDetails ADD CONSTRAINT MProduct_PAdvCommissionDetails FOREIGN KEY (M_Product_ID) REFERENCES M_Product DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE Pay_OnlinePaymentHistory ADD CONSTRAINT CPayment_PayOnlinePaymentHisto FOREIGN KEY (C_Payment_ID) REFERENCES C_Payment DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE PP_Cost_Collector ADD CONSTRAINT PPCostCollectorParent_PPCostCo FOREIGN KEY (PP_Cost_Collector_Parent_ID) REFERENCES PP_Cost_Collector DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE PP_Order_ProductAttribute ADD CONSTRAINT MAttribute_PPOrderProductAttri FOREIGN KEY (M_Attribute_ID) REFERENCES M_Attribute DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE PP_Order_ProductAttribute ADD CONSTRAINT MAttributeValue_PPOrderProduct FOREIGN KEY (M_AttributeValue_ID) REFERENCES M_AttributeValue DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE PP_Order_ProductAttribute ADD CONSTRAINT MHU_PPOrderProductAttribute FOREIGN KEY (M_HU_ID) REFERENCES M_HU DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE PP_Order_ProductAttribute ADD CONSTRAINT PPCostCollector_PPOrderProduct FOREIGN KEY (PP_Cost_Collector_ID) REFERENCES PP_Cost_Collector DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE PP_Order_ProductAttribute ADD CONSTRAINT PPOrder_PPOrderProductAttribut FOREIGN KEY (PP_Order_ID) REFERENCES PP_Order DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE R_Group ADD CONSTRAINT RCategory_RGroup FOREIGN KEY (R_Category_ID) REFERENCES R_Category DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE R_Group_Prospect ADD CONSTRAINT Locke_RGroupProspect FOREIGN KEY (LockedBy) REFERENCES AD_User DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE SEPA_Export ADD CONSTRAINT ADTable_SEPAExport FOREIGN KEY (AD_Table_ID) REFERENCES AD_Table DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE SEPA_Export_Line ADD CONSTRAINT ADTable_SEPAExportLine FOREIGN KEY (AD_Table_ID) REFERENCES AD_Table DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE SEPA_Export_Line ADD CONSTRAINT CBPartner_SEPAExportLine FOREIGN KEY (C_BPartner_ID) REFERENCES C_BPartner DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE SEPA_Export_Line ADD CONSTRAINT CBPBankAccount_SEPAExportLine FOREIGN KEY (C_BP_BankAccount_ID) REFERENCES C_BP_BankAccount DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE SEPA_Export_Line ADD CONSTRAINT CCurrency_SEPAExportLine FOREIGN KEY (C_Currency_ID) REFERENCES C_Currency DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE SEPA_Export_Line ADD CONSTRAINT SEPAExport_SEPAExportLine FOREIGN KEY (SEPA_Export_ID) REFERENCES SEPA_Export DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE SEPA_Export_Line ADD CONSTRAINT SEPAExportLineRetry_SEPAExport FOREIGN KEY (SEPA_Export_Line_Retry_ID) REFERENCES SEPA_Export_Line DEFERRABLE INITIALLY DEFERRED;
-- ALTER TABLE X_MRP_ProductInfo_Detail_MV ADD CONSTRAINT MAttributeSetInstance_XMRPProd FOREIGN KEY (M_AttributeSetInstance_ID) REFERENCES M_AttributeSetInstance DEFERRABLE INITIALLY DEFERRED;


ALTER TABLE A_Asset_Acct DROP CONSTRAINT IF EXISTS AAssetA_AAssetAcct;
ALTER TABLE A_Asset_Acct DROP CONSTRAINT IF EXISTS ADepreciationA_AAssetAcct;
ALTER TABLE A_Asset_Acct DROP CONSTRAINT IF EXISTS ADisposalG_AAssetAcct;
ALTER TABLE A_Asset_Acct DROP CONSTRAINT IF EXISTS ADisposalL_AAssetAcct;
ALTER TABLE A_Asset_Acct DROP CONSTRAINT IF EXISTS ADisposalReve_AAssetAcct;
ALTER TABLE A_Asset_Acct DROP CONSTRAINT IF EXISTS ARevalAccumdepOffset_AAssetAcc;
ALTER TABLE A_Asset_Acct DROP CONSTRAINT IF EXISTS ARevalAccumdepOffsetPr_AAssetA;
ALTER TABLE A_Asset_Acct DROP CONSTRAINT IF EXISTS ARevalCostOff_AAssetAcct;
ALTER TABLE A_Asset_Acct DROP CONSTRAINT IF EXISTS ARevalCostOffsetPr_AAssetAcct;
ALTER TABLE A_Asset_Acct DROP CONSTRAINT IF EXISTS ARevalDepexpOff_AAssetAcct;
ALTER TABLE A_Asset_Change DROP CONSTRAINT IF EXISTS AAccumdepreciationA_AAssetChan;
ALTER TABLE A_Asset_Change DROP CONSTRAINT IF EXISTS AAssetA_AAssetChange;
ALTER TABLE A_Asset_Change DROP CONSTRAINT IF EXISTS AAssetSpreadT_AAssetChange;
ALTER TABLE A_Asset_Change DROP CONSTRAINT IF EXISTS ADepreciationA_AAssetChange;
ALTER TABLE A_Asset_Change DROP CONSTRAINT IF EXISTS ADepreciationCalcT_AAssetChang;
ALTER TABLE A_Asset_Change DROP CONSTRAINT IF EXISTS ADisposalL_AAssetChange;
ALTER TABLE A_Asset_Change DROP CONSTRAINT IF EXISTS ADisposalReve_AAssetChange;
ALTER TABLE A_Asset_Change DROP CONSTRAINT IF EXISTS ConventionT_AAssetChange;
ALTER TABLE A_Asset_Change DROP CONSTRAINT IF EXISTS CValidCombination_AAssetChange;
ALTER TABLE A_Asset_Change DROP CONSTRAINT IF EXISTS DepreciationT_AAssetChange;
ALTER TABLE A_Asset_Group_Acct DROP CONSTRAINT IF EXISTS AAccumdepreciationA_AAssetGrou;
ALTER TABLE A_Asset_Group_Acct DROP CONSTRAINT IF EXISTS AAssetA_AAssetGroupAcct;
ALTER TABLE A_Asset_Group_Acct DROP CONSTRAINT IF EXISTS AAssetSpreadT_AAssetGroupAcct;
ALTER TABLE A_Asset_Group_Acct DROP CONSTRAINT IF EXISTS ADepreciationA_AAssetGroupAcct;
ALTER TABLE A_Asset_Group_Acct DROP CONSTRAINT IF EXISTS ADepreciationCalcT_AAssetGroup;
ALTER TABLE A_Asset_Group_Acct DROP CONSTRAINT IF EXISTS ADisposalG_AAssetGroupAcct;
ALTER TABLE A_Asset_Group_Acct DROP CONSTRAINT IF EXISTS ADisposalL_AAssetGroupAcct;
ALTER TABLE A_Asset_Group_Acct DROP CONSTRAINT IF EXISTS ADisposalReve_AAssetGroupAcct;
ALTER TABLE A_Asset_Group_Acct DROP CONSTRAINT IF EXISTS ARevalAccumdepOffset_AAssetGro;
ALTER TABLE A_Asset_Group_Acct DROP CONSTRAINT IF EXISTS ARevalAccumdepOffsetPr_AAssetG;
ALTER TABLE A_Asset_Group_Acct DROP CONSTRAINT IF EXISTS ARevalCostOff_AAssetGroupAcct;
ALTER TABLE A_Asset_Group_Acct DROP CONSTRAINT IF EXISTS ARevalCostOffsetPr_AAssetGroup;
ALTER TABLE A_Asset_Group_Acct DROP CONSTRAINT IF EXISTS ARevalDepexpOff_AAssetGroupAcc;
ALTER TABLE A_Asset_Group_Acct DROP CONSTRAINT IF EXISTS ConventionT_AAssetGroupAcct;
ALTER TABLE A_Asset_Group_Acct DROP CONSTRAINT IF EXISTS DepreciationT_AAssetGroupAcct;
ALTER TABLE A_Asset_Split DROP CONSTRAINT IF EXISTS AAssetID_AAssetSplit;
ALTER TABLE A_Asset_Transfer DROP CONSTRAINT IF EXISTS AAccumdepreciationAcct_AAssetT;
ALTER TABLE A_Asset_Transfer DROP CONSTRAINT IF EXISTS AAssetAcct_AAssetTransfer;
ALTER TABLE A_Asset_Transfer DROP CONSTRAINT IF EXISTS ADepreciationAcct_AAssetTransf;
ALTER TABLE A_Asset_Transfer DROP CONSTRAINT IF EXISTS ADisposalLoss_AAssetTransfer;
ALTER TABLE A_Asset_Transfer DROP CONSTRAINT IF EXISTS ADisposalRevenue_AAssetTransfe;
ALTER TABLE AD_Archive DROP CONSTRAINT IF EXISTS CBPartner_ADArchive;
ALTER TABLE AD_Archive DROP CONSTRAINT IF EXISTS CDocOutboundConfig_ADArchive;
ALTER TABLE A_Depreciation_Exp DROP CONSTRAINT IF EXISTS AAccountNum_ADepreciationExp;
ALTER TABLE AD_JavaClass DROP CONSTRAINT IF EXISTS EntityT_ADJavaClass;
ALTER TABLE AD_JavaClass_Type DROP CONSTRAINT IF EXISTS EntityT_ADJavaClassType;
ALTER TABLE AD_Package_Exp_Detail DROP CONSTRAINT IF EXISTS EntityT_ADPackageExpDetail;
ALTER TABLE C_Doc_Outbound_Log DROP CONSTRAINT IF EXISTS CBPartner_CDocOutboundLog;
ALTER TABLE C_Invoice_Candidate DROP CONSTRAINT IF EXISTS MPriceListVersion_CInvoiceCand;
ALTER TABLE C_Order DROP CONSTRAINT IF EXISTS ADInputDataSource_COrder;
ALTER TABLE C_Order_MFGWarehouse_Report DROP CONSTRAINT IF EXISTS CBPartner_COrderMFGWarehouseRe;
ALTER TABLE C_Printing_Queue DROP CONSTRAINT IF EXISTS ADLanguage_CPrintingQueue;
ALTER TABLE C_Printing_Queue DROP CONSTRAINT IF EXISTS BillBPartner_CPrintingQueue;
ALTER TABLE C_Printing_Queue DROP CONSTRAINT IF EXISTS CBPartner_CPrintingQueue;
ALTER TABLE Fact_Acct_Summary DROP CONSTRAINT IF EXISTS ADOrgTrx_FactAcctSummary;
ALTER TABLE Fact_Acct_Summary DROP CONSTRAINT IF EXISTS CLocFrom_FactAcctSummary;
ALTER TABLE Fact_Acct_Summary DROP CONSTRAINT IF EXISTS CLocTo_FactAcctSummary;
ALTER TABLE I_Asset DROP CONSTRAINT IF EXISTS ConventionT_IAsset;
ALTER TABLE I_Asset DROP CONSTRAINT IF EXISTS DepreciationT_IAsset;
ALTER TABLE M_DeliveryDay_Alloc DROP CONSTRAINT IF EXISTS ADTable_MDeliveryDayAlloc;
ALTER TABLE M_InOut DROP CONSTRAINT IF EXISTS MShipperTransportation_MInOut;
ALTER TABLE M_InOutLine DROP CONSTRAINT IF EXISTS MHUPIItemProductCalculated_MIn;
ALTER TABLE M_InOutLine DROP CONSTRAINT IF EXISTS MHUPIItemProduct_MInOutLine;
ALTER TABLE M_InOutLine DROP CONSTRAINT IF EXISTS MHUPIItemProductOverride_MInOu;
ALTER TABLE M_InOutLine DROP CONSTRAINT IF EXISTS MPackingMaterialInOutLine_MInO;
ALTER TABLE M_MovementLine DROP CONSTRAINT IF EXISTS DDOrderLineAlternative_MMoveme;
ALTER TABLE M_ReceiptSchedule_Alloc DROP CONSTRAINT IF EXISTS VHU_MReceiptScheduleAlloc;
ALTER TABLE M_ShipmentSchedule DROP CONSTRAINT IF EXISTS MHUPIItemProductCalculated_MSh;
ALTER TABLE M_ShipmentSchedule DROP CONSTRAINT IF EXISTS MHUPIItemProductOverride_MShip;
ALTER TABLE M_ShipperTransportation DROP CONSTRAINT IF EXISTS MTour_MShipperTransportation;
ALTER TABLE M_ShipperTransportation DROP CONSTRAINT IF EXISTS SalesRep_MShipperTransportatio;


ALTER TABLE A_Asset_Acct ADD CONSTRAINT AAssetA_AAssetAcct FOREIGN KEY (A_Asset_Acct) REFERENCES C_ValidCombination DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE A_Asset_Acct ADD CONSTRAINT ADepreciationA_AAssetAcct FOREIGN KEY (A_Depreciation_Acct) REFERENCES C_ValidCombination DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE A_Asset_Acct ADD CONSTRAINT ADisposalG_AAssetAcct FOREIGN KEY (A_Disposal_Gain) REFERENCES C_ValidCombination DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE A_Asset_Acct ADD CONSTRAINT ADisposalL_AAssetAcct FOREIGN KEY (A_Disposal_Loss) REFERENCES C_ValidCombination DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE A_Asset_Acct ADD CONSTRAINT ADisposalReve_AAssetAcct FOREIGN KEY (A_Disposal_Revenue) REFERENCES C_ValidCombination DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE A_Asset_Acct ADD CONSTRAINT ARevalAccumdepOffset_AAssetAcc FOREIGN KEY (A_Reval_Accumdep_Offset_Cur) REFERENCES C_ValidCombination DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE A_Asset_Acct ADD CONSTRAINT ARevalAccumdepOffsetPr_AAssetA FOREIGN KEY (A_Reval_Accumdep_Offset_Prior) REFERENCES C_ValidCombination DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE A_Asset_Acct ADD CONSTRAINT ARevalCostOff_AAssetAcct FOREIGN KEY (A_Reval_Cost_Offset) REFERENCES C_ValidCombination DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE A_Asset_Acct ADD CONSTRAINT ARevalCostOffsetPr_AAssetAcct FOREIGN KEY (A_Reval_Cost_Offset_Prior) REFERENCES C_ValidCombination DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE A_Asset_Acct ADD CONSTRAINT ARevalDepexpOff_AAssetAcct FOREIGN KEY (A_Reval_Depexp_Offset) REFERENCES C_ValidCombination DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE A_Asset_Change ADD CONSTRAINT AAccumdepreciationA_AAssetChan FOREIGN KEY (A_Accumdepreciation_Acct) REFERENCES C_ValidCombination DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE A_Asset_Change ADD CONSTRAINT AAssetA_AAssetChange FOREIGN KEY (A_Asset_Acct) REFERENCES C_ValidCombination DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE A_Asset_Change ADD CONSTRAINT AAssetSpreadT_AAssetChange FOREIGN KEY (A_Asset_Spread_Type) REFERENCES A_Asset_Spread DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE A_Asset_Change ADD CONSTRAINT ADepreciationA_AAssetChange FOREIGN KEY (A_Depreciation_Acct) REFERENCES C_ValidCombination DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE A_Asset_Change ADD CONSTRAINT ADepreciationCalcT_AAssetChang FOREIGN KEY (A_Depreciation_Calc_Type) REFERENCES A_Depreciation_Method DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE A_Asset_Change ADD CONSTRAINT ADisposalL_AAssetChange FOREIGN KEY (A_Disposal_Loss) REFERENCES C_ValidCombination DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE A_Asset_Change ADD CONSTRAINT ADisposalReve_AAssetChange FOREIGN KEY (A_Disposal_Revenue) REFERENCES C_ValidCombination DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE A_Asset_Change ADD CONSTRAINT ConventionT_AAssetChange FOREIGN KEY (ConventionType) REFERENCES A_Depreciation_Convention DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE A_Asset_Change ADD CONSTRAINT CValidCombination_AAssetChange FOREIGN KEY (C_ValidCombination_ID) REFERENCES C_ValidCombination DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE A_Asset_Change ADD CONSTRAINT DepreciationT_AAssetChange FOREIGN KEY (DepreciationType) REFERENCES A_Depreciation DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE A_Asset_Group_Acct ADD CONSTRAINT AAccumdepreciationA_AAssetGrou FOREIGN KEY (A_Accumdepreciation_Acct) REFERENCES C_ValidCombination DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE A_Asset_Group_Acct ADD CONSTRAINT AAssetA_AAssetGroupAcct FOREIGN KEY (A_Asset_Acct) REFERENCES C_ValidCombination DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE A_Asset_Group_Acct ADD CONSTRAINT AAssetSpreadT_AAssetGroupAcct FOREIGN KEY (A_Asset_Spread_Type) REFERENCES A_Asset_Spread DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE A_Asset_Group_Acct ADD CONSTRAINT ADepreciationA_AAssetGroupAcct FOREIGN KEY (A_Depreciation_Acct) REFERENCES C_ValidCombination DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE A_Asset_Group_Acct ADD CONSTRAINT ADepreciationCalcT_AAssetGroup FOREIGN KEY (A_Depreciation_Calc_Type) REFERENCES A_Depreciation_Method DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE A_Asset_Group_Acct ADD CONSTRAINT ADisposalG_AAssetGroupAcct FOREIGN KEY (A_Disposal_Gain) REFERENCES C_ValidCombination DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE A_Asset_Group_Acct ADD CONSTRAINT ADisposalL_AAssetGroupAcct FOREIGN KEY (A_Disposal_Loss) REFERENCES C_ValidCombination DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE A_Asset_Group_Acct ADD CONSTRAINT ADisposalReve_AAssetGroupAcct FOREIGN KEY (A_Disposal_Revenue) REFERENCES C_ValidCombination DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE A_Asset_Group_Acct ADD CONSTRAINT ARevalAccumdepOffset_AAssetGro FOREIGN KEY (A_Reval_Accumdep_Offset_Cur) REFERENCES C_ValidCombination DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE A_Asset_Group_Acct ADD CONSTRAINT ARevalAccumdepOffsetPr_AAssetG FOREIGN KEY (A_Reval_Accumdep_Offset_Prior) REFERENCES C_ValidCombination DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE A_Asset_Group_Acct ADD CONSTRAINT ARevalCostOff_AAssetGroupAcct FOREIGN KEY (A_Reval_Cost_Offset) REFERENCES C_ValidCombination DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE A_Asset_Group_Acct ADD CONSTRAINT ARevalCostOffsetPr_AAssetGroup FOREIGN KEY (A_Reval_Cost_Offset_Prior) REFERENCES C_ValidCombination DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE A_Asset_Group_Acct ADD CONSTRAINT ARevalDepexpOff_AAssetGroupAcc FOREIGN KEY (A_Reval_Depexp_Offset) REFERENCES C_ValidCombination DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE A_Asset_Group_Acct ADD CONSTRAINT ConventionT_AAssetGroupAcct FOREIGN KEY (ConventionType) REFERENCES A_Depreciation_Convention DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE A_Asset_Group_Acct ADD CONSTRAINT DepreciationT_AAssetGroupAcct FOREIGN KEY (DepreciationType) REFERENCES A_Depreciation DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE A_Asset_Split ADD CONSTRAINT AAssetID_AAssetSplit FOREIGN KEY (A_Asset_ID_To) REFERENCES A_Asset DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE A_Asset_Transfer ADD CONSTRAINT AAccumdepreciationAcct_AAssetT FOREIGN KEY (A_Accumdepreciation_Acct_New) REFERENCES C_ValidCombination DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE A_Asset_Transfer ADD CONSTRAINT AAssetAcct_AAssetTransfer FOREIGN KEY (A_Asset_Acct_New) REFERENCES C_ValidCombination DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE A_Asset_Transfer ADD CONSTRAINT ADepreciationAcct_AAssetTransf FOREIGN KEY (A_Depreciation_Acct_New) REFERENCES C_ValidCombination DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE A_Asset_Transfer ADD CONSTRAINT ADisposalLoss_AAssetTransfer FOREIGN KEY (A_Disposal_Loss_New) REFERENCES C_ValidCombination DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE A_Asset_Transfer ADD CONSTRAINT ADisposalRevenue_AAssetTransfe FOREIGN KEY (A_Disposal_Revenue_New) REFERENCES C_ValidCombination DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE AD_Archive ADD CONSTRAINT CBPartner_ADArchive FOREIGN KEY (C_BPartner_ID) REFERENCES C_BPartner DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE AD_Archive ADD CONSTRAINT CDocOutboundConfig_ADArchive FOREIGN KEY (C_Doc_Outbound_Config_ID) REFERENCES C_Doc_Outbound_Config DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE A_Depreciation_Exp ADD CONSTRAINT AAccountNum_ADepreciationExp FOREIGN KEY (A_Account_Number) REFERENCES C_ValidCombination DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE AD_JavaClass ADD CONSTRAINT EntityT_ADJavaClass FOREIGN KEY (EntityType) REFERENCES AD_EntityType DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE AD_JavaClass_Type ADD CONSTRAINT EntityT_ADJavaClassType FOREIGN KEY (EntityType) REFERENCES AD_EntityType DEFERRABLE INITIALLY DEFERRED;
--ALTER TABLE AD_Package_Exp_Detail ADD CONSTRAINT EntityT_ADPackageExpDetail FOREIGN KEY (EntityType) REFERENCES AD_EntityType DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE C_Doc_Outbound_Log ADD CONSTRAINT CBPartner_CDocOutboundLog FOREIGN KEY (C_BPartner_ID) REFERENCES C_BPartner DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE C_Invoice_Candidate ADD CONSTRAINT MPriceListVersion_CInvoiceCand FOREIGN KEY (M_PriceList_Version_ID) REFERENCES M_PriceList_Version DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE C_Order ADD CONSTRAINT ADInputDataSource_COrder FOREIGN KEY (AD_InputDataSource_ID) REFERENCES AD_InputDataSource DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE C_Order_MFGWarehouse_Report ADD CONSTRAINT CBPartner_COrderMFGWarehouseRe FOREIGN KEY (C_BPartner_ID) REFERENCES C_BPartner DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE C_Printing_Queue ADD CONSTRAINT BillBPartner_CPrintingQueue FOREIGN KEY (Bill_BPartner_ID) REFERENCES C_BPartner DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE C_Printing_Queue ADD CONSTRAINT CBPartner_CPrintingQueue FOREIGN KEY (C_BPartner_ID) REFERENCES C_BPartner DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE Fact_Acct_Summary ADD CONSTRAINT ADOrgTrx_FactAcctSummary FOREIGN KEY (AD_OrgTrx_ID) REFERENCES AD_Org DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE Fact_Acct_Summary ADD CONSTRAINT CLocFrom_FactAcctSummary FOREIGN KEY (C_LocFrom_ID) REFERENCES C_Location DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE Fact_Acct_Summary ADD CONSTRAINT CLocTo_FactAcctSummary FOREIGN KEY (C_LocTo_ID) REFERENCES C_Location DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE M_DeliveryDay_Alloc ADD CONSTRAINT ADTable_MDeliveryDayAlloc FOREIGN KEY (AD_Table_ID) REFERENCES AD_Table DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE M_InOut ADD CONSTRAINT MShipperTransportation_MInOut FOREIGN KEY (M_ShipperTransportation_ID) REFERENCES M_ShipperTransportation DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE M_InOutLine ADD CONSTRAINT MHUPIItemProductCalculated_MIn FOREIGN KEY (M_HU_PI_Item_Product_Calculated_ID) REFERENCES M_HU_PI_Item_Product DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE M_InOutLine ADD CONSTRAINT MHUPIItemProduct_MInOutLine FOREIGN KEY (M_HU_PI_Item_Product_ID) REFERENCES M_HU_PI_Item_Product DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE M_InOutLine ADD CONSTRAINT MHUPIItemProductOverride_MInOu FOREIGN KEY (M_HU_PI_Item_Product_Override_ID) REFERENCES M_HU_PI_Item_Product DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE M_InOutLine ADD CONSTRAINT MPackingMaterialInOutLine_MInO FOREIGN KEY (M_PackingMaterial_InOutLine_ID) REFERENCES M_InOutLine DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE M_MovementLine ADD CONSTRAINT DDOrderLineAlternative_MMoveme FOREIGN KEY (DD_OrderLine_Alternative_ID) REFERENCES DD_OrderLine_Alternative DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE M_ReceiptSchedule_Alloc ADD CONSTRAINT VHU_MReceiptScheduleAlloc FOREIGN KEY (VHU_ID) REFERENCES M_HU DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE M_ShipmentSchedule ADD CONSTRAINT MHUPIItemProductCalculated_MSh FOREIGN KEY (M_HU_PI_Item_Product_Calculated_ID) REFERENCES M_HU_PI_Item_Product DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE M_ShipmentSchedule ADD CONSTRAINT MHUPIItemProductOverride_MShip FOREIGN KEY (M_HU_PI_Item_Product_Override_ID) REFERENCES M_HU_PI_Item_Product DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE M_ShipperTransportation ADD CONSTRAINT MTour_MShipperTransportation FOREIGN KEY (M_Tour_ID) REFERENCES M_Tour DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE M_ShipperTransportation ADD CONSTRAINT SalesRep_MShipperTransportatio FOREIGN KEY (SalesRep_ID) REFERENCES AD_User DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE C_Printing_Queue ADD CONSTRAINT ADLangu_CPrintingQueue FOREIGN KEY (AD_Language) REFERENCES AD_Language DEFERRABLE INITIALLY DEFERRED;
