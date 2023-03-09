package org.adempiere.server.rpl.trx.spi;

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

import org.adempiere.server.rpl.trx.api.IReplicationIssueSolverParams;
import org.slf4j.Logger;

import ch.qos.logback.classic.Level;
import de.metas.logging.LogManager;
import de.metas.util.Loggables;
import lombok.ToString;

/**
 * This implementation does nothing with the given {@link IReplicationIssueAware}.
 */
@ToString
public class NoOpIssueSolver<T extends IReplicationIssueAware> implements IReplicationIssueSolver<T>
{
	private static final Logger logger = LogManager.getLogger(NoOpIssueSolver.class);

	/**
	 * Does nothing; we just want to clear the record for further processing.
	 */
	@Override
	public void solveIssues(final IReplicationIssueAware recordWithIssues, final IReplicationIssueSolverParams params)
	{
		Loggables.withLogger(logger, Level.DEBUG).addLog("NoOpIssueSolver is called with IReplicationIssueAware={}", recordWithIssues);
	}
}
