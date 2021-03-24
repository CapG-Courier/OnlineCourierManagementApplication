package com.cg.ocma.service;

import java.util.List;

import com.cg.ocma.exception.DuplicateCustomerFoundException;
import com.cg.ocma.exception.CourierNotFoundException;
import com.cg.ocma.exception.CustomerNotFoundException;
import com.cg.ocma.exception.DuplicateStaffMember;
import com.cg.ocma.exception.OutletNotFoundException;
import com.cg.ocma.exception.StaffMemberNotFoundException;
import com.cg.ocma.model.ComplaintModel;
import com.cg.ocma.model.OfficeStaffMembersModel;

public interface IManagerService {

	public int addStaffMember(OfficeStaffMembersModel staffmember) throws DuplicateStaffMember;
	public boolean removeStaffMember(int empid) throws StaffMemberNotFoundException;
	public OfficeStaffMembersModel getStaffMember(int empid) throws StaffMemberNotFoundException;
	
	public List<OfficeStaffMembersModel> getAllStaffMembers(int officeid) throws OutletNotFoundException; //OfficeOutletRepo
	
	public String getCourierStatus(int courierid) throws CourierNotFoundException; //CourierRepo
	
	public ComplaintModel getRegistedComplaint(int complaintid) throws DuplicateCustomerFoundException;  //ComplaintRepo
	public List<ComplaintModel> getAllComplaints(int customerid) throws CustomerNotFoundException;
}