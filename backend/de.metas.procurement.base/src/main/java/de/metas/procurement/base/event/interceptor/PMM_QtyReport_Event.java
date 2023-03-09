package de.metas.procurement.base.event.interceptor;

import org.adempiere.ad.modelvalidator.annotations.Interceptor;
import org.adempiere.ad.modelvalidator.annotations.ModelChange;
import org.adempiere.exceptions.AdempiereException;
import org.compiere.model.ModelValidator;

import de.metas.procurement.base.event.async.PMM_QtyReport_Event_Processor;
import de.metas.procurement.base.model.I_PMM_QtyReport_Event;

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
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/gpl-2.0.html>.
 * #L%
 */

@Interceptor(I_PMM_QtyReport_Event.class)
public class PMM_QtyReport_Event
{
	@ModelChange(timings = ModelValidator.TYPE_AFTER_NEW)
	public void scheduleToProcess(final I_PMM_QtyReport_Event event)
	{
		PMM_QtyReport_Event_Processor.scheduleOnTrxCommit(event);
	}

	@ModelChange(timings = ModelValidator.TYPE_BEFORE_CHANGE)
	public void preventChange(final I_PMM_QtyReport_Event event)
	{
		// NOTE: we cannot prevent because the processor shall be able to set Processed flag
		// throw new AdempiereException("Changing event " + event + " is no allowed");
	}

	@ModelChange(timings = ModelValidator.TYPE_BEFORE_DELETE)
	public void preventDelete(final I_PMM_QtyReport_Event event)
	{
		throw new AdempiereException("Deleting event " + event + " is no allowed");
	}
}
