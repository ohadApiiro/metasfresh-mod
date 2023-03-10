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
 * This type contains the specifications for processing the fulfillment of a line item, including the handling window and the delivery window. These fields provide guidance for eBay Guaranteed Delivery as well as for non-guaranteed delivery.
 */
@ApiModel(description = "This type contains the specifications for processing the fulfillment of a line item, including the handling window and the delivery window. These fields provide guidance for eBay Guaranteed Delivery as well as for non-guaranteed delivery.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2021-07-20T14:45:55.981728+02:00[Europe/Berlin]")
public class LineItemFulfillmentInstructions
{
	public static final String SERIALIZED_NAME_GUARANTEED_DELIVERY = "guaranteedDelivery";
	@SerializedName(SERIALIZED_NAME_GUARANTEED_DELIVERY)
	private Boolean guaranteedDelivery;

	public static final String SERIALIZED_NAME_MAX_ESTIMATED_DELIVERY_DATE = "maxEstimatedDeliveryDate";
	@SerializedName(SERIALIZED_NAME_MAX_ESTIMATED_DELIVERY_DATE)
	private String maxEstimatedDeliveryDate;

	public static final String SERIALIZED_NAME_MIN_ESTIMATED_DELIVERY_DATE = "minEstimatedDeliveryDate";
	@SerializedName(SERIALIZED_NAME_MIN_ESTIMATED_DELIVERY_DATE)
	private String minEstimatedDeliveryDate;

	public static final String SERIALIZED_NAME_SHIP_BY_DATE = "shipByDate";
	@SerializedName(SERIALIZED_NAME_SHIP_BY_DATE)
	private String shipByDate;

	public LineItemFulfillmentInstructions guaranteedDelivery(Boolean guaranteedDelivery)
	{

		this.guaranteedDelivery = guaranteedDelivery;
		return this;
	}

	/**
	 * This field is returned as true if the order line item is qualified for eBay Guaranteed Delivery, or false if it is not eligible. Only domestic shipments are available for eBay Guaranteed Delivery. At this time, eBay Guaranteed Delivery is only available to a select number of sellers on the US and Australia sites, but this feature will be enabled on more eBay sites in 2019. There are two
	 * different eBay Guaranteed Delivery options - &#39;Handling time&#39; option and &#39;Door-to-Door&#39; option. With both options, the seller is commiting to getting the order delivered to the buyer within three business days after purchase. With the &#39;Handling time&#39; option, the seller&#39;s stated handling time for a listing must be &#39;same-day&#39; or &#39;1-day&#39;, and at least
	 * one of the available shipping service options should have a shipping time that guarantees that the buyer receives the order on time. With this option, eBay will set the &#39;ship-by date&#39; and expected delivery window for the seller, and the seller should just make sure they physically ship the order by the shipToDate. With the &#39;Door-to-door&#39; option, the seller must create
	 * regional shipping rate tables (with shipping costs and delivery times based on destination regions), and then apply these regional shipping rates/delivery times to the listing. If a &#39;Door-to-door&#39; order does not arrive on time, the seller must refund the buyer the full shipping cost (if any), and the buyer also has the option of returning the item for a full refund, and the seller
	 * will also have to pay the return shipping cost. With &#39;Handling time&#39; option, as long as the seller meets the stated handling time, and ships using the correct shipping service option, eBay will refund the buyer the shipping cost and pay for return shipping label (if buyer wants to return item) if the order arrives after the expected delivery time. For more information on the details
	 * and requirements of eBay Guaranteed Delivery, see the Offering eBay Guaranteed Delivery help topic. This field will always be returned regardless of whether the listing site offers eBay Guaranteed Delivery or if the seller is opted in to the feature.
	 * 
	 * @return guaranteedDelivery
	 **/
	@javax.annotation.Nullable
	@ApiModelProperty(value = "This field is returned as true if the order line item is qualified for eBay Guaranteed Delivery, or false if it is not eligible. Only domestic shipments are available for eBay Guaranteed Delivery. At this time, eBay Guaranteed Delivery is only available to a select number of sellers on the US and Australia sites, but this feature will be enabled on more eBay sites in 2019. There are two different eBay Guaranteed Delivery options - 'Handling time' option and 'Door-to-Door' option. With both options, the seller is commiting to getting the order delivered to the buyer within three business days after purchase. With the 'Handling time' option, the seller's stated handling time for a listing must be 'same-day' or '1-day', and at least one of the available shipping service options should have a shipping time that guarantees that the buyer receives the order on time. With this option, eBay will set the 'ship-by date' and expected delivery window for the seller, and the seller should just make sure they physically ship the order by the shipToDate. With the 'Door-to-door' option, the seller must create regional shipping rate tables (with shipping costs and delivery times based on destination regions), and then apply these regional shipping rates/delivery times to the listing. If a 'Door-to-door' order does not arrive on time, the seller must refund the buyer the full shipping cost (if any), and the buyer also has the option of returning the item for a full refund, and the seller will also have to pay the return shipping cost. With 'Handling time' option, as long as the seller meets the stated handling time, and ships using the correct shipping service option, eBay will refund the buyer the shipping cost and pay for return shipping label (if buyer wants to return item) if the order arrives after the expected delivery time. For more information on the details and requirements of eBay Guaranteed Delivery, see the Offering eBay Guaranteed Delivery help topic. This field will always be returned regardless of whether the listing site offers eBay Guaranteed Delivery or if the seller is opted in to the feature.")

	public Boolean getGuaranteedDelivery()
	{
		return guaranteedDelivery;
	}

	public void setGuaranteedDelivery(Boolean guaranteedDelivery)
	{
		this.guaranteedDelivery = guaranteedDelivery;
	}

	public LineItemFulfillmentInstructions maxEstimatedDeliveryDate(String maxEstimatedDeliveryDate)
	{

		this.maxEstimatedDeliveryDate = maxEstimatedDeliveryDate;
		return this;
	}

	/**
	 * The estimated latest date and time that the buyer can expect to receive the line item based on the seller&#39;s stated handling time and the transit times of the available shipping service options. If the listing is eligible for eBay Guaranteed Delivery (value of guaranteedDelivery field is true, the seller must pay extra attention to this date, as a failure to deliver by this date/time can
	 * result in a &#39;Late shipment&#39; seller defect, and can affect seller level and Top-Rated Seller status. In addition to the seller defect, buyers will be eligible for a shipping cost refund, and will also be eligible to return the item for a full refund (with no return shipping charge) if they choose. Note: This timestamp is in ISO 8601 format, which uses the 24-hour Universal
	 * Coordinated Time (UTC) clock. Format: [YYYY]-[MM]-[DD]T[hh]:[mm]:[ss].[sss]Z Example: 2015-08-04T19:09:02.768Z
	 * 
	 * @return maxEstimatedDeliveryDate
	 **/
	@javax.annotation.Nullable
	@ApiModelProperty(value = "The estimated latest date and time that the buyer can expect to receive the line item based on the seller's stated handling time and the transit times of the available shipping service options. If the listing is eligible for eBay Guaranteed Delivery (value of guaranteedDelivery field is true, the seller must pay extra attention to this date, as a failure to deliver by this date/time can result in a 'Late shipment' seller defect, and can affect seller level and Top-Rated Seller status. In addition to the seller defect, buyers will be eligible for a shipping cost refund, and will also be eligible to return the item for a full refund (with no return shipping charge) if they choose. Note: This timestamp is in ISO 8601 format, which uses the 24-hour Universal Coordinated Time (UTC) clock. Format: [YYYY]-[MM]-[DD]T[hh]:[mm]:[ss].[sss]Z Example: 2015-08-04T19:09:02.768Z")

	public String getMaxEstimatedDeliveryDate()
	{
		return maxEstimatedDeliveryDate;
	}

	public void setMaxEstimatedDeliveryDate(String maxEstimatedDeliveryDate)
	{
		this.maxEstimatedDeliveryDate = maxEstimatedDeliveryDate;
	}

	public LineItemFulfillmentInstructions minEstimatedDeliveryDate(String minEstimatedDeliveryDate)
	{

		this.minEstimatedDeliveryDate = minEstimatedDeliveryDate;
		return this;
	}

	/**
	 * The estimated earliest date and time that the buyer can expect to receive the line item based on the seller&#39;s stated handling time and the transit times of the available shipping service options. Note: This timestamp is in ISO 8601 format, which uses the 24-hour Universal Coordinated Time (UTC) clock. Format: [YYYY]-[MM]-[DD]T[hh]:[mm]:[ss].[sss]Z Example: 2015-08-04T19:09:02.768Z
	 * 
	 * @return minEstimatedDeliveryDate
	 **/
	@javax.annotation.Nullable
	@ApiModelProperty(value = "The estimated earliest date and time that the buyer can expect to receive the line item based on the seller's stated handling time and the transit times of the available shipping service options. Note: This timestamp is in ISO 8601 format, which uses the 24-hour Universal Coordinated Time (UTC) clock. Format: [YYYY]-[MM]-[DD]T[hh]:[mm]:[ss].[sss]Z Example: 2015-08-04T19:09:02.768Z")

	public String getMinEstimatedDeliveryDate()
	{
		return minEstimatedDeliveryDate;
	}

	public void setMinEstimatedDeliveryDate(String minEstimatedDeliveryDate)
	{
		this.minEstimatedDeliveryDate = minEstimatedDeliveryDate;
	}

	public LineItemFulfillmentInstructions shipByDate(String shipByDate)
	{

		this.shipByDate = shipByDate;
		return this;
	}

	/**
	 * The latest date and time by which the seller should ship line item in order to meet the expected delivery window. This timestamp will be set by eBay based on time of purchase and the seller&#39;s stated handling time. If the listing is eligible for eBay Guaranteed Delivery (value of guaranteedDelivery field is true, the seller must pay extra attention to this date, as a failure to
	 * physically ship the line item by this date/time can result in a &#39;Late shipment&#39; seller defect, and can affect seller level and Top-Rated Seller status. In addition to the seller defect, buyers will be eligible for a shipping cost refund, and will also be eligible to return the item for a full refund (with no return shipping charge) if they choose. Note: This timestamp is in ISO 8601
	 * format, which uses the 24-hour Universal Coordinated Time (UTC) clock. Format: [YYYY]-[MM]-[DD]T[hh]:[mm]:[ss].[sss]Z Example: 2015-08-04T19:09:02.768Z
	 * 
	 * @return shipByDate
	 **/
	@javax.annotation.Nullable
	@ApiModelProperty(value = "The latest date and time by which the seller should ship line item in order to meet the expected delivery window. This timestamp will be set by eBay based on time of purchase and the seller's stated handling time. If the listing is eligible for eBay Guaranteed Delivery (value of guaranteedDelivery field is true, the seller must pay extra attention to this date, as a failure to physically ship the line item by this date/time can result in a 'Late shipment' seller defect, and can affect seller level and Top-Rated Seller status. In addition to the seller defect, buyers will be eligible for a shipping cost refund, and will also be eligible to return the item for a full refund (with no return shipping charge) if they choose. Note: This timestamp is in ISO 8601 format, which uses the 24-hour Universal Coordinated Time (UTC) clock. Format: [YYYY]-[MM]-[DD]T[hh]:[mm]:[ss].[sss]Z Example: 2015-08-04T19:09:02.768Z")

	public String getShipByDate()
	{
		return shipByDate;
	}

	public void setShipByDate(String shipByDate)
	{
		this.shipByDate = shipByDate;
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
		LineItemFulfillmentInstructions lineItemFulfillmentInstructions = (LineItemFulfillmentInstructions)o;
		return Objects.equals(this.guaranteedDelivery, lineItemFulfillmentInstructions.guaranteedDelivery) &&
				Objects.equals(this.maxEstimatedDeliveryDate, lineItemFulfillmentInstructions.maxEstimatedDeliveryDate) &&
				Objects.equals(this.minEstimatedDeliveryDate, lineItemFulfillmentInstructions.minEstimatedDeliveryDate) &&
				Objects.equals(this.shipByDate, lineItemFulfillmentInstructions.shipByDate);
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(guaranteedDelivery, maxEstimatedDeliveryDate, minEstimatedDeliveryDate, shipByDate);
	}

	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("class LineItemFulfillmentInstructions {\n");
		sb.append("    guaranteedDelivery: ").append(toIndentedString(guaranteedDelivery)).append("\n");
		sb.append("    maxEstimatedDeliveryDate: ").append(toIndentedString(maxEstimatedDeliveryDate)).append("\n");
		sb.append("    minEstimatedDeliveryDate: ").append(toIndentedString(minEstimatedDeliveryDate)).append("\n");
		sb.append("    shipByDate: ").append(toIndentedString(shipByDate)).append("\n");
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
