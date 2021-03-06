package com.cg.ocma.entities;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "officemembers")
public class OfficeStaffMembersEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "empid")
	private int empid;
	
	@Column(name = "name", length = 50)
	private String name;
	
	@Column(name = "role", length = 20)
	private String role;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "officeid")
	private CourierOfficeOutletEntity office;
	
	public OfficeStaffMembersEntity() {
		
		//no implementation//
	}
	
	public OfficeStaffMembersEntity(int empid, String name, String role, CourierOfficeOutletEntity office) {
		
		super();
		this.empid=empid;
		this.name = name;
		this.role = role;
		this.office = office;
	}

	public OfficeStaffMembersEntity(int empid, String name, String role) {
		super();
		this.empid = empid;
		this.name = name;
		this.role = role;
	}

	public int getEmpid() {
		return empid;
	}

	public void setEmpid(int empid) {
		this.empid = empid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public CourierOfficeOutletEntity getOffice() {
		return office;
	}

	public void setOffice(CourierOfficeOutletEntity office) {
		this.office = office;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + empid;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((office == null) ? 0 : office.hashCode());
		result = prime * result + ((role == null) ? 0 : role.hashCode());
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
		OfficeStaffMembersEntity other = (OfficeStaffMembersEntity) obj;
		if (empid != other.empid)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (office == null) {
			if (other.office != null)
				return false;
		} else if (!office.equals(other.office))
			return false;
		if (role == null) {
			if (other.role != null)
				return false;
		} else if (!role.equals(other.role))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "OfficeStaffMembers [empid=" + empid + ", name=" + name + ", role=" + role + ", office=" + office + "]";
	}
}