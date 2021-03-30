package com.cg.ocma.model;


import javax.validation.constraints.NotNull;

import com.cg.ocma.entities.BankAccount;

public class CustomerModel {
	
	private int customerid;
	
	@NotNull(message="This field cannot be omitted")
	private long aadharno;
	
	@NotNull(message="This field cannot be omitted")
	private String firstname;
	
	@NotNull(message="This field cannot be omitted")
	private String lastname;
	
	@NotNull(message="Mobile number cannot be omitted")
	private long mobileno;

	private BankAccount acct;

	public CustomerModel() {
		 
	}

	public CustomerModel(int customerid,long aadharno, String firstname, String lastname, long mobileno, BankAccount acct) {
		super();
		this.customerid = customerid;
		this.aadharno = aadharno;
		this.firstname = firstname;
		this.lastname = lastname;
		this.mobileno = mobileno;
		this.acct = acct;
	}
	
	public CustomerModel(int customerid, long aadharno, String firstname, String lastname, long mobileno) {
		super();
		this.customerid = customerid;
		this.aadharno = aadharno;
		this.firstname = firstname;
		this.lastname = lastname;
		this.mobileno = mobileno;
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

	public BankAccount getAcct() {
		return acct;
	}

	public void setAcct(BankAccount acct) {
		this.acct = acct;
	}


	@Override
	public String toString() {
		return "CustomerModel [customerid=" + customerid + ", aadharno=" + aadharno + ", firstname=" + firstname
				+ ", lastname=" + lastname + ", mobileno=" + mobileno + ", acct=" + acct + "]";
	}
	
}
