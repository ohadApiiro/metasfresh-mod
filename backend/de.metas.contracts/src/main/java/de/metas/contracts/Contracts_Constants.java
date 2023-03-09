package de.metas.contracts;

import de.metas.impex.model.I_AD_InputDataSource;

/*
 * #%L
 * de.metas.contracts
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
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/gpl-2.0.html>.
 * #L%
 */


public final class Contracts_Constants
{
	private Contracts_Constants()
	{
	}

	public static final String ENTITY_TYPE = Contracts_Constants.class.getPackage().getName();;

	/**
	 * Internal name of the {@link I_AD_InputDataSource} for contracts.
	 *
	 * @see de.metas.impex.api.IInputDataSourceDAO#retrieveInputDataSource(java.util.Properties, String, boolean, String)
	 */
	public static final String DATA_DESTINATION_INTERNAL_NAME = "DEST.de.metas.flatrate";

	public static final int CONTRACTS_WINDOW_ID = 540359; // FIXME hardcoded

}
