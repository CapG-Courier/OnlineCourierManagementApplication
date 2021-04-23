package com.cg.ocma.service;

import java.util.List;

import com.cg.ocma.exception.DuplicateFoundException;
import com.cg.ocma.exception.NotFoundException;
import com.cg.ocma.model.AddressModel;
import com.cg.ocma.model.ComplaintModel;
import com.cg.ocma.model.CourierModel;
import com.cg.ocma.model.CustomerModel;
import com.cg.ocma.model.OfficeStaffMembersModel;

public interface IManagerService {

	public boolean loginManager(int empId, String password);
	
	public boolean addStaffMember(OfficeStaffMembersModel staffmember);
	public boolean addManager(OfficeStaffMembersModel staff);
	public boolean removeStaffMember(int empid) throws NotFoundException;
	public OfficeStaffMembersModel getStaffMember(int empid) throws NotFoundException;
	
	public List<OfficeStaffMembersModel> getAllStaffMembers() throws NotFoundException; //OfficeOutletRepo
	
	public String getCourierStatus(int courierid) throws NotFoundException; //CourierRepo
	public AddressModel findCustomerAddress(int customerid) throws NotFoundException;
	public CustomerModel findCustomer(int customerid) throws NotFoundException;
	
	public ComplaintModel getRegistedComplaint(int complaintid) throws DuplicateFoundException;  //ComplaintRepo
	public List<ComplaintModel> getAllComplaints() throws NotFoundException;
	public List<CourierModel> getAllCouriers() throws NotFoundException;
}