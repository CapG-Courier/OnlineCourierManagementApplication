package com.cg.ocma.model;

public class CourierOfficeOutletModel {
	
	private int officeid;
	
	private String openingTime;
	
	private String closingTime;

	public CourierOfficeOutletModel() {
		 
	}

	public CourierOfficeOutletModel(int officeid, String openingTime, String closingTime) {
		super();
		this.officeid = officeid;
		this.openingTime = openingTime;
		this.closingTime = closingTime;
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
		CourierOfficeOutletModel other = (CourierOfficeOutletModel) obj;
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
		return "CourierOfficeOutletModel [officeid=" + officeid + ", openingTime=" + openingTime + ", closingTime="
				+ closingTime + "]";
	}

}
