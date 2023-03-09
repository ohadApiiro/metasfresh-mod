package de.metas.invoicecandidate.api;

import javax.annotation.Nullable;

import org.adempiere.exceptions.AdempiereException;

import de.metas.process.PInstanceId;
import lombok.EqualsAndHashCode;
import lombok.Getter;

/*
 * #%L
 * de.metas.swat.base
 * %%
 * Copyright (C) 2015 metas GmbH
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

/**
 * Immutable recompute tag used to tag invoice candidates.
 *
 * @author metas-dev <dev@metasfresh.com>
 *
 */
@EqualsAndHashCode
public final class InvoiceCandRecomputeTag
{
	public static final InvoiceCandRecomputeTag NULL = new InvoiceCandRecomputeTag(null);

	public static final InvoiceCandRecomputeTag ofPInstanceId(@Nullable final PInstanceId pinstanceId)
	{
		return new InvoiceCandRecomputeTag(pinstanceId);
	}

	/**
	 * Creates an {@link InvoiceCandRecomputeTag} from a string created with {@link InvoiceCandRecomputeTag#asString()}.
	 */
	public static final InvoiceCandRecomputeTag fromString(@Nullable final String recomputeTagStr)
	{
		// NOTE: keep in sync with toString()
		if (recomputeTagStr == null)
		{
			return NULL;
		}
		try
		{
			final PInstanceId pinstanceId = PInstanceId.ofRepoId(Integer.parseInt(recomputeTagStr));
			return ofPInstanceId(pinstanceId);
		}
		catch (final NumberFormatException e)
		{
			throw new AdempiereException("Failed parsing the tag for recomputeTagStr='" + recomputeTagStr + "'", e);
		}
	}

	public static final boolean isNull(@Nullable final InvoiceCandRecomputeTag recomputeTag)
	{
		return recomputeTag == null || recomputeTag == NULL;
	}

	/**
	 * @return AD_PInstance_ID or null if the tag {@link #isNull(InvoiceCandRecomputeTag)}.
	 */
	public static final PInstanceId getPinstanceIdOrNull(@Nullable final InvoiceCandRecomputeTag recomputeTag)
	{
		if (isNull(recomputeTag))
		{
			return null;
		}
		return recomputeTag.getPinstanceId();
	}

	@Getter
	private final PInstanceId pinstanceId;

	private InvoiceCandRecomputeTag(@Nullable final PInstanceId pinstanceId)
	{
		this.pinstanceId = pinstanceId;
	}

	@Override
	public final String toString()
	{
		return asString();
	}

	/**
	 * @return tag as string
	 * @see #fromString(String)
	 */
	public final String asString()
	{
		if (pinstanceId == null)
		{
			return "NULL";
		}
		// NOTE: keep in sync with fromString()
		return String.valueOf(pinstanceId.getRepoId());
	}
}
