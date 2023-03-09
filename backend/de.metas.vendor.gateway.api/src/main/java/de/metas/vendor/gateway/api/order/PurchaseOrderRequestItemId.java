package de.metas.vendor.gateway.api.order;

import java.util.UUID;

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
public class PurchaseOrderRequestItemId
{
	public static PurchaseOrderRequestItemId of(final String valueAsString)
	{
		return new PurchaseOrderRequestItemId(valueAsString);
	}

	public static PurchaseOrderRequestItemId random()
	{
		return new PurchaseOrderRequestItemId(UUID.randomUUID().toString());
	}

	private final String valueAsString;

	private PurchaseOrderRequestItemId(@NonNull final String valueAsString)
	{
		if (valueAsString.isEmpty())
		{
			throw new IllegalArgumentException("value shall not be empty");
		}

		this.valueAsString = valueAsString;
	}
}
