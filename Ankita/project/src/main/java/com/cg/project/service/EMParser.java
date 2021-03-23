package com.cg.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.project.entity.Complaint;
import com.cg.project.entity.Courier;
import com.cg.project.entity.CourierOfficeOutlet;
import com.cg.project.entity.Customer;
import com.cg.project.entity.OfficeStaffMembers;
import com.cg.project.model.ComplaintModel;
import com.cg.project.model.CourierModel;
import com.cg.project.model.CourierOfficeOutletModel;
import com.cg.project.model.CourierStaffMembersModel;
import com.cg.project.model.CustomerModel;
import com.cg.project.repository.ComplaintRepo;
import com.cg.project.repository.CourierRepo;

@Service
public class EMParser {
	
	@Autowired
	private ComplaintRepo complaintRepo;
	
	@Autowired
	private CourierRepo courierRepo;
	
	public CustomerModel parse(Customer customer) {
		
		return customer==null?null:
			
			new CustomerModel(customer.getCustomerid(),
					customer.getAadharno(),
					customer.getFirstname(),
					customer.getLastname(),
					customer.getMobileno(),
					customer.getAddr(),
					customer.getAcct());
		
	}
	
	public Customer parse(CustomerModel customer) {
		
		return customer==null?null:
			
			new Customer(customer.getCustomerid(),
					customer.getAadharno(),
					customer.getFirstname(),
					customer.getLastname(),
					customer.getAddr(),
					customer.getMobileno(),
					customer.getAcct());
		
	}
	
	public CourierModel parse(Courier courier) {
		
		return courier==null?null:
			
			new CourierModel(courier.getCourierId(),
					courier.getConsignmentNo(),
					courier.getInitiatedDate(),
					courier.getDeliveredDate(),
					courierRepo.findCustomer(courier.getCourierId()));
		
	}
	
	public Courier parse(CourierModel courier) {
		
		return courier==null?null:
			
			new Courier(courier.getCourierId(),
					courier.getConsignmentNo(),
					courier.getInitiatedDate(),
					courier.getDeliveredDate(),
					courierRepo.findCustomer(courier.getCourierId()));
		
	}
	
	public ComplaintModel parse(Complaint complaint) {
		
		return complaint==null?null:
			
			new ComplaintModel(complaint.getComplaintId(),
					complaint.getConsignmentNo(),
					complaint.getShortDescription(),
					complaint.getDetailDescription(),
					complaintRepo.findCustomer(complaint.getComplaintId()));
		
	}
	
	public Complaint parse(ComplaintModel complaint) {
		
		return complaint==null?null:
			
			new Complaint(complaint.getComplaintId(),
					complaint.getConsignmentNo(),
					complaint.getShortDescription(),
					complaint.getDetailDescription(),
					complaintRepo.findCustomer(complaint.getComplaintId()));
		
	}
	
	public CourierOfficeOutletModel parse(CourierOfficeOutlet office) {
		
		return office==null?null:
			
			new CourierOfficeOutletModel(office.getOfficeid(),
					office.getAddress(),
					office.getOpeningTime(),
					office.getClosingTime());
	}
	
	public CourierOfficeOutlet parse(CourierOfficeOutletModel office) {
		
		return office==null?null:
			
			new CourierOfficeOutlet(office.getOfficeid(),
					office.getAddress(),
					office.getOpeningTime(),
					office.getClosingTime());
	}
	
	public CourierStaffMembersModel parse(OfficeStaffMembers staff) {
		
		return staff==null?null:
			
			new CourierStaffMembersModel(staff.getEmpid(),
					staff.getName(),
					staff.getRole(),
					staff.getOffice(),
					staff.getAddress());
	}
	
	public OfficeStaffMembers parse(CourierStaffMembersModel staff) {
		
		return staff==null?null:
			
			new OfficeStaffMembers(staff.getEmpid(),
					staff.getName(),
					staff.getRole(),
					staff.getOffice(),
					staff.getAddress());
	}
	
}
