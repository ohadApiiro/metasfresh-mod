package org.compiere.report.email.service.impl;

import static org.adempiere.model.InterfaceWrapperHelper.getTableId;

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
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public
 * License along with this program. If not, see
 * <http://www.gnu.org/licenses/gpl-2.0.html>.
 * #L%
 */

import java.util.ArrayList;

import org.adempiere.ad.trx.api.ITrx;
import org.compiere.model.I_AD_User;
import org.compiere.model.I_C_Invoice;
import org.compiere.model.I_C_Order;
import org.compiere.model.I_M_InOut;
import org.compiere.model.MBPartner;
import org.compiere.model.MDocType;
import org.compiere.model.MInOut;
import org.compiere.model.MInvoice;
import org.compiere.model.MOrder;
import org.compiere.report.email.service.IEmailParameters;
import org.compiere.util.Env;

import de.metas.bpartner.service.IBPartnerDAO;
import de.metas.i18n.Msg;
import de.metas.letters.model.MADBoilerPlate;
import de.metas.process.ProcessInfo;
import de.metas.user.api.IUserDAO;
import de.metas.util.Services;

/**
 *
 * @author ts
 *
 */
public final class DocumentEmailParams implements IEmailParameters
{

	public static final String MSG_SEND_MAIL = "SendMail";
	public static final String MSG_ATTACHMENT_INVOICE_DOC_NO = "AttachmentInvoiceDocNo";
	public static final String MSG_SUBJECT_INVOICE_DOC_NO = "SubjectInvoiceDocNo";
	public static final String MSG_ATTACHMENT_SHIPMENT_DOC_NO = "AttachmentShipmentDocNo";
	public static final String MSG_SUBJECT_SHIPMENT_DOC_NO = "SubjectShipmentDocNo";
	public static final String MSG_ATTACHMENT_ORDER_DOC_NO = "AttachmentOrderDocNo";
	public static final String MSG_SUBJECT_ORDER_DOC_NO = "SubjectOrderDocNo";

	private final String subject;
	private final String to;
	private final String attachmentPrefix;
	private final I_AD_User from;

	private final static String EXPORT_FILE_PREFIX = null;

	private Integer defaultBoilerPlateId;

	public DocumentEmailParams(final ProcessInfo pi)
	{

		final int tableId = pi.getTable_ID();
		final boolean isOrder = getTableId(I_C_Order.class) == tableId;
		final boolean isInOut = getTableId(I_M_InOut.class) == tableId;
		final boolean isInvoice = getTableId(I_C_Invoice.class) == tableId;

		if (!isOrder && !isInOut && !isInvoice)
		{
			throw new IllegalArgumentException(
					"Process must belong to an order, a shipment or and invoice");
		}

		// get the email subject, the attachment file name and the
		// AD_User_IDs of possible email recipients.

		String documentNo = null;
		String subjectKey = null;
		String attachmentKey = null;
		ArrayList<Integer> userIds = new ArrayList<>();
		int targetDocTypeId = 0;

		if (isOrder)
		{

			MOrder order = new MOrder(Env.getCtx(), pi.getRecord_ID(), null);
			documentNo = order.getDocumentNo();
			subjectKey = MSG_SUBJECT_ORDER_DOC_NO;
			attachmentKey = MSG_ATTACHMENT_ORDER_DOC_NO;
			targetDocTypeId = order.getC_DocTypeTarget_ID();

			final int billUserId = order.getBill_User_ID();
			if (billUserId != 0)
			{
				userIds.add(billUserId);
			}
			final int billBPartnerId = order.getBill_BPartner_ID();
			if (billBPartnerId != 0)
			{
				for (final I_AD_User user : Services.get(IBPartnerDAO.class).retrieveContacts(Env.getCtx(), billBPartnerId, ITrx.TRXNAME_None))
				{
					if (user.isDefaultContact())
					{
						userIds.add(user.getAD_User_ID());
					}
				}
			}
			final int userId = order.getAD_User_ID();
			if (userId > 0)
			{
				userIds.add(userId);
			}

			final int bPartnerId = order.getC_BPartner_ID();
			if (bPartnerId != 0)
			{
				for (final I_AD_User user : Services.get(IBPartnerDAO.class).retrieveContacts(Env.getCtx(), bPartnerId, ITrx.TRXNAME_None))
				{
					if (user.isDefaultContact())
					{
						userIds.add(user.getAD_User_ID());
					}
				}
			}
		}
		else if (isInOut)
		{

			MInOut inOut = new MInOut(Env.getCtx(), pi.getRecord_ID(), null);
			documentNo = inOut.getDocumentNo();
			subjectKey = MSG_SUBJECT_SHIPMENT_DOC_NO;
			attachmentKey = MSG_ATTACHMENT_SHIPMENT_DOC_NO;
			targetDocTypeId = inOut.getC_DocType_ID();

			final int userId = inOut.getAD_User_ID();
			if (userId != 0)
			{
				userIds.add(userId);
			}
			final int bPartnerId = inOut.getC_BPartner_ID();
			if (bPartnerId != 0)
			{
				userIds.add(MBPartner.getDefaultContactId(bPartnerId));
			}
		}
		else if (isInvoice)
		{

			MInvoice invoice = new MInvoice(Env.getCtx(), pi.getRecord_ID(),
					null);
			documentNo = invoice.getDocumentNo();
			subjectKey = MSG_SUBJECT_INVOICE_DOC_NO;
			attachmentKey = MSG_ATTACHMENT_INVOICE_DOC_NO;
			targetDocTypeId = invoice.getC_DocTypeTarget_ID();

			final int userId = invoice.getAD_User_ID();
			if (userId != 0)
			{
				userIds.add(userId);
			}
			final int bPartnerId = invoice.getC_BPartner_ID();
			if (bPartnerId != 0)
			{
				userIds.add(MBPartner.getDefaultContactId(bPartnerId));
			}
		}

		subject = Msg.getMsg(Env.getCtx(), subjectKey,
				new Object[] { documentNo });
		attachmentPrefix = Msg.getMsg(Env.getCtx(), attachmentKey,
				new Object[] { documentNo });

		// attempt to figure out an email-address for the customer
		String toFound = "";
		for (int userId : userIds)
		{
			if (userId < 1)
			{
				continue;
			}
			I_AD_User contanct = Services.get(IUserDAO.class).retrieveUserOrNull(Env.getCtx(), userId);
			if (contanct.getEMail() != null && !"".equals(contanct.getEMail()))
			{
				toFound = contanct.getEMail();
				break;
			}
		}
		to = toFound;

		if (targetDocTypeId != 0)
		{
			MDocType docType = MDocType.get(Env.getCtx(), targetDocTypeId);
			defaultBoilerPlateId = docType.getAD_BoilerPlate_ID();
		}

		from = Services.get(IUserDAO.class).retrieveUserOrNull(Env.getCtx(), Env.getAD_User_ID(Env.getCtx()));
	}

	@Override
	public String getAttachmentPrefix(final String defaultValue)
	{
		if (attachmentPrefix == null)
		{
			return defaultValue;
		}
		return attachmentPrefix;
	}

	@Override
	public I_AD_User getFrom()
	{
		return from;
	}

	@Override
	public String getMessage()
	{
		return "";
	}

	@Override
	public String getSubject()
	{
		return subject;
	}

	@Override
	public String getTitle()
	{
		return Msg.getMsg(Env.getCtx(), MSG_SEND_MAIL);
	}

	@Override
	public String getTo()
	{
		return to;
	}

	@Override
	public String getExportFilePrefix()
	{
		return EXPORT_FILE_PREFIX;
	}

	@Override
	public MADBoilerPlate getDefaultTextPreset()
	{
		if (defaultBoilerPlateId != null && defaultBoilerPlateId > 0)
		{
			return new MADBoilerPlate(Env.getCtx(), defaultBoilerPlateId, null);
		}
		return null;
	}

}
