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
 * This type is used by the shipmentTracking array returned under the evidence container if the seller has provided shipment tracking information as evidence to support PROOF_OF_DELIVERY for an INR-related payment dispute.
 */
@ApiModel(description = "This type is used by the shipmentTracking array returned under the evidence container if the seller has provided shipment tracking information as evidence to support PROOF_OF_DELIVERY for an INR-related payment dispute.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2021-07-20T14:45:55.981728+02:00[Europe/Berlin]")
public class TrackingInfo
{
	public static final String SERIALIZED_NAME_SHIPMENT_TRACKING_NUMBER = "shipmentTrackingNumber";
	@SerializedName(SERIALIZED_NAME_SHIPMENT_TRACKING_NUMBER)
	private String shipmentTrackingNumber;

	public static final String SERIALIZED_NAME_SHIPPING_CARRIER_CODE = "shippingCarrierCode";
	@SerializedName(SERIALIZED_NAME_SHIPPING_CARRIER_CODE)
	private String shippingCarrierCode;

	public TrackingInfo shipmentTrackingNumber(String shipmentTrackingNumber)
	{

		this.shipmentTrackingNumber = shipmentTrackingNumber;
		return this;
	}

	/**
	 * This string value represents the shipment tracking number of the package.
	 * 
	 * @return shipmentTrackingNumber
	 **/
	@javax.annotation.Nullable
	@ApiModelProperty(value = "This string value represents the shipment tracking number of the package.")

	public String getShipmentTrackingNumber()
	{
		return shipmentTrackingNumber;
	}

	public void setShipmentTrackingNumber(String shipmentTrackingNumber)
	{
		this.shipmentTrackingNumber = shipmentTrackingNumber;
	}

	public TrackingInfo shippingCarrierCode(String shippingCarrierCode)
	{

		this.shippingCarrierCode = shippingCarrierCode;
		return this;
	}

	/**
	 * This string value represents the shipping carrier used to ship the package.
	 * 
	 * @return shippingCarrierCode
	 **/
	@javax.annotation.Nullable
	@ApiModelProperty(value = "This string value represents the shipping carrier used to ship the package.")

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
		TrackingInfo trackingInfo = (TrackingInfo)o;
		return Objects.equals(this.shipmentTrackingNumber, trackingInfo.shipmentTrackingNumber) &&
				Objects.equals(this.shippingCarrierCode, trackingInfo.shippingCarrierCode);
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(shipmentTrackingNumber, shippingCarrierCode);
	}

	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("class TrackingInfo {\n");
		sb.append("    shipmentTrackingNumber: ").append(toIndentedString(shipmentTrackingNumber)).append("\n");
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
