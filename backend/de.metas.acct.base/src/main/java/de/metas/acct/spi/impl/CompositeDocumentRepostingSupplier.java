package de.metas.acct.spi.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.CopyOnWriteArrayList;

import de.metas.acct.spi.IDocumentRepostingSupplier;
import de.metas.document.engine.IDocument;
import de.metas.document.engine.IDocumentBL;
import de.metas.util.Services;

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

/**
 * Composite Document reposting handler
 *
 * @author metas-dev <dev@metasfresh.com>
 *
 */
public class CompositeDocumentRepostingSupplier implements IDocumentRepostingSupplier
{

	// list of handlers to be used when the reposting process is called
	private final CopyOnWriteArrayList<IDocumentRepostingSupplier> suppliers = new CopyOnWriteArrayList<>();

	// add the handler in the list
	public void addSupplier(final IDocumentRepostingSupplier supplier)
	{
		if (supplier == null)
		{
			return;
		}

		suppliers.addIfAbsent(supplier);
	}

	@Override
	public List<IDocument> retrievePostedWithoutFactAcct(final Properties ctx, final Timestamp startTime)
	{
		final IDocumentBL docActionBL = Services.get(IDocumentBL.class);

		final List<IDocument> documentsPostedWithoutFactAcct = new ArrayList<>();

		// Retrieve the documents marked as posted but with no fact accounts from all the handlers
		for (final IDocumentRepostingSupplier handler : suppliers)
		{
			final List<?> documents = handler.retrievePostedWithoutFactAcct(ctx, startTime);
			for (final Object document : documents)
			{
				documentsPostedWithoutFactAcct.add(docActionBL.getDocument(document));
			}

		}

		return documentsPostedWithoutFactAcct;
	}

}
