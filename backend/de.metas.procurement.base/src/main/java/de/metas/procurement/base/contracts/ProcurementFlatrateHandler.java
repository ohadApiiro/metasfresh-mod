package de.metas.procurement.base.contracts;

import java.sql.Timestamp;
import java.util.List;

import org.adempiere.model.InterfaceWrapperHelper;
import org.compiere.util.TimeUtil;

import com.google.common.annotations.VisibleForTesting;

import de.metas.contracts.IFlatrateDAO;
import de.metas.contracts.model.I_C_Flatrate_DataEntry;
import de.metas.contracts.spi.FallbackFlatrateTermEventListener;
import de.metas.procurement.base.PMMContractBuilder;
import de.metas.procurement.base.model.I_C_Flatrate_Conditions;
import de.metas.procurement.base.model.I_C_Flatrate_Term;
import de.metas.util.Check;
import de.metas.util.Services;

/*
 * #%L
 * de.metas.procurement.base
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

public class ProcurementFlatrateHandler extends FallbackFlatrateTermEventListener
{
	public static final String TYPE_CONDITIONS = I_C_Flatrate_Conditions.TYPE_CONDITIONS_Procuremnt;

	/**
	 * Does not delete the data entries on reactivate!
	 */
	@Override
	protected void deleteFlatrateTermDataEntriesOnReactivate(final de.metas.contracts.model.I_C_Flatrate_Term term)
	{
		// nothing
	}

	/**
	 * Create new {@link de.metas.contracts.model.I_C_Flatrate_DataEntry}s using {@link PMMContractBuilder#newBuilder(I_C_Flatrate_Term)}.
	 * The new dataEntries use data from the dataEntries of the given <code>oldTerm</code>.
	 *
	 * @task https://github.com/metasfresh/metasfresh/issues/549
	 */
	@Override
	public void afterSaveOfNextTermForPredecessor(final de.metas.contracts.model.I_C_Flatrate_Term next, final de.metas.contracts.model.I_C_Flatrate_Term predecessor)
	{
		final IFlatrateDAO flatrateDAO = Services.get(IFlatrateDAO.class);

		final I_C_Flatrate_Term oldTermtoUse = InterfaceWrapperHelper.create(predecessor, I_C_Flatrate_Term.class);
		final I_C_Flatrate_Term newTermtoUse = InterfaceWrapperHelper.create(next, I_C_Flatrate_Term.class);

		newTermtoUse.setPMM_Product(oldTermtoUse.getPMM_Product());
		InterfaceWrapperHelper.save(newTermtoUse);

		final List<I_C_Flatrate_DataEntry> oldDataEntries = flatrateDAO.retrieveDataEntries(predecessor, null, null);

		final PMMContractBuilder builder = newPMMContractBuilder(newTermtoUse)
				.setComplete(false);

		oldDataEntries
				.forEach(e -> {
					Check.errorUnless(e.getC_Period() != null, "{} has a missing C_Period", e);
					final Timestamp dateOldEntry = e.getC_Period().getStartDate();

					final Timestamp dateNewEntry;
					if (dateOldEntry.before(newTermtoUse.getStartDate()))
					{
						dateNewEntry = TimeUtil.addYears(dateOldEntry, 1);
					}
					else
					{
						dateNewEntry = dateOldEntry;
					}

					if (InterfaceWrapperHelper.isNull(e, I_C_Flatrate_DataEntry.COLUMNNAME_FlatrateAmtPerUOM))
					{
						// if the current entry has a null value, then also the new entry shall have a null value
						builder.setFlatrateAmtPerUOM(dateNewEntry, null);
					}
					else
					{
						builder.setFlatrateAmtPerUOM(dateNewEntry, e.getFlatrateAmtPerUOM());
					}
					builder.addQtyPlanned(dateNewEntry, e.getQty_Planned());
				});

		builder.build();
	}

	@VisibleForTesting
	PMMContractBuilder newPMMContractBuilder(final I_C_Flatrate_Term term)
	{
		return PMMContractBuilder.newBuilder(term);
	}
}
