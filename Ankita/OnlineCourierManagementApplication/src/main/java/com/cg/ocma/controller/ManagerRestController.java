package com.cg.ocma.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ocma.exception.CourierNotFoundException;
import com.cg.ocma.exception.CustomerNotFoundException;
import com.cg.ocma.exception.DuplicateCustomerFoundException;
import com.cg.ocma.exception.DuplicateStaffMember;
import com.cg.ocma.exception.OutletNotFoundException;
import com.cg.ocma.exception.StaffMemberNotFoundException;
import com.cg.ocma.model.ComplaintModel;
import com.cg.ocma.model.OfficeStaffMembersModel;
import com.cg.ocma.service.IManagerService;

@RestController
@RequestMapping("/home/manager")
@CrossOrigin
public class ManagerRestController {

	@Autowired
	private IManagerService managerService;
	
	@PostMapping("/{managerid}")
	public ResponseEntity <String> loginAction(@PathVariable("managerid") int managerid) {
		
		return new ResponseEntity <> ("Manager with manager id " + managerid + " has successfully logged in!", HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/{managerid}/addStaff")
	public ResponseEntity <String> addStaffAction(@RequestBody @Valid OfficeStaffMembersModel staff, BindingResult result) throws DuplicateStaffMember{
		
		if (result.hasErrors()) {
			throw new DuplicateStaffMember(GlobalExceptionHandler.messageFrom(result));
		} else {
			
			int empid = managerService.addStaffMember(staff);
			ResponseEntity <String> response = new ResponseEntity <> ("You have successfully added staff member with the id " + empid, HttpStatus.CREATED);
			return response;
			
		}
		
	}
	
	@DeleteMapping("/{managerid}/{empid}")
	public ResponseEntity <String> removeStaffAction(@PathVariable("empid") int empid, BindingResult result) throws StaffMemberNotFoundException{
		
		if (result.hasErrors()) {
			throw new StaffMemberNotFoundException(GlobalExceptionHandler.messageFrom(result));
		} else {
			
			boolean check = managerService.removeStaffMember(empid);
			if(check) {
				
				ResponseEntity <String> response = new ResponseEntity <> ("You have successfully removed staff member with the id " + empid, HttpStatus.OK);
				return response;
				
			} else {
				
				ResponseEntity <String> response = new ResponseEntity <> ("Staff Member with the id " + empid + " was not found", HttpStatus.NOT_FOUND);
				return response;
				
			}
			
		}
		
	}
	
	@GetMapping("/{managerid}/getStaff/empid={empid}")
	public ResponseEntity <OfficeStaffMembersModel> getStaffAction(@PathVariable("{empid}") int empid, BindingResult result) throws StaffMemberNotFoundException{
		
		if (result.hasErrors()) {
			throw new StaffMemberNotFoundException(GlobalExceptionHandler.messageFrom(result));
		} else {
			
			ResponseEntity <OfficeStaffMembersModel> response = new ResponseEntity <> (managerService.getStaffMember(empid), HttpStatus.FOUND);
			return response;
			
		}
		
	}
	
	@GetMapping("/{managerid}/getStaff/officeid={officeid}")
	public ResponseEntity <List<OfficeStaffMembersModel>> getAllStaffAction(@PathVariable("{officeid}") int officeid, BindingResult result) throws OutletNotFoundException{
		
		if (result.hasErrors()) {
			throw new OutletNotFoundException(GlobalExceptionHandler.messageFrom(result));
		} else {
			
			ResponseEntity <List<OfficeStaffMembersModel>> response = new ResponseEntity <> (managerService.getAllStaffMembers(officeid), HttpStatus.FOUND);
			return response;
			
		}
		
	}
	
	@GetMapping("/{managerid}/courierid={courierid}")
	public ResponseEntity <String> checkCourierStatusAction(@PathVariable("{courierid}") int courierid, BindingResult result) throws CourierNotFoundException {
		
		if (result.hasErrors()) {
			throw new CourierNotFoundException(GlobalExceptionHandler.messageFrom(result));
		} else {
			
			String status = managerService.getCourierStatus(courierid);
			ResponseEntity <String> response = new ResponseEntity <> ("The status of the courier is: " + status, HttpStatus.OK);
			return response;
			
		}
	}
	
	@GetMapping("/{managerid}/complaintid={complaintid}")
	public ResponseEntity <ComplaintModel> getComplaintAction(@PathVariable("{complaintid}") int complaintid, BindingResult result) throws DuplicateCustomerFoundException {
		
		if (result.hasErrors()) {
			throw new DuplicateCustomerFoundException(GlobalExceptionHandler.messageFrom(result));
		} else {
			
			ResponseEntity <ComplaintModel> response = new ResponseEntity <> (managerService.getRegistedComplaint(complaintid), HttpStatus.FOUND);
			return response;
			
		}
	}
	
	@GetMapping("/{managerid}/customerid={customerid}")
	public ResponseEntity <List<ComplaintModel>> getAllComplaintAction(@PathVariable("{customerid}") int customerid, BindingResult result) throws CustomerNotFoundException {
		
		if (result.hasErrors()) {
			throw new CustomerNotFoundException(GlobalExceptionHandler.messageFrom(result));
		} else {
			
			ResponseEntity <List<ComplaintModel>> response = new ResponseEntity <> (managerService.getAllComplaints(customerid), HttpStatus.FOUND);
			return response;
			
		}
	}
	
}