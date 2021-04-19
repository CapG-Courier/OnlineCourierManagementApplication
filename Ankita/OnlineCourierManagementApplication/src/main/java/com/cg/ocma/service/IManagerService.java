package com.cg.ocma.service;


import java.util.List;

import com.cg.ocma.exception.AddressNotFoundException;
import com.cg.ocma.exception.ComplaintNotFoundException;
import com.cg.ocma.exception.CourierNotFoundException;
import com.cg.ocma.exception.DuplicateCustomerFoundException;
import com.cg.ocma.exception.StaffMemberNotFoundException;
import com.cg.ocma.model.AddressModel;
import com.cg.ocma.model.ComplaintModel;
import com.cg.ocma.model.OfficeStaffMembersModel;

public interface IManagerService {

	public boolean loginManager(int empId, String password);
	
	public String addManager(OfficeStaffMembersModel staffmember);
	public String addStaffMember(OfficeStaffMembersModel staffmember);
	public boolean removeStaffMember(int empid) throws StaffMemberNotFoundException;
	
	public OfficeStaffMembersModel getStaffMember(int empid) throws StaffMemberNotFoundException;
	public List<OfficeStaffMembersModel> getAllStaffMembers() throws StaffMemberNotFoundException; //OfficeOutletRepo
	
	public String getCourierStatus(int courierid) throws CourierNotFoundException; //CourierRepo
	public AddressModel findCustomerAddress(int customerId) throws AddressNotFoundException;
	
	public ComplaintModel getRegistedComplaint(int complaintid) throws DuplicateCustomerFoundException;  //ComplaintRepo
	public List<ComplaintModel> getAllComplaints() throws ComplaintNotFoundException;
	
}