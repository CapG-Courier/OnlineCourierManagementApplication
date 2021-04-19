package com.cg.ocma.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.cg.ocma.entities.BankAccountEntity;

public class CustomerModel {
	
	private int customerId;
	
	@NotNull(message="This field cannot be omitted")
	private long aadharNo;
	
	@NotEmpty(message="This field cannot be empty")
	private String firstName;
	
	@NotEmpty(message="This field cannot be empty")
	private String lastName;
	
	private long mobileNo;
	
	@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$", message="A digit must occur at least once;"
			+ "A lower case letter must occur at least once; An upper case letter must occur at least once; A special character must occur at least once;"
			+ "No whitespace allowed in the entire password; Atleast 8 characters must be there")
		private String password;

	private BankAccountEntity acct;

	public CustomerModel() {
		 
	}

	public CustomerModel(long aadharNo, String firstName, String lastName, long mobileNo, String password, BankAccountEntity acct) {
		super();
		this.aadharNo = aadharNo;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobileNo = mobileNo;
		this.password = password;
		this.acct = acct;
	}

	public CustomerModel(int customerId,long aadharNo, String firstName, String lastName, long mobileNo,String password, BankAccountEntity acct) {
		super();
		this.customerId = customerId;
		this.aadharNo = aadharNo;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobileNo = mobileNo;
		this.password = password;
		this.acct = acct;
	}
	
	public CustomerModel(long aadharNo, String firstName, String lastName, long mobileNo) {
		super();
		this.aadharNo = aadharNo;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobileNo = mobileNo;
	}

	public int getCustomerid() {
		return customerId;
	}

	public long getAadharno() {
		return aadharNo;
	}

	public void setAadharno(long aadharNo) {
		this.aadharNo = aadharNo;
	}

	public String getFirstname() {
		return firstName;
	}

	public void setFirstname(String firstName) {
		this.firstName = firstName;
	}

	public String getLastname() {
		return lastName;
	}

	public void setLastname(String lastName) {
		this.lastName = lastName;
	}

	public long getMobileno() {
		return mobileNo;
	}

	public void setMobileno(long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public BankAccountEntity getAcct() {
		return acct;
	}

	public void setAcct(BankAccountEntity acct) {
		this.acct = acct;
	}
	
	@Override
	public String toString() {
		return "CustomerModel [customerId=" + customerId + ", aadharNo=" + aadharNo + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", mobileNo=" + mobileNo + ", acct=" + acct + "]";
	}
	
}
