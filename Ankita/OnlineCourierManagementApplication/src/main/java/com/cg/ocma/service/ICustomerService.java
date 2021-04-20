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
	public double initiateProcess(CourierModel courier) throws DuplicateFoundException; //CourierRepo
	public String register(CustomerModel customer) throws DuplicateFoundException;
	public boolean registerAddress(AddressModel address) throws DuplicateFoundException;
	public String checkOnlineTrackingStatus(int consignmentNo) throws NotFoundException; //CourierRepo
	public int registerComplaint(ComplaintModel complaint) throws DuplicateFoundException;  //ComplaintRepo
	public CustomerModel getCustomer(int customerId) throws NotFoundException; 
	public List<CourierModel> getCouriers(int customerId);
	public List<ComplaintModel> getComplaints(int customerId);

}