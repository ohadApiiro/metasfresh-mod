package de.metas.vertical.creditscore.creditpass.model.schema;

/*
 * #%L
 * de.metas.vertical.creditscore.creditpass.model.schema
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

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

@JsonRootName(value = "REQUEST")
@Value
@Builder
public class Request
{

	@NonNull
	@JsonProperty("CUSTOMER")
	private Customer customer;

	@NonNull
	@JsonProperty("PROCESS")
	private ProcessRequest process;

	@NonNull
	@JsonProperty("QUERY")
	private Query query;
}
