
package de.metas.contracts.subscription.process;

import de.metas.contracts.model.I_C_Flatrate_Term;
import de.metas.contracts.subscription.impl.SubscriptionService;
import de.metas.process.IProcessPrecondition;

/*
 * #%L
 * de.metas.contracts
 * %%
 * Copyright (C) 2017 metas GmbH
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 2 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public
 * License along with this program. If not, see
 * <http://www.gnu.org/licenses/gpl-2.0.html>.
 * #L%
 */

public class C_FlatrateTerm_RemovePauses
		extends C_SubscriptionProgressBase
		implements IProcessPrecondition
{

	@Override
	protected String doIt() throws Exception
	{
		final I_C_Flatrate_Term term = getTermFromProcessInfo();


		SubscriptionService.get().removeAllPauses(term);

		return MSG_OK;
	}
	


}