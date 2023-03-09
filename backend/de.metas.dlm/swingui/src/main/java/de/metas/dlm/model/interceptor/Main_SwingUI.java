package de.metas.dlm.model.interceptor;

import org.adempiere.ad.modelvalidator.AbstractModuleInterceptor;

import de.metas.dlm.IDLMService;
import de.metas.dlm.swingui.PreferenceCustomizer;
import de.metas.util.Services;

/*
 * #%L
 * metasfresh-dlm
 * %%
 * Copyright (C) 2016 metas GmbH
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
 * DLM SwingUI module activator.
 *
 * This class will be loaded only if running with {@link org.compiere.Adempiere.RunMode#SWING_CLIENT} run mode.
 *
 * NOTE: for this it's important to keep the name (incl. package name!) in sync with {@link de.metas.dlm.model.interceptor.Main} and also to keep the suffix {@code _SwingUI}.
 *
 * @author metas-dev <dev@metasfresh.com>
 */
public class Main_SwingUI extends AbstractModuleInterceptor
{
	@Override
	public void onUserLogin(final int AD_Org_ID, final int AD_Role_ID, final int AD_User_ID)
	{
		// gh #1411: only add the connection customizer settings to the preferences window if it was enabled.
		final IDLMService dlmService = Services.get(IDLMService.class);
		if (dlmService.isConnectionCustomizerEnabled(AD_User_ID))
		{
			PreferenceCustomizer.customizePrefernces(); // gh #975
		}
	}
}
