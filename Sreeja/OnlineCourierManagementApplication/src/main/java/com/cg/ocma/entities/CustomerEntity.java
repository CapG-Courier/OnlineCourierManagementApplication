package com.cg.ocma.entities;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class CustomerEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "customerid")
	private int customerid;
	
	@Column(name = "aadharno")
	private int aadharno;
	
	@Column(name = "firstname", length = 20)
	private String firstname;
	
	@Column(name = "lastname", length = 20)
	private String lastname;
	
	@Embedded
	private AddressEntity addr;
	
	@Column(name = "mobileno")
	private int mobileno;
	
	@Embedded
	private BankAccountEntity acct;
	
	@OneToMany(mappedBy = "customer", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List <ComplaintEntity> complaints;
	
	@OneToMany(mappedBy = "customer", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List <CourierEntity> couriers;
	
	public CustomerEntity() {
		
		/*No implementation*/
		
	}

	public CustomerEntity(int customerid, int aadharno, String firstname, String lastname, AddressEntity addr, int mobileno, BankAccountEntity acct) {
		super();
		this.customerid = customerid;
		this.aadharno = aadharno;
		this.firstname = firstname;
		this.lastname = lastname;
		this.addr = addr;
		this.mobileno = mobileno;
		this.acct = acct;
	}

	public CustomerEntity(int customerid, int aadharno, String firstname, String lastname, int mobileno) {
		super();
		this.customerid = customerid;
		this.aadharno = aadharno;
		this.firstname = firstname;
		this.lastname = lastname;
		this.mobileno = mobileno;
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

	public AddressEntity getAddr() {
		return addr;
	}

	public void setAddr(AddressEntity addr) {
		this.addr = addr;
	}

	public int getMobileno() {
		return mobileno;
	}

	public void setMobileno(int mobileno) {
		this.mobileno = mobileno;
	}

	public BankAccountEntity getAcct() {
		return acct;
	}

	public void setAcct(BankAccountEntity acct) {
		this.acct = acct;
	}

	public int getCustomerid() {
		return customerid;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + aadharno;
		result = prime * result + ((acct == null) ? 0 : acct.hashCode());
		result = prime * result + ((addr == null) ? 0 : addr.hashCode());
		result = prime * result + customerid;
		result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
		result = prime * result + ((lastname == null) ? 0 : lastname.hashCode());
		result = prime * result + mobileno;
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
		CustomerEntity other = (CustomerEntity) obj;
		if (aadharno != other.aadharno)
			return false;
		if (acct == null) {
			if (other.acct != null)
				return false;
		} else if (!acct.equals(other.acct))
			return false;
		if (addr == null) {
			if (other.addr != null)
				return false;
		} else if (!addr.equals(other.addr))
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
		return "Customer [customerid=" + customerid + ", aadharno=" + aadharno + ", firstname=" + firstname
				+ ", lastname=" + lastname + ", addr=" + addr + ", mobileno=" + mobileno + ", acct=" + acct + "]";
	}

	
}
