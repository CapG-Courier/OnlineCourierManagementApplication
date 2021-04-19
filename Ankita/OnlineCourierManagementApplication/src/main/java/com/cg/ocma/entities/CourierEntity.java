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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="courier")
public class CourierEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "courierid")
	private int courierId;
	
	@Column(unique = true, name = "consignmentno")
	@SequenceGenerator(name = "mySeqGen", sequenceName = "mySeq", initialValue = 5000, allocationSize = 123)
	@GeneratedValue(generator = "mySeqGen")
	private int consignmentNo;
	
	@Column(name = "initiateddate")
	private LocalDate initiatedDate;
	
	@Column(name = "delivereddate")
	private LocalDate deliveredDate;
	
	@ManyToOne
	@JoinColumn(name = "customerid")
	private CustomerEntity customer;
	
	@Column(name = "weight")
	private double weight;
	
	@Enumerated(EnumType.STRING)
	private CourierStatus status;

	public CourierEntity() {
		
		/*No implementation*/
		
	}
	
	
	public CourierEntity(LocalDate initiatedDate, CustomerEntity customer, double weight) {
		super();
		this.initiatedDate = initiatedDate;
		this.customer = customer;
		this.weight = weight;
	}

	public CourierEntity(int courierId, int consignmentNo, LocalDate initiatedDate, LocalDate deliveredDate, CourierStatus status, CustomerEntity customer, double weight) {
		super();
		this.courierId = courierId;
		this.consignmentNo = consignmentNo;
		this.initiatedDate = initiatedDate;
		this.deliveredDate = deliveredDate;
		this.status = status;
		this.customer = customer;
		this.weight = weight;
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
	
	public CustomerEntity getCustomer() {
		return customer;
	}
	
	public void setCustomer(CustomerEntity customer) {
		this.customer = customer;
	}

	public CourierStatus getStatus() {
		return status;
	}

	public void setStatus(CourierStatus status) {
		this.status = status;
	}
	
	public double getWeight() {
		return weight;
	}


	public void setWeight(double weight) {
		this.weight = weight;
	}


	@Override
	public String toString() {
		return "CourierEntity [courierId=" + courierId + ", consignmentNo=" + consignmentNo + ", initiatedDate="
				+ initiatedDate + ", deliveredDate=" + deliveredDate + ", customer=" + customer + ", weight=" + weight
				+ ", status=" + status + "]";
	}

	
	
}