package de.metas.invoicecandidate.api.impl;

import de.metas.invoicecandidate.api.IInvoiceCandUpdateSchedulerRequest;
import de.metas.invoicecandidate.api.IInvoiceCandUpdateSchedulerService;
import de.metas.invoicecandidate.async.spi.impl.UpdateInvalidInvoiceCandidatesWorkpackageProcessor;
import lombok.NonNull;

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
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/gpl-2.0.html>.
 * #L%
 */

public class InvoiceCandUpdateSchedulerService implements IInvoiceCandUpdateSchedulerService
{
	@Override
	public void scheduleForUpdate(@NonNull final IInvoiceCandUpdateSchedulerRequest request)
	{
		UpdateInvalidInvoiceCandidatesWorkpackageProcessor.schedule(request);
	}
}
