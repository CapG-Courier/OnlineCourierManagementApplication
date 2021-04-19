package com.cg.ocma.service;

import java.util.List;

import com.cg.ocma.exception.CourierNotFoundException;
import com.cg.ocma.exception.CustomerNotFoundException;
import com.cg.ocma.exception.DuplicateAddressFoundException;
import com.cg.ocma.exception.DuplicateComplaintFoundException;
import com.cg.ocma.exception.DuplicateCourierFoundException;
import com.cg.ocma.exception.DuplicateCustomerFoundException;
import com.cg.ocma.model.AddressModel;
import com.cg.ocma.model.ComplaintModel;
import com.cg.ocma.model.CourierModel;
import com.cg.ocma.model.CustomerModel;

public interface ICustomerService {

	public boolean loginCustomer(int customerId, String password);
	public double initiateProcess(CourierModel courier) throws DuplicateCourierFoundException; //CourierRepo
	public String register(CustomerModel customer) throws DuplicateCustomerFoundException;
	public boolean registerAddress(AddressModel address) throws DuplicateAddressFoundException;
	public String checkOnlineTrackingStatus(int consignmentNo) throws CourierNotFoundException; //CourierRepo
	public int registerComplaint(ComplaintModel complaint) throws DuplicateComplaintFoundException;  //ComplaintRepo
	public CustomerModel getCustomer(int customerId) throws CustomerNotFoundException; 
	public List<CourierModel> getCouriers(int customerId);
	public List<ComplaintModel> getComplaints(int customerId);

}