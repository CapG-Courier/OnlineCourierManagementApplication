package com.cg.ocma.service;
import java.util.List;

import com.cg.ocma.exception.DuplicateFoundException;
import com.cg.ocma.exception.NotFoundException;
import com.cg.ocma.model.AddressModel;
import com.cg.ocma.model.ComplaintModel;
import com.cg.ocma.model.CourierModel;
import com.cg.ocma.model.CustomerModel;

public interface ICustomerService {

	public boolean loginCustomer(int customerId, String password);
	public boolean register(CustomerModel customer) throws DuplicateFoundException;
	public CustomerModel getCustomer(int customerid) throws NotFoundException;
	public int initiateProcess(CourierModel courier);
	public boolean registerAddress(AddressModel address) throws DuplicateFoundException;
	public String checkOnlineTrackingStatus(int consignmentno) throws NotFoundException; //CourierRepo
	public boolean registerComplaint(ComplaintModel complaint) throws DuplicateFoundException;  //ComplaintRepo
	public List<CourierModel> getCouriers(int customerid) throws NotFoundException;
	public List<ComplaintModel> getComplaints(int customerid) throws NotFoundException;
}