package de.metas.location.geocoding;

import java.util.Optional;

import javax.annotation.Nullable;

import org.adempiere.exceptions.AdempiereException;
import org.springframework.stereotype.Service;

import de.metas.location.geocoding.provider.GeocodingProviderFactory;
import lombok.NonNull;

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

@Service
public class GeocodingService
{
	private final GeocodingProviderFactory providersFactory;

	public GeocodingService(
			@NonNull final GeocodingProviderFactory providersFactory)
	{
		this.providersFactory = providersFactory;
	}

	public Optional<GeographicalCoordinates> findBestCoordinates(@NonNull final GeoCoordinatesRequest request)
	{
		final GeocodingProvider provider = getProvider();
		return provider.findBestCoordinates(request);
	}

	@NonNull
	private GeocodingProvider getProvider()
	{
		return providersFactory.getProvider().orElseThrow(() -> new AdempiereException("No Provider Selected"));
	}
}
