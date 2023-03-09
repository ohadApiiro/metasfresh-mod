package de.metas.acct.spi;

import java.sql.Timestamp;
import java.util.List;
import java.util.Properties;

/*
 * #%L
 * de.metas.acct.base
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

public interface IDocumentRepostingSupplier
{

	/**
	 * Retrieve all the documents that are marked as posted but do not actually have fact accounts.
	 * The entries that always produce 0 in accounting will be excluded.
	 * 
	 * @param ctx
	 * @param startTime
	 * @return
	 */
	public List<?> retrievePostedWithoutFactAcct(Properties ctx, Timestamp startTime);
}
