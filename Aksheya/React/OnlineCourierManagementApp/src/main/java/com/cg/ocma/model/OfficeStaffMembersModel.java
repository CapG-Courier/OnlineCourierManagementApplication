package com.cg.ocma.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.cg.ocma.entities.CourierOfficeOutletEntity;

public class OfficeStaffMembersModel {
	
	private int empid;
	
	@NotEmpty(message="Employee name cannot be empty")
	@NotNull(message="Employee name cannot be omitted")
	private String name;
	
//	@NotEmpty(message="Employee role cannot be empty")
	@NotNull(message="Employee role cannot be omitted")
	private String role;
	
	@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$", message="A digit must occur at least once;"
			+ "A lower case letter must occur at least once; An upper case letter must occur at least once; A special character must occur at least once;"
			+ "No whitespace allowed in the entire password; Atleast 8 characters must be there")
	private String password;
	
	private CourierOfficeOutletEntity office;

	public OfficeStaffMembersModel() {
		
		/*No implementation*/
		
	}

	public OfficeStaffMembersModel(int empid, String name, String role, String password, CourierOfficeOutletEntity office) {
		super();
		this.empid = empid;
		this.name = name;
		this.role = role;
		this.password = password;
		this.office = office;
	}
	
	public OfficeStaffMembersModel(int empid, String name, String role, CourierOfficeOutletEntity office) {
		super();
		this.empid = empid;
		this.name = name;
		this.role = role;
		this.office = office;
	}

	public OfficeStaffMembersModel(int empid, String name, String role) {
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

	public CourierOfficeOutletEntity getOffice() {
		return office;
	}

	public void setOffice(CourierOfficeOutletEntity office) {
		this.office = office;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "OfficeStaffMembersModel [empid=" + empid + ", name=" + name + ", role=" + role + ", office=" + office
				+ "]";
	}
}
