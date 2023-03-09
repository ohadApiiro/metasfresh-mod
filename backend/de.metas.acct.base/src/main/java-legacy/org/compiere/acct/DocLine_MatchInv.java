package org.compiere.acct;

import org.adempiere.model.InterfaceWrapperHelper;
import org.compiere.model.I_M_MatchInv;
import org.compiere.model.MAccount;

import de.metas.acct.api.AcctSchema;
import de.metas.acct.accounts.ProductAcctType;
import de.metas.quantity.Quantity;

/*
 * #%L
 * de.metas.acct.base
 * %%
 * Copyright (C) 2018 metas GmbH
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

final class DocLine_MatchInv extends DocLine<Doc_MatchInv>
{

	public DocLine_MatchInv(final I_M_MatchInv matchInv, final Doc_MatchInv doc)
	{
		super(InterfaceWrapperHelper.getPO(matchInv), doc);
		
		final Quantity qty = Quantity.of(matchInv.getQty(), getProductStockingUOM());
		setQty(qty, false);
	}

	public MAccount getInventoryClearingAccount(final AcctSchema as)
	{
		return getAccount(isService() ? ProductAcctType.P_Expense_Acct : ProductAcctType.P_InventoryClearing_Acct, as);
	}

	public MAccount getInvoicePriceVarianceAccount(final AcctSchema as)
	{
		return getAccount(ProductAcctType.P_InvoicePriceVariance_Acct, as);
	}
}
