package com.cg.mts.entities;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "?")
public class OfficeStaffMembers {
 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "emp_id")
	private  int empid;
	
	@Column(name = "emp_name", length = 20)
	@NotEmpty(message="Employee Name cannot be empty")
	@NotNull(message="Employee Name cannot be omitted")
	private String name;
	
	@Column(name = "emp_role", length = 10)
	@NotEmpty(message="Role cannot be empty")
	@NotNull(message="Role cannot be omitted")
	private String role;
	
	private Address address;
	
	private CourierOfficeOutlet office;
	
	public OfficeStaffMembers() {
		//default constructor
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

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public CourierOfficeOutlet getOffice() {
		return office;
	}

	public void setOffice(CourierOfficeOutlet office) {
		this.office = office;
	}

//	public OfficeStaffMembers(
//			@NotEmpty(message = "Employee Name cannot be empty") @NotNull(message = "Employee Name cannot be omitted") String name,
//			@NotEmpty(message = "Role cannot be empty") @NotNull(message = "Role cannot be omitted") String role,
//			Address address, CourierOfficeOutlet office) {
//		super();
//		this.name = name;
//		this.role = role;
//		this.address = address;
//		this.office = office;
//	}
	
	
	
	
}
