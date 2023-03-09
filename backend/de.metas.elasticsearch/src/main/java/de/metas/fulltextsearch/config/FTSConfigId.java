/*
 * #%L
 * de.metas.elasticsearch
 * %%
 * Copyright (C) 2021 metas GmbH
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

package de.metas.fulltextsearch.config;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import de.metas.util.Check;
import de.metas.util.lang.RepoIdAware;
import lombok.Value;

import javax.annotation.Nullable;

@Value
public class FTSConfigId implements RepoIdAware
{
	@JsonCreator
	public static FTSConfigId ofRepoId(final int repoId)
	{
		return new FTSConfigId(repoId);
	}

	@Nullable
	public static FTSConfigId ofRepoIdOrNull(final int repoId)
	{
		return repoId > 0 ? new FTSConfigId(repoId) : null;
	}

	int repoId;

	private FTSConfigId(final int repoId)
	{
		this.repoId = Check.assumeGreaterThanZero(repoId, "ES_FTS_Config_ID");
	}

	@JsonValue
	@Override
	public int getRepoId()
	{
		return repoId;
	}

	public static int toRepoId(@Nullable final FTSConfigId id)
	{
		return id != null ? id.getRepoId() : -1;
	}
}
