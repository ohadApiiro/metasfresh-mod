package de.metas.acct.posting;

import java.sql.Timestamp;
import java.util.List;
import java.util.Properties;

import de.metas.acct.spi.IDocumentRepostingSupplier;
import de.metas.document.engine.IDocument;
import de.metas.util.ISingletonService;

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

public interface IDocumentRepostingSupplierService extends ISingletonService
{
	void registerSupplier(IDocumentRepostingSupplier supplier);

	/**
	 * Retrieve all the documents that are marked as posted but do not actually have fact accounts
	 * Exclude the documents with no fact accounts that were not supposed to be posted (always 0 in posting)
	 * 
	 * @param ctx
	 * @param startTime
	 * @return
	 */
	List<IDocument> retrievePostedWithoutFactAcct(Properties ctx, Timestamp startTime);

}
