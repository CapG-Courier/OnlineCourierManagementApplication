package com.cg.ocma.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.ocma.entities.CourierStatus;
import com.cg.ocma.exception.CourierNotFoundException;
import com.cg.ocma.exception.DuplicateComplaintFoundException;
import com.cg.ocma.exception.DuplicateCourierFoundException;
import com.cg.ocma.exception.DuplicateCustomerFoundException;
import com.cg.ocma.model.ComplaintModel;
import com.cg.ocma.model.CourierModel;
import com.cg.ocma.model.CustomerModel;
import com.cg.ocma.repository.ComplaintRepo;
import com.cg.ocma.repository.CourierRepo;
import com.cg.ocma.repository.CustomerRepo;

@Service
public class CustomerServiceImpl implements ICustomerService {
	
	@Autowired
	private CourierRepo courierRepo;
	
	@Autowired
	private ComplaintRepo complaintRepo;
	
	@Autowired
	private CustomerRepo customerRepo;
	
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
				(courierRepo.findById(courier.getCourierId()).orElse(null)).setStatus(CourierStatus.INITIATED);
				//parser.parse(courierRepo.findById(courier.getCourierId()).orElse(null)).setStatus("INITIATED");
			}
		} 
		return courier.getConsignmentNo();
	}
	
	@Transactional
	@Override
	public int register(CustomerModel customer) throws DuplicateCustomerFoundException {
		if(customer != null) {
			if(customerRepo.existsById(customer.getCustomerid())) {
				
				throw new DuplicateCustomerFoundException("Customer with id " + customer.getCustomerid() + " already exists!");
			} else {
				parser.parse(customerRepo.save(parser.parse(customer)));
			}
		}
		
		return customer.getCustomerid();
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
