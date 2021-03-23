package com.cg.project.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.cg.project.entity.Complaint;
import com.cg.project.repository.ComplaintRepo;
import com.cg.project.repository.CourierRepo;
import com.cg.project.repository.CustomerRepo;

public class CustomerServiceImpl implements ICustomerService {
	
	@Autowired
	private CustomerRepo customerRepo;
	
	@Autowired
	private CourierRepo courierRepo;
	
	@Autowired
	private ComplaintRepo complaintRepo;
	
	@Autowired
	private EMParser parser;	

	public CustomerServiceImpl() {
		/* No implementation */
	}

	public CustomerServiceImpl(CustomerRepo customerRepo, CourierRepo courierRepo, ComplaintRepo complaintRepo) {
		super();
		this.customerRepo = customerRepo;
		this.courierRepo = courierRepo;
		this.complaintRepo = complaintRepo;
		this.parser=new EMParser();
	}


	@Override
	public boolean initiateProcess() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean makePayment() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String checkOnlineTrackingStatus(int consignmentno) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int registerComplaint(Complaint complaint) {
		// TODO Auto-generated method stub
		return 0;
	}

}
