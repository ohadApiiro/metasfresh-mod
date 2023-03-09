package de.metas.vertical.pharma.msv3.server.peer.metasfresh.services;

import java.util.List;

import org.adempiere.ad.dao.IQueryBL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.ImmutableList;

import de.metas.util.Services;
import de.metas.vertical.pharma.msv3.server.model.I_MSV3_Customer_Config;
import de.metas.vertical.pharma.msv3.server.peer.protocol.MSV3MetasfreshUserId;
import de.metas.vertical.pharma.msv3.server.peer.protocol.MSV3UserChangedBatchEvent;
import de.metas.vertical.pharma.msv3.server.peer.protocol.MSV3UserChangedEvent;
import de.metas.vertical.pharma.msv3.server.peer.service.MSV3ServerPeerService;

/*
 * #%L
 * metasfresh-pharma.msv3.server-peer-metasfresh
 * %%
 * Copyright (C) 2018 metas GmbH
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

@Service
public class MSV3CustomerConfigService
{
	@Autowired
	private MSV3ServerPeerService msv3ServerPeerService;

	public void publishConfigChanged(final I_MSV3_Customer_Config configRecord)
	{
		msv3ServerPeerService.publishUserChangedEvent(toMSV3UserChangedEvent(configRecord));
	}

	public void publishConfigDeleted(final int MSV3_Customer_Config_ID)
	{
		final MSV3MetasfreshUserId userId = MSV3MetasfreshUserId.of(MSV3_Customer_Config_ID);
		final MSV3UserChangedEvent deletedEvent = MSV3UserChangedEvent.deletedEvent(userId);
		msv3ServerPeerService.publishUserChangedEvent(deletedEvent);
	}

	public void publishAllConfig()
	{
		final List<MSV3UserChangedEvent> events = Services.get(IQueryBL.class)
				.createQueryBuilder(I_MSV3_Customer_Config.class)
				// .addOnlyActiveRecordsFilter() // ALL, even if is not active. For those inactive we will generate delete events
				.orderBy(I_MSV3_Customer_Config.COLUMN_MSV3_Customer_Config_ID)
				.create()
				.stream(I_MSV3_Customer_Config.class)
				.map(configRecord -> toMSV3UserChangedEvent(configRecord))
				.collect(ImmutableList.toImmutableList());

		msv3ServerPeerService.publishUserChangedEvent(MSV3UserChangedBatchEvent.builder()
				.events(events)
				.deleteAllOtherUsers(true)
				.build());
	}

	private static MSV3UserChangedEvent toMSV3UserChangedEvent(final I_MSV3_Customer_Config configRecord)
	{
		final MSV3MetasfreshUserId externalId = MSV3MetasfreshUserId.of(configRecord.getMSV3_Customer_Config_ID());

		if (configRecord.isActive())
		{
			return MSV3UserChangedEvent.prepareCreatedOrUpdatedEvent(externalId)
					.username(configRecord.getUserID())
					.password(configRecord.getPassword())
					.bpartnerId(configRecord.getC_BPartner_ID())
					.bpartnerLocationId(configRecord.getC_BPartner_Location_ID())
					.build();
		}
		else
		{
			return MSV3UserChangedEvent.deletedEvent(externalId);
		}

	}
}
