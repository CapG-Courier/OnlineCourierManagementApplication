package com.cg.project.model;

import java.time.LocalDate;

import com.cg.project.entity.Customer;

public class CourierModel {

	private int courierId;
	
	private int consignmentNo;
	
	private LocalDate initiatedDate;
	
	private LocalDate deliveredDate;
	
	private Customer customer;
	
	private String status;

	public CourierModel() {
		
	}

	public CourierModel(int courierId, int consignmentNo, LocalDate initiatedDate, LocalDate deliveredDate, String status, Customer customer) {
		super();
		this.courierId = courierId;
		this.consignmentNo = consignmentNo;
		this.initiatedDate = initiatedDate;
		this.deliveredDate = deliveredDate;
		this.status = status;
		this.customer = customer;
	}
	
	

	public CourierModel(int courierId, int consignmentNo,LocalDate initiatedDate) {
		super();
		this.courierId = courierId;
		this.consignmentNo = consignmentNo;
		this.initiatedDate = initiatedDate;
	}

	public int getCourierId() {
		return courierId;
	}

	public int getConsignmentNo() {
		return consignmentNo;
	}

	public void setConsignmentNo(int consignmentNo) {
		this.consignmentNo = consignmentNo;
	}

	public LocalDate getInitiatedDate() {
		return initiatedDate;
	}

	public void setInitiatedDate(LocalDate initiatedDate) {
		this.initiatedDate = initiatedDate;
	}

	public LocalDate getDeliveredDate() {
		return deliveredDate;
	}

	public void setDeliveredDate(LocalDate deliveredDate) {
		this.deliveredDate = deliveredDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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
		result = prime * result + consignmentNo;
		result = prime * result + courierId;
		result = prime * result + ((customer == null) ? 0 : customer.hashCode());
		result = prime * result + ((deliveredDate == null) ? 0 : deliveredDate.hashCode());
		result = prime * result + ((initiatedDate == null) ? 0 : initiatedDate.hashCode());
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
		CourierModel other = (CourierModel) obj;
		if (consignmentNo != other.consignmentNo)
			return false;
		if (courierId != other.courierId)
			return false;
		if (customer == null) {
			if (other.customer != null)
				return false;
		} else if (!customer.equals(other.customer))
			return false;
		if (deliveredDate == null) {
			if (other.deliveredDate != null)
				return false;
		} else if (!deliveredDate.equals(other.deliveredDate))
			return false;
		if (initiatedDate == null) {
			if (other.initiatedDate != null)
				return false;
		} else if (!initiatedDate.equals(other.initiatedDate))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CourierModel [courierId=" + courierId + ", consignmentNo=" + consignmentNo + ", initiatedDate="
				+ initiatedDate + ", deliveredDate=" + deliveredDate + ", customer=" + customer + "]";
	}
	
	
	
}
