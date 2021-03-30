package com.cg.ocma.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.cg.ocma.entities.CourierOfficeOutlet;
import com.cg.ocma.entities.Customer;

public class AddressModel {
	
private int addressid;
	
	@NotEmpty(message="This field cannot be empty")
	@NotNull(message="This field cannot be omitted")
	private String houseNo;
	
	@NotEmpty(message="This field cannot be empty")
	@NotNull(message="This field cannot be omitted")
	private String street;
	
	@NotEmpty(message="This field cannot be empty")
	@NotNull(message="This field cannot be omitted")
	private String city;
	
	@NotEmpty(message="This field cannot be empty")
	@NotNull(message="This field cannot be omitted")
	private String state;
	
	@NotEmpty(message="This field cannot be empty")
	@NotNull(message="This field cannot be omitted")
	private String country;
	

	private int zip;

	private Customer customer;
	
	private CourierOfficeOutlet office;
	
	public AddressModel() {
		
		/*No implementation*/
		
	}
	
	public AddressModel(int addressid, String houseNo, String street, String city, String state, String country, int zip, CourierOfficeOutlet office) {
		super();
		this.addressid = addressid;
		this.houseNo = houseNo;
		this.street = street;
		this.city = city;
		this.state = state;
		this.country = country;
		this.zip = zip;
		this.office = office;
	}

	public AddressModel(int addressid, String houseNo, String street, String city, String state, String country, int zip, Customer customer) {
		super();
		this.addressid = addressid;
		this.houseNo = houseNo;
		this.street = street;
		this.city = city;
		this.state = state;
		this.country = country;
		this.zip = zip;
		this.customer = customer;
	}

	public AddressModel(int addressid, String houseNo, String street, String city, String state, String country, int zip) {
		super();
		this.addressid = addressid;
		this.houseNo = houseNo;
		this.street = street;
		this.city = city;
		this.state = state;
		this.country = country;
		this.zip = zip;
	}

	public String getHouseNo() {
		return houseNo;
	}

	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getZip() {
		return zip;
	}

	public void setZip(int zip) {
		this.zip = zip;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public int getAddressid() {
		return addressid;
	}

	public void setAddressid(int addressid) {
		this.addressid = addressid;
	}

	public CourierOfficeOutlet getOffice() {
		return office;
	}

	public void setOffice(CourierOfficeOutlet office) {
		this.office = office;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + addressid;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((customer == null) ? 0 : customer.hashCode());
		result = prime * result + ((houseNo == null) ? 0 : houseNo.hashCode());
		result = prime * result + ((office == null) ? 0 : office.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + ((street == null) ? 0 : street.hashCode());
		result = prime * result + zip;
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
		AddressModel other = (AddressModel) obj;
		if (addressid != other.addressid)
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (customer == null) {
			if (other.customer != null)
				return false;
		} else if (!customer.equals(other.customer))
			return false;
		if (houseNo == null) {
			if (other.houseNo != null)
				return false;
		} else if (!houseNo.equals(other.houseNo))
			return false;
		if (office == null) {
			if (other.office != null)
				return false;
		} else if (!office.equals(other.office))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		if (street == null) {
			if (other.street != null)
				return false;
		} else if (!street.equals(other.street))
			return false;
		if (zip != other.zip)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AddressModel [addressid=" + addressid + ", houseNo=" + houseNo + ", street=" + street + ", city=" + city
				+ ", state=" + state + ", country=" + country + ", zip=" + zip + ", customer=" + customer + ", office="
				+ office + "]";
	}

}
