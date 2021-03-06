package com.cg.ocma.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ocma.exception.CourierNotFoundException;
import com.cg.ocma.exception.DuplicateComplaintFoundException;
import com.cg.ocma.exception.DuplicateCourierFoundException;
import com.cg.ocma.exception.DuplicateCustomerFoundException;
import com.cg.ocma.model.ComplaintModel;
import com.cg.ocma.model.CourierModel;
import com.cg.ocma.model.CustomerModel;
import com.cg.ocma.service.ICustomerService;

@RestController
@RequestMapping("/home/customer")
@CrossOrigin
public class CustomerRestController {

	@Autowired
	private ICustomerService customerService;
	
	@PostMapping("/{customerid}")
	public ResponseEntity <String> loginAction(@PathVariable("customerid") int customerid) {
		
		return new ResponseEntity <> ("Customer with customer id " + customerid + " has successfully logged in!", HttpStatus.ACCEPTED);
	}
	
	@PostMapping
	public ResponseEntity <String> registerAction(@RequestBody @Valid CustomerModel customer, BindingResult result) throws DuplicateCustomerFoundException{
		
		if (result.hasErrors()) {
			throw new DuplicateCustomerFoundException(GlobalExceptionHandler.messageFrom(result));
		} else {
			
			int customerid = customerService.register(customer);
			ResponseEntity <String> response = new ResponseEntity <> ("You have successfully registered with the id " + customerid, HttpStatus.CREATED);
			return response;
			
		}
		
	}
	
	@PostMapping("/{customerid}/initiate")
	public ResponseEntity <String> initiateCourierAction(@RequestBody @Valid CourierModel courier, BindingResult result) throws DuplicateCourierFoundException{
		
		if (result.hasErrors()) {
			throw new DuplicateCourierFoundException(GlobalExceptionHandler.messageFrom(result));
		} else {
			
			int consignmentid = customerService.initiateProcess(courier);
			ResponseEntity <String> response = new ResponseEntity <> ("The courier has been registered with consignment id " + consignmentid, HttpStatus.CREATED);
			return response;
			
		}
		
	}
	
	@GetMapping("/{customerid}/checkStatus/{consignmentno}")
	public ResponseEntity <String> checkCourierStatusAction(@PathVariable("consignmentno") int consignmentno) throws CourierNotFoundException {
			
			String status = customerService.checkOnlineTrackingStatus(consignmentno);
			ResponseEntity <String> response = new ResponseEntity <> ("The status of the courier is: " + status, HttpStatus.OK);
			return response;
		
	}
	
	@PostMapping("/{customerid}/registerComplaint")
	public ResponseEntity <String> initiateComplaintAction(@RequestBody @Valid ComplaintModel complaint, BindingResult result) throws DuplicateComplaintFoundException{
		
		if (result.hasErrors()) {
			throw new DuplicateComplaintFoundException(GlobalExceptionHandler.messageFrom(result));
		} else {
			
			int complaintid = customerService.registerComplaint(complaint);
			ResponseEntity <String> response = new ResponseEntity <> ("The complaint has been registered with complaint id " + complaintid, HttpStatus.CREATED);
			return response;
			
		}
		
	}
	
}
