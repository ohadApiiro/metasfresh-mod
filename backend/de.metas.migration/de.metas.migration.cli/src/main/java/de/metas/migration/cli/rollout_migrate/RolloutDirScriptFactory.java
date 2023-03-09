package de.metas.migration.cli.rollout_migrate;

/*
 * #%L
 * de.metas.migration.cli
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

import de.metas.migration.IScript;
import de.metas.migration.scanner.IFileRef;
import de.metas.migration.scanner.impl.AbstractScriptFactory;

/* package */class RolloutDirScriptFactory extends AbstractScriptFactory
{

	@Override
	public IScript createScript(final IFileRef fileRef)
	{
		final IFileRef parent = fileRef.getParent();

		final String projectName = parent.getFileName();

		return createScript(projectName, fileRef);
	}

	@Override
	public String toString()
	{
		return "RolloutDirScriptFactory []";
	}
}
