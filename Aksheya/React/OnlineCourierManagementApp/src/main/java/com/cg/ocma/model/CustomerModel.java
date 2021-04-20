package com.cg.ocma.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.cg.ocma.entities.BankAccountEntity;

public class CustomerModel {
	
	private int customerid;
	
	@NotNull(message="This field cannot be omitted")
	private long aadharno;
	
	@NotEmpty(message="This field cannot be empty")
	private String firstname;
	
	@NotEmpty(message="This field cannot be empty")
	private String lastname;
	
	private long mobileno;
	
	@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$", message="A digit must occur at least once;"
			+ "A lower case letter must occur at least once; An upper case letter must occur at least once; A special character must occur at least once;"
			+ "No whitespace allowed in the entire password; Atleast 8 characters must be there")
		private String password;

	private BankAccountEntity acct;

	public CustomerModel() {
		 
	}

	public CustomerModel(int customerid,long aadharno, String firstname, String lastname, long mobileno, String password, BankAccountEntity acct) {
		super();
		this.customerid = customerid;
		this.aadharno = aadharno;
		this.firstname = firstname;
		this.lastname = lastname;
		this.mobileno = mobileno;
		this.password = password;
		this.acct = acct;
	}
	
	public CustomerModel(int customerid, long aadharno, String firstname, String lastname, long mobileno, String password) {
		super();
		this.customerid = customerid;
		this.aadharno = aadharno;
		this.firstname = firstname;
		this.lastname = lastname;
		this.mobileno = mobileno;
		this.password = password;
	}

	public int getCustomerid() {
		return customerid;
	}

	public long getAadharno() {
		return aadharno;
	}

	public void setAadharno(long aadharno) {
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

	public long getMobileno() {
		return mobileno;
	}

	public void setMobileno(long mobileno) {
		this.mobileno = mobileno;
	}

	public BankAccountEntity getAcct() {
		return acct;
	}

	public void setAcct(BankAccountEntity acct) {
		this.acct = acct;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "CustomerModel [customerid=" + customerid + ", aadharno=" + aadharno + ", firstname=" + firstname
				+ ", lastname=" + lastname + ", mobileno=" + mobileno + ", acct=" + acct + "]";
	}
	
}
