package de.metas.async.spi;

/*
 * #%L
 * de.metas.async
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


import org.adempiere.ad.dao.IQueryBuilder;

import de.metas.async.model.I_C_Queue_WorkPackage;

/**
 * Default strategy that is used unless a work package processor explicitly specifies something else.
 * 
 * @author ts
 *
 */
public final class NullLatchStrategy implements ILatchStragegy
{
	public static final NullLatchStrategy INSTANCE = new NullLatchStrategy();

	private NullLatchStrategy()
	{
	};

	@Override
	public void postponeIfNeeded(final I_C_Queue_WorkPackage currentWorkPackage, 
			final IQueryBuilder<I_C_Queue_WorkPackage> currentlyLockedWorpackagesQuery)
	{
		// nothing
	}
}
