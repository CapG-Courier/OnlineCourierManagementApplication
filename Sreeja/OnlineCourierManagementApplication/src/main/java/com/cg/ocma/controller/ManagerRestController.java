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

import com.cg.ocma.exception.ComplaintNotFoundException;
import com.cg.ocma.exception.CourierNotFoundException;
import com.cg.ocma.exception.DuplicateCustomerFoundException;
import com.cg.ocma.exception.DuplicateStaffMember;
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
	public ResponseEntity <String> removeStaffAction(@PathVariable("empid") int empid) throws StaffMemberNotFoundException{
		
		boolean check = managerService.removeStaffMember(empid);
		if(check) {
			
			ResponseEntity <String> response = new ResponseEntity <> ("You have successfully removed staff member with the id " + empid, HttpStatus.OK);
			return response;
			
		} else {
			
			ResponseEntity <String> response = new ResponseEntity <> ("Staff Member with the id " + empid + " was not found", HttpStatus.NOT_FOUND);
			return response;
			
		}
		
	}
	
	@GetMapping("/{managerid}/getStaff/{empid}")
	public ResponseEntity <OfficeStaffMembersModel> getStaffAction(@PathVariable("empid") int empid) throws StaffMemberNotFoundException{
		
		ResponseEntity <OfficeStaffMembersModel> response = new ResponseEntity <> (managerService.getStaffMember(empid), HttpStatus.FOUND);
		return response;
		
	}
	
	@GetMapping("/{managerid}/getAllStaff")
	public ResponseEntity <List<OfficeStaffMembersModel>> getAllStaffAction() throws StaffMemberNotFoundException{
		
		ResponseEntity <List<OfficeStaffMembersModel>> response = new ResponseEntity <> (managerService.getAllStaffMembers(), HttpStatus.FOUND);
		return response;
		
	}
	
	@GetMapping("/{managerid}/courierid={courierid}")
	public ResponseEntity <String> checkCourierStatusAction(@PathVariable("courierid") int courierid) throws CourierNotFoundException {
		
		String status = managerService.getCourierStatus(courierid);
		ResponseEntity <String> response = new ResponseEntity <> ("The status of the courier is: " + status, HttpStatus.OK);
		return response;
	}
	
	@GetMapping("/{managerid}/complaintid={complaintid}")
	public ResponseEntity <ComplaintModel> getComplaintAction(@PathVariable("complaintid") int complaintid) throws DuplicateCustomerFoundException {
		
		ResponseEntity <ComplaintModel> response = new ResponseEntity <> (managerService.getRegistedComplaint(complaintid), HttpStatus.FOUND);
		return response;
	}
	
	@GetMapping("/{managerid}/getComplaints")
	public ResponseEntity <List<ComplaintModel>> getAllComplaintAction() throws ComplaintNotFoundException {
		
		ResponseEntity <List<ComplaintModel>> response = new ResponseEntity <> (managerService.getAllComplaints(), HttpStatus.FOUND);
		return response;
	}
	
}
