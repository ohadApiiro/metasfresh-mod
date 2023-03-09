package org.adempiere.appdict.validation.spi;

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
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/gpl-2.0.html>.
 * #L%
 */


import java.lang.reflect.Method;

import org.adempiere.exceptions.AdempiereException;

import de.metas.util.Check;

public abstract class AbstractADValidator<T> implements IADValidator<T>
{
	protected Method validateJavaMethodName(final String classname, final Class<?> parentClass, final String methodName)
	{
		Class<?> clazz = validateJavaClassname(classname, parentClass);
		for (Method m : clazz.getMethods())
		{
			if (methodName.equals(m.getName()))
			{
				return m;
			}
		}

		throw new AdempiereException("Method '" + methodName + "' not found in " + clazz);
	}

	protected Class<?> validateJavaClassname(final String classname, final Class<?> parentClass)
	{
		if (Check.isEmpty(classname, true))
		{
			throw new AdempiereException("no classname specified");
		}
		ClassLoader cl = Thread.currentThread().getContextClassLoader();
		if (cl == null)
		{
			cl = getClass().getClassLoader();
		}

		final Class<?> clazz;
		try
		{
			clazz = cl.loadClass(classname);
		}
		catch (ClassNotFoundException e)
		{
			throw new AdempiereException("Classname not found: " + classname, e);
		}

		if (parentClass != null)
		{
			if (!parentClass.isAssignableFrom(clazz))
			{
				throw new AdempiereException("Class " + clazz + " is not assignable from " + parentClass);
			}
		}

		return clazz;
	}
}
