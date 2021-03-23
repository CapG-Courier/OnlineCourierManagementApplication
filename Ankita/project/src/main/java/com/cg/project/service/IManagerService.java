package com.cg.project.service;

import java.util.List;

import com.cg.project.entity.Complaint;
import com.cg.project.entity.Courier;
import com.cg.project.entity.CourierOfficeOutlet;
import com.cg.project.entity.OfficeStaffMembers;
import com.cg.project.exception.ComplaintNotFoundException;
import com.cg.project.exception.CourierNotFoundException;
import com.cg.project.exception.StaffMemberNotFoundException;

public interface IManagerService {

	public int addStaffMember(OfficeStaffMembers staffmember);
	public boolean removeStaffMember(int empid);
	public OfficeStaffMembers getStaffMember(int empid) throws StaffMemberNotFoundException;
	
	public List<OfficeStaffMembers> getAllStaffMembers(CourierOfficeOutlet officeoutlet); //OfficeOutletRepo
	
	public String getCourierStatus(int courierid) throws CourierNotFoundException; //CourierRepo
	
	public Complaint getRegistedComplaint(int complaintid) throws ComplaintNotFoundException;  //ComplaintRepo
	public List<Complaint> getAllComplaints();
}