-- 2022-08-12T16:03:40.940Z
INSERT INTO AD_Sequence (AD_Client_ID,AD_Org_ID,AD_Sequence_ID,Created,CreatedBy,CurrentNext,CurrentNextSys,IncrementNo,IsActive,IsAudited,IsAutoSequence,IsTableID,Name,StartNewYear,StartNo,Updated,UpdatedBy) VALUES (1000000,1000000,555997,TO_TIMESTAMP('2022-08-12 19:03:40','YYYY-MM-DD HH24:MI:SS'),100,1000000,100,1,'Y','N','N','N','Budget Projekt','N',1000000,TO_TIMESTAMP('2022-08-12 19:03:40','YYYY-MM-DD HH24:MI:SS'),100)
;

-- 2022-08-12T16:03:47.944Z
UPDATE AD_Sequence SET IsAutoSequence='Y',Updated=TO_TIMESTAMP('2022-08-12 19:03:47','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Sequence_ID=555997
;

-- 2022-08-12T16:03:58.439Z
UPDATE AD_Sequence SET AD_Org_ID=0,Updated=TO_TIMESTAMP('2022-08-12 19:03:58','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Sequence_ID=555997
;

-- 2022-08-12T16:14:13.662Z
UPDATE C_ProjectType SET AD_Sequence_ProjectValue_ID=555997,Updated=TO_TIMESTAMP('2022-08-12 19:14:13','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE C_ProjectType_ID=540005
;