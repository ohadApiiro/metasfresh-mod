package org.adempiere.util.lang;

/*
 * #%L
 * de.metas.util
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


/**
 * Defines a value reference.
 * 
 * This is the base interface for all reference aware classes and interfaces like:
 * <ul>
 * <li> {@link IMutable} which defines a mutable reference
 * <li> {@link LazyInitializer} which is an abtract class. It's value is initalized on first call of {@link #getValue()}.
 * <li>etc
 * </ul>
 * 
 * @author tsa
 * 
 * @param <T>
 */
public interface IReference<T>
{
	/**
	 * 
	 * @return reference value
	 */
	public T getValue();
}
