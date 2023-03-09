package de.metas.vertical.pharma.msv3.protocol.order;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import lombok.Value;

/*
 * #%L
 * metasfresh-pharma.msv3.commons
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

@JsonAutoDetect(fieldVisibility = Visibility.ANY, getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE, setterVisibility = Visibility.NONE)
@Value
public final class MSV3PurchaseCandidateId
{
	public static MSV3PurchaseCandidateId ofRepoId(final int repoId)
	{
		return new MSV3PurchaseCandidateId(repoId);
	}

	@JsonCreator
	public static MSV3PurchaseCandidateId ofRepoIdOrNull(final int repoId)
	{
		return repoId > 0 ? new MSV3PurchaseCandidateId(repoId) : null;
	}

	public static int toRepoId(final MSV3PurchaseCandidateId id)
	{
		return id != null ? id.getRepoId() : -1;
	}

	int repoId;

	private MSV3PurchaseCandidateId(final int repoId)
	{
		if (repoId <= 0)
		{
			throw new IllegalArgumentException("Invalid repoId: " + repoId);
		}
		this.repoId = repoId;
	}

	@JsonValue
	public int getRepoId()
	{
		return repoId;
	}
}
