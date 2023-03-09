package de.metas.acct.accounts;

import de.metas.acct.api.AccountId;
import de.metas.acct.api.AcctSchemaId;
import de.metas.logging.LogManager;
import lombok.Builder;
import lombok.NonNull;
import lombok.Value;
import org.adempiere.exceptions.AdempiereException;
import org.slf4j.Logger;

@Value
@Builder
public class BPartnerCustomerAccounts
{
	private static final Logger logger = LogManager.getLogger(BPartnerVendorAccounts.class);

	@NonNull AcctSchemaId acctSchemaId;

	@NonNull AccountId C_Receivable_Acct;
	@NonNull AccountId C_Receivable_Services_Acct;
	@NonNull AccountId C_Prepayment_Acct;

	public AccountId getAccountId(@NonNull final BPartnerCustomerAccountType acctType)
	{
		switch (acctType)
		{
			case C_Receivable:
				return C_Receivable_Acct;
			case C_Receivable_Services:
				return C_Receivable_Services_Acct;
			case C_Prepayment:
				// metas: changed per Mark request: don't use prepayment account:
				logger.warn("C_Prepayment account shall not be used", new Exception());

				return C_Prepayment_Acct;
			default:
				throw new AdempiereException("Unknown account type: " + acctType);
		}
	}
}
