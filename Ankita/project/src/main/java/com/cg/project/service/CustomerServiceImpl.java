package com.cg.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.cg.project.exception.CourierNotFoundException;
import com.cg.project.exception.DuplicateComplaintFoundException;
import com.cg.project.exception.DuplicateCourierFoundException;
import com.cg.project.model.ComplaintModel;
import com.cg.project.model.CourierModel;
import com.cg.project.repository.ComplaintRepo;
import com.cg.project.repository.CourierRepo;

public class CustomerServiceImpl implements ICustomerService {
	
	@Autowired
	private CourierRepo courierRepo;
	
	@Autowired
	private ComplaintRepo complaintRepo;
	
	@Autowired
	private EMParser parser;	

	public CustomerServiceImpl() {
		/* No implementation */
	}

	public CustomerServiceImpl(CourierRepo courierRepo, ComplaintRepo complaintRepo) {
		super();
		this.courierRepo = courierRepo;
		this.complaintRepo = complaintRepo;
		this.parser=new EMParser();
	}

	@Transactional
	@Override
	public int initiateProcess(CourierModel courier) throws DuplicateCourierFoundException {
		
		if(courier != null) {
			if(courierRepo.existsById(courier.getCourierId())) {
				throw new DuplicateCourierFoundException("Courier with id " + courier.getCourierId() + " already exists!");
			} else {
				parser.parse(courierRepo.save(parser.parse(courier)));
				parser.parse(courierRepo.findById(courier.getCourierId()).orElse(null)).setStatus("INITIATED");
			}
		} 
		return courier.getConsignmentNo();
	}

	@Override
	public boolean makePayment() {        //Empty method for shifting urls
		return true;
	}

	@Override
	public String checkOnlineTrackingStatus(int consignmentno) throws CourierNotFoundException{
		
		if(courierRepo.findByConsignmentNo(consignmentno) == null) {
			throw new CourierNotFoundException("Courier with consignment no " + consignmentno + " doesn't exist!");
		} else {
			return (courierRepo.findByConsignmentNo(consignmentno)).getStatus().toString();
		}
		
	}

	@Transactional
	@Override
	public int registerComplaint(ComplaintModel complaint) throws DuplicateComplaintFoundException {
		
		if(complaint != null) {
			if(complaintRepo.existsById(complaint.getComplaintId())) {
				throw new DuplicateComplaintFoundException("Complaint with id " + complaint.getComplaintId() + " already exists!");
			} else {
				parser.parse(complaintRepo.save(parser.parse(complaint)));
			}
		} 
		return complaint.getComplaintId();
		
	}

}
