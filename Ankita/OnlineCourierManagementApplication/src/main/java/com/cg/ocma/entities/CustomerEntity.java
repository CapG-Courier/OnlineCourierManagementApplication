package com.cg.ocma.entities;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class CustomerEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "customerid")
	private int customerId;
	
	@Column(name = "aadharno")
	private long aadharNo;
	
	@Column(name = "firstname", length = 20)
	private String firstName;
	
	@Column(name = "lastname", length = 20)
	private String lastName;
	
	@OneToOne(mappedBy = "customer", cascade = CascadeType.ALL)
	private AddressEntity addr;
	
	@Column(name = "mobileno")
	private long mobileNo;
	
	@Column(name = "password")
	private String password;
	
	@Embedded
	private BankAccountEntity acct;
	
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	private List <ComplaintEntity> complaints;
	
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	private List <CourierEntity> couriers;
	
	public CustomerEntity() {
		
		/*No implementation*/
		
	}

	public CustomerEntity(long aadharNo, String firstName, String lastName, long mobileNo, String password, BankAccountEntity acct) {
		super();
		this.aadharNo = aadharNo;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobileNo = mobileNo;
		this.password = password;
		this.acct = acct;
	}
	
	public CustomerEntity(int customerId, long aadharNo, String firstName, String lastName, long mobileNo, String password, BankAccountEntity acct) {
		super();
		this.customerId = customerId;
		this.aadharNo = aadharNo;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobileNo = mobileNo;
		this.password = password;
		this.acct = acct;
	}

	public CustomerEntity(long aadharNo, String firstName, String lastName, long mobileNo, String password) {
		super();
		this.aadharNo = aadharNo;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobileNo = mobileNo;
		this.password = password;
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

	public int getCustomerid() {
		return customerId;
	}

	@Override
	public String toString() {
		return "CustomerEntity [customerId=" + customerId + ", aadharNo=" + aadharNo + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", addr=" + addr + ", mobileNo=" + mobileNo + ", password=" + password
				+ ", acct=" + acct + ", complaints=" + complaints + ", couriers=" + couriers + "]";
	}



}