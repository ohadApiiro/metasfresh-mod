package de.metas.acct.accounts;

import de.metas.acct.api.AccountId;
import de.metas.acct.api.AcctSchemaId;
import lombok.Builder;
import lombok.NonNull;
import lombok.Value;
import org.adempiere.exceptions.AdempiereException;

@Value
@Builder
public class WarehouseAccounts
{
	@NonNull AcctSchemaId acctSchemaId;

	@NonNull AccountId W_Differences_Acct;

	public AccountId getAccountId(@NonNull final WarehouseAccountType acctType)
	{
		//noinspection SwitchStatementWithTooFewBranches
		switch (acctType)
		{
			case W_Differences_Acct:
				return W_Differences_Acct;
			default:
				throw new AdempiereException("Unknown account type: " + acctType);
		}
	}
}
