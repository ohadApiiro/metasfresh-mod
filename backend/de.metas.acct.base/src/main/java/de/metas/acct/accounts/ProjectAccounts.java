package de.metas.acct.accounts;

import de.metas.acct.api.AccountId;
import de.metas.acct.api.AcctSchemaId;
import lombok.Builder;
import lombok.NonNull;
import lombok.Value;
import org.adempiere.exceptions.AdempiereException;

@Value
@Builder
public class ProjectAccounts
{
	@NonNull AcctSchemaId acctSchemaId;
	@NonNull AccountId PJ_Asset_Acct;
	@NonNull AccountId PJ_WIP_Acct;

	public AccountId getAccountId(@NonNull final ProjectAccountType acctType)
	{
		switch (acctType)
		{
			case PJ_Asset_Acct:
				return PJ_Asset_Acct;
			case PJ_WIP_Acct:
				return PJ_WIP_Acct;
			default:
				throw new AdempiereException("Unknown account type: " + acctType);
		}
	}

}
