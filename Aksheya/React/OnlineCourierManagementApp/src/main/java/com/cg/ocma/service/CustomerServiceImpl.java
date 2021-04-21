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
	public boolean register(CustomerModel customer) throws DuplicateFoundException {
		
		boolean flag = false;
		if(customer != null) {
			if(customerRepo.existsByAadharno(customer.getAadharno())) {
				
				throw new DuplicateFoundException("Customer with aadhar number  " + customer.getAadharno() + " already exists!");
			} else {
				parser.parse(customerRepo.save(parser.parse(customer)));
				flag = true;
			}
		}
		
		return flag;
	}
	
	@Override
	public CustomerModel getCustomer(int customerid) throws NotFoundException {
		if(customerRepo.existsById(customerid) == false) {
			
			throw new NotFoundException("Customer with id " + customerid + " does not exist!");
			
		}else {
			
			return parser.parse(customerRepo.findById(customerid).orElse(null));
			
		}
	}
	
	@Transactional
	@Override
	public boolean registerAddress(AddressModel address) throws DuplicateFoundException{
		
		boolean flag = false;
		if(address != null) {
			if(addressRepo.existsByHouseNo(address.getHouseNo())) {
				
				throw new DuplicateFoundException("Address with the same house number " + address.getHouseNo() + " already exists!");
			} else {
				
				parser.parse(addressRepo.save(parser.parse(address)));
				flag = true;
			}
		}
		return flag;
	}


	@Transactional
	@Override
	public int initiateProcess(CourierModel courier) {
			
		if(courier != null) {
			
			int consignmentno = (int) Math.floor(Math.random()*(10000 - 5000 + 1) + 5000);
			courier.setConsignmentNo(consignmentno);
			courier.setStatus("INITIATED");
			parser.parse(courierRepo.save(parser.parse(courier)));
		} 
		
		return courier.getConsignmentNo();
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
	public boolean registerComplaint(ComplaintModel complaint) throws DuplicateFoundException {
		
		boolean flag = false;
		if(complaint != null) {
			if(complaintRepo.existsByConsignmentNo(complaint.getConsignmentNo())) {
				throw new DuplicateFoundException("Complaint for the courier with consignment id " + complaint.getConsignmentNo() + " already exists!");
				
			} else {
				parser.parse(complaintRepo.save(parser.parse(complaint)));
				flag = true;
			}
		} 
		return flag;
		
	}

}
