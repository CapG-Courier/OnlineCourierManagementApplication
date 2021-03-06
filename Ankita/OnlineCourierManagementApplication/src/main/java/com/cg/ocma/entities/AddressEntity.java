package com.cg.ocma.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "address")
public class AddressEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "address_id")
	private int addressId;
	
	@Column(name = "house_no")
	private String houseNo;
	
	@Column(name = "street")
	private String street;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "state")
	private String state;
	
	@Column(name = "country")
	private String country;
	
	@Column(name = "zip")
	private int zip;
	
	@OneToOne
	@JoinColumn(name = "customer_id")
	private CustomerEntity customer;
	
	@OneToOne
	@JoinColumn(name = "office_id")
	private CourierOfficeOutletEntity office;
	
	public AddressEntity() {
		
		/*No implementation*/
		
	}
	
	public AddressEntity(int addressId, String houseNo, String street, String city, String state, String country, int zip, CourierOfficeOutletEntity office) {
		super();
		this.addressId = addressId;
		this.houseNo = houseNo;
		this.street = street;
		this.city = city;
		this.state = state;
		this.country = country;
		this.zip = zip;
		this.office = office;
	}

	public AddressEntity(int addressId, String houseNo, String street, String city, String state, String country, int zip, CustomerEntity customer) {
		super();
		this.addressId = addressId;
		this.houseNo = houseNo;
		this.street = street;
		this.city = city;
		this.state = state;
		this.country = country;
		this.zip = zip;
		this.customer = customer;
	}

	public AddressEntity(int addressId, String houseNo, String street, String city, String state, String country, int zip) {
		super();
		this.addressId = addressId;
		this.houseNo = houseNo;
		this.street = street;
		this.city = city;
		this.state = state;
		this.country = country;
		this.zip = zip;
	}

	public CustomerEntity getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerEntity customer) {
		this.customer = customer;
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

	public int getAddressid() {
		return addressId;
	}

	public void setAddressid(int addressId) {
		this.addressId = addressId;
	}

	public String getHouseNo() {
		return houseNo;
	}

	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}

	public CourierOfficeOutletEntity getOffice() {
		return office;
	}

	public void setOffice(CourierOfficeOutletEntity office) {
		this.office = office;
	}

	@Override
	public String toString() {
		return "AddressEntity [addressId=" + addressId + ", houseNo=" + houseNo + ", street=" + street + ", city="
				+ city + ", state=" + state + ", country=" + country + ", zip=" + zip + ", customer=" + customer
				+ ", office=" + office + "]";
	}
}