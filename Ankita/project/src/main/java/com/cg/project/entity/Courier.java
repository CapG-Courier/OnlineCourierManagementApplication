package com.cg.project.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name="courier")
public class Courier {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int courierId;
	
	@Column(name = "c_no")
	private int consignmentNo;
	
	@DateTimeFormat(iso=ISO.DATE)
	private LocalDate initiatedDate;
	
	@DateTimeFormat(iso=ISO.DATE)
	private LocalDate deliveredDate;
	

	public Courier() {
		
	}

	
	public Courier(int courierId, int consignmentNo, LocalDate initiatedDate, LocalDate deliveredDate) {
		super();
		this.courierId = courierId;
		this.consignmentNo = consignmentNo;
		this.initiatedDate = initiatedDate;
		this.deliveredDate = deliveredDate;
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


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + consignmentNo;
		result = prime * result + courierId;
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
				+ initiatedDate + ", deliveredDate=" + deliveredDate + "]";
	}
	
	

}
