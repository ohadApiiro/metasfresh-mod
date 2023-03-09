/*
 * #%L
 * de.metas.adempiere.adempiere.base
 * %%
 * Copyright (C) 2020 metas GmbH
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

package de.metas.postgrest.client;

import lombok.Builder;
import lombok.NonNull;
import lombok.Value;
import org.springframework.util.MultiValueMap;

import javax.annotation.Nullable;
import java.util.List;

import static de.metas.postgrest.client.PostgRESTResponseFormat.JSON;

@Value
@Builder
public class GetRequest
{
	@NonNull
	String baseURL;

	@Builder.Default
	PostgRESTResponseFormat responseFormat = JSON;

	@Nullable
	List<String> pathVariables;

	@Nullable
	MultiValueMap<String, String> queryParameters;

}