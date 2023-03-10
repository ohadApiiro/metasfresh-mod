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
import de.metas.camel.externalsystems.ebay.api.model.FileInfo;
import de.metas.camel.externalsystems.ebay.api.model.OrderLineItems;
import de.metas.camel.externalsystems.ebay.api.model.TrackingInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * This type is used by the evidence array that is returned in the getPaymentDispute response if one or more evidential documents are associated with the payment dispute.
 */
@ApiModel(description = "This type is used by the evidence array that is returned in the getPaymentDispute response if one or more evidential documents are associated with the payment dispute.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2021-07-20T14:45:55.981728+02:00[Europe/Berlin]")
public class DisputeEvidence
{
	public static final String SERIALIZED_NAME_EVIDENCE_ID = "evidenceId";
	@SerializedName(SERIALIZED_NAME_EVIDENCE_ID)
	private String evidenceId;

	public static final String SERIALIZED_NAME_EVIDENCE_TYPE = "evidenceType";
	@SerializedName(SERIALIZED_NAME_EVIDENCE_TYPE)
	private String evidenceType;

	public static final String SERIALIZED_NAME_FILES = "files";
	@SerializedName(SERIALIZED_NAME_FILES)
	private List<FileInfo> files = null;

	public static final String SERIALIZED_NAME_LINE_ITEMS = "lineItems";
	@SerializedName(SERIALIZED_NAME_LINE_ITEMS)
	private List<OrderLineItems> lineItems = null;

	public static final String SERIALIZED_NAME_PROVIDED_DATE = "providedDate";
	@SerializedName(SERIALIZED_NAME_PROVIDED_DATE)
	private String providedDate;

	public static final String SERIALIZED_NAME_REQUEST_DATE = "requestDate";
	@SerializedName(SERIALIZED_NAME_REQUEST_DATE)
	private String requestDate;

	public static final String SERIALIZED_NAME_RESPOND_BY_DATE = "respondByDate";
	@SerializedName(SERIALIZED_NAME_RESPOND_BY_DATE)
	private String respondByDate;

	public static final String SERIALIZED_NAME_SHIPMENT_TRACKING = "shipmentTracking";
	@SerializedName(SERIALIZED_NAME_SHIPMENT_TRACKING)
	private List<TrackingInfo> shipmentTracking = null;

	public DisputeEvidence evidenceId(String evidenceId)
	{

		this.evidenceId = evidenceId;
		return this;
	}

	/**
	 * Unique identifier of the evidential file set. Potentially, each evidential file set can have more than one file, that is why there is this file set identifier, and then an identifier for each file within this file set.
	 * 
	 * @return evidenceId
	 **/
	@javax.annotation.Nullable
	@ApiModelProperty(value = "Unique identifier of the evidential file set. Potentially, each evidential file set can have more than one file, that is why there is this file set identifier, and then an identifier for each file within this file set.")

	public String getEvidenceId()
	{
		return evidenceId;
	}

	public void setEvidenceId(String evidenceId)
	{
		this.evidenceId = evidenceId;
	}

	public DisputeEvidence evidenceType(String evidenceType)
	{

		this.evidenceType = evidenceType;
		return this;
	}

	/**
	 * This enumeration value shows the type of evidential file provided. For implementation help, refer to &lt;a href&#x3D;&#39;https://developer.ebay.com/api-docs/sell/fulfillment/types/api:EvidenceTypeEnum&#39;&gt;eBay API documentation&lt;/a&gt;
	 * 
	 * @return evidenceType
	 **/
	@javax.annotation.Nullable
	@ApiModelProperty(value = "This enumeration value shows the type of evidential file provided. For implementation help, refer to <a href='https://developer.ebay.com/api-docs/sell/fulfillment/types/api:EvidenceTypeEnum'>eBay API documentation</a>")

	public String getEvidenceType()
	{
		return evidenceType;
	}

	public void setEvidenceType(String evidenceType)
	{
		this.evidenceType = evidenceType;
	}

	public DisputeEvidence files(List<FileInfo> files)
	{

		this.files = files;
		return this;
	}

	public DisputeEvidence addFilesItem(FileInfo filesItem)
	{
		if (this.files == null)
		{
			this.files = new ArrayList<>();
		}
		this.files.add(filesItem);
		return this;
	}

	/**
	 * This array shows the name, ID, file type, and upload date for each provided file.
	 * 
	 * @return files
	 **/
	@javax.annotation.Nullable
	@ApiModelProperty(value = "This array shows the name, ID, file type, and upload date for each provided file.")

	public List<FileInfo> getFiles()
	{
		return files;
	}

	public void setFiles(List<FileInfo> files)
	{
		this.files = files;
	}

	public DisputeEvidence lineItems(List<OrderLineItems> lineItems)
	{

		this.lineItems = lineItems;
		return this;
	}

	public DisputeEvidence addLineItemsItem(OrderLineItems lineItemsItem)
	{
		if (this.lineItems == null)
		{
			this.lineItems = new ArrayList<>();
		}
		this.lineItems.add(lineItemsItem);
		return this;
	}

	/**
	 * This array shows one or more order line items associated with the evidential document that has been provided.
	 * 
	 * @return lineItems
	 **/
	@javax.annotation.Nullable
	@ApiModelProperty(value = "This array shows one or more order line items associated with the evidential document that has been provided.")

	public List<OrderLineItems> getLineItems()
	{
		return lineItems;
	}

	public void setLineItems(List<OrderLineItems> lineItems)
	{
		this.lineItems = lineItems;
	}

	public DisputeEvidence providedDate(String providedDate)
	{

		this.providedDate = providedDate;
		return this;
	}

	/**
	 * The timestamp in this field shows the date/time when the seller provided a requested evidential document to eBay. The timestamps returned here use the ISO-8601 24-hour date and time format, and the time zone used is Universal Coordinated Time (UTC), also known as Greenwich Mean Time (GMT), or Zulu. The ISO-8601 format looks like this: yyyy-MM-ddThh:mm.ss.sssZ. An example would be
	 * 2019-08-04T19:09:02.768Z.
	 * 
	 * @return providedDate
	 **/
	@javax.annotation.Nullable
	@ApiModelProperty(value = "The timestamp in this field shows the date/time when the seller provided a requested evidential document to eBay. The timestamps returned here use the ISO-8601 24-hour date and time format, and the time zone used is Universal Coordinated Time (UTC), also known as Greenwich Mean Time (GMT), or Zulu. The ISO-8601 format looks like this: yyyy-MM-ddThh:mm.ss.sssZ. An example would be 2019-08-04T19:09:02.768Z.")

	public String getProvidedDate()
	{
		return providedDate;
	}

	public void setProvidedDate(String providedDate)
	{
		this.providedDate = providedDate;
	}

	public DisputeEvidence requestDate(String requestDate)
	{

		this.requestDate = requestDate;
		return this;
	}

	/**
	 * The timestamp in this field shows the date/time when eBay requested the evidential document from the seller in response to a payment dispute. The timestamps returned here use the ISO-8601 24-hour date and time format, and the time zone used is Universal Coordinated Time (UTC), also known as Greenwich Mean Time (GMT), or Zulu. The ISO-8601 format looks like this: yyyy-MM-ddThh:mm.ss.sssZ. An
	 * example would be 2019-08-04T19:09:02.768Z.
	 * 
	 * @return requestDate
	 **/
	@javax.annotation.Nullable
	@ApiModelProperty(value = "The timestamp in this field shows the date/time when eBay requested the evidential document from the seller in response to a payment dispute. The timestamps returned here use the ISO-8601 24-hour date and time format, and the time zone used is Universal Coordinated Time (UTC), also known as Greenwich Mean Time (GMT), or Zulu. The ISO-8601 format looks like this: yyyy-MM-ddThh:mm.ss.sssZ. An example would be 2019-08-04T19:09:02.768Z.")

	public String getRequestDate()
	{
		return requestDate;
	}

	public void setRequestDate(String requestDate)
	{
		this.requestDate = requestDate;
	}

	public DisputeEvidence respondByDate(String respondByDate)
	{

		this.respondByDate = respondByDate;
		return this;
	}

	/**
	 * The timestamp in this field shows the date/time when the seller was expected to provide a requested evidential document to eBay. The timestamps returned here use the ISO-8601 24-hour date and time format, and the time zone used is Universal Coordinated Time (UTC), also known as Greenwich Mean Time (GMT), or Zulu. The ISO-8601 format looks like this: yyyy-MM-ddThh:mm.ss.sssZ. An example
	 * would be 2019-08-04T19:09:02.768Z.
	 * 
	 * @return respondByDate
	 **/
	@javax.annotation.Nullable
	@ApiModelProperty(value = "The timestamp in this field shows the date/time when the seller was expected to provide a requested evidential document to eBay. The timestamps returned here use the ISO-8601 24-hour date and time format, and the time zone used is Universal Coordinated Time (UTC), also known as Greenwich Mean Time (GMT), or Zulu. The ISO-8601 format looks like this: yyyy-MM-ddThh:mm.ss.sssZ. An example would be 2019-08-04T19:09:02.768Z.")

	public String getRespondByDate()
	{
		return respondByDate;
	}

	public void setRespondByDate(String respondByDate)
	{
		this.respondByDate = respondByDate;
	}

	public DisputeEvidence shipmentTracking(List<TrackingInfo> shipmentTracking)
	{

		this.shipmentTracking = shipmentTracking;
		return this;
	}

	public DisputeEvidence addShipmentTrackingItem(TrackingInfo shipmentTrackingItem)
	{
		if (this.shipmentTracking == null)
		{
			this.shipmentTracking = new ArrayList<>();
		}
		this.shipmentTracking.add(shipmentTrackingItem);
		return this;
	}

	/**
	 * This array shows the shipping carrier and shipment tracking number associated with each shipment package of the order. This array is returned if the seller has provided shipment tracking information as evidence to support PROOF_OF_DELIVERY.
	 * 
	 * @return shipmentTracking
	 **/
	@javax.annotation.Nullable
	@ApiModelProperty(value = "This array shows the shipping carrier and shipment tracking number associated with each shipment package of the order. This array is returned if the seller has provided shipment tracking information as evidence to support PROOF_OF_DELIVERY.")

	public List<TrackingInfo> getShipmentTracking()
	{
		return shipmentTracking;
	}

	public void setShipmentTracking(List<TrackingInfo> shipmentTracking)
	{
		this.shipmentTracking = shipmentTracking;
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
		DisputeEvidence disputeEvidence = (DisputeEvidence)o;
		return Objects.equals(this.evidenceId, disputeEvidence.evidenceId) &&
				Objects.equals(this.evidenceType, disputeEvidence.evidenceType) &&
				Objects.equals(this.files, disputeEvidence.files) &&
				Objects.equals(this.lineItems, disputeEvidence.lineItems) &&
				Objects.equals(this.providedDate, disputeEvidence.providedDate) &&
				Objects.equals(this.requestDate, disputeEvidence.requestDate) &&
				Objects.equals(this.respondByDate, disputeEvidence.respondByDate) &&
				Objects.equals(this.shipmentTracking, disputeEvidence.shipmentTracking);
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(evidenceId, evidenceType, files, lineItems, providedDate, requestDate, respondByDate, shipmentTracking);
	}

	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("class DisputeEvidence {\n");
		sb.append("    evidenceId: ").append(toIndentedString(evidenceId)).append("\n");
		sb.append("    evidenceType: ").append(toIndentedString(evidenceType)).append("\n");
		sb.append("    files: ").append(toIndentedString(files)).append("\n");
		sb.append("    lineItems: ").append(toIndentedString(lineItems)).append("\n");
		sb.append("    providedDate: ").append(toIndentedString(providedDate)).append("\n");
		sb.append("    requestDate: ").append(toIndentedString(requestDate)).append("\n");
		sb.append("    respondByDate: ").append(toIndentedString(respondByDate)).append("\n");
		sb.append("    shipmentTracking: ").append(toIndentedString(shipmentTracking)).append("\n");
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
