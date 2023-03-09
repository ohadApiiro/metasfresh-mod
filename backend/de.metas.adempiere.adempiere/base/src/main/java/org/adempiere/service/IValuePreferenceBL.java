package org.adempiere.service;

import java.util.Collection;

/*
 * #%L
 * de.metas.adempiere.adempiere.base
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

import java.util.Properties;

import org.adempiere.ad.element.api.AdWindowId;

import de.metas.util.ISingletonService;

import javax.annotation.Nullable;

public interface IValuePreferenceBL extends ISingletonService
{
	public interface IUserValuePreference
	{
		@Nullable AdWindowId getAdWindowId();

		String getName();

		String getValue();

		<T> T getValue(Class<T> clazz);
	}

	public interface IUserValuePreferences
	{
		@Nullable AdWindowId getAdWindowId();

		String getValue(String name);

		<T> T getValue(String name, Class<T> clazz);

		Collection<IUserValuePreference> values();
	}

	IUserValuePreferences getWindowPreferences(Properties ctx, AdWindowId adWindowId);

	Collection<IUserValuePreferences> getAllWindowPreferences(int AD_Client_ID, int AD_Org_ID, int AD_User_ID);

}
