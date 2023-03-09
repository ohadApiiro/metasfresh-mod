package de.metas.util.collections;

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


import java.util.NoSuchElementException;

import org.junit.Assert;
import org.junit.Test;

import de.metas.util.collections.SingletonIterator;

/**
 * Tests for {@link SingletonIterator}
 * 
 * @author tsa
 * 
 */
public class SingletonIteratorTest
{
	@Test
	public void commonScenario()
	{
		final String itemExpected = "item1";
		SingletonIterator<String> it = new SingletonIterator<String>(itemExpected);

		Assert.assertTrue(it.hasNext());
		final String itemActual = it.next();
		Assert.assertSame(itemExpected, itemActual);

		Assert.assertFalse(it.hasNext());
	}

	@Test(expected = UnsupportedOperationException.class)
	public void removeNotAllowed()
	{
		final String itemExpected = "item1";
		SingletonIterator<String> it = new SingletonIterator<String>(itemExpected);

		it.remove();
	}

	@Test(expected = NoSuchElementException.class)
	public void onlyOneElementShallBeAvailable()
	{
		final String itemExpected = "item1";
		SingletonIterator<String> it = new SingletonIterator<String>(itemExpected);

		it.next();
		it.next(); // this one shall throw exception
	}
}
