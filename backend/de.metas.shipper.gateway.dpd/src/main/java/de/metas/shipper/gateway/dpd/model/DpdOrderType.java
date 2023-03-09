/*
 * #%L
 * de.metas.shipper.gateway.dpd
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

package de.metas.shipper.gateway.dpd.model;

/**
 * Defines the shipment type.
 * It is somehow related to service type (aka dpd product), but i don't understand how.
 */
public class DpdOrderType
{
	public static final String CONSIGNMENT = "consignment"; // i think this is the default
	public static final String COLLECTION_REQUEST_ORDER = "collection request order";
	public static final String PICKUP_INFORMATION = "pickup information";
}
