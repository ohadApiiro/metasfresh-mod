
-- 2017-10-02T20:57:43.017
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Message SET MsgText='Lieferstop',Updated=TO_TIMESTAMP('2017-10-02 20:57:43','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Message_ID=544513
;

-- 2017-10-02T20:57:47.942
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Message SET MsgType='I',Updated=TO_TIMESTAMP('2017-10-02 20:57:47','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Message_ID=544513
;

-- 2017-10-02T20:58:01.066
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Message_Trl SET UpdatedBy=100,Updated=TO_TIMESTAMP('2017-10-02 20:58:01','YYYY-MM-DD HH24:MI:SS'),IsTranslated='Y',MsgText='Lieferstop' WHERE AD_Message_ID=544513 AND AD_Language='de_CH'
;

-- 2017-10-02T20:58:08.958
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Message_Trl SET UpdatedBy=100,Updated=TO_TIMESTAMP('2017-10-02 20:58:08','YYYY-MM-DD HH24:MI:SS'),IsTranslated='Y' WHERE AD_Message_ID=544513 AND AD_Language='en_US'
;

-- 2017-10-02T20:58:48.104
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Message (AD_Client_ID,AD_Message_ID,AD_Org_ID,Created,CreatedBy,EntityType,IsActive,MsgText,MsgType,Updated,UpdatedBy,Value) VALUES (0,544523,0,TO_TIMESTAMP('2017-10-02 20:58:47','YYYY-MM-DD HH24:MI:SS'),100,'de.metas.inoutcandidate','Y','Lieferdispo-Datensatz geschlossen','I',TO_TIMESTAMP('2017-10-02 20:58:47','YYYY-MM-DD HH24:MI:SS'),100,'ShipmentSchedule_Closed_Status')
;

-- 2017-10-02T20:58:48.106
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Message_Trl (AD_Language,AD_Message_ID, MsgText,MsgTip, IsTranslated,AD_Client_ID,AD_Org_ID,Created,Createdby,Updated,UpdatedBy) SELECT l.AD_Language,t.AD_Message_ID, t.MsgText,t.MsgTip, 'N',t.AD_Client_ID,t.AD_Org_ID,t.Created,t.Createdby,t.Updated,t.UpdatedBy FROM AD_Language l, AD_Message t WHERE l.IsActive='Y' AND l.IsSystemLanguage='Y' AND l.IsBaseLanguage='N' AND t.AD_Message_ID=544523 AND NOT EXISTS (SELECT 1 FROM AD_Message_Trl tt WHERE tt.AD_Language=l.AD_Language AND tt.AD_Message_ID=t.AD_Message_ID)
;

