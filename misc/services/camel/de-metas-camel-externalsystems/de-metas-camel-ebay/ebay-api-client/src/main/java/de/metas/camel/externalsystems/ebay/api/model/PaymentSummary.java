/*
 * Fulfillment API
 * Use the Fulfillment API to complete the process of packaging, addressing, handling, and shipping each order on behalf of the seller, in accordance with the payment method and timing specified at checkout.
 *
 * The version of the OpenAPI document: v1.19.7
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package de.metas.camel.externalsystems.ebay.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import de.metas.camel.externalsystems.ebay.api.model.Amount;
import de.metas.camel.externalsystems.ebay.api.model.OrderRefund;
import de.metas.camel.externalsystems.ebay.api.model.Payment;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * This type contains information about the various monetary exchanges that apply to the net balance due for the order.
 */
@ApiModel(description = "This type contains information about the various monetary exchanges that apply to the net balance due for the order.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2021-07-20T14:45:55.981728+02:00[Europe/Berlin]")
public class PaymentSummary
{
	public static final String SERIALIZED_NAME_PAYMENTS = "payments";
	@SerializedName(SERIALIZED_NAME_PAYMENTS)
	private List<Payment> payments = null;

	public static final String SERIALIZED_NAME_REFUNDS = "refunds";
	@SerializedName(SERIALIZED_NAME_REFUNDS)
	private List<OrderRefund> refunds = null;

	public static final String SERIALIZED_NAME_TOTAL_DUE_SELLER = "totalDueSeller";
	@SerializedName(SERIALIZED_NAME_TOTAL_DUE_SELLER)
	private Amount totalDueSeller;

	public PaymentSummary payments(List<Payment> payments)
	{

		this.payments = payments;
		return this;
	}

	public PaymentSummary addPaymentsItem(Payment paymentsItem)
	{
		if (this.payments == null)
		{
			this.payments = new ArrayList<>();
		}
		this.payments.add(paymentsItem);
		return this;
	}

	/**
	 * This array consists of payment information for the order, including payment status, payment method, payment amount, and payment date. This array is always returned, although some of the fields under this container will not be returned until payment has been made.
	 * 
	 * @return payments
	 **/
	@javax.annotation.Nullable
	@ApiModelProperty(value = "This array consists of payment information for the order, including payment status, payment method, payment amount, and payment date. This array is always returned, although some of the fields under this container will not be returned until payment has been made.")

	public List<Payment> getPayments()
	{
		return payments;
	}

	public void setPayments(List<Payment> payments)
	{
		this.payments = payments;
	}

	public PaymentSummary refunds(List<OrderRefund> refunds)
	{

		this.refunds = refunds;
		return this;
	}

	public PaymentSummary addRefundsItem(OrderRefund refundsItem)
	{
		if (this.refunds == null)
		{
			this.refunds = new ArrayList<>();
		}
		this.refunds.add(refundsItem);
		return this;
	}

	/**
	 * This array is always returned, but is returned as an empty array unless the seller has submitted a partial or full refund to the buyer for the order. If a refund has occurred, the refund amount and refund date will be shown for each refund.
	 * 
	 * @return refunds
	 **/
	@javax.annotation.Nullable
	@ApiModelProperty(value = "This array is always returned, but is returned as an empty array unless the seller has submitted a partial or full refund to the buyer for the order. If a refund has occurred, the refund amount and refund date will be shown for each refund.")

	public List<OrderRefund> getRefunds()
	{
		return refunds;
	}

	public void setRefunds(List<OrderRefund> refunds)
	{
		this.refunds = refunds;
	}

	public PaymentSummary totalDueSeller(Amount totalDueSeller)
	{

		this.totalDueSeller = totalDueSeller;
		return this;
	}

	/**
	 * Get totalDueSeller
	 * 
	 * @return totalDueSeller
	 **/
	@javax.annotation.Nullable
	@ApiModelProperty(value = "")

	public Amount getTotalDueSeller()
	{
		return totalDueSeller;
	}

	public void setTotalDueSeller(Amount totalDueSeller)
	{
		this.totalDueSeller = totalDueSeller;
	}

	@Override
	public boolean equals(Object o)
	{
		if (this == o)
		{
			return true;
		}
		if (o == null || getClass() != o.getClass())
		{
			return false;
		}
		PaymentSummary paymentSummary = (PaymentSummary)o;
		return Objects.equals(this.payments, paymentSummary.payments) &&
				Objects.equals(this.refunds, paymentSummary.refunds) &&
				Objects.equals(this.totalDueSeller, paymentSummary.totalDueSeller);
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(payments, refunds, totalDueSeller);
	}

	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("class PaymentSummary {\n");
		sb.append("    payments: ").append(toIndentedString(payments)).append("\n");
		sb.append("    refunds: ").append(toIndentedString(refunds)).append("\n");
		sb.append("    totalDueSeller: ").append(toIndentedString(totalDueSeller)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	/**
	 * Convert the given object to string with each line indented by 4 spaces
	 * (except the first line).
	 */
	private String toIndentedString(Object o)
	{
		if (o == null)
		{
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}

}
