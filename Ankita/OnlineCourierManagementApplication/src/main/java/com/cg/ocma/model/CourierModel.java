package com.cg.ocma.model;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.cg.ocma.entities.CustomerEntity;

public class CourierModel {

	private int courierId;
	
	private int consignmentNo;
	
	@DateTimeFormat(iso=ISO.DATE)
	private LocalDate initiatedDate;
	
	@DateTimeFormat(iso=ISO.DATE)
	private LocalDate deliveredDate;
	
	private CustomerEntity customer;
	
	@NotNull(message="Weight cannot be omitted")
	private double weight;
	
	private double cost;
	
	private String status;

	public CourierModel() {
		
		/* Not implemented */
	}
	
	public CourierModel(LocalDate initiatedDate, CustomerEntity customer, double weight, String status) {
		super();
		this.initiatedDate = initiatedDate;
		this.customer = customer;
		this.weight = weight;
		this.status = status;
	}

	
	public CourierModel(int courierId, int consignmentNo, LocalDate initiatedDate, LocalDate deliveredDate, CustomerEntity customer, double weight,	double cost, String status) {
		super();
		this.courierId = courierId;
		this.consignmentNo = consignmentNo;
		this.initiatedDate = initiatedDate;
		this.deliveredDate = deliveredDate;
		this.customer = customer;
		this.weight = weight;
		this.cost = cost;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public CustomerEntity getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerEntity customer) {
		this.customer = customer;
	}
	
	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	@Override
	public String toString() {
		return "CourierModel [courierId=" + courierId + ", consignmentNo=" + consignmentNo + ", initiatedDate="
				+ initiatedDate + ", deliveredDate=" + deliveredDate + ", customer=" + customer + ", weight=" + weight
				+ ", cost=" + cost + ", status=" + status + "]";
	}

}

