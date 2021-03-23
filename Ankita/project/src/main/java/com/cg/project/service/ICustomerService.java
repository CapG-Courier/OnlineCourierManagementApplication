package com.cg.project.service;
import com.cg.mts.entities.Complaint;

public interface ICustomerService {

	public boolean initiateProcess();
	public boolean makePayment();
	public String checkOnlineTrackingStatus(int consignmentno);
	
	public int registerComplaint(Complaint complaint);
}