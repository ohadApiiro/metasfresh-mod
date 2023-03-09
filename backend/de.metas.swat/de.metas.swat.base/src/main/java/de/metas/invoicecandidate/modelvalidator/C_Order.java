package de.metas.invoicecandidate.modelvalidator;

import de.metas.adempiere.model.I_C_Order;
import de.metas.bpartner.service.BPartnerCreditLimitRepository;
import de.metas.bpartner.service.BPartnerStats;
import de.metas.bpartner.service.IBPartnerStatsBL;
import de.metas.bpartner.service.IBPartnerStatsBL.CalculateSOCreditStatusRequest;
import de.metas.bpartner.service.IBPartnerStatsDAO;
import de.metas.currency.ICurrencyBL;
import de.metas.document.IDocTypeDAO;
import de.metas.document.exception.DocumentActionException;
import de.metas.i18n.AdMessageKey;
import de.metas.i18n.TranslatableStrings;
import de.metas.invoicecandidate.api.IInvoiceCandidateHandlerBL;
import de.metas.invoicecandidate.approvedforinvoice.ApprovedForInvoicingService;
import de.metas.money.CurrencyConversionTypeId;
import de.metas.money.CurrencyId;
import de.metas.organization.OrgId;
import de.metas.payment.PaymentRule;
import de.metas.util.Services;
import lombok.NonNull;
import org.adempiere.ad.modelvalidator.annotations.DocValidate;
import org.adempiere.ad.modelvalidator.annotations.Interceptor;
import org.adempiere.exceptions.AdempiereException;
import org.adempiere.service.ClientId;
import org.adempiere.service.ISysConfigBL;
import org.adempiere.util.lang.impl.TableRecordReference;
import org.compiere.Adempiere;
import org.compiere.model.I_C_DocType;
import org.compiere.model.ModelValidator;
import org.compiere.model.X_C_BPartner_Stats;
import org.compiere.model.X_C_DocType;
import org.compiere.util.DisplayType;
import org.springframework.stereotype.Component;
import org.compiere.util.TimeUtil;

import javax.naming.OperationNotSupportedException;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Interceptor(I_C_Order.class)
@Component
public class C_Order
{
	private static final AdMessageKey OPERATION_NOT_SUPPORTED_APPROVED_FOR_INVOICE = AdMessageKey.of("Operation_Not_Supported_Approved_For_Invoice");

	private final ApprovedForInvoicingService approvedForInvoicingService;

	public C_Order(@NonNull final ApprovedForInvoicingService approvedForInvoicingService)
	{
		this.approvedForInvoicingService = approvedForInvoicingService;
	}

	@DocValidate(timings = {
			ModelValidator.TIMING_AFTER_COMPLETE,
			ModelValidator.TIMING_AFTER_REACTIVATE,
			ModelValidator.TIMING_AFTER_CLOSE,
			ModelValidator.TIMING_AFTER_VOID })
	public void invalidateInvoiceCandidates(final I_C_Order order)
	{
		final IInvoiceCandidateHandlerBL invoiceCandidateHandlerBL = Services.get(IInvoiceCandidateHandlerBL.class);
		invoiceCandidateHandlerBL.invalidateCandidatesFor(order);
	}

	@DocValidate(timings = { ModelValidator.TIMING_BEFORE_PREPARE })
	public void checkCreditLimit(@NonNull final I_C_Order order)
	{
		if (!isCheckCreditLimitNeeded(order))
		{
			return;
		}

		final IBPartnerStatsBL bpartnerStatsBL = Services.get(IBPartnerStatsBL.class);
		final IBPartnerStatsDAO bpartnerStatsDAO = Services.get(IBPartnerStatsDAO.class);

		final BPartnerStats stats = bpartnerStatsDAO.getCreateBPartnerStats(order.getBill_BPartner_ID());
		final BigDecimal creditUsed = stats.getSOCreditUsed();
		final String soCreditStatus = stats.getSOCreditStatus();
		final Timestamp dateOrdered = order.getDateOrdered();

		final BPartnerCreditLimitRepository creditLimitRepo = Adempiere.getBean(BPartnerCreditLimitRepository.class);
		final BigDecimal creditLimit = creditLimitRepo.retrieveCreditLimitByBPartnerId(order.getBill_BPartner_ID(), dateOrdered);

		if (X_C_BPartner_Stats.SOCREDITSTATUS_CreditStop.equals(soCreditStatus))
		{
			throw new AdempiereException(TranslatableStrings.builder()
					.appendADElement("BPartnerCreditStop").append(":")
					.append(" ").appendADElement("SO_CreditUsed").append("=").append(creditUsed, DisplayType.Amount)
					.append(", ").appendADElement("SO_CreditLimit").append("=").append(creditLimit, DisplayType.Amount)
					.build());
		}
		if (X_C_BPartner_Stats.SOCREDITSTATUS_CreditHold.equals(soCreditStatus))
		{
			throw new AdempiereException(TranslatableStrings.builder()
					.appendADElement("BPartnerCreditHold").append(":")
					.append(" ").appendADElement("SO_CreditUsed").append("=").append(creditUsed, DisplayType.Amount)
					.append(", ").appendADElement("SO_CreditLimit").append("=").append(creditLimit, DisplayType.Amount)
					.build());
		}
		final BigDecimal grandTotal = Services.get(ICurrencyBL.class).convertBase(
				order.getGrandTotal(),
				CurrencyId.ofRepoId(order.getC_Currency_ID()),
				order.getDateOrdered().toInstant(),
				CurrencyConversionTypeId.ofRepoIdOrNull(order.getC_ConversionType_ID()),
				ClientId.ofRepoId(order.getAD_Client_ID()),
				OrgId.ofRepoId(order.getAD_Org_ID()));

		final CalculateSOCreditStatusRequest request = CalculateSOCreditStatusRequest.builder()
				.stat(stats)
				.additionalAmt(grandTotal) // null is threated like zero
				.date(dateOrdered)
				.build();
		final String calculatedSOCreditStatus = bpartnerStatsBL.calculateProjectedSOCreditStatus(request);

		if (X_C_BPartner_Stats.SOCREDITSTATUS_CreditHold.equals(calculatedSOCreditStatus))
		{
			throw new AdempiereException(TranslatableStrings.builder()
					.appendADElement("BPartnerOverOCreditHold").append(":")
					.append(" ").appendADElement("SO_CreditUsed").append("=").append(creditUsed, DisplayType.Amount)
					.append(", ").appendADElement("GrandTotal").append("=").append(grandTotal, DisplayType.Amount)
					.append(", ").appendADElement("SO_CreditLimit").append("=").append(creditLimit, DisplayType.Amount)
					.build());
		}
	}

	private boolean isCheckCreditLimitNeeded(@NonNull final I_C_Order order)
	{
		if (!order.isSOTrx())
		{
			return false;
		}

		final IBPartnerStatsDAO bpartnerStatsDAO = Services.get(IBPartnerStatsDAO.class);
		final BPartnerStats stats = bpartnerStatsDAO.getCreateBPartnerStats(order.getBill_BPartner_ID());
		if (X_C_BPartner_Stats.SOCREDITSTATUS_NoCreditCheck.equals(stats.getSOCreditStatus()))
		{
			return false;
		}

		final I_C_DocType dt = Services.get(IDocTypeDAO.class).getById(order.getC_DocTypeTarget_ID());
		final ISysConfigBL sysConfigBL = Services.get(ISysConfigBL.class);
		final PaymentRule paymentRule = PaymentRule.ofCode(order.getPaymentRule());
		if (X_C_DocType.DOCSUBTYPE_POSOrder.equals(dt.getDocSubType())
				&& paymentRule.isCash()
				&& !sysConfigBL.getBooleanValue("CHECK_CREDIT_ON_CASH_POS_ORDER", true, order.getAD_Client_ID(), order.getAD_Org_ID()))
		{
			// ignore -- don't validate for Cash POS Orders depending on sysconfig parameter
			return false;
		}
		else if (X_C_DocType.DOCSUBTYPE_PrepayOrder.equals(dt.getDocSubType())
				&& !sysConfigBL.getBooleanValue("CHECK_CREDIT_ON_PREPAY_ORDER", true, order.getAD_Client_ID(), order.getAD_Org_ID()))
		{
			// ignore -- don't validate Prepay Orders depending on sysconfig parameter
			return false;
		}

		return true;
	}

	@DocValidate(timings = {
			ModelValidator.TIMING_BEFORE_REVERSECORRECT,
			ModelValidator.TIMING_BEFORE_REACTIVATE,
			ModelValidator.TIMING_BEFORE_VOID,
			ModelValidator.TIMING_BEFORE_REVERSEACCRUAL })
	public void checkAnyAssociatedInvoiceCandidateClearedForInvoice(@NonNull final I_C_Order order) throws OperationNotSupportedException
	{
		final TableRecordReference recordReference = TableRecordReference.of(I_C_Order.Table_Name, order.getC_Order_ID());

		if (approvedForInvoicingService.areAnyCandidatesApprovedForInvoice(recordReference))
		{
			throw new DocumentActionException(OPERATION_NOT_SUPPORTED_APPROVED_FOR_INVOICE);
		}
	}
}
