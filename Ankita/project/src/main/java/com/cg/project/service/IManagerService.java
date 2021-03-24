package com.cg.project.service;

import java.util.List;

import com.cg.project.entity.Complaint;
import com.cg.project.entity.Courier;
import com.cg.project.entity.CourierOfficeOutlet;
import com.cg.project.entity.OfficeStaffMembers;
import com.cg.project.exception.ComplaintNotFoundException;
import com.cg.project.exception.CourierNotFoundException;
import com.cg.project.exception.CustomerNotFoundException;
import com.cg.project.exception.DuplicateStaffMember;
import com.cg.project.exception.OutletNotFoundException;
import com.cg.project.exception.StaffMemberNotFoundException;
import com.cg.project.model.ComplaintModel;
import com.cg.project.model.OfficeStaffMembersModel;

public interface IManagerService {

	public int addStaffMember(OfficeStaffMembersModel staffmember) throws DuplicateStaffMember;
	public boolean removeStaffMember(int empid) throws StaffMemberNotFoundException;
	public OfficeStaffMembersModel getStaffMember(int empid) throws StaffMemberNotFoundException;
	
	public List<OfficeStaffMembersModel> getAllStaffMembers(int officeid) throws OutletNotFoundException; //OfficeOutletRepo
	
	public String getCourierStatus(int courierid) throws CourierNotFoundException; //CourierRepo
	
	public ComplaintModel getRegistedComplaint(int complaintid) throws ComplaintNotFoundException;  //ComplaintRepo
	public List<ComplaintModel> getAllComplaints(int customerid) throws CustomerNotFoundException;
}