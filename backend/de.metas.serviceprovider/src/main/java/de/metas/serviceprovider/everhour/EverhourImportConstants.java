/*
 * #%L
 * de.metas.serviceprovider.base
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

package de.metas.serviceprovider.everhour;

import lombok.AllArgsConstructor;
import lombok.Getter;

public interface EverhourImportConstants
{
	int PROCESSING_DATE_INTERVAL_SIZE = 7;

	@AllArgsConstructor
	@Getter enum EverhourImporterSysConfig
	{
		ACCESS_TOKEN("de.metas.issue.tracking.everhour.accessToken"),
		BPARTNER_USER_IMPORT("de.metas.serviceprovider.everhour.bpartnerUserImport");

		private final String name;
	}
}
