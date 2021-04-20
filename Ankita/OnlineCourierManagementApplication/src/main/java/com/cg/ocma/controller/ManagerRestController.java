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
import com.cg.ocma.model.OfficeStaffMembersModel;
import com.cg.ocma.service.IManagerService;

@RestController
@RequestMapping("/home/managerId={managerId}")
@CrossOrigin(origins = "*")
public class ManagerRestController {

	@Autowired
	private IManagerService managerService;
	
	@PostMapping("/addManager")
	public ResponseEntity <String> addManagerAction(@RequestBody @Valid OfficeStaffMembersModel staff, BindingResult result) throws DuplicateFoundException{
		
		if (result.hasErrors()) {
			throw new DuplicateFoundException(GlobalExceptionHandler.messageFrom(result));
		} else {
			
			String staffName = managerService.addManager(staff);
			return new ResponseEntity <> ("You have successfully added the admin: " + staffName, HttpStatus.CREATED);
			
		}
		
	}
	
	@PostMapping("/addStaff")
	public ResponseEntity <String> addStaffAction(@RequestBody @Valid OfficeStaffMembersModel staff, BindingResult result) throws DuplicateFoundException{
		
		if (result.hasErrors()) {
			throw new DuplicateFoundException(GlobalExceptionHandler.messageFrom(result));
		} else {
			
			String staffName = managerService.addStaffMember(staff);
			return new ResponseEntity <> ("You have successfully added the staff member: " + staffName, HttpStatus.CREATED);
			
		}
		
	}
	
	@DeleteMapping("deleteStaff/{empId}")
	public ResponseEntity <String> removeStaffAction(@PathVariable("empId") int empId) throws NotFoundException{
		
		boolean check = managerService.removeStaffMember(empId);
		if(check) {
			
			return new ResponseEntity <> ("You have successfully removed staff member with the id " + empId, HttpStatus.OK);
			
		} else {
			
			return new ResponseEntity <> ("Staff Member with the id " + empId + " was not found", HttpStatus.NOT_FOUND);
			
		}
		
	}
	
	@GetMapping("/getStaff/{empId}")
	public ResponseEntity <OfficeStaffMembersModel> getStaffAction(@PathVariable("empId") int empId) throws NotFoundException{
		
		return new ResponseEntity <> (managerService.getStaffMember(empId), HttpStatus.OK);
		
	}
	
	@GetMapping("/getAllStaff")
	public ResponseEntity <List<OfficeStaffMembersModel>> getAllStaffAction() throws NotFoundException{
		
		return new ResponseEntity <> (managerService.getAllStaffMembers(), HttpStatus.OK);
		
	}
	
	@GetMapping("/courierId={courierId}")
	public ResponseEntity <String> checkCourierStatusAction(@PathVariable("courierId") int courierId) throws NotFoundException {
		
		String status = managerService.getCourierStatus(courierId);
		return new ResponseEntity <> ("The status of the courier is: " + status, HttpStatus.OK);
		
	}
	
	@GetMapping("/getAllComplaints")
	public ResponseEntity <List<ComplaintModel>> getAllComplaintAction() throws NotFoundException {
		
		return new ResponseEntity <> (managerService.getAllComplaints(), HttpStatus.OK);
	}
	
	
	@GetMapping("/getAllCourier")
	public ResponseEntity <List<CourierModel>> getAllCourierAction() throws NotFoundException {
		
		return new ResponseEntity <> (managerService.getAllCouriers(), HttpStatus.OK);
	}
	
	@GetMapping("/{customerId}")
	public ResponseEntity <AddressModel> getAddressAction(@PathVariable("customerId") int customerId) throws NotFoundException{
		
		return new ResponseEntity <> (managerService.findCustomerAddress(customerId), HttpStatus.OK);
		
	}
	
}