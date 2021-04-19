package com.cg.ocma.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ocma.exception.CourierNotFoundException;
import com.cg.ocma.exception.CustomerNotFoundException;
import com.cg.ocma.exception.DuplicateAddressFoundException;
import com.cg.ocma.exception.DuplicateComplaintFoundException;
import com.cg.ocma.exception.DuplicateCourierFoundException;
import com.cg.ocma.exception.DuplicateCustomerFoundException;
import com.cg.ocma.model.AddressModel;
import com.cg.ocma.model.ComplaintModel;
import com.cg.ocma.model.CourierModel;
import com.cg.ocma.model.CustomerModel;
import com.cg.ocma.service.ICustomerService;

@RestController
@RequestMapping("/home")
@CrossOrigin
public class CustomerRestController {

	@Autowired
	private ICustomerService customerService;
	
	@PostMapping("/login")
	public ResponseEntity <String> loginAction(@RequestParam int customerid, @RequestParam String password) {
		
		boolean flag = customerService.loginCustomer(customerid, password);
		if(flag) {
			
			return new ResponseEntity <> ("Customer with customer id " + customerid + " has successfully logged in!", HttpStatus.ACCEPTED);
			
		} else {
			
			return new ResponseEntity <> ("Incorrect Login Credentials!", HttpStatus.NOT_ACCEPTABLE);
			
		}
	}
	
	@PostMapping("/register")
	public ResponseEntity <String> registerAction(@RequestBody @Valid CustomerModel customer, BindingResult result) throws DuplicateCustomerFoundException{
		
		if (result.hasErrors()) {
			throw new DuplicateCustomerFoundException(GlobalExceptionHandler.messageFrom(result));
		} else {
			
			String customerName = customerService.register(customer);
			ResponseEntity <String> response = new ResponseEntity <> ("Welcome " + customerName + " ! You have successfully registered.", HttpStatus.CREATED);
			return response;
			
		}
		
	}
	
	@PostMapping("/customer/id={customerid}/newCourier")
	public ResponseEntity <String> initiateCourierAction(@RequestBody @Valid CourierModel courier, BindingResult result) throws DuplicateCourierFoundException{
		
		if (result.hasErrors()) {
			throw new DuplicateCourierFoundException(GlobalExceptionHandler.messageFrom(result));
		} else {
			
			double amount = customerService.initiateProcess(courier);
			ResponseEntity <String> response = new ResponseEntity <> ("The courier has been initiated. The amount to be paid is " + amount, HttpStatus.CREATED);
			return response;
		}
		
	}
	
	@PostMapping("/customer/")
	public ResponseEntity <String> registerAddressAction(@RequestBody @Valid AddressModel address, BindingResult result) throws DuplicateAddressFoundException{
		
		if (result.hasErrors()) {
			throw new DuplicateAddressFoundException(GlobalExceptionHandler.messageFrom(result));
		} else {
			
			boolean flag = customerService.registerAddress(address);
			if(flag) {

				return new ResponseEntity <> ("You have successfully added your address.", HttpStatus.CREATED);
				
			} else {
				
				return new ResponseEntity <> ("Your address was not added!", HttpStatus.CREATED);
				
			}
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
			
			int consignmentNo = customerService.registerComplaint(complaint);
			ResponseEntity <String> response = new ResponseEntity <> ("The complaint has been registered for courier with consignment number " + consignmentNo, HttpStatus.CREATED);
			return response;
			
		}
		
	}
	
	@GetMapping("/{customerid}/getCustomer/{customerid}")
	public ResponseEntity <CustomerModel> getCustomerAction(@PathVariable("customerid") int customerid) throws CustomerNotFoundException{
		
		return new ResponseEntity <> (customerService.getCustomer(customerid), HttpStatus.OK);
		
	}
	
	@GetMapping("/{customerid}/getAllComplaints")
	public ResponseEntity <List<ComplaintModel>> getAllComplaintAction(@PathVariable("customerid") int customerid) {
		
		return new ResponseEntity <> (customerService.getComplaints(customerid), HttpStatus.OK);
		
	}
	
}
