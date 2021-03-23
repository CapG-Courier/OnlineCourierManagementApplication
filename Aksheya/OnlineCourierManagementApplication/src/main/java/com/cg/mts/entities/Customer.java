package com.cg.mts.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "customer")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cust_id")
	private int customerid;
	
	@Column(name = "cust_aadhar_no")
	@NotEmpty(message="This field cannot be empty")
    @NotNull(message="This field cannot be omitted")
	@Pattern(regexp="[0-9]{12}", message="Aadhar number should be 12 digits only")
	private int aadharno;
	
	@Column(name = "first_name", length = 20)
	@NotEmpty(message="This field cannot be empty")
	@NotNull(message="This field cannot be omitted")
	private String firstname;
	
	@Column(name = "last_name", length = 20)
	@NotEmpty(message="This field cannot be empty")
	@NotNull(message="This field cannot be omitted")
	private String lastname;
	
	private Address addr;
	
	@Pattern(regexp="[1-9][0-9]{9}", message="Mobile number is expected to be 10 digits and should not start with 0")
	@NotEmpty(message="This field cannot be empty")
    @NotNull(message="Mobile number cannot be omitted")
	private int mobileno;
	
	private BankAccount acct;
	
	public Customer() {
		
		/*No implementation*/
		
	}

	public int getAadharno() {
		return aadharno;
	}

	public void setAadharno(int aadharno) {
		this.aadharno = aadharno;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Address getAddr() {
		return addr;
	}

	public void setAddr(Address addr) {
		this.addr = addr;
	}

	public int getMobileno() {
		return mobileno;
	}

	public void setMobileno(int mobileno) {
		this.mobileno = mobileno;
	}

	public BankAccount getAcct() {
		return acct;
	}

	public void setAcct(BankAccount acct) {
		this.acct = acct;
	}

	public int getCustomerid() {
		return customerid;
	}

}
