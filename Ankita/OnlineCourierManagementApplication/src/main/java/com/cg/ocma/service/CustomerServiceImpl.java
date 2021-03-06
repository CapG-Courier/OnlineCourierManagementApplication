package com.cg.ocma.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.ocma.exception.DuplicateFoundException;
import com.cg.ocma.exception.NotFoundException;
import com.cg.ocma.model.AddressModel;
import com.cg.ocma.model.ComplaintModel;
import com.cg.ocma.model.CourierModel;
import com.cg.ocma.model.CustomerModel;
import com.cg.ocma.repository.AddressRepo;
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
	private AddressRepo addressRepo;
	
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
	
	@Override
	public boolean loginCustomer(int customerId, String password) {
		
		boolean flag = true;
		if(customerRepo.existsById(customerId)) {
			
			String compare = (customerRepo.findById(customerId).orElse(null)).getPassword();
			if((compare.compareTo(password)) == 0) { 
				
				flag = true;
			} else {
				
				flag = false;
			}
			
		} else {
			
			flag = false;
			
		}
		
		return flag;
		
	}

	@Transactional
	@Override
	public int initiateProcess(CourierModel courier) throws DuplicateFoundException {
		
		if(courier != null) {
			if(courierRepo.existsById(courier.getCourierId())) {
				throw new DuplicateFoundException("Courier with id " + courier.getCourierId() + " already exists!");
			} else {
				parser.parse(courierRepo.save(parser.parse(courier)));
			}
		} 
		return courier.getConsignmentNo();
	}
	
	@Transactional
	@Override
	public int register(CustomerModel customer) throws DuplicateFoundException {
		if(customer != null) {
			if(customerRepo.existsById(customer.getCustomerid())) {
				
				throw new DuplicateFoundException("Customer with id " + customer.getCustomerid() + " already exists!");
			} else {
				parser.parse(customerRepo.save(parser.parse(customer)));
			}
		}
		
		return customer.getCustomerid();
	}
	
	@Transactional
	@Override
	public int registerAddress(AddressModel address) throws DuplicateFoundException{
		if(address != null) {
			if(addressRepo.existsById(address.getAddressid())) {
				
				throw new DuplicateFoundException("Address with id " + address.getAddressid() + " already exists!");
			} else {
				
				parser.parse(addressRepo.save(parser.parse(address)));
			}
		}
		return address.getAddressid();
	}

	@Override
	public String checkOnlineTrackingStatus(int consignmentno) throws NotFoundException{
		
		if(courierRepo.existsByConsignmentNo(consignmentno) == false) {
			throw new NotFoundException("Courier with consignment no " + consignmentno + " doesn't exist!");
		} else {
			return ((courierRepo.findByConsignmentNo(consignmentno)).getStatus()).toString();
		}
		
	}

	@Transactional
	@Override
	public int registerComplaint(ComplaintModel complaint) throws DuplicateFoundException {
		
		if(complaint != null) {
			if(complaintRepo.existsById(complaint.getComplaintId())) {
				throw new DuplicateFoundException("Complaint with id " + complaint.getComplaintId() + " already exists!");
			} else {
				parser.parse(complaintRepo.save(parser.parse(complaint)));
			}
		} 
		return complaint.getComplaintId();
		
	}


}
