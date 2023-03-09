package de.metas.vendor.gateway.api.availability;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

import javax.annotation.Nullable;

import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

/*
 * #%L
 * de.metas.vendor.gateway.api
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

@Value
@Builder
public class AvailabilityResponseItem
{
	public enum Type
	{
		AVAILABLE, NOT_AVAILABLE;
	}

	@NonNull
	AvailabilityRequestItem correspondingRequestItem;

	@NonNull
	String productIdentifier;

	@NonNull
	BigDecimal availableQuantity;

	@Nullable
	ZonedDateTime datePromised;

	@NonNull
	Type type;

	@Nullable
	String availabilityText;

	public TrackingId getTrackingId()
	{
		return getCorrespondingRequestItem().getTrackingId();
	}

	public int getUomId()
	{
		return getCorrespondingRequestItem().getProductAndQuantity().getUomId();
	}
}
