package com.cg.project.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.cg.project.entity.Customer;

public class ComplaintModel {
	
	private int complaintId;
	
	@NotEmpty(message="This field cannot be empty")
	@NotNull(message="This field cannot be omitted")
	private int consignmentNo;
	
	@NotEmpty(message="This field cannot be empty")
	@NotNull(message="This field cannot be omitted")
	private String shortDescription;
	
	private String detailDescription;
	
	private Customer customer;

	public ComplaintModel() {
		
	}

	public ComplaintModel(int complaintId, int consignmentNo, String shortDescription, String detailDescription, Customer customer) {
		super();
		this.complaintId = complaintId;
		this.consignmentNo = consignmentNo;
		this.shortDescription = shortDescription;
		this.detailDescription = detailDescription;
		this.customer = customer;
	}
	

	public ComplaintModel(int complaintId, int consignmentNo, String shortDescription, String detailDescription) {
		super();
		this.complaintId = complaintId;
		this.consignmentNo = consignmentNo;
		this.shortDescription = shortDescription;
		this.detailDescription = detailDescription;
	}

	public int getComplaintId() {
		return complaintId;
	}

	public void setComplaintId(int complaintId) {
		this.complaintId = complaintId;
	}

	public int getConsignmentNo() {
		return consignmentNo;
	}

	public void setConsignmentNo(int consignmentNo) {
		this.consignmentNo = consignmentNo;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public String getDetailDescription() {
		return detailDescription;
	}

	public void setDetailDescription(String detailDescription) {
		this.detailDescription = detailDescription;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + complaintId;
		result = prime * result + consignmentNo;
		result = prime * result + ((customer == null) ? 0 : customer.hashCode());
		result = prime * result + ((detailDescription == null) ? 0 : detailDescription.hashCode());
		result = prime * result + ((shortDescription == null) ? 0 : shortDescription.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ComplaintModel other = (ComplaintModel) obj;
		if (complaintId != other.complaintId)
			return false;
		if (consignmentNo != other.consignmentNo)
			return false;
		if (customer == null) {
			if (other.customer != null)
				return false;
		} else if (!customer.equals(other.customer))
			return false;
		if (detailDescription == null) {
			if (other.detailDescription != null)
				return false;
		} else if (!detailDescription.equals(other.detailDescription))
			return false;
		if (shortDescription == null) {
			if (other.shortDescription != null)
				return false;
		} else if (!shortDescription.equals(other.shortDescription))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ComplaintModel [complaintId=" + complaintId + ", consignmentNo=" + consignmentNo + ", shortDescription="
				+ shortDescription + ", detailDescription=" + detailDescription + ", customer=" + customer + "]";
	}

	
}
