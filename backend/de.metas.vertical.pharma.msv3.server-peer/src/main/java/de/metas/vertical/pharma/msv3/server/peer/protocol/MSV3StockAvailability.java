package de.metas.vertical.pharma.msv3.server.peer.protocol;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Value;

/*
 * #%L
 * metasfresh-pharma.msv3.server
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
public class MSV3StockAvailability
{
	private long pzn;

	private int qty;

	private boolean delete;

	@JsonCreator
	@Builder(toBuilder = true)
	private MSV3StockAvailability(
			@JsonProperty("pzn") final long pzn,
			@JsonProperty("qty") final int qty,
			@JsonProperty("delete") final boolean delete)
	{
		if (pzn <= 0)
		{
			throw new IllegalArgumentException("pzn shall be > 0");
		}
		if (qty < 0)
		{
			throw new IllegalArgumentException("qty shall be >= 0");
		}

		this.pzn = pzn;
		this.qty = qty;
		this.delete = delete;
	}

}
