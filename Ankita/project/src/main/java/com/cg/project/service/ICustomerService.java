package com.cg.project.service;
import com.cg.project.entity.Complaint;

public interface ICustomerService {

	public boolean initiateProcess(); //CourierRepo
	public boolean makePayment();
	public String checkOnlineTrackingStatus(int consignmentno); //CourierRepo
	public int registerComplaint(Complaint complaint);  //ComplaintRepo
}