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
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "customerid")
	private int customerid;
	
	@Column(name = "aadharno")
	private long aadharno;
	
	@Column(name = "firstname", length = 20)
	private String firstname;
	
	@Column(name = "lastname", length = 20)
	private String lastname;
	
	@OneToOne(mappedBy = "customer", cascade = CascadeType.ALL)
	private Address addr;
	
	@Column(name = "mobileno")
	private long mobileno;
	
	@Embedded
	private BankAccount acct;
	
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	private List <Complaint> complaints;
	
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	private List <Courier> couriers;
	
	public Customer() {
		
		/*No implementation*/
		
	}

	public Customer(int customerid, long aadharno, String firstname, String lastname, long mobileno, BankAccount acct) {
		super();
		this.customerid = customerid;
		this.aadharno = aadharno;
		this.firstname = firstname;
		this.lastname = lastname;
		this.mobileno = mobileno;
		this.acct = acct;
	}

	public Customer(int customerid, long aadharno, String firstname, String lastname, long mobileno) {
		super();
		this.customerid = customerid;
		this.aadharno = aadharno;
		this.firstname = firstname;
		this.lastname = lastname;
		this.mobileno = mobileno;
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

	public Address getAddr() {
		return addr;
	}

	public void setAddr(Address addr) {
		this.addr = addr;
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

	public int getCustomerid() {
		return customerid;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (aadharno ^ (aadharno >>> 32));
		result = prime * result + ((acct == null) ? 0 : acct.hashCode());
		result = prime * result + ((addr == null) ? 0 : addr.hashCode());
		result = prime * result + ((complaints == null) ? 0 : complaints.hashCode());
		result = prime * result + ((couriers == null) ? 0 : couriers.hashCode());
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
		Customer other = (Customer) obj;
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
		if (complaints == null) {
			if (other.complaints != null)
				return false;
		} else if (!complaints.equals(other.complaints))
			return false;
		if (couriers == null) {
			if (other.couriers != null)
				return false;
		} else if (!couriers.equals(other.couriers))
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
				+ ", lastname=" + lastname + ", addr=" + addr + ", mobileno=" + mobileno + ", acct=" + acct
				+ ", complaints=" + complaints + ", couriers=" + couriers + "]";
	}

	
}
