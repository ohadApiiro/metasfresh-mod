package de.metas.dlm.process;

import java.util.List;

import org.adempiere.ad.dao.IQueryBL;
import org.adempiere.ad.trx.api.ITrxManager;
import org.adempiere.model.InterfaceWrapperHelper;
import org.adempiere.model.PlainContextAware;
import org.compiere.util.TrxRunnable;

import de.metas.dlm.IDLMService;
import de.metas.dlm.model.I_AD_Table;
import de.metas.dlm.model.I_DLM_Partition_Config;
import de.metas.dlm.model.I_DLM_Partition_Config_Line;
import de.metas.process.IProcessDefaultParameter;
import de.metas.process.IProcessDefaultParametersProvider;
import de.metas.process.JavaProcess;
import de.metas.process.Param;
import de.metas.process.RunOutOfTrx;
import de.metas.util.Loggables;
import de.metas.util.Services;

/*
 * #%L
 * metasfresh-dlm
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

/**
 * This process makes sure that all tables
 *
 * @author metas-dev <dev@metasfresh.com>
 *
 */
public class Add_Tables_to_DLM
		extends JavaProcess
		implements IProcessDefaultParametersProvider
{

	@Param(mandatory = true, parameterName = I_DLM_Partition_Config.COLUMNNAME_DLM_Partition_Config_ID)
	private I_DLM_Partition_Config configDB;

	/**
	 * Iterate the {@link I_DLM_Partition_Config_Line}s and handle their talbes one by one.
	 * Runs out of trx because each table is dealt with in its own trx and the overall process might run for some time until all tables were processed.
	 */
	@Override
	@RunOutOfTrx
	protected String doIt() throws Exception
	{
		final IQueryBL queryBL = Services.get(IQueryBL.class);
		final IDLMService dlmService = Services.get(IDLMService.class);
		final ITrxManager trxManager = Services.get(ITrxManager.class);

		final List<I_DLM_Partition_Config_Line> configLinesDB = queryBL.createQueryBuilder(I_DLM_Partition_Config_Line.class, PlainContextAware.newWithThreadInheritedTrx(getCtx()))
				.addOnlyActiveRecordsFilter()
				.addEqualsFilter(I_DLM_Partition_Config_Line.COLUMN_DLM_Partition_Config_ID, configDB.getDLM_Partition_Config_ID())
				.orderBy().addColumn(I_DLM_Partition_Config_Line.COLUMNNAME_DLM_Partition_Config_ID).endOrderBy()
				.create()
				.list();
		for (final I_DLM_Partition_Config_Line line : configLinesDB)
		{
			final I_AD_Table dlm_Referencing_Table = InterfaceWrapperHelper.create(line.getDLM_Referencing_Table(), I_AD_Table.class);
			if (dlm_Referencing_Table.isDLM())
			{
				Loggables.addLog("Table {} is already DLM'ed. Skipping", dlm_Referencing_Table.getTableName());
				continue;
			}

			trxManager.runInNewTrx(new TrxRunnable()
			{
				@Override
				public void run(String localTrxName) throws Exception
				{
					dlmService.addTableToDLM(dlm_Referencing_Table);
				}
			});
		}

		return MSG_OK;
	}

	@Override
	public Object getParameterDefaultValue(final IProcessDefaultParameter parameter)
	{
		final int configId = parameter.getContextAsInt(I_DLM_Partition_Config.COLUMNNAME_DLM_Partition_Config_ID);
		if (configId > 0)
		{
			return configId;
		}

		return DEFAULT_VALUE_NOTAVAILABLE;
	}

}
