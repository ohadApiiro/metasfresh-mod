package de.metas.customs.model.interceptor;

import java.util.Set;

import org.adempiere.ad.modelvalidator.annotations.DocValidate;
import org.adempiere.ad.modelvalidator.annotations.Interceptor;
import org.adempiere.exceptions.AdempiereException;
import org.compiere.Adempiere;
import org.compiere.model.I_C_Customs_Invoice;
import org.compiere.model.ModelValidator;
import org.springframework.stereotype.Component;

import de.metas.customs.CustomsInvoiceId;
import de.metas.customs.CustomsInvoiceRepository;
import de.metas.i18n.AdMessageKey;
import de.metas.i18n.IMsgBL;
import de.metas.i18n.ITranslatableString;
import de.metas.product.ProductId;
import de.metas.util.Services;

/*
 * #%L
 * de.metas.business
 * %%
 * Copyright (C) 2019 metas GmbH
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
@Interceptor(I_C_Customs_Invoice.class)
@Component
public class C_Customs_Invoice
{
	private static final AdMessageKey MSG_C_Customs_Invoice_Tariff_NotSet = AdMessageKey.of("C_Customs_Invoice_Tariff_NotSet");

	@DocValidate(timings = ModelValidator.TIMING_BEFORE_COMPLETE)
	public void doNotCompleteUnlessCustomsTariff(final I_C_Customs_Invoice customsInvoiceRecord)
	{
		final CustomsInvoiceRepository repo = Adempiere.getBean(CustomsInvoiceRepository.class);

		final CustomsInvoiceId customsInvoiceId = CustomsInvoiceId.ofRepoId(customsInvoiceRecord.getC_Customs_Invoice_ID());

		final Set<ProductId> productIdsWithNoCustomsTariff = repo.retrieveProductIdsWithNoCustomsTariff(customsInvoiceId);

		if (!productIdsWithNoCustomsTariff.isEmpty())
		{

			final IMsgBL msgBL = Services.get(IMsgBL.class);

			final ITranslatableString translatableMsgText = msgBL.getTranslatableMsgText(MSG_C_Customs_Invoice_Tariff_NotSet);
			throw new AdempiereException(translatableMsgText)
					.markAsUserValidationError();
		}
	}
}
