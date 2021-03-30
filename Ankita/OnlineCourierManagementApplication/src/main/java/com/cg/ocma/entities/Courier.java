package com.cg.ocma.entities;

import java.time.LocalDate;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="courier")
public class Courier {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "courierid")
	private int courierId;
	
	@Column(unique = true, name = "consignmentno")
	private int consignmentNo;
	
	@Column(name = "initiateddate")
	private LocalDate initiatedDate;
	
	@Column(name = "delivereddate")
	private LocalDate deliveredDate;
	
	@ManyToOne
	@JoinColumn(name = "customerid")
	private Customer customer;
	
	@Enumerated(EnumType.STRING)
	private CourierStatus status;

	public Courier() {
		
		/*No implementation*/
		
	}

	
	public Courier(int courierId, int consignmentNo, LocalDate initiatedDate, LocalDate deliveredDate, Customer customer) {
		super();
		this.courierId = courierId;
		this.consignmentNo = consignmentNo;
		this.initiatedDate = initiatedDate;
		this.deliveredDate = deliveredDate;
		this.customer = customer;
	}


	public Courier(int courierId, int consignmentNo, LocalDate initiatedDate, LocalDate deliveredDate) {
		super();
		this.courierId = courierId;
		this.consignmentNo = consignmentNo;
		this.initiatedDate = initiatedDate;
		this.deliveredDate = deliveredDate;
	}

	public Courier(LocalDate initiatedDate) {
		super();
		this.initiatedDate = initiatedDate;
	}
	

	public Courier(int courierId, int consignmentNo, LocalDate initiatedDate) {
		super();
		this.courierId = courierId;
		this.consignmentNo = consignmentNo;
		this.initiatedDate = initiatedDate;
	}

	public Courier(int courierId, int consignmentNo, LocalDate initiatedDate, LocalDate deliveredDate, CourierStatus status) {
		super();
		this.courierId = courierId;
		this.consignmentNo = consignmentNo;
		this.initiatedDate = initiatedDate;
		this.deliveredDate = deliveredDate;
		this.status = status;
	}

	

	public Courier(int courierId, int consignmentNo, LocalDate initiatedDate, LocalDate deliveredDate,Customer customer, CourierStatus status) {
		super();
		this.courierId = courierId;
		this.consignmentNo = consignmentNo;
		this.initiatedDate = initiatedDate;
		this.deliveredDate = deliveredDate;
		this.customer = customer;
		this.status = status;
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
	
	public Customer getCustomer() {
		return customer;
	}
	
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public CourierStatus getStatus() {
		return status;
	}

	public void setStatus(CourierStatus status) {
		this.status = status;
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
		Courier other = (Courier) obj;
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
		return "Courier [courierId=" + courierId + ", consignmentNo=" + consignmentNo + ", initiatedDate="
				+ initiatedDate + ", deliveredDate=" + deliveredDate + ", customer=" + customer + "]";
	}

	
}
