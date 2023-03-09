package de.metas.rfq.process;

import de.metas.process.IProcessPrecondition;
import de.metas.process.IProcessPreconditionsContext;
import de.metas.process.JavaProcess;
import de.metas.process.ProcessPreconditionsResolution;
import de.metas.rfq.IRfQConfiguration;
import de.metas.rfq.IRfQResponsePublisher;
import de.metas.rfq.IRfqBL;
import de.metas.rfq.RfQResponsePublisherRequest;
import de.metas.rfq.RfQResponsePublisherRequest.PublishingType;
import de.metas.rfq.model.I_C_RfQResponse;
import de.metas.rfq.model.I_C_RfQResponseLine;
import de.metas.util.Services;

/*
 * #%L
 * de.metas.rfq
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

public class C_RfQResponseLine_Publish extends JavaProcess implements IProcessPrecondition
{
	// services
	private final transient IRfQConfiguration rfqConfiguration = Services.get(IRfQConfiguration.class);
	private final transient IRfqBL rfqBL = Services.get(IRfqBL.class);

	@Override
	public ProcessPreconditionsResolution checkPreconditionsApplicable(final IProcessPreconditionsContext context)
	{
		final I_C_RfQResponseLine rfqResponseLine = context.getSelectedModel(I_C_RfQResponseLine.class);
		final I_C_RfQResponse rfqResponse = rfqResponseLine.getC_RfQResponse();
		return ProcessPreconditionsResolution.acceptIf(rfqBL.isDraft(rfqResponse));
	}

	@Override
	protected String doIt() throws Exception
	{
		final I_C_RfQResponseLine rfqResponseLine = getRecord(I_C_RfQResponseLine.class);
		final I_C_RfQResponse rfqResponse = rfqResponseLine.getC_RfQResponse();
		rfqBL.assertDraft(rfqResponse);

		final IRfQResponsePublisher rfqPublisher = rfqConfiguration.getRfQResponsePublisher();
		rfqPublisher.publish(RfQResponsePublisherRequest.of(rfqResponse, PublishingType.Invitation));

		return MSG_OK;
	}
}
