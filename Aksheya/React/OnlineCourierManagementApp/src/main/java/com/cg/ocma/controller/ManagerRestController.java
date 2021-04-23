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

import com.cg.ocma.exception.DuplicateFoundException;
import com.cg.ocma.exception.NotFoundException;
import com.cg.ocma.model.AddressModel;
import com.cg.ocma.model.ComplaintModel;
import com.cg.ocma.model.CourierModel;
import com.cg.ocma.model.CustomerModel;
import com.cg.ocma.model.OfficeStaffMembersModel;
import com.cg.ocma.service.IManagerService;

@RestController
@RequestMapping("/home/managerid={managerid}")
@CrossOrigin(origins = "*")
public class ManagerRestController {

	@Autowired
	private IManagerService managerService;
	
	@PostMapping("/addManager")
	public ResponseEntity <String> addManagerAction(@RequestBody @Valid OfficeStaffMembersModel staff, BindingResult result) throws DuplicateFoundException{
		
		if (result.hasErrors()) {
			throw new DuplicateFoundException(GlobalExceptionHandler.messageFrom(result));
		} else {
			
			boolean flag = managerService.addManager(staff);
			
			if(flag) {
				
				return new ResponseEntity <> ("You have successfully added a new manager to the office with office id: " + staff.getOffice().getOfficeid(), HttpStatus.CREATED);
				
			}else {
				
				return new ResponseEntity <> ("Unfortunately you couldn't add a new manager", HttpStatus.BAD_REQUEST);
				
			}
			
		}
		
	}
	
	@PostMapping("/addStaff")
	public ResponseEntity <String> addStaffAction(@RequestBody @Valid OfficeStaffMembersModel staff, BindingResult result) throws DuplicateFoundException{
		
		if (result.hasErrors()) {
			throw new DuplicateFoundException(GlobalExceptionHandler.messageFrom(result));
		} else {
			
			boolean flag = managerService.addStaffMember(staff);
			
			if(flag) {
				
				return new ResponseEntity <> ("You have successfully added a new staff member to the office with office id: " + staff.getOffice().getOfficeid(), HttpStatus.CREATED);
				
			}else {
				
				return new ResponseEntity <> ("Unfortunately you couldn't add a new employee", HttpStatus.BAD_REQUEST);
				
			}
			
		}
		
	}
	
	@DeleteMapping("deleteStaff/{empid}")
	public ResponseEntity <String> removeStaffAction(@PathVariable("empid") int empid) throws NotFoundException{
		
		boolean check = managerService.removeStaffMember(empid);
		
		if(check) {
			
			return new ResponseEntity <> ("You have successfully removed staff member with the id " + empid, HttpStatus.OK);
			
		} else {
			
			return new ResponseEntity <> ("Staff Member with the id " + empid + " was not found", HttpStatus.NOT_FOUND);
			
		}
		
	}
	
	@GetMapping("/getStaff/{empid}")
	public ResponseEntity <OfficeStaffMembersModel> getStaffAction(@PathVariable("empid") int empid) throws NotFoundException{
		
		return new ResponseEntity <> (managerService.getStaffMember(empid), HttpStatus.OK);
		
	}
	
	@GetMapping("/getAllStaff")
	public ResponseEntity <List<OfficeStaffMembersModel>> getAllStaffAction() throws NotFoundException{
		
		return new ResponseEntity <> (managerService.getAllStaffMembers(), HttpStatus.OK);
		
	}
	
	@GetMapping("/checkStatus/courierid={courierid}")
	public ResponseEntity <String> checkCourierStatusAction(@PathVariable("courierid") int courierid) throws NotFoundException {
		
		String status = managerService.getCourierStatus(courierid);
		return new ResponseEntity <> ("The status of the courier is: " + status, HttpStatus.OK);
		
	}
	
	@GetMapping("complaintid={complaintid}")
	public ResponseEntity <ComplaintModel> getComplaintAction(@PathVariable("complaintid") int complaintid) throws DuplicateFoundException {
		
		return new ResponseEntity <> (managerService.getRegistedComplaint(complaintid), HttpStatus.OK);

	}
	
	@GetMapping("/getAllComplaints")
	public ResponseEntity <List<ComplaintModel>> getAllComplaintAction() throws NotFoundException {
		
		return new ResponseEntity <> (managerService.getAllComplaints(), HttpStatus.OK);
	}
	
	@GetMapping("/getAllCouriers")
	public ResponseEntity <List<CourierModel>> getAllCourierAction() throws NotFoundException {
		
		return new ResponseEntity <> (managerService.getAllCouriers(), HttpStatus.OK);
	}
	
	@GetMapping("/customerid={customerid}")
	public ResponseEntity <AddressModel> getAddressAction(@PathVariable("customerid") int customerid) throws NotFoundException{
		
		return new ResponseEntity <> (managerService.findCustomerAddress(customerid), HttpStatus.OK);
		
	}
	
	@GetMapping("/getCustomer/customerid={customerid}")
	public ResponseEntity <CustomerModel> getCustomerAction(@PathVariable("customerid") int customerid) throws NotFoundException{
		
		return new ResponseEntity <> (managerService.findCustomer(customerid), HttpStatus.OK);
		
	}
	
}
