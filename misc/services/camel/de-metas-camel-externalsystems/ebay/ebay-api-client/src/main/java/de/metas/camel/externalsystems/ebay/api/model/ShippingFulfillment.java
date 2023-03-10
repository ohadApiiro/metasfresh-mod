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
import de.metas.camel.externalsystems.ebay.api.model.LineItemReference;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * This type contains the complete details of an existing fulfillment for an order.
 */
@ApiModel(description = "This type contains the complete details of an existing fulfillment for an order.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2021-07-20T14:45:55.981728+02:00[Europe/Berlin]")
public class ShippingFulfillment
{
	public static final String SERIALIZED_NAME_FULFILLMENT_ID = "fulfillmentId";
	@SerializedName(SERIALIZED_NAME_FULFILLMENT_ID)
	private String fulfillmentId;

	public static final String SERIALIZED_NAME_LINE_ITEMS = "lineItems";
	@SerializedName(SERIALIZED_NAME_LINE_ITEMS)
	private List<LineItemReference> lineItems = null;

	public static final String SERIALIZED_NAME_SHIPMENT_TRACKING_NUMBER = "shipmentTrackingNumber";
	@SerializedName(SERIALIZED_NAME_SHIPMENT_TRACKING_NUMBER)
	private String shipmentTrackingNumber;

	public static final String SERIALIZED_NAME_SHIPPED_DATE = "shippedDate";
	@SerializedName(SERIALIZED_NAME_SHIPPED_DATE)
	private String shippedDate;

	public static final String SERIALIZED_NAME_SHIPPING_CARRIER_CODE = "shippingCarrierCode";
	@SerializedName(SERIALIZED_NAME_SHIPPING_CARRIER_CODE)
	private String shippingCarrierCode;

	public ShippingFulfillment fulfillmentId(String fulfillmentId)
	{

		this.fulfillmentId = fulfillmentId;
		return this;
	}

	/**
	 * The unique identifier of the fulfillment; for example, 9405509699937003457459. This eBay-generated value is created with a successful createShippingFulfillment call.
	 * 
	 * @return fulfillmentId
	 **/
	@javax.annotation.Nullable
	@ApiModelProperty(value = "The unique identifier of the fulfillment; for example, 9405509699937003457459. This eBay-generated value is created with a successful createShippingFulfillment call.")

	public String getFulfillmentId()
	{
		return fulfillmentId;
	}

	public void setFulfillmentId(String fulfillmentId)
	{
		this.fulfillmentId = fulfillmentId;
	}

	public ShippingFulfillment lineItems(List<LineItemReference> lineItems)
	{

		this.lineItems = lineItems;
		return this;
	}

	public ShippingFulfillment addLineItemsItem(LineItemReference lineItemsItem)
	{
		if (this.lineItems == null)
		{
			this.lineItems = new ArrayList<>();
		}
		this.lineItems.add(lineItemsItem);
		return this;
	}

	/**
	 * This array contains a list of one or more line items (and purchased quantity) to which the fulfillment applies.
	 * 
	 * @return lineItems
	 **/
	@javax.annotation.Nullable
	@ApiModelProperty(value = "This array contains a list of one or more line items (and purchased quantity) to which the fulfillment applies.")

	public List<LineItemReference> getLineItems()
	{
		return lineItems;
	}

	public void setLineItems(List<LineItemReference> lineItems)
	{
		this.lineItems = lineItems;
	}

	public ShippingFulfillment shipmentTrackingNumber(String shipmentTrackingNumber)
	{

		this.shipmentTrackingNumber = shipmentTrackingNumber;
		return this;
	}

	/**
	 * The tracking number provided by the shipping carrier for the package shipped in this fulfillment. This field is returned if available.
	 * 
	 * @return shipmentTrackingNumber
	 **/
	@javax.annotation.Nullable
	@ApiModelProperty(value = "The tracking number provided by the shipping carrier for the package shipped in this fulfillment. This field is returned if available.")

	public String getShipmentTrackingNumber()
	{
		return shipmentTrackingNumber;
	}

	public void setShipmentTrackingNumber(String shipmentTrackingNumber)
	{
		this.shipmentTrackingNumber = shipmentTrackingNumber;
	}

	public ShippingFulfillment shippedDate(String shippedDate)
	{

		this.shippedDate = shippedDate;
		return this;
	}

	/**
	 * The date and time that the fulfillment package was shipped. This timestamp is in ISO 8601 format, which uses the 24-hour Universal Coordinated Time (UTC) clock. This field should only be returned if the package has been shipped. Format: [YYYY]-[MM]-[DD]T[hh]:[mm]:[ss].[sss]Z Example: 2015-08-04T19:09:02.768Z
	 * 
	 * @return shippedDate
	 **/
	@javax.annotation.Nullable
	@ApiModelProperty(value = "The date and time that the fulfillment package was shipped. This timestamp is in ISO 8601 format, which uses the 24-hour Universal Coordinated Time (UTC) clock. This field should only be returned if the package has been shipped. Format: [YYYY]-[MM]-[DD]T[hh]:[mm]:[ss].[sss]Z Example: 2015-08-04T19:09:02.768Z")

	public String getShippedDate()
	{
		return shippedDate;
	}

	public void setShippedDate(String shippedDate)
	{
		this.shippedDate = shippedDate;
	}

	public ShippingFulfillment shippingCarrierCode(String shippingCarrierCode)
	{

		this.shippingCarrierCode = shippingCarrierCode;
		return this;
	}

	/**
	 * The eBay code identifying the shipping carrier for this fulfillment. This field is returned if available. Note: The Trading API&#39;s ShippingCarrierCodeType enumeration type contains the most current list of eBay shipping carrier codes and the countries served by each carrier. See ShippingCarrierCodeType.
	 * 
	 * @return shippingCarrierCode
	 **/
	@javax.annotation.Nullable
	@ApiModelProperty(value = "The eBay code identifying the shipping carrier for this fulfillment. This field is returned if available. Note: The Trading API's ShippingCarrierCodeType enumeration type contains the most current list of eBay shipping carrier codes and the countries served by each carrier. See ShippingCarrierCodeType.")

	public String getShippingCarrierCode()
	{
		return shippingCarrierCode;
	}

	public void setShippingCarrierCode(String shippingCarrierCode)
	{
		this.shippingCarrierCode = shippingCarrierCode;
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
		ShippingFulfillment shippingFulfillment = (ShippingFulfillment)o;
		return Objects.equals(this.fulfillmentId, shippingFulfillment.fulfillmentId) &&
				Objects.equals(this.lineItems, shippingFulfillment.lineItems) &&
				Objects.equals(this.shipmentTrackingNumber, shippingFulfillment.shipmentTrackingNumber) &&
				Objects.equals(this.shippedDate, shippingFulfillment.shippedDate) &&
				Objects.equals(this.shippingCarrierCode, shippingFulfillment.shippingCarrierCode);
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(fulfillmentId, lineItems, shipmentTrackingNumber, shippedDate, shippingCarrierCode);
	}

	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("class ShippingFulfillment {\n");
		sb.append("    fulfillmentId: ").append(toIndentedString(fulfillmentId)).append("\n");
		sb.append("    lineItems: ").append(toIndentedString(lineItems)).append("\n");
		sb.append("    shipmentTrackingNumber: ").append(toIndentedString(shipmentTrackingNumber)).append("\n");
		sb.append("    shippedDate: ").append(toIndentedString(shippedDate)).append("\n");
		sb.append("    shippingCarrierCode: ").append(toIndentedString(shippingCarrierCode)).append("\n");
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
