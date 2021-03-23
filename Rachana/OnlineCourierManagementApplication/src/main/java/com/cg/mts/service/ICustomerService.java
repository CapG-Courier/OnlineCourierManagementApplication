package com.cg.mts.service;
import com.cg.mts.entities.Complaint;
import com.cg.mts.entities.CourierStatus;

public interface ICustomerService {

	public boolean initiateProcess();
	public boolean makePayment();
	public String checkOnlineTrackingStatus(int consignmentno);
	
	public int registerComplaint(Complaint complaint);
}