-- 2017-09-04T12:10:01.789
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Message (AD_Client_ID,AD_Message_ID,AD_Org_ID,Created,CreatedBy,EntityType,IsActive,MsgText,MsgType,Updated,UpdatedBy,Value) VALUES (0,544485,0,TO_TIMESTAMP('2017-09-04 12:10:01','YYYY-MM-DD HH24:MI:SS'),100,'de.metas.ui.web','Y','Not enough TUs found. Required {1} but only {2} found.','E',TO_TIMESTAMP('2017-09-04 12:10:01','YYYY-MM-DD HH24:MI:SS'),100,'WEBUI_M_HU_MoveTUsToDirectWarehouse.NotEnoughTUsFound')
;

-- 2017-09-04T12:10:01.834
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Message_Trl (AD_Language,AD_Message_ID, MsgText,MsgTip, IsTranslated,AD_Client_ID,AD_Org_ID,Created,Createdby,Updated,UpdatedBy) SELECT l.AD_Language,t.AD_Message_ID, t.MsgText,t.MsgTip, 'N',t.AD_Client_ID,t.AD_Org_ID,t.Created,t.Createdby,t.Updated,t.UpdatedBy FROM AD_Language l, AD_Message t WHERE l.IsActive='Y' AND l.IsSystemLanguage='Y' AND l.IsBaseLanguage='N' AND t.AD_Message_ID=544485 AND NOT EXISTS (SELECT 1 FROM AD_Message_Trl tt WHERE tt.AD_Language=l.AD_Language AND tt.AD_Message_ID=t.AD_Message_ID)
;

-- 2017-09-04T12:12:35.249
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Message SET MsgText='Not enough TUs found. Required {0} but only {1} found.',Updated=TO_TIMESTAMP('2017-09-04 12:12:35','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Message_ID=544485
;

update AD_Message_Trl trl set MsgText='Not enough TUs found. Required {0} but only {1} found.' where AD_Message_ID=544485;

