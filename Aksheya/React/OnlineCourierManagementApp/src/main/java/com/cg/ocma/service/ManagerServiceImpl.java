package com.cg.ocma.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.ocma.entities.RoleEnum;
import com.cg.ocma.exception.DuplicateFoundException;
import com.cg.ocma.exception.NotFoundException;
import com.cg.ocma.model.AddressModel;
import com.cg.ocma.model.ComplaintModel;
import com.cg.ocma.model.CourierModel;
import com.cg.ocma.model.CustomerModel;
import com.cg.ocma.model.OfficeStaffMembersModel;
import com.cg.ocma.repository.AddressRepo;
import com.cg.ocma.repository.ComplaintRepo;
import com.cg.ocma.repository.CourierRepo;
import com.cg.ocma.repository.CustomerRepo;
import com.cg.ocma.repository.ManagerRepo;
import com.cg.ocma.repository.OfficeOutletRepo;

@Service
public class ManagerServiceImpl implements IManagerService {
	
	@Autowired
	private ManagerRepo managerRepo;
	
	@Autowired
	private CourierRepo courierRepo;
	
	@Autowired
	private OfficeOutletRepo officeRepo;
	
	@Autowired
	private ComplaintRepo complaintRepo;
	
	@Autowired
	private AddressRepo addressRepo;
	
	@Autowired
	private CustomerRepo customerRepo;
	
	@Autowired
	private EMParser parser;
	

	public ManagerServiceImpl() {
		/* No implementation */
	}

	public ManagerServiceImpl(ManagerRepo managerRepo, CourierRepo courierRepo, OfficeOutletRepo officeRepo,
			ComplaintRepo complaintRepo) {
		super();
		this.managerRepo = managerRepo;
		this.courierRepo = courierRepo;
		this.officeRepo = officeRepo;
		this.complaintRepo = complaintRepo;
		this.parser=new EMParser();
	}
	
	@Override
	public boolean loginManager(int empId, String password) {
		
		boolean flag = true;
		if(managerRepo.existsById(empId) && (managerRepo.findById(empId).orElse(null)).getRole() == RoleEnum.MANAGER) {
			
			String compare = (managerRepo.findById(empId).orElse(null)).getPassword();
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
	public boolean addManager(OfficeStaffMembersModel staff) {
		
		boolean flag = false;
		if(staff != null && staff.getPassword() != null) {
			
			staff.setRole("MANAGER");
			parser.parseAdmin(managerRepo.save(parser.parseAdmin(staff)));
			flag = true;
		} 
		return flag;
	}

	@Transactional
	@Override
	public boolean addStaffMember(OfficeStaffMembersModel staffmember) {
		
		boolean flag = false;
		if(staffmember != null) {
			
			parser.parse(managerRepo.save(parser.parse(staffmember)));
			flag = true;
		} 
		return flag;
	}

	@Transactional
	@Override
	public boolean removeStaffMember(int empid) throws NotFoundException{
		boolean flag = false;
		if(managerRepo.findById(empid) == null) {
			throw new NotFoundException("Staff with id " + empid + " doesn't exist!");	
		} else {
			managerRepo.deleteById(empid);
			if(managerRepo.existsById(empid) == false) {
				
				flag = true;
				
			}
		}
		return flag;
	}

	@Override
	public OfficeStaffMembersModel getStaffMember(int empid) throws NotFoundException {
		if(managerRepo.findById(empid) == null) {
			throw new NotFoundException("Staff with id " + empid + " doesn't exist!");
		} else {
			return parser.parse(managerRepo.findById(empid).get());
		}
	}

	@Override
	public List<OfficeStaffMembersModel> getAllStaffMembers() throws NotFoundException{
	
		if(officeRepo.count() == 0) {
			
			throw new NotFoundException("No office staff members found!");
		} else {
			
			return managerRepo.findAll().stream().map(parser::parse).collect(Collectors.toList());
		}
	}

	@Override
	public String getCourierStatus(int courierid) throws NotFoundException {
		if(courierRepo.existsById(courierid) == false) {
			
			throw new NotFoundException("Courier with id " + courierid + " doesn't exist!");
		} else {
			
			return (courierRepo.findById(courierid).orElse(null)).getStatus().toString();
		}
	}

	@Override
	public ComplaintModel getRegistedComplaint(int complaintid) throws DuplicateFoundException {
		if(complaintRepo.existsById(complaintid) == false) {
			
			throw new DuplicateFoundException("Complaint with id " + complaintid + " doesn't exist!");
			
		} else {
			return parser.parse(complaintRepo.findById(complaintid).orElse(null));
		}
	}

	@Override
	public List<ComplaintModel> getAllComplaints() throws NotFoundException{
		
		if(complaintRepo.count() == 0) {
			
			throw new NotFoundException("No complaints found!");
		} else {
			
			return complaintRepo.findAll().stream().map(parser::parse).collect(Collectors.toList());
		}
	}

	@Override
	public AddressModel findCustomerAddress(int customerid) throws NotFoundException {
		
		if(addressRepo.findByCustomerId(customerid) == null) {
			
			throw new NotFoundException("The address for customer with id: " + customerid + " doesn't exist!");
			
		}else {
			
			return parser.parse(addressRepo.findByCustomerId(customerid));
			
		}
		
	}

	@Override
	public List<CourierModel> getAllCouriers() throws NotFoundException {
		
		if(courierRepo.count() == 0) {
			
			throw new NotFoundException("No couriers found!");
		} else {
			
			return courierRepo.findAll().stream().map(parser::parse).collect(Collectors.toList());
		}
	}

	@Override
	public CustomerModel findCustomer(int customerid) throws NotFoundException {
		
		if(customerRepo.existsById(customerid) == false) {
			
			throw new NotFoundException("The customer with id: " + customerid + " doesn't exist!");
			
		}else {
			
			return parser.parse(customerRepo.findById(customerid).orElse(null));
			
		}
	}

}
