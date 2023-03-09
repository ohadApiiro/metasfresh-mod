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
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;

/**
 * This type is used to provide the status and outcome of an order line item going through the Authenticity Guarantee verification process.
 */
@ApiModel(description = "This type is used to provide the status and outcome of an order line item going through the Authenticity Guarantee verification process.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2021-07-20T14:45:55.981728+02:00[Europe/Berlin]")
public class PostSaleAuthenticationProgram
{
	public static final String SERIALIZED_NAME_OUTCOME_REASON = "outcomeReason";
	@SerializedName(SERIALIZED_NAME_OUTCOME_REASON)
	private String outcomeReason;

	public static final String SERIALIZED_NAME_STATUS = "status";
	@SerializedName(SERIALIZED_NAME_STATUS)
	private String status;

	public PostSaleAuthenticationProgram outcomeReason(String outcomeReason)
	{

		this.outcomeReason = outcomeReason;
		return this;
	}

	/**
	 * This field indicates the result of the authenticity verification inspection on an order line item. This field is not returned when the status value of the order line item is PENDING or PASSED. The possible values returned here are NOT_AUTHENTIC, NOT_AS_DESCRIBED, CUSTOMIZED, MISCATEGORIZED, or NOT_AUTHENTIC_NO_RETURN. For implementation help, refer to &lt;a
	 * href&#x3D;&#39;https://developer.ebay.com/api-docs/sell/fulfillment/types/sel:AuthenticityVerificationReasonEnum&#39;&gt;eBay API documentation&lt;/a&gt;
	 * 
	 * @return outcomeReason
	 **/
	@javax.annotation.Nullable
	@ApiModelProperty(value = "This field indicates the result of the authenticity verification inspection on an order line item. This field is not returned when the status value of the order line item is PENDING or PASSED. The possible values returned here are NOT_AUTHENTIC, NOT_AS_DESCRIBED, CUSTOMIZED, MISCATEGORIZED, or NOT_AUTHENTIC_NO_RETURN. For implementation help, refer to <a href='https://developer.ebay.com/api-docs/sell/fulfillment/types/sel:AuthenticityVerificationReasonEnum'>eBay API documentation</a>")

	public String getOutcomeReason()
	{
		return outcomeReason;
	}

	public void setOutcomeReason(String outcomeReason)
	{
		this.outcomeReason = outcomeReason;
	}

	public PostSaleAuthenticationProgram status(String status)
	{

		this.status = status;
		return this;
	}

	/**
	 * The value in this field indicates whether the order line item has passed or failed the authenticity verification inspection, or if the inspection and/or results are still pending. The possible values returned here are PENDING, PASSED, FAILED, or PASSED_WITH_EXCEPTION. For implementation help, refer to &lt;a
	 * href&#x3D;&#39;https://developer.ebay.com/api-docs/sell/fulfillment/types/sel:AuthenticityVerificationStatusEnum&#39;&gt;eBay API documentation&lt;/a&gt;
	 * 
	 * @return status
	 **/
	@javax.annotation.Nullable
	@ApiModelProperty(value = "The value in this field indicates whether the order line item has passed or failed the authenticity verification inspection, or if the inspection and/or results are still pending. The possible values returned here are PENDING, PASSED, FAILED, or PASSED_WITH_EXCEPTION. For implementation help, refer to <a href='https://developer.ebay.com/api-docs/sell/fulfillment/types/sel:AuthenticityVerificationStatusEnum'>eBay API documentation</a>")

	public String getStatus()
	{
		return status;
	}

	public void setStatus(String status)
	{
		this.status = status;
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
		PostSaleAuthenticationProgram postSaleAuthenticationProgram = (PostSaleAuthenticationProgram)o;
		return Objects.equals(this.outcomeReason, postSaleAuthenticationProgram.outcomeReason) &&
				Objects.equals(this.status, postSaleAuthenticationProgram.status);
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(outcomeReason, status);
	}

	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("class PostSaleAuthenticationProgram {\n");
		sb.append("    outcomeReason: ").append(toIndentedString(outcomeReason)).append("\n");
		sb.append("    status: ").append(toIndentedString(status)).append("\n");
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