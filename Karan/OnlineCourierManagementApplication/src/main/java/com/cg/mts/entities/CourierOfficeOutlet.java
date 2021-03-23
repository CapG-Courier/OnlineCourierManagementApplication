package com.cg.mts.entities;

import java.time.LocalTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.tomcat.jni.Address;



@Entity
@Table(name = "CourierOfficeOutlet")
public class CourierOfficeOutlet {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name = "office_id")
	private int officeid;
	@Column(name = "address")
	private Address address_time;
	@Column(name = "opening_time")	
	private LocalTime openingTime;
	@Column(name = "closing_time")
	private LocalTime closingTime;	
	private List<OfficeStaffMember> staffmembers;
	public int getOfficeid() {
		return officeid;
	}
	public void setOfficeid(int officeid) {
		this.officeid = officeid;
	}
	public Address getAddress_time() {
		return address_time;
	}
	public void setAddress_time(Address address_time) {
		this.address_time = address_time;
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
	public List<OfficeStaffMember> getStaffmembers() {
		return staffmembers;
	}
	public void setStaffmembers(List<OfficeStaffMember> staffmembers) {
		this.staffmembers = staffmembers;
	}
	
}
