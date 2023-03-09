package de.metas.contracts.spi;

import de.metas.contracts.model.I_C_Flatrate_Term;

/*
 * #%L
 * de.metas.contracts
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
 * {@link I_C_Flatrate_Term} lifecycle handler.
 *
 * @author metas-dev <dev@metasfresh.com>
 *
 */
public interface IFlatrateTermEventListener
{
	/**
	 * Invoked by a model interceptor on {@link org.compiere.model.ModelValidator#TIMING_BEFORE_REACTIVATE}.
	 *
	 * @param term
	 */
	void beforeFlatrateTermReactivate(final I_C_Flatrate_Term term);

	/**
	 * Invoked by {@link IFlatrateBL#extendContract(I_C_Flatrate_Term, boolean, boolean, de.metas.contracts.subscription.model.I_C_OrderLine)} after the given <code>newTerm</code> was saved.
	 * At this point, the term was not completed, nor was any user notified.
	 * @param next the successor of <code>oldTerm</code>
	 * @param predecessor the term that is extended
	 *
	 * @task https://github.com/metasfresh/metasfresh/issues/549
	 */
	void afterSaveOfNextTermForPredecessor(final I_C_Flatrate_Term next, final I_C_Flatrate_Term predecessor);
	
	
	/**
	 * Invoked by {@link IFlatrateBL#de.metas.flatrate.api.impl.FlatrateBL.extendContract0(I_C_Flatrate_Term, boolean, boolean, I_C_OrderLine, String)} after the given <code>term</code> was checked if does need to be renew
	 *
	 * @param term the term that is ended
	 * 
	 */
	void afterFlatrateTermEnded(final I_C_Flatrate_Term term);
	
	/**
	 * Invoked by {@link IFlatrateBL#de.metas.flatrate.api.impl.FlatrateBL.extendContract0(I_C_Flatrate_Term, boolean, boolean, I_C_OrderLine, String)} after the given <code>nextTerm</code> was created, but not yet saved
	 * @param term
	 */
	void beforeSaveOfNextTermForPredecessor(final I_C_Flatrate_Term next, final I_C_Flatrate_Term predecessor);
}
