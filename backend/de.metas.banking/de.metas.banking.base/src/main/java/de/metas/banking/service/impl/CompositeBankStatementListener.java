package de.metas.banking.service.impl;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import de.metas.banking.BankStatementLineReferenceList;
import de.metas.banking.payment.PaymentLinkResult;
import de.metas.banking.service.IBankStatementListener;
import lombok.NonNull;
import lombok.ToString;

/*
 * #%L
 * de.metas.banking.base
 * %%
 * Copyright (C) 2016 metas GmbH
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

@ToString
final class CompositeBankStatementListener implements IBankStatementListener
{
	private final CopyOnWriteArrayList<IBankStatementListener> listeners = new CopyOnWriteArrayList<>();

	public boolean addListener(@NonNull final IBankStatementListener listener)
	{
		return listeners.addIfAbsent(listener);
	}

	@Override
	public void onPaymentsLinked(@NonNull final List<PaymentLinkResult> payments)
	{
		for (final IBankStatementListener listener : listeners)
		{
			listener.onPaymentsLinked(payments);
		}
	}

	@Override
	public void onPaymentsUnlinkedFromBankStatementLineReferences(@NonNull final BankStatementLineReferenceList lineRefs)
	{
		for (final IBankStatementListener listener : listeners)
		{
			listener.onPaymentsUnlinkedFromBankStatementLineReferences(lineRefs);
		}
	}
}
