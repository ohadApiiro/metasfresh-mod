package de.metas.marketing.base.model;

import lombok.Builder;
import lombok.Value;
import org.adempiere.exceptions.AdempiereException;

import java.util.Optional;

/*
 * #%L
 * marketing-base
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
public class Platform
{
	String name;
	PlatformGatewayId platformGatewayId;
	PlatformId platformId;
	boolean requiredLocation;
	boolean requiredMailAddress;

	/** @return existing repository ID or throws exception */
	public int getRepoId()
	{
		final int repoId = Optional.of(this)
				.map(Platform::getPlatformId)
				.map(PlatformId::getRepoId)
				.orElseThrow(() -> new AdempiereException("This platform instance has no repoId")
						.appendParametersToMessage()
						.setParameter("platform", this));
		return repoId;
	}
}
