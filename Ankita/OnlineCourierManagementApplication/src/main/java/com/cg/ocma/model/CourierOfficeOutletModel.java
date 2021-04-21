package com.cg.ocma.model;

public class CourierOfficeOutletModel {
	
	private int officeId;
	
	private String openingTime;
	
	private String closingTime;

	public CourierOfficeOutletModel() {
		
		/*No implementation*/
		 
	}

	public CourierOfficeOutletModel(int officeId, String openingTime, String closingTime) {
		super();
		this.officeId = officeId;
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
		return "CourierOfficeOutletModel [officeId=" + officeId + ", openingTime=" + openingTime + ", closingTime="
				+ closingTime + "]";
	}

}
