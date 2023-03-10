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
 * This type contains the details of a geographical address.
 */
@ApiModel(description = "This type contains the details of a geographical address.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2021-07-20T14:45:55.981728+02:00[Europe/Berlin]")
public class Address
{
	public static final String SERIALIZED_NAME_ADDRESS_LINE1 = "addressLine1";
	@SerializedName(SERIALIZED_NAME_ADDRESS_LINE1)
	private String addressLine1;

	public static final String SERIALIZED_NAME_ADDRESS_LINE2 = "addressLine2";
	@SerializedName(SERIALIZED_NAME_ADDRESS_LINE2)
	private String addressLine2;

	public static final String SERIALIZED_NAME_CITY = "city";
	@SerializedName(SERIALIZED_NAME_CITY)
	private String city;

	public static final String SERIALIZED_NAME_COUNTRY = "country";
	@SerializedName(SERIALIZED_NAME_COUNTRY)
	private String country;
	
	public static final String SERIALIZED_NAME_COUNTRY_CODE = "countryCode";
	@SerializedName(SERIALIZED_NAME_COUNTRY_CODE)
	private String countryCode;

	public static final String SERIALIZED_NAME_COUNTY = "county";
	@SerializedName(SERIALIZED_NAME_COUNTY)
	private String county;

	public static final String SERIALIZED_NAME_POSTAL_CODE = "postalCode";
	@SerializedName(SERIALIZED_NAME_POSTAL_CODE)
	private String postalCode;

	public static final String SERIALIZED_NAME_STATE_OR_PROVINCE = "stateOrProvince";
	@SerializedName(SERIALIZED_NAME_STATE_OR_PROVINCE)
	private String stateOrProvince;

	public Address addressLine1(String addressLine1)
	{

		this.addressLine1 = addressLine1;
		return this;
	}

	/**
	 * The first line of the street address.
	 * 
	 * @return addressLine1
	 **/
	@javax.annotation.Nullable
	@ApiModelProperty(value = "The first line of the street address.")

	public String getAddressLine1()
	{
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1)
	{
		this.addressLine1 = addressLine1;
	}

	public Address addressLine2(String addressLine2)
	{

		this.addressLine2 = addressLine2;
		return this;
	}

	/**
	 * The second line of the street address. This field can be used for additional address information, such as a suite or apartment number. This field will be returned if defined for the shipping address.
	 * 
	 * @return addressLine2
	 **/
	@javax.annotation.Nullable
	@ApiModelProperty(value = "The second line of the street address. This field can be used for additional address information, such as a suite or apartment number. This field will be returned if defined for the shipping address.")

	public String getAddressLine2()
	{
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2)
	{
		this.addressLine2 = addressLine2;
	}

	public Address city(String city)
	{

		this.city = city;
		return this;
	}

	/**
	 * The city of the shipping destination.
	 * 
	 * @return city
	 **/
	@javax.annotation.Nullable
	@ApiModelProperty(value = "The city of the shipping destination.")

	public String getCity()
	{
		return city;
	}

	public void setCity(String city)
	{
		this.city = city;
	}

	public Address country(String country)
	{

		this.country = country;
		return this;
	}

	/**
	 * The country of the shipping destination, represented as a two-letter ISO 3166-1 alpha-2 country code. For example, US represents the United States, and DE represents Germany. For implementation help, refer to &lt;a href&#x3D;&#39;https://developer.ebay.com/api-docs/sell/fulfillment/types/ba:CountryCodeEnum&#39;&gt;eBay API documentation&lt;/a&gt;
	 * 
	 * @return country
	 **/
	@javax.annotation.Nullable
	@ApiModelProperty(value = "The country of the shipping destination, represented as a two-letter ISO 3166-1 alpha-2 country code. For example, US represents the United States, and DE represents Germany. For implementation help, refer to <a href='https://developer.ebay.com/api-docs/sell/fulfillment/types/ba:CountryCodeEnum'>eBay API documentation</a>")

	public String getCountry()
	{
		return country;
	}

	public void setCountry(String country)
	{
		this.country = country;
	}

	public Address county(String county)
	{

		this.county = county;
		return this;
	}

	/**
	 * The county of the shipping destination. Counties typically, but not always, contain multiple cities or towns. This field is returned if known/available.
	 * 
	 * @return county
	 **/
	@javax.annotation.Nullable
	@ApiModelProperty(value = "The county of the shipping destination. Counties typically, but not always, contain multiple cities or towns. This field is returned if known/available.")

	public String getCounty()
	{
		return county;
	}

	public void setCounty(String county)
	{
		this.county = county;
	}

	public Address postalCode(String postalCode)
	{

		this.postalCode = postalCode;
		return this;
	}

	/**
	 * The postal code of the shipping destination. Usually referred to as Zip codes in the US. Most countries have postal codes, but not all. The postal code will be returned if applicable.
	 * 
	 * @return postalCode
	 **/
	@javax.annotation.Nullable
	@ApiModelProperty(value = "The postal code of the shipping destination. Usually referred to as Zip codes in the US. Most countries have postal codes, but not all. The postal code will be returned if applicable.")

	public String getPostalCode()
	{
		return postalCode;
	}

	public void setPostalCode(String postalCode)
	{
		this.postalCode = postalCode;
	}

	public Address stateOrProvince(String stateOrProvince)
	{

		this.stateOrProvince = stateOrProvince;
		return this;
	}

	/**
	 * The state or province of the shipping destination. Most countries have states or provinces, but not all. The state or province will be returned if applicable.
	 * 
	 * @return stateOrProvince
	 **/
	@javax.annotation.Nullable
	@ApiModelProperty(value = "The state or province of the shipping destination. Most countries have states or provinces, but not all. The state or province will be returned if applicable.")

	public String getStateOrProvince()
	{
		return stateOrProvince;
	}

	public void setStateOrProvince(String stateOrProvince)
	{
		this.stateOrProvince = stateOrProvince;
	}
	
	@javax.annotation.Nullable
	public String getCountryCode()
	{
		return countryCode;
	}

	public void setCountryCode(String countryCode)
	{
		this.countryCode = countryCode;
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
		Address address = (Address)o;
		return Objects.equals(this.addressLine1, address.addressLine1) &&
				Objects.equals(this.addressLine2, address.addressLine2) &&
				Objects.equals(this.city, address.city) &&
				Objects.equals(this.country, address.country) &&
				Objects.equals(this.county, address.county) &&
				Objects.equals(this.postalCode, address.postalCode) &&
				Objects.equals(this.stateOrProvince, address.stateOrProvince);
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(addressLine1, addressLine2, city, country, county, postalCode, stateOrProvince);
	}

	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("class Address {\n");
		sb.append("    addressLine1: ").append(toIndentedString(addressLine1)).append("\n");
		sb.append("    addressLine2: ").append(toIndentedString(addressLine2)).append("\n");
		sb.append("    city: ").append(toIndentedString(city)).append("\n");
		sb.append("    country: ").append(toIndentedString(country)).append("\n");
		sb.append("    countryCode: ").append(toIndentedString(countryCode)).append("\n");
		sb.append("    county: ").append(toIndentedString(county)).append("\n");
		sb.append("    postalCode: ").append(toIndentedString(postalCode)).append("\n");
		sb.append("    stateOrProvince: ").append(toIndentedString(stateOrProvince)).append("\n");
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
