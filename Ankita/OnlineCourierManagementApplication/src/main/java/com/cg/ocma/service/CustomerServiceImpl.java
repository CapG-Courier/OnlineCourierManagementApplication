package com.cg.ocma.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.ocma.entities.CourierStatus;
import com.cg.ocma.entities.CustomerEntity;
import com.cg.ocma.exception.CourierNotFoundException;
import com.cg.ocma.exception.CustomerNotFoundException;
import com.cg.ocma.exception.DuplicateComplaintFoundException;
import com.cg.ocma.exception.DuplicateCourierFoundException;
import com.cg.ocma.exception.DuplicateCustomerFoundException;
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
		if(courierRepo.existsById(customerId)) {
			
			CustomerEntity customer = customerRepo.findById(customerId).orElse(null);
			if(customer.getPassword().equals(password)) {
				
				flag = true;
			}
			
		} else {
			
			flag = false;
			
		}
		
		return flag;
		
	}
	
	@Transactional
	@Override
	public double initiateProcess(CourierModel courier) throws DuplicateCourierFoundException {
		
		if(courier != null) {
			if(courierRepo.existsById(courier.getCourierId())) {
				throw new DuplicateCourierFoundException("Courier with id " + courier.getCourierId() + " already exists!");
			} else {
				courier.setStatus(CourierStatus.INITIATED.toString());
				parser.parse(courierRepo.save(parser.parse(courier)));
			}
		} 
		
		return courier.getWeight()*250;
	}
	
	@Transactional
	@Override
	public String register(CustomerModel customer) throws DuplicateCustomerFoundException {
		if(customer != null) {
			if(customerRepo.existsByAadharNo(customer.getAadharno())) {
				
				throw new DuplicateCustomerFoundException("Customer with aadhar number " + customer.getAadharno() + " already exists!");
			} else {
				
				if(customer.getAcct() != null) {
					 
					double balance = Math.floor(Math.random()*(10000.00 - 500.00 + 1) + 500.00);
					customer.getAcct().setBankBalance(balance);
					parser.accParse(customerRepo.save(parser.accParse(customer)));
				}else {
					
					parser.parse(customerRepo.save(parser.parse(customer)));
				}
			}
		}
		
		return customer.getFirstname();
	}
	
	@Transactional
	@Override
	public boolean registerAddress(AddressModel address) {
		if(address != null) {
				
				parser.parse(addressRepo.save(parser.parse(address)));
			}
		
			boolean flag = addressRepo.existsByHouseNo(address.getHouseNo());
			return flag;
		
		}
		

	@Override
	public String checkOnlineTrackingStatus(int consignmentno) throws CourierNotFoundException{
		
		if(courierRepo.existsByConsignmentNo(consignmentno) == false) {
			
			throw new CourierNotFoundException("Courier with consignment no " + consignmentno + " doesn't exist!");
		} else {
			return ((courierRepo.findByConsignmentNo(consignmentno)).getStatus()).toString();
		}
		
	}

	@Transactional
	@Override
	public int registerComplaint(ComplaintModel complaint) throws DuplicateComplaintFoundException {
		
		if(complaint != null) {
			if(complaintRepo.existsByConsignmentNo(complaint.getConsignmentNo())) {
				throw new DuplicateComplaintFoundException("Complaint for courier with consignment number " + complaint.getConsignmentNo() + " already exists!");
			} else {
				
				parser.parse(complaintRepo.save(parser.parse(complaint)));
			}
		} 
		return complaint.getConsignmentNo();
		
	}

	@Override
	public CustomerModel getCustomer(int customerid) throws CustomerNotFoundException {
		
		if(customerRepo.findById(customerid) == null) {
			
			throw new CustomerNotFoundException("Customer with id " + customerid + " doesn't exist!");
			
		} else {
			return parser.parse(customerRepo.findById(customerid).orElse(null));
		}
	}

	@Override
	public List<CourierModel> getCouriers(int customerId) {
		
		return (courierRepo.findAllByCustomerId(customerId));
	}

	@Override
	public List<ComplaintModel> getComplaints(int customerId) {
		
		return (complaintRepo.findAllByCustomerId(customerId));
	}


}
