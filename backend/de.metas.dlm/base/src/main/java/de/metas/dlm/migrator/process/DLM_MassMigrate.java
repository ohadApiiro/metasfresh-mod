package de.metas.dlm.migrator.process;

import java.sql.ResultSet;

import org.adempiere.ad.trx.api.ITrx;
import org.adempiere.ad.trx.api.ITrxManager;
import org.adempiere.util.lang.Mutable;
import org.compiere.util.CPreparedStatement;
import org.compiere.util.DB;
import org.compiere.util.TrxRunnable;

import com.google.common.base.Stopwatch;

import de.metas.process.JavaProcess;
import de.metas.process.Param;
import de.metas.process.RunOutOfTrx;
import de.metas.util.Check;
import de.metas.util.Loggables;
import de.metas.util.Services;

/*
 * #%L
 * metasfresh-dlm
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

/**
 * Invokes the two DB functions {@code dlm.load_production_table_rows()} and {@code dlm.update_production_table()} until they are all processed.
 * 
 * @author metas-dev <dev@metasfresh.com>
 * @task https://github.com/metasfresh/metasfresh/issues/969
 */
public class DLM_MassMigrate extends JavaProcess
{
	@Param(mandatory = true, parameterName = "IsRun_load_production_table_rows")
	private boolean run_load_production_table_rows;

	@Param(mandatory = true, parameterName = "IsRun_update_production_table")
	private boolean run_update_production_table;

	/**
	 * @task https://github.com/metasfresh/metasfresh/issues/1035
	 */
	@Param(mandatory = true, parameterName = "MaxUpdates")
	private int maxUpdates;

	@RunOutOfTrx
	@Override
	protected String doIt() throws Exception
	{
		final Stopwatch stopWatch = Stopwatch.createStarted();

		if (run_load_production_table_rows)
		{
			callDBFunctionUntilDone("dlm.load_production_table_rows", -1, false); // maxUpdates <= 0 because this function won't do a large number of updates.
		}
		else
		{
			Loggables.addLog("Skipping load_production_table_rows because of the process parameter IsRun_load_production_table_rows");
		}

		if (run_update_production_table)
		{
			callDBFunctionUntilDone("dlm.update_production_table", maxUpdates, true);
		}
		else
		{
			Loggables.addLog("Skipping update_production_table because of the process parameter IsRun_update_production_table");
		}

		final String elapsedTime = stopWatch.stop().toString();
		Loggables.addLog("overall elapsed time={}", elapsedTime);

		return MSG_OK;
	}

	/**
	 * @param maxUpdates if this number is surpassed, stop working even if not yet done.<br>
	 *            Otherwise we might overwhelm the DB's vacuum process and run out of disk space.<br>
	 *            Use a value <= 0 to disable the feature.<br>
	 *            See https://github.com/metasfresh/metasfresh/issues/1035
	 */
	private void callDBFunctionUntilDone(final String dbFunctionName, final int maxUpdates, final boolean vacuum)
	{
		final Mutable<Boolean> done = new Mutable<>(false);

		final Mutable<Integer> updates = new Mutable<>(0);
		final Mutable<String> lastTableName = new Mutable<>();
		final Mutable<Integer> lastTableUpdates = new Mutable<>(0);

		do
		{
			Services.get(ITrxManager.class).runInNewTrx((TrxRunnable)localTrxName -> {
				final CPreparedStatement stmt = DB.prepareStatement("select * from " + dbFunctionName + "();", localTrxName);

				final Stopwatch stopWatch = Stopwatch.createStarted();
				final ResultSet rs = stmt.executeQuery();
				final String elapsedTime = stopWatch.stop().toString();

				if (!rs.next())
				{
					done.setValue(true);
					Loggables.addLog("{}: we are done", dbFunctionName);
					return;
				}

				final String tablename = rs.getString("tablename");
				final int updatecount = rs.getInt("updatecount");
				final int massmigrate_id = rs.getInt("massmigrate_id");

				Loggables.addLog("{}: MassMigrate_ID={}; elapsed time={}; Table={}; Updated={}", dbFunctionName, massmigrate_id, elapsedTime, tablename, updatecount);

				updates.setValue(updates.getValue() + updatecount);

				lastTableName.setValue(tablename);
				lastTableUpdates.setValue(updatecount);
			});

			if (vacuum && !Check.isEmpty(lastTableName.getValue()) && lastTableUpdates.getValue() > 0)
			{ 
				// note that we can't include the vacuum calls in the DB function because of some transaction stuffs
				final Stopwatch stopWatch = Stopwatch.createStarted();
				DB.executeFunctionCallEx(ITrx.TRXNAME_None, "VACUUM ANALYZE " + lastTableName.getValue(), new Object[0]);
				DB.executeFunctionCallEx(ITrx.TRXNAME_None, "VACUUM ANALYZE dlm.massmigrate_records", new Object[0]);
				final String elapsedTime = stopWatch.stop().toString();

				Loggables.addLog("{}: Vacuumed {} and dlm.massmigrate_records; elapsed time={}", dbFunctionName, lastTableName.getValue(), elapsedTime);
			}

			if (maxUpdates > 0 && updates.getValue() >= maxUpdates)
			{
				Loggables.addLog(
						"{}: we now updated {} which is >= maxUpdates={}; Stopping now",
						dbFunctionName, updates.getValue(), maxUpdates);
				break;
			}
		}
		while (!done.getValue());
	}

}
