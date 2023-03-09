package org.adempiere.mm.attributes.exceptions;

/*
 * #%L
 * de.metas.swat.base
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


import java.util.Properties;

import org.adempiere.exceptions.AdempiereException;
import org.adempiere.mm.attributes.AttributeListValue;
import org.adempiere.mm.attributes.api.IAttributesBL;
import org.compiere.util.Env;

import de.metas.i18n.AdMessageKey;
import de.metas.i18n.IMsgBL;
import de.metas.lang.SOTrx;
import de.metas.util.Services;

public class AttributeRestrictedException extends AdempiereException
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7812550089813860111L;

	private static final AdMessageKey MSG = AdMessageKey.of("de.metas.swat.Attribute.attributeRestricted");

	private static final AdMessageKey MSG_SOTransaction = AdMessageKey.of("de.metas.swat.SOTrx");
	private static final AdMessageKey MSG_POTransaction = AdMessageKey.of("de.metas.swat.POTrx");

	/**
	 * 
	 * @param ctx
	 * @param isSOTrx
	 * @param attributeValue
	 * @param referenceName name of referenced model on which given attribute value is restricted
	 */
	public AttributeRestrictedException(final Properties ctx, final SOTrx soTrx, final AttributeListValue attributeValue, final String referenceName)
	{
		super(buildMsg(ctx, soTrx, attributeValue, referenceName));

	}

	private static String buildMsg(Properties ctx, SOTrx soTrx, AttributeListValue attributeValue, final String referenceName)
	{
		final boolean isSOTrx = SOTrx.toBoolean(soTrx);
		final String transactionType = Services.get(IMsgBL.class).getMsg(ctx, (isSOTrx ? MSG_SOTransaction : MSG_POTransaction));

		final String adLanguage = Env.getAD_Language(ctx);
		final String attributeName = Services.get(IAttributesBL.class).getAttributeById(attributeValue.getAttributeId()).getName();
		return Services.get(IMsgBL.class).getMsg(adLanguage,
				MSG,
				new Object[] { attributeName, referenceName, transactionType });
	}
}
