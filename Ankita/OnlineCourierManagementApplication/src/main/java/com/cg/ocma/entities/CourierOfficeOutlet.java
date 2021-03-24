package com.cg.ocma.entities;

import java.time.LocalTime;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CourierOfficeOutlet")
public class CourierOfficeOutlet {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "office_id")
	private int officeid;
	
	@Embedded
	private Address address;
	
	@Column(name = "opening_time")	
	private LocalTime openingTime;
	
	
	@Column(name = "closing_time")
	private LocalTime closingTime;
	
	public CourierOfficeOutlet() {
		
		/*No implementation*/
			
	}

	public CourierOfficeOutlet(int officeid, Address address, LocalTime openingTime, LocalTime closingTime) {
		super();
		this.officeid = officeid;
		this.address = address;
		this.openingTime = openingTime;
		this.closingTime = closingTime;
	}

	public CourierOfficeOutlet(int officeid, LocalTime openingTime, LocalTime closingTime) {
		super();
		this.officeid = officeid;
		this.openingTime = openingTime;
		this.closingTime = closingTime;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public int getOfficeid() {
		return officeid;
	}

	public void setOfficeid(int officeid) {
		
		this.officeid = officeid;
	}
	
	public Address getAddress_time() {
		
		return address;
	}
	
	public void setAddress_time(Address address) {
		
		this.address = address;
	}
	
	public LocalTime getOpeningTime() {
		
		return openingTime;
	}
	
	public void setOpeningTime(LocalTime openingTime) {
		
		this.openingTime = openingTime;
	}
	
	public LocalTime getClosingTime() {
		
		return closingTime;
	}
	
	public void setClosingTime(LocalTime closingTime) {
		
		this.closingTime = closingTime;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((closingTime == null) ? 0 : closingTime.hashCode());
		result = prime * result + officeid;
		result = prime * result + ((openingTime == null) ? 0 : openingTime.hashCode());
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
		CourierOfficeOutlet other = (CourierOfficeOutlet) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (closingTime == null) {
			if (other.closingTime != null)
				return false;
		} else if (!closingTime.equals(other.closingTime))
			return false;
		if (officeid != other.officeid)
			return false;
		if (openingTime == null) {
			if (other.openingTime != null)
				return false;
		} else if (!openingTime.equals(other.openingTime))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CourierOfficeOutlet [officeid=" + officeid + ", address=" + address + ", openingTime=" + openingTime
				+ ", closingTime=" + closingTime + "]";
	}
	
	
}