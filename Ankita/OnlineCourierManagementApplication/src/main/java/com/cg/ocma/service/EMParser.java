package com.cg.ocma.service;

import org.springframework.stereotype.Service;

import com.cg.ocma.entities.Address;
import com.cg.ocma.entities.Complaint;
import com.cg.ocma.entities.Courier;
import com.cg.ocma.entities.CourierOfficeOutlet;
import com.cg.ocma.entities.CourierStatus;
import com.cg.ocma.entities.Customer;
import com.cg.ocma.entities.OfficeStaffMembers;
import com.cg.ocma.model.AddressModel;
import com.cg.ocma.model.ComplaintModel;
import com.cg.ocma.model.CourierModel;
import com.cg.ocma.model.CourierOfficeOutletModel;
import com.cg.ocma.model.CustomerModel;
import com.cg.ocma.model.OfficeStaffMembersModel;

@Service
public class EMParser {
	
	public CustomerModel parse(Customer customer) {
		
		return customer==null?null:
			
			new CustomerModel(customer.getCustomerid(),
					customer.getAadharno(),
					customer.getFirstname(),
					customer.getLastname(),
					customer.getMobileno(),
					customer.getAcct());
		
	}
	
	public Customer parse(CustomerModel customer) {
		
		return customer==null?null:
			
			new Customer(customer.getCustomerid(),
					customer.getAadharno(),
					customer.getFirstname(),
					customer.getLastname(),
					customer.getMobileno(),
					customer.getAcct());
		
	}
	public Address parse(AddressModel address) {
		
		return address==null?null:
			
			new Address(address.getAddressid(),
					address.getHouseNo(),
					address.getStreet(),
					address.getCity(),
					address.getState(),
					address.getCountry(),
					address.getZip(),
					address.getCustomer());
		
	}
	
	public AddressModel parse(Address address) {
		
		return address==null?null:
			
			new AddressModel(address.getAddressid(),
					address.getHouseNo(),
					address.getStreet(),
					address.getCity(),
					address.getState(),
					address.getCountry(),
					address.getZip(),
					address.getCustomer());
		
	}
	public Address parseOffice(AddressModel address) {
		
		return address==null?null:
			
			new Address(address.getAddressid(),
					address.getHouseNo(),
					address.getStreet(),
					address.getCity(),
					address.getState(),
					address.getCountry(),
					address.getZip(),
					address.getOffice());
		
	}
	
	public AddressModel parseOffice(Address address) {
		
		return address==null?null:
			
			new AddressModel(address.getAddressid(),
					address.getHouseNo(),
					address.getStreet(),
					address.getCity(),
					address.getState(),
					address.getCountry(),
					address.getZip(),
					address.getOffice());
	}
	
	public CourierModel parse(Courier courier) {
		
		return courier==null?null:
			
			new CourierModel(courier.getCourierId(),
					courier.getConsignmentNo(),
					courier.getInitiatedDate(),
					courier.getDeliveredDate(),
					courier.getStatus().toString(),
					courier.getCustomer());
		
	}
	
	public Courier parse(CourierModel courier) {
		
		return courier==null?null:
			
			new Courier(courier.getCourierId(),
					courier.getConsignmentNo(),
					courier.getInitiatedDate(),
					courier.getDeliveredDate(),
					courier.getCustomer(),
					CourierStatus.valueOf(courier.getStatus()));
		
	}
	
	public ComplaintModel parse(Complaint complaint) {
		
		return complaint==null?null:
			
			new ComplaintModel(complaint.getComplaintId(),
					complaint.getConsignmentNo(),
					complaint.getShortDescription(),
					complaint.getDetailDescription(),
					complaint.getCustomer());
		
	}
	
	public Complaint parse(ComplaintModel complaint) {
		
		return complaint==null?null:
			
			new Complaint(complaint.getComplaintId(),
					complaint.getConsignmentNo(),
					complaint.getShortDescription(),
					complaint.getDetailDescription(),
					complaint.getCustomer());
		
	}
	
	public CourierOfficeOutletModel parse(CourierOfficeOutlet office) {
		
		return office==null?null:
			
			new CourierOfficeOutletModel(office.getOfficeid(),
					office.getOpeningTime(),
					office.getClosingTime());
	}
	
	public CourierOfficeOutlet parse(CourierOfficeOutletModel office) {
		
		return office==null?null:
			
			new CourierOfficeOutlet(office.getOfficeid(),
					office.getOpeningTime(),
					office.getClosingTime());
	}
	
	public OfficeStaffMembersModel parse(OfficeStaffMembers staff) {
		
		return staff==null?null:
			
			new OfficeStaffMembersModel(staff.getEmpid(),
					staff.getName(),
					staff.getRole(),
					staff.getOffice());
	}
	
	public OfficeStaffMembers parse(OfficeStaffMembersModel staff) {
		
		return staff==null?null:
			
			new OfficeStaffMembers(staff.getEmpid(),
					staff.getName(),
					staff.getRole(),
					staff.getOffice());
	}
	
}
