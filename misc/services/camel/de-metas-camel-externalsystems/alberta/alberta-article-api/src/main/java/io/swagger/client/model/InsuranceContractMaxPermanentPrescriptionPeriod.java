/*
 * Artikel - Warenwirtschaft (Basis)
 * Synchronisation der Artikel mit Kumavision
 *
 * OpenAPI spec version: 1.0.2
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package io.swagger.client.model;

import com.google.gson.annotations.SerializedName;
import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;
import java.util.Objects;
/**
 * maximales Intervall für die Dauerverordung
 */
@Schema(description = "maximales Intervall für die Dauerverordung")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2022-02-18T14:17:41.660Z[GMT]")
public class InsuranceContractMaxPermanentPrescriptionPeriod {
  @SerializedName("amount")
  private BigDecimal amount = null;

  @SerializedName("timePeriod")
  private BigDecimal timePeriod = null;

  public InsuranceContractMaxPermanentPrescriptionPeriod amount(BigDecimal amount) {
    this.amount = amount;
    return this;
  }

   /**
   * Anzahl der Tage, Wochen, Monate
   * @return amount
  **/
  @Schema(example = "1", description = "Anzahl der Tage, Wochen, Monate")
  public BigDecimal getAmount() {
    return amount;
  }

  public void setAmount(BigDecimal amount) {
    this.amount = amount;
  }

  public InsuranceContractMaxPermanentPrescriptionPeriod timePeriod(BigDecimal timePeriod) {
    this.timePeriod = timePeriod;
    return this;
  }

   /**
   * Zeitintervall (Unbekannt &#x3D; 0, Minute &#x3D; 1, Stunde &#x3D; 2, Tag &#x3D; 3, Woche &#x3D; 4, Monat &#x3D; 5, Quartal &#x3D; 6, Halbjahr &#x3D; 7, Jahr &#x3D; 8)
   * @return timePeriod
  **/
  @Schema(example = "6", description = "Zeitintervall (Unbekannt = 0, Minute = 1, Stunde = 2, Tag = 3, Woche = 4, Monat = 5, Quartal = 6, Halbjahr = 7, Jahr = 8)")
  public BigDecimal getTimePeriod() {
    return timePeriod;
  }

  public void setTimePeriod(BigDecimal timePeriod) {
    this.timePeriod = timePeriod;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InsuranceContractMaxPermanentPrescriptionPeriod insuranceContractMaxPermanentPrescriptionPeriod = (InsuranceContractMaxPermanentPrescriptionPeriod) o;
    return Objects.equals(this.amount, insuranceContractMaxPermanentPrescriptionPeriod.amount) &&
        Objects.equals(this.timePeriod, insuranceContractMaxPermanentPrescriptionPeriod.timePeriod);
  }

  @Override
  public int hashCode() {
    return Objects.hash(amount, timePeriod);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InsuranceContractMaxPermanentPrescriptionPeriod {\n");
    
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    timePeriod: ").append(toIndentedString(timePeriod)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}