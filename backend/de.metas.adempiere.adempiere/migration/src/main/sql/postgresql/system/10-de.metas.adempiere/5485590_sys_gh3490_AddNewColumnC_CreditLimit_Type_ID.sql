-- 2018-02-16T12:04:13.642
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Column SET IsMandatory='N',Updated=TO_TIMESTAMP('2018-02-16 12:04:13','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Column_ID=558978
;

-- 2018-02-16T12:04:15.541
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
/* DDL */ SELECT public.db_alter_table('C_BPartner_CreditLimit','ALTER TABLE public.C_BPartner_CreditLimit ADD COLUMN C_CreditLimit_Type_ID NUMERIC(10)')
;

-- 2018-02-16T12:04:15.563
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
ALTER TABLE C_BPartner_CreditLimit ADD CONSTRAINT CCreditLimitType_CBPartnerCreditLimit FOREIGN KEY (C_CreditLimit_Type_ID) REFERENCES public.C_CreditLimit_Type DEFERRABLE INITIALLY DEFERRED
;


/* DDL */ SELECT public.db_alter_table('C_BPartner_CreditLimit','ALTER TABLE public.C_BPartner_CreditLimit DROP COLUMN Type')
;





