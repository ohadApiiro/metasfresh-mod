package de.metas.banking.spi.impl;

import java.sql.Timestamp;
import java.util.List;
import java.util.Properties;

import de.metas.acct.spi.IDocumentRepostingSupplier;
import de.metas.banking.service.IBankStatementDAO;
import lombok.NonNull;

/*
 * #%L
 * de.metas.banking.base
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
 * * Document reposting handler for C_BankStatement
 * 
 * @author metas-dev <dev@metasfresh.com>
 *
 */
public class BankStatementDocumentRepostingSupplier implements IDocumentRepostingSupplier
{
	private final IBankStatementDAO bankStatementDAO;

	public BankStatementDocumentRepostingSupplier(@NonNull final IBankStatementDAO bankStatementDAO)
	{
		this.bankStatementDAO = bankStatementDAO;
	}

	@Override
	public List<?> retrievePostedWithoutFactAcct(Properties ctx, Timestamp startTime)
	{
		return bankStatementDAO.getPostedWithoutFactAcct(ctx, startTime);
	}
}
