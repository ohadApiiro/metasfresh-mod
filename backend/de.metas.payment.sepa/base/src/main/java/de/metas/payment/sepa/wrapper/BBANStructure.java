/**
 * 
 */
package de.metas.payment.sepa.wrapper;

/*
 * #%L
 * de.metas.payment.sepa
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


import java.util.ArrayList;
import java.util.List;

/**
 * @author cg
 *
 */
public class BBANStructure
{

	final List<BBANStructureEntry> entries = new ArrayList<BBANStructureEntry>();

	
	public BBANStructure()
	{
		super();
	}
	
	public void addEntry(BBANStructureEntry e)
	{
		entries.add(e);
	}

	public List<BBANStructureEntry> getEntries()
	{
		return entries;
	}

	/**
	 * Returns the length of bban.
	 *
	 * @return int length
	 */
	public int getBbanLength()
	{
		int length = 0;

		for (BBANStructureEntry entry : entries)
		{
			length += entry.getLength();
		}

		return length;
	}
}
