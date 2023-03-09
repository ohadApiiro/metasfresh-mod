package de.metas.allocation.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import de.metas.util.Check;
import de.metas.util.lang.RepoIdAware;
import lombok.Value;

/*
 * #%L
 * de.metas.adempiere.adempiere.base
 * %%
 * Copyright (C) 2019 metas GmbH
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
public class PaymentAllocationId implements RepoIdAware
{
	@JsonCreator
	public static PaymentAllocationId ofRepoId(final int repoId)
	{
		return new PaymentAllocationId(repoId);
	}

	public static PaymentAllocationId ofRepoIdOrNull(final int repoId)
	{
		return repoId > 0 ? new PaymentAllocationId(repoId) : null;
	}

	int repoId;

	private PaymentAllocationId(final int repoId)
	{
		this.repoId = Check.assumeGreaterThanZero(repoId, "C_AllocationHdr_ID");
	}

	@JsonValue
	@Override
	public int getRepoId()
	{
		return repoId;
	}

	public static int toRepoId(final PaymentAllocationId PaymentAllocationId)
	{
		return PaymentAllocationId != null ? PaymentAllocationId.getRepoId() : -1;
	}
}
