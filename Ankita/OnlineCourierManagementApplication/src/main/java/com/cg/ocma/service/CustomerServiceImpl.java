package com.cg.ocma.service;

import java.util.List;
import java.util.stream.Collectors;

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
	public double initiateProcess(CourierModel courier) throws DuplicateFoundException {
		
		if(courier != null) {
			if(courierRepo.existsById(courier.getCourierId())) {
				
				throw new DuplicateFoundException("Courier with id " + courier.getCourierId() + " already exists!");
			} else {
				
				courier.setStatus("INITIATED");
				courier.setCost(courier.getWeight()*250);
				parser.parse(courierRepo.save(parser.parse(courier)));
			}
		} 
		
		return courier.getCost();
	}
	
	@Transactional
	@Override
	public String register(CustomerModel customer) throws DuplicateFoundException {
		if(customer != null) {
			if(customerRepo.existsByAadharNo(customer.getAadharno())) {
				
				throw new DuplicateFoundException("Customer with aadhar number " + customer.getAadharno() + " already exists!");
			} else {
				
				double balance = Math.floor(Math.random()*(10000.00 - 500.00 + 1) + 500.00);
				customer.getAcct().setBankBalance(balance);
				parser.parse(customerRepo.save(parser.parse(customer)));
			}
		}
		
		return customer.getFirstname();
	}
	
	@Transactional
	@Override
	public boolean registerAddress(AddressModel address) {
		if(address != null) {
				
			System.out.println(address);
			parser.parse(addressRepo.save(parser.parse(address)));
			}
		
			boolean flag = addressRepo.existsByHouseNo(address.getHouseNo());
			return flag;
		
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
			if(complaintRepo.existsByConsignmentNo(complaint.getConsignmentNo())) {
				throw new DuplicateFoundException("Complaint for courier with consignment number " + complaint.getConsignmentNo() + " already exists!");
			} else {
				
				parser.parse(complaintRepo.save(parser.parse(complaint)));
			}
		} 
		return complaint.getConsignmentNo();
		
	}

	@Override
	public CustomerModel getCustomer(int customerid) throws NotFoundException {
		
		if(customerRepo.findById(customerid) == null) {
			
			throw new NotFoundException("Customer with id " + customerid + " doesn't exist!");
			
		} else {
			return parser.parse(customerRepo.findById(customerid).orElse(null));
		}
	}

	@Override
	public List<CourierModel> getCouriers(int customerId) {
		
		return courierRepo.findAllByCustomerId(customerId).stream().map(parser::parse).collect(Collectors.toList());
	}

	@Override
	public List<ComplaintModel> getComplaints(int customerId) {
		
		return complaintRepo.findAllByCustomerId(customerId).stream().map(parser::parse).collect(Collectors.toList());
	}


}
