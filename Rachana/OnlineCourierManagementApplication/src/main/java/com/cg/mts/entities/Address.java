package com.cg.mts.entities;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
@Entity
@Table(name = "?")
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "street")
	@NotEmpty(message="This field cannot be empty")
    @NotNull(message="This field cannot be omitted")
	private String street;
	
	@Column(name = "city")
	@NotEmpty(message="This field cannot be empty")
    @NotNull(message="This field cannot be omitted")
	private String city;
	
	@Column(name = "state")
	private String state;
	
	@Column(name = "street")
	private String country;
	
	@Column(name = "zip")
	@NotEmpty(message="This field cannot be empty")
	@NotNull(message="This field cannot be omitted")
	private int zip;
	
	public Address() {
		
	}
	
	public Address( String street, String city, String state, String country, int zip) {
		super();
		this.street = street;
		this.city = city;
		this.state = state;
		this.country = country;
		this.zip = zip;
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
}