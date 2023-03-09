package de.metas.costing;

import org.adempiere.service.ClientId;

import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

/*
 * #%L
 * de.metas.business
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
public class CostElement
{
	CostElementId id;
	String name;
	CostElementType costElementType;
	CostingMethod costingMethod;
	boolean allowUserChangingCurrentCosts;
	ClientId clientId;

	@Builder
	private CostElement(
			@NonNull final CostElementId id,
			@NonNull final String name,
			@NonNull final CostElementType costElementType,
			@NonNull final CostingMethod costingMethod,
			final boolean allowUserChangingCurrentCosts,
			@NonNull final ClientId clientId)
	{
		this.id = id;
		this.name = name;
		this.costElementType = costElementType;
		this.costingMethod = costingMethod;
		this.allowUserChangingCurrentCosts = allowUserChangingCurrentCosts;
		this.clientId = clientId;
	}

	public boolean isMaterialCostingMethod()
	{
		return getCostElementType().isMaterial()
				&& getCostingMethod() != null;
	}

	public boolean isActivityControlElement()
	{
		return getCostElementType().isActivityControlElement();
	}

}
