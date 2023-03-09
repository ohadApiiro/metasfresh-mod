package de.metas.material.event.supplyrequired;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import de.metas.material.event.MaterialEvent;
import de.metas.material.event.commons.EventDescriptor;
import de.metas.material.event.commons.SupplyRequiredDescriptor;
import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

/*
 * #%L
 * metasfresh-material-event
 * %%
 * Copyright (C) 2017 metas GmbH
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
public class SupplyRequiredEvent implements MaterialEvent
{
	public static final String TYPE = "SupplyRequiredEvent";

	@NonNull
	SupplyRequiredDescriptor supplyRequiredDescriptor;

	@JsonCreator
	@Builder
	private SupplyRequiredEvent(
			@JsonProperty("supplyRequiredDescriptor") @NonNull final SupplyRequiredDescriptor supplyRequiredDescriptor)
	{
		this.supplyRequiredDescriptor = supplyRequiredDescriptor;
	}

	@JsonIgnore
	@Override
	public EventDescriptor getEventDescriptor()
	{
		return supplyRequiredDescriptor.getEventDescriptor();
	}
}
