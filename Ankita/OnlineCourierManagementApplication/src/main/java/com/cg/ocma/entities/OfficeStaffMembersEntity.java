package com.cg.ocma.entities;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "office_members")
public class OfficeStaffMembersEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "emp_id")
	private int empId;
	
	@Column(name = "name", length = 50)
	private String name;
	
	@Column(name = "role")
	@Enumerated(EnumType.STRING)
	private RoleEnum role;
	
	@Column(name = "password")
	private String password;
	
	@ManyToOne
	@JoinColumn(name = "office_id")
	private CourierOfficeOutletEntity office;
	
	public OfficeStaffMembersEntity() {
		
		//no implementation//
	}
	
	public OfficeStaffMembersEntity(String name, RoleEnum role, String password, CourierOfficeOutletEntity office) {
		
		super();
		this.name = name;
		this.role = role;
		this.password = password;
		this.office = office;
	}
	
	public OfficeStaffMembersEntity(String name, RoleEnum role, CourierOfficeOutletEntity office) {
		
		super();
		this.name = name;
		this.role = role;
		this.office = office;
	}
	
	public OfficeStaffMembersEntity(int empId,  String name, RoleEnum role, CourierOfficeOutletEntity office) {
		
		super();
		this.empId = empId;
		this.name = name;
		this.role = role;
		this.office = office;
	}

	public int getEmpid() {
		return empId;
	}

	public void setEmpid(int empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public RoleEnum getRole() {
		return role;
	}

	public void setRole(RoleEnum role) {
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
		return "OfficeStaffMembers [empId=" + empId + ", name=" + name + ", role=" + role + ", office=" + office + "]";
	}
}