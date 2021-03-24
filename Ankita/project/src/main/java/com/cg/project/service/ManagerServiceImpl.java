package com.cg.project.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.project.entity.Customer;
import com.cg.project.exception.ComplaintNotFoundException;
import com.cg.project.exception.CourierNotFoundException;
import com.cg.project.exception.CustomerNotFoundException;
import com.cg.project.exception.DuplicateStaffMember;
import com.cg.project.exception.OutletNotFoundException;
import com.cg.project.exception.StaffMemberNotFoundException;
import com.cg.project.model.ComplaintModel;
import com.cg.project.model.OfficeStaffMembersModel;
import com.cg.project.repository.ComplaintRepo;
import com.cg.project.repository.CourierRepo;
import com.cg.project.repository.CustomerRepo;
import com.cg.project.repository.ManagerRepo;
import com.cg.project.repository.OfficeOutletRepo;

@Service
public class ManagerServiceImpl implements IManagerService {
	
	@Autowired
	private ManagerRepo managerRepo;
	
	@Autowired
	private CustomerRepo customerRepo;
	
	@Autowired
	private CourierRepo courierRepo;
	
	@Autowired
	private OfficeOutletRepo officeRepo;
	
	@Autowired
	private ComplaintRepo complaintRepo;
	
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

	@Transactional
	@Override
	public int addStaffMember(OfficeStaffMembersModel staffmember) throws DuplicateStaffMember {
		if(staffmember != null) {
			if(managerRepo.existsById(staffmember.getEmpid())) {
				throw new DuplicateStaffMember("Staff with id " + staffmember.getEmpid() + " already exists!");
			} else {
				parser.parse(managerRepo.save(parser.parse(staffmember)));
			}
		} 
		return staffmember.getEmpid();
	}

	@Transactional
	@Override
	public boolean removeStaffMember(int empid) throws StaffMemberNotFoundException{
		boolean flag = false;
		if(managerRepo.findById(empid) == null) {
			throw new StaffMemberNotFoundException("Staff with id " + empid + " doesn't exist!");	
		} else {
			managerRepo.deleteById(empid);
			if(managerRepo.existsById(empid) == false) {
				
				flag = true;
				
			}
		}
		return flag;
	}

	@Override
	public OfficeStaffMembersModel getStaffMember(int empid) throws StaffMemberNotFoundException {
		if(managerRepo.findById(empid) == null) {
			throw new StaffMemberNotFoundException("Staff with id " + empid + " doesn't exist!");
		} else {
			return parser.parse(managerRepo.findById(empid).get());
		}
	}

	@Override
	public List<OfficeStaffMembersModel> getAllStaffMembers(int officeid) throws OutletNotFoundException{
	
		if(officeRepo.existsById(officeid) == false) {
			throw new OutletNotFoundException("Office with id " + officeid + " doesn't exist!");
		} else {
			return managerRepo.findAllByOfficeId(officeid).stream().map(parser::parse).collect(Collectors.toList());
		}
	}

	@Override
	public String getCourierStatus(int courierid) throws CourierNotFoundException {
		if(courierRepo.existsById(courierid) == false) {
			
			throw new CourierNotFoundException("Courier with id " + courierid + " doesn't exist!");
		} else {
			
			return (courierRepo.findById(courierid).orElse(null)).getStatus().toString();
		}
	}

	@Override
	public ComplaintModel getRegistedComplaint(int complaintid) throws ComplaintNotFoundException {
		if(complaintRepo.existsById(complaintid) == false) {
			
			throw new ComplaintNotFoundException("Complaint with id " + complaintid + " doesn't exist!");
			
		} else {
			return parser.parse(complaintRepo.findById(complaintid).orElse(null));
		}
	}

	@Override
	public List<ComplaintModel> getAllComplaints(int customerid) throws CustomerNotFoundException{
		
		if(customerRepo.existsById(customerid) == false) {
			
			throw new CustomerNotFoundException("Customer with id " + customerid + " doesn't exist!");
		} else {
			return complaintRepo.findAllByCustomerId(customerid).stream().map(parser::parse).collect(Collectors.toList());
		}
	}

}
