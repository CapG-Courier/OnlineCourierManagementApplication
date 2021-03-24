package com.cg.project.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.cg.project.entity.Address;
import com.cg.project.entity.CourierOfficeOutlet;

public class OfficeStaffMembersModel {
	
	private int empid;
	
	@NotEmpty(message="Employee name cannot be empty")
	@NotNull(message="Employee name cannot be omitted")
	private String name;
	
	@NotEmpty(message="Employee role cannot be empty")
	@NotNull(message="Employee role cannot be omitted")
	private String role;
	
	private CourierOfficeOutlet office;
	
	private Address address;

	public OfficeStaffMembersModel() {
		
	}

	public OfficeStaffMembersModel(int empid, String name, String role, CourierOfficeOutlet office, Address address) {
		super();
		this.empid = empid;
		this.name = name;
		this.role = role;
		this.office = office;
		this.address = address;
	}

	public OfficeStaffMembersModel(int empid,
			@NotEmpty(message = "Employee name cannot be empty") @NotNull(message = "Employee name cannot be omitted") String name,
			@NotEmpty(message = "Employee role cannot be empty") @NotNull(message = "Employee role cannot be omitted") String role) {
		super();
		this.empid = empid;
		this.name = name;
		this.role = role;
	}

	public int getEmpid() {
		return empid;
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

	public CourierOfficeOutlet getOffice() {
		return office;
	}

	public void setOffice(CourierOfficeOutlet office) {
		this.office = office;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
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
		OfficeStaffMembersModel other = (OfficeStaffMembersModel) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
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
		return "CourierStaffMembersModel [empid=" + empid + ", name=" + name + ", role=" + role + ", office=" + office
				+ ", address=" + address + "]";
	}
	
	

}
