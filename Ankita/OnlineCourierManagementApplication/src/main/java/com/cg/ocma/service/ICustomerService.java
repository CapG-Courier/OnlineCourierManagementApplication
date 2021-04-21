package com.cg.ocma.service;
import com.cg.ocma.exception.DuplicateFoundException;
import com.cg.ocma.exception.NotFoundException;
import com.cg.ocma.model.AddressModel;
import com.cg.ocma.model.ComplaintModel;
import com.cg.ocma.model.CourierModel;
import com.cg.ocma.model.CustomerModel;

public interface ICustomerService {

	public boolean loginCustomer(int customerId, String password);
	public int initiateProcess(CourierModel courier) throws DuplicateFoundException; //CourierRepo
	public int register(CustomerModel customer) throws DuplicateFoundException;
	public int registerAddress(AddressModel address) throws DuplicateFoundException;
	public String checkOnlineTrackingStatus(int consignmentno) throws NotFoundException; //CourierRepo
	public int registerComplaint(ComplaintModel complaint) throws DuplicateFoundException;  //ComplaintRepo
}