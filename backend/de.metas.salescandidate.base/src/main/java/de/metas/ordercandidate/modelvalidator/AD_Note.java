package de.metas.ordercandidate.modelvalidator;

/*
 * #%L
 * de.metas.swat.base
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

import org.adempiere.ad.dao.IQueryBL;
import org.adempiere.ad.modelvalidator.annotations.Interceptor;
import org.adempiere.ad.modelvalidator.annotations.ModelChange;
import org.adempiere.model.InterfaceWrapperHelper;
import org.compiere.model.I_AD_Note;
import org.compiere.model.ModelValidator;
import org.springframework.stereotype.Component;

import de.metas.ordercandidate.model.I_C_OLCand;
import de.metas.util.Services;

/** Disclaimer: i just refactored (modernized) this MI, but am not sure if it's still used or needed. */
@Interceptor(I_AD_Note.class)
@Component
public class AD_Note
{
	/**
	 * if the error message is deleted, then unset the candidates' error status
	 */
	@ModelChange(timings = ModelValidator.TYPE_BEFORE_DELETE)
	public void onModelChange(final I_AD_Note note)
	{
		final List<I_C_OLCand> olCands = Services.get(IQueryBL.class)
				.createQueryBuilder(I_C_OLCand.class)
				.addEqualsFilter(I_C_OLCand.COLUMNNAME_AD_Note_ID, note.getAD_Note_ID())
				.create()
				.list();

		for (final I_C_OLCand cand : olCands)
		{
			cand.setIsError(false);
			InterfaceWrapperHelper.save(cand);
		}
	}
}
