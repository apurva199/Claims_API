package com.miracle.claims.entity;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


//domain microservice, as interacting with database
//multiple domain
//bff(backend for the frontend) service
@Getter
@Setter
@ToString
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection="claim")
public class Claim{
	
	@Transient
    public static final String SEQUENCE_NAME = "claim_id_sequence";
	
	@Id
	@Field("_id")
	private String id;
	
	@ApiModelProperty(required = true, value = "customer claim id", name = "claimId", dataType = "String", example = "1234")
	@Field("claim_id")
	private String claimId;
	
	@ApiModelProperty(required = true, value = "facility id", name = "facilityId", dataType = "String", example = "Facility_id")
	@Field("facility_id")
	private String facilityId;
	
	@ApiModelProperty(required = true, value = "quantity of pallet", name = "palletQuantity", dataType = "Integer", example = "12")
	@Field("pallet_quantity")
	private int palletQuantity;
	
	@ApiModelProperty(required = true, value = "type of document", name = "documentType", dataType = "String", example = "PDF")
	@Field("document_type")
	private String documentType;
	
	@ApiModelProperty(required = true, value = "amount of claim", name = "claimedAmount", dataType = "String", example = "512")
	@Field("claimed_amount")
	private String claimedAmount;

	@ApiModelProperty(required = true, value = "id of the service provider", name = "serviceProviderClaimId", dataType = "Long", example = "1001")
	@Field("service_provider_claim_id")//auto incrementation to the last value
	public long serviceProviderClaimId;
	
	@ApiModelProperty(required = true, value = "status of the claim", name = "claimStatus", dataType = "String", example = "open")
	@Field("claim_status")
	private String claimStatus;
	
	@ApiModelProperty(required = true, value = "type of claim", name = "claimType", dataType = "String", example = "Warehouse")
	@Field("claim_type")
	private String claimType;
	
	@ApiModelProperty(required = true, value = "creation Date of claim", name = "creationDate", dataType = "Date", example = "2020-05-18T14:10:30.000Z")
	@Field("creation_date")
	private Date creationDate;
	
	@ApiModelProperty(required = true, value = "last updated date of date", name = "lastUpdateDate", dataType = "Date", example = "2020-05-18T14:10:30.000Z")
	@Field("last_update_date")
	private Date lastUpdateDate;
	
	@ApiModelProperty(required = true, value = "closure date of claim", name = "claimCloseDate", dataType = "Date", example = "2020-05-18T14:10:30.000Z")
	@Field("claim_close_date")
	private Date claimCloseDate;

	public String getId() {
		return id;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getLastUpdateDate() {
		return lastUpdateDate;
	}

	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	public Date getClaimCloseDate() {
		return claimCloseDate;
	}

	public void setClaimCloseDate(Date claimCloseDate) {
		this.claimCloseDate = claimCloseDate;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getClaimId() {
		return claimId;
	}

	public void setClaimId(String claimId) {
		this.claimId = claimId;
	}

	public String getFacilityId() {
		return facilityId;
	}

	public void setFacilityId(String facilityId) {
		this.facilityId = facilityId;
	}

	public int getPalletQuantity() {
		return palletQuantity;
	}

	public void setPalletQuantity(int palletQuantity) {
		this.palletQuantity = palletQuantity;
	}

	public String getDocumentType() {
		return documentType;
	}

	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}

	public String getClaimedAmount() {
		return claimedAmount;
	}

	public void setClaimedAmount(String claimedAmount) {
		this.claimedAmount = claimedAmount;
	}

	public long getServiceProviderClaimId() {
		return serviceProviderClaimId;
	}

	public void setServiceProviderClaimId(long serviceProviderClaimId) {
		this.serviceProviderClaimId = serviceProviderClaimId;
	}

	public String getClaimStatus() {
		return claimStatus;
	}

	public void setClaimStatus(String claimStatus) {
		this.claimStatus = claimStatus;
	}

	public String getClaimType() {
		return claimType;
	}

	public void setClaimType(String claimType) {
		this.claimType = claimType;
	}

	@Override
	public String toString() {
		return "Claim [id=" + id + ", claimId=" + claimId + ", facilityId=" + facilityId + ", palletQuantity="
				+ palletQuantity + ", documentType=" + documentType + ", claimedAmount=" + claimedAmount
				+ ", serviceProviderClaimId=" + serviceProviderClaimId + ", claimStatus=" + claimStatus + ", claimType="
				+ claimType + ", creationDate=" + creationDate + ", lastUpdateDate=" + lastUpdateDate
				+ ", claimCloseDate=" + claimCloseDate + "]";
	}	
	
	
}