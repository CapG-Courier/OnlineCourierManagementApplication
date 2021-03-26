	package com.cg.ocma.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

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

	private BankAccountEntity acct;

	public CustomerModel() {
		 
	}

	public CustomerModel(int customerid,long aadharno, String firstname, String lastname, long mobileno, BankAccountEntity acct) {
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

	public BankAccountEntity getAcct() {
		return acct;
	}

	public void setAcct(BankAccountEntity acct) {
		this.acct = acct;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (aadharno ^ (aadharno >>> 32));
		result = prime * result + ((acct == null) ? 0 : acct.hashCode());
		result = prime * result + customerid;
		result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
		result = prime * result + ((lastname == null) ? 0 : lastname.hashCode());
		result = prime * result + (int) (mobileno ^ (mobileno >>> 32));
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
		CustomerModel other = (CustomerModel) obj;
		if (aadharno != other.aadharno)
			return false;
		if (acct == null) {
			if (other.acct != null)
				return false;
		} else if (!acct.equals(other.acct))
			return false;
		if (customerid != other.customerid)
			return false;
		if (firstname == null) {
			if (other.firstname != null)
				return false;
		} else if (!firstname.equals(other.firstname))
			return false;
		if (lastname == null) {
			if (other.lastname != null)
				return false;
		} else if (!lastname.equals(other.lastname))
			return false;
		if (mobileno != other.mobileno)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CustomerModel [customerid=" + customerid + ", aadharno=" + aadharno + ", firstname=" + firstname
				+ ", lastname=" + lastname + ", mobileno=" + mobileno + ", acct=" + acct + "]";
	}
	
}
