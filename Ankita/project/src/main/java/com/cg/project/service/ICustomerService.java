package com.cg.project.service;
import com.cg.project.exception.CourierNotFoundException;
import com.cg.project.exception.DuplicateComplaintFoundException;
import com.cg.project.exception.DuplicateCourierFoundException;
import com.cg.project.model.ComplaintModel;
import com.cg.project.model.CourierModel;

public interface ICustomerService {

	public int initiateProcess(CourierModel courier) throws DuplicateCourierFoundException; //CourierRepo
	public boolean makePayment();
	public String checkOnlineTrackingStatus(int consignmentno) throws CourierNotFoundException; //CourierRepo
	public int registerComplaint(ComplaintModel complaint) throws DuplicateComplaintFoundException;  //ComplaintRepo
}