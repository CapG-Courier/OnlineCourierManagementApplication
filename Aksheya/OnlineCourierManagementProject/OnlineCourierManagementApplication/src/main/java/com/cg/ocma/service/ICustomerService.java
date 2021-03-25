package com.cg.ocma.service;
import com.cg.ocma.exception.CourierNotFoundException;
import com.cg.ocma.exception.DuplicateComplaintFoundException;
import com.cg.ocma.exception.DuplicateCourierFoundException;
import com.cg.ocma.exception.DuplicateCustomerFoundException;
import com.cg.ocma.model.ComplaintModel;
import com.cg.ocma.model.CourierModel;
import com.cg.ocma.model.CustomerModel;

public interface ICustomerService {

	public int initiateProcess(CourierModel courier) throws DuplicateCourierFoundException; //CourierRepo
	public int register(CustomerModel customer) throws DuplicateCustomerFoundException;
	public boolean makePayment();
	public String checkOnlineTrackingStatus(int consignmentno) throws CourierNotFoundException; //CourierRepo
	public int registerComplaint(ComplaintModel complaint) throws DuplicateComplaintFoundException;  //ComplaintRepo
}