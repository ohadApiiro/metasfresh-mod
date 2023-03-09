package de.metas.dunning.process;

import static org.adempiere.model.InterfaceWrapperHelper.markColumnChanged;
import static org.adempiere.model.InterfaceWrapperHelper.save;

/*
 * #%L
 * de.metas.dunning
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

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.compiere.model.Query;

import de.metas.dunning.model.I_C_Dunning_Candidate;
import de.metas.process.JavaProcess;
import de.metas.process.ProcessInfoParameter;
import de.metas.security.permissions.Access;
import de.metas.util.Check;

/**
 * Update {@link I_C_Dunning_Candidate#COLUMNNAME_DunningDate} field for selected records.
 *
 * @author tsa
 *
 */
public class C_Dunning_Candidate_SetDunningGrace extends JavaProcess
{
	private static final String PARAM_DunningGrace = I_C_Dunning_Candidate.COLUMNNAME_DunningGrace;
	private Timestamp p_DunningGrace = null;

	@Override
	protected void prepare()
	{
		for (ProcessInfoParameter para : getParametersAsArray())
		{
			if (para.getParameter() == null)
			{
				// skip if no parameter value
				continue;
			}

			final String name = para.getParameterName();
			if (name.equals(PARAM_DunningGrace))
			{
				p_DunningGrace = para.getParameterAsTimestamp();
			}
		}
	}

	@Override
	protected String doIt()
	{
		final Iterator<I_C_Dunning_Candidate> it = retrieveSelectionIterator();
		setDunningGrace(it, p_DunningGrace);
		return "@Updated@";
	}

	private void setDunningGrace(final Iterator<I_C_Dunning_Candidate> it, final Timestamp dunningGrace)
	{
		while (it.hasNext())
		{
			final I_C_Dunning_Candidate candidate = it.next();
			setDunningGrace(candidate, dunningGrace);
		}
	}

	private void setDunningGrace(final I_C_Dunning_Candidate candidate, final Timestamp dunningGrace)
	{
		candidate.setDunningGrace(dunningGrace);

		// We want to make sure that model validators are triggered EVEN if the old DunningGrace value equals with new DunningGrace value
		markColumnChanged(candidate, I_C_Dunning_Candidate.COLUMNNAME_DunningGrace);
		save(candidate);
	}

	private Iterator<I_C_Dunning_Candidate> retrieveSelectionIterator()
	{
		final StringBuilder sqlWhere = new StringBuilder();
		final List<Object> params = new ArrayList<>();

		if (!Check.isEmpty(getProcessInfo().getWhereClause(), true))
		{
			sqlWhere.append(getProcessInfo().getWhereClause())
					.append(" AND " + I_C_Dunning_Candidate.COLUMNNAME_Processed + " = 'N'"); // 03663 : Must make sure to take only unprocessed candidates.
		}
		else
		{
			// We have no where clause. Assume all unprocessed candidates.
			sqlWhere.append(I_C_Dunning_Candidate.COLUMNNAME_IsActive + " = 'Y'")
					.append(" AND " + I_C_Dunning_Candidate.COLUMNNAME_Processed + " = 'N'");
		}

		return new Query(getCtx(), I_C_Dunning_Candidate.Table_Name, sqlWhere.toString(), get_TrxName())
				.setParameters(params)
				.setClient_ID()
				.setOnlyActiveRecords(true)
				.setRequiredAccess(Access.WRITE)
				.iterate(I_C_Dunning_Candidate.class, false); // guaranteed=false

	}
}
