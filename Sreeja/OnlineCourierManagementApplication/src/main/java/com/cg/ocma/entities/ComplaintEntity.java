package com.cg.ocma.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="complaint")
public class ComplaintEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "complaintid")
	private int complaintId;
	
	@Column(name = "consignmentno")
	@SequenceGenerator(name = "mySeqGen", sequenceName = "mySeq", initialValue = 5000, allocationSize = 123)
	@GeneratedValue(generator = "mySeqGen")
	private int consignmentNo;
	
	@Column(name = "shortdesc")
	private String shortDescription;
	
	@Column(name = "detaildesc")
	private String detailDescription;
	
	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "customerid")
	private CustomerEntity customer;

	public ComplaintEntity() {
		
		/*No implementation*/
		
	}

	public ComplaintEntity(int complaintId, int consignmentNo, String shortDescription, String detailDescription, CustomerEntity customer) {
		super();
		this.complaintId = complaintId;
		this.consignmentNo = consignmentNo;
		this.shortDescription = shortDescription;
		this.detailDescription = detailDescription;
		this.customer = customer;
	}

	
	public ComplaintEntity(int complaintId, int consignmentNo, String shortDescription, CustomerEntity customer) {
		super();
		this.complaintId = complaintId;
		this.consignmentNo = consignmentNo;
		this.shortDescription = shortDescription;
		this.customer = customer;
	}

	public ComplaintEntity(int complaintId, int consignmentNo, String shortDescription, String detailDescription) {
		super();
		this.complaintId = complaintId;
		this.consignmentNo = consignmentNo;
		this.shortDescription = shortDescription;
		this.detailDescription = detailDescription;
	}

	public int getComplaintId() {
		return complaintId;
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

	public CustomerEntity getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerEntity customer) {
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
		ComplaintEntity other = (ComplaintEntity) obj;
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
		return "Complaint [complaintId=" + complaintId + ", consignmentNo=" + consignmentNo + ", shortDescription="
				+ shortDescription + ", detailDescription=" + detailDescription + ", customer=" + customer + "]";
	}

	
}
