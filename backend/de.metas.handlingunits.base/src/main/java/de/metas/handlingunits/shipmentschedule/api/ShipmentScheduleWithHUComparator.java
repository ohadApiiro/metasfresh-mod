package de.metas.handlingunits.shipmentschedule.api;

/*
 * #%L
 * de.metas.handlingunits.base
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

import static de.metas.common.util.CoalesceUtil.coalesce;

import java.util.Comparator;

import org.adempiere.util.agg.key.IAggregationKeyBuilder;

import de.metas.handlingunits.model.I_M_HU;
import de.metas.inoutcandidate.api.IShipmentScheduleBL;
import de.metas.inoutcandidate.model.I_M_ShipmentSchedule;
import de.metas.util.Services;
import lombok.NonNull;

/**
 * Sort {@link IShipmentScheduleWithHU} records by
 * <ul>
 * <li>Shipment Schedule's header aggregation key ({@link I_M_ShipmentSchedule#getHeaderAggregationKey()})
 * <li>TU's M_HU_ID ({@link IShipmentScheduleWithHU#getM_TU_HU()})
 * <li>M_ShipmentSchedule_ID ({@link I_M_ShipmentSchedule#getM_ShipmentSchedule_ID()})
 * </ul>
 *
 * @author tsa
 *
 */
public class ShipmentScheduleWithHUComparator implements Comparator<ShipmentScheduleWithHU>
{
	private final IAggregationKeyBuilder<I_M_ShipmentSchedule> shipmentScheduleKeyBuilder = Services.get(IShipmentScheduleBL.class).mkShipmentHeaderAggregationKeyBuilder();
	private final IAggregationKeyBuilder<ShipmentScheduleWithHU> huShipmentScheduleKeyBuilder = Services.get(IHUShipmentScheduleBL.class).mkHUShipmentScheduleHeaderAggregationKeyBuilder();

	public ShipmentScheduleWithHUComparator()
	{
	}

	@Override
	public int compare(final ShipmentScheduleWithHU o1, final ShipmentScheduleWithHU o2)
	{
		if (o1 == o2)
		{
			return 0;
		}
		if (o1 == null)
		{
			return +1; // nulls last, shall not happen
		}
		else if (o2 == null)
		{
			return -1; // nulls last, shall not happen
		}

		//
		// Sort by shipment schedule's aggregation key
		{
			final String aggregationKey1 = getAggregationKey(o1);
			final String aggregationKey2 = getAggregationKey(o2);
			final int cmp = aggregationKey1.compareTo(aggregationKey2);
			if (cmp != 0)
			{
				return cmp;
			}
		}

		//
		// Sort by M_HU_ID - instances a smaller M_HU_ID go first, but instances with no HU go last;
		// important because when we mix instances with and without HU, the ones with HU need to "take the lead"!
		{
			final int huId1 = getM_HU_ID(o1);
			final int huId2 = getM_HU_ID(o2);
			if (huId1 != huId2)
			{
				// o1 has a smaller M_HU_ID => result is < 0 => o1 is smaller and goes first
				return huId1 - huId2;
			}
		}

		//
		// Sort by M_ShipmentSchedule_ID
		{
			final int shipmentScheduleId1 = getM_ShipmentSchedule_ID(o1);
			final int shipmentScheduleId2 = getM_ShipmentSchedule_ID(o2);
			if (shipmentScheduleId1 != shipmentScheduleId2)
			{
				return shipmentScheduleId1 - shipmentScheduleId2;
			}
		}

		//
		// Else, we can consider them pretty the same ;)
		return 0;
	}

	private final int getM_ShipmentSchedule_ID(final ShipmentScheduleWithHU schedWithHU)
	{
		if (schedWithHU == null)
		{
			return -1;
		}
		final I_M_ShipmentSchedule shipmentSchedule = schedWithHU.getM_ShipmentSchedule();
		if (shipmentSchedule == null)
		{
			// shall not happen
			return -1;
		}

		final int shipmentScheduleId = shipmentSchedule.getM_ShipmentSchedule_ID();
		if (shipmentScheduleId <= 0)
		{
			return -1;
		}

		return shipmentScheduleId;
	}

	private final String getAggregationKey(final ShipmentScheduleWithHU schedWithHU)
	{
		if (schedWithHU == null)
		{
			return "";
		}
		final I_M_ShipmentSchedule shipmentSchedule = schedWithHU.getM_ShipmentSchedule();
		if (shipmentSchedule == null)
		{
			// shall not happen
			return "";
		}

		final StringBuilder aggregationKey = new StringBuilder();

		//
		// Shipment header aggregation key (from M_ShipmentSchedule)
		final String shipmentScheduleAggregationKey = shipmentScheduleKeyBuilder.buildKey(shipmentSchedule);
		if (shipmentScheduleAggregationKey != null)
		{
			aggregationKey.append(shipmentScheduleAggregationKey);
		}

		//
		// Shipment header aggregation key (the HU related part)
		final String huShipmentScheduleAggregationKey = huShipmentScheduleKeyBuilder.buildKey(schedWithHU);
		if (huShipmentScheduleAggregationKey != null)
		{
			if (aggregationKey.length() > 0)
			{
				aggregationKey.append("#");
			}
			aggregationKey.append(huShipmentScheduleAggregationKey);
		}

		//
		// Shipment line aggregation key
		{
			final Object attributesAggregationKey = schedWithHU.getAttributesAggregationKey();
			if (aggregationKey.length() > 0)
			{
				aggregationKey.append("#");
			}
			aggregationKey.append(attributesAggregationKey);
		}

		return aggregationKey.toString();
	}

	private final int getM_HU_ID(@NonNull final ShipmentScheduleWithHU schedWithHU)
	{
		final I_M_HU huRecord = coalesce(schedWithHU.getM_LU_HU(), schedWithHU.getM_TU_HU(), schedWithHU.getVHU());
		if (huRecord == null)
		{
			return Integer.MAX_VALUE;
		}

		final int huId = huRecord.getM_HU_ID();
		if (huId <= 0)
		{
			return Integer.MAX_VALUE;
		}

		return huId;
	}
}
