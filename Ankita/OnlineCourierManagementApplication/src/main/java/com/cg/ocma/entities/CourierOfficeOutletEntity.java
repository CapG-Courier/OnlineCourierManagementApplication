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
public class CourierOfficeOutletEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "officeid")
	private int officeId;
	
	@OneToOne(mappedBy = "office", cascade = CascadeType.ALL)
	private AddressEntity addr;
	
	@Column(name = "openingtime")	
	private String openingTime;
	
	@Column(name = "closingtime")
	private String closingTime;

	@OneToMany(mappedBy = "office", cascade = CascadeType.ALL)
	private List <OfficeStaffMembersEntity> officeStaff;
	
	public CourierOfficeOutletEntity() {
		
		/*No implementation*/
			
	}

	public CourierOfficeOutletEntity(int officeId, String openingTime, String closingTime) {
		super();
		this.officeId = officeId;
		this.openingTime = openingTime;
		this.closingTime = closingTime;
	}
	
	public CourierOfficeOutletEntity(String openingTime, String closingTime) {
		super();
		this.openingTime = openingTime;
		this.closingTime = closingTime;
	}

	public int getOfficeid() {
		return officeId;
	}

	public void setOfficeid(int officeId) {
		
		this.officeId = officeId;
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
	public String toString() {
		return "CourierOfficeOutletEntity [officeId=" + officeId + ", addr=" + addr + ", openingTime=" + openingTime
				+ ", closingTime=" + closingTime + ", officeStaff=" + officeStaff + "]";
	}

	
}