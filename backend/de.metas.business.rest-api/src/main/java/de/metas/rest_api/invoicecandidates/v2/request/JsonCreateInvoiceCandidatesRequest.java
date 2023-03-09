/*
 * #%L
 * de.metas.business.rest-api
 * %%
 * Copyright (C) 2022 metas GmbH
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

package de.metas.rest_api.invoicecandidates.v2.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.NonNull;
import lombok.Singular;
import lombok.Value;

import java.util.List;

@Value
public class JsonCreateInvoiceCandidatesRequest
{
	@ApiModelProperty(position = 10, required = true)
	List<JsonCreateInvoiceCandidatesRequestItem> items;

	@Builder
	@JsonCreator
	private JsonCreateInvoiceCandidatesRequest(
			@JsonProperty("items") @Singular @NonNull final List<JsonCreateInvoiceCandidatesRequestItem> items)
	{
		this.items = items;
	}
}