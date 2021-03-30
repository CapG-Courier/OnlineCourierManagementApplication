package com.cg.ocma.entities;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "courierofficeoutlet")
public class CourierOfficeOutlet {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "officeid")
	private int officeid;
	
	@OneToOne(mappedBy = "office", cascade = CascadeType.ALL)
	private Address address;
	
	@Column(name = "openingtime")	
	private String openingTime;
	
	@Column(name = "closingtime")
	private String closingTime;
	
	@OneToMany(mappedBy = "office", cascade = CascadeType.ALL)
	private List <OfficeStaffMembers> officeStaff;
	
	public CourierOfficeOutlet() {
		
		/*No implementation*/
			
	}

	public CourierOfficeOutlet(int officeid, String openingTime, String closingTime) {
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
	
	public String getOpeningTime() {
		
		return openingTime;
	}
	
	public void setOpeningTime(String openingTime) {
		
		this.openingTime = openingTime;
	}
	
	public String getClosingTime() {
		
		return closingTime;
	}
	
	public void setClosingTime(String closingTime) {
		
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