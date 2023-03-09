-- 2017-09-27T16:01:49.585
-- URL zum Konzept
INSERT INTO AD_Process (AccessLevel,AD_Client_ID,AD_Org_ID,AD_Process_ID,AllowProcessReRun,Classname,CopyFromProcess,Created,CreatedBy,EntityType,IsActive,IsApplySecuritySettings,IsBetaFunctionality,IsDirectPrint,IsOneInstanceOnly,IsReport,IsServerProcess,IsUseBPartnerLanguage,LockWaitTimeout,Name,RefreshAllAfterExecution,ShowHelp,Type,Updated,UpdatedBy,Value) VALUES ('3',0,0,540855,'N','de.metas.inoutcandidate.process.M_ShipmentSchedule_OpenProcessed','N',TO_TIMESTAMP('2017-09-27 16:01:49','YYYY-MM-DD HH24:MI:SS'),100,'de.metas.inoutcandidate','Y','N','N','N','N','N','N','Y',0,'Lieferdispo Auswahl offen','N','Y','Java',TO_TIMESTAMP('2017-09-27 16:01:49','YYYY-MM-DD HH24:MI:SS'),100,'M_ShipmentSchedule_OpenProcessed')
;

-- 2017-09-27T16:01:49.595
-- URL zum Konzept
INSERT INTO AD_Process_Trl (AD_Language,AD_Process_ID, Description,Help,Name, IsTranslated,AD_Client_ID,AD_Org_ID,Created,Createdby,Updated,UpdatedBy) SELECT l.AD_Language,t.AD_Process_ID, t.Description,t.Help,t.Name, 'N',t.AD_Client_ID,t.AD_Org_ID,t.Created,t.Createdby,t.Updated,t.UpdatedBy FROM AD_Language l, AD_Process t WHERE l.IsActive='Y' AND l.IsSystemLanguage='Y' AND l.IsBaseLanguage='N' AND t.AD_Process_ID=540855 AND NOT EXISTS (SELECT 1 FROM AD_Process_Trl tt WHERE tt.AD_Language=l.AD_Language AND tt.AD_Process_ID=t.AD_Process_ID)
;

-- 2017-09-27T16:03:02.524
-- URL zum Konzept
INSERT INTO AD_Table_Process (AD_Client_ID,AD_Org_ID,AD_Process_ID,AD_Table_ID,AD_Window_ID,Created,CreatedBy,EntityType,IsActive,Updated,UpdatedBy,WEBUI_QuickAction,WEBUI_QuickAction_Default) VALUES (0,0,540855,500221,500221,TO_TIMESTAMP('2017-09-27 16:03:02','YYYY-MM-DD HH24:MI:SS'),100,'de.metas.inoutcandidate','Y',TO_TIMESTAMP('2017-09-27 16:03:02','YYYY-MM-DD HH24:MI:SS'),100,'N','N')
;

-- 2017-09-27T16:04:06.022
-- URL zum Konzept
UPDATE AD_Table_Process SET WEBUI_QuickAction='Y',Updated=TO_TIMESTAMP('2017-09-27 16:04:06','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Process_ID=540855 AND AD_Table_ID=500221
;

