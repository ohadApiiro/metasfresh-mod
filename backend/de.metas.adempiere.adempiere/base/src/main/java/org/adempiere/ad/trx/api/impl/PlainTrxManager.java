package org.adempiere.ad.trx.api.impl;

/*
 * #%L
 * de.metas.adempiere.adempiere.base
 * %%
 * Copyright (C) 2015 metas GmbH
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

import java.util.List;

import org.adempiere.ad.trx.api.ITrx;
import org.adempiere.ad.trx.api.ITrxManager;
import org.adempiere.exceptions.DBException;
import org.compiere.Adempiere;

import de.metas.util.Check;
import de.metas.util.Services;

/**
 * This implementation is intended for unit and module testing in scenarios where you want the trxManager to get out of the way.
 * <p>
 * Hint: if you want to actually test trx related behavior (e.g. if some trx was committed and so on), then there is {@link MockedTrxManager}.
 *
 * @author metas-dev <dev@metasfresh.com>
 *
 */
public class PlainTrxManager extends AbstractTrxManager
{
	/** Convenient method to get the {@link PlainTrxManager} via {@link Services} */
	public static PlainTrxManager get()
	{
		return (PlainTrxManager)Services.get(ITrxManager.class);
	}

	//
	// Flags used to check transaction lifecycle and consistency: COMMIT and ROLLBACK
	// NOTE: atm, the actual JDBC are not failing in this case, but, i think is helpful in tests to be much more strict to enforce consistency
	private boolean failCommitIfTrxNotStarted = true;
	private boolean failRollbackIfTrxNotStarted = true;
	private boolean debugTrxLog;

	public PlainTrxManager()
	{
		Adempiere.assertUnitTestMode();
	}

	@Override
	protected PlainTrx createTrx(String trxName, final boolean autoCommit)
	{
		Adempiere.assertUnitTestMode();

		try
		{
			return new PlainTrx(this, trxName, autoCommit);
		}
		catch (Exception e)
		{
			throw DBException.wrapIfNeeded(e);
		}
	}

	public PlainTrxManager setFailCommitIfTrxNotStarted(final boolean failCommitIfTrxNotStarted)
	{
		this.failCommitIfTrxNotStarted = failCommitIfTrxNotStarted;
		return this;
	}

	public boolean isFailCommitIfTrxNotStarted()
	{
		return failCommitIfTrxNotStarted;
	}

	public PlainTrxManager setFailRollbackIfTrxNotStarted(final boolean failRollbackIfTrxNotStarted)
	{
		this.failRollbackIfTrxNotStarted = failRollbackIfTrxNotStarted;
		return this;
	}

	public boolean isFailRollbackIfTrxNotStarted()
	{
		return failRollbackIfTrxNotStarted;
	}

	public void assertNoActiveTransactions()
	{
		final List<ITrx> activeTrxs = getActiveTransactionsList();
		Check.assume(activeTrxs.isEmpty(), "Expected no active transactions but got: {}", activeTrxs);
	}

	/**
	 * Ask the transactions to log their major events like COMMIT, ROLLBACK.
	 * Those events will be visible on {@link PlainTrx#toString()}.
	 * 
	 * @param debugTrxLog
	 */
	public void setDebugTrxLog(boolean debugTrxLog)
	{
		this.debugTrxLog = debugTrxLog;
	}

	/**
	 * @see #setDebugTrxLog(boolean)
	 */
	public boolean isDebugTrxLog()
	{
		return debugTrxLog;
	}
}
