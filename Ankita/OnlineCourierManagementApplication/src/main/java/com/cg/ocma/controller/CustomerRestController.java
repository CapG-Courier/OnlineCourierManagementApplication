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
import org.springframework.web.bind.annotation.RestController;

import com.cg.ocma.exception.DuplicateFoundException;
import com.cg.ocma.exception.NotFoundException;
import com.cg.ocma.model.AddressModel;
import com.cg.ocma.model.ComplaintModel;
import com.cg.ocma.model.CourierModel;
import com.cg.ocma.model.CustomerModel;
import com.cg.ocma.service.ICustomerService;

@RestController
@RequestMapping("/home/customerId={customerId}")
@CrossOrigin(origins = "*")
public class CustomerRestController {

	@Autowired
	private ICustomerService customerService;
	
	@GetMapping("/profile")
	public ResponseEntity <CustomerModel> getCustomerAction(@PathVariable("customerId") int customerId) throws NotFoundException{
		
		return new ResponseEntity <> (customerService.getCustomer(customerId), HttpStatus.OK);
	}
	
	@PostMapping("/profile/addAddress")
	public ResponseEntity <String> registerAddressAction(@RequestBody @Valid AddressModel address, BindingResult result) throws DuplicateFoundException{
		
		if (result.hasErrors()) {
			throw new DuplicateFoundException(GlobalExceptionHandler.messageFrom(result));
		} else {
			
			boolean flag = customerService.registerAddress(address);
			if(flag) {

				return new ResponseEntity <> ("You have successfully added your address.", HttpStatus.CREATED);
			} else {
				
				return new ResponseEntity <> ("Your address was not added!", HttpStatus.CREATED);
			}
		}
	}
	
	@PostMapping("/newCourier")
	public ResponseEntity <String> initiateCourierAction(@RequestBody @Valid CourierModel courier, BindingResult result) throws DuplicateFoundException{
		
		if (result.hasErrors()) {
			
			throw new DuplicateFoundException(GlobalExceptionHandler.messageFrom(result));
		} else {
			
			double amount = customerService.initiateProcess(courier);
			ResponseEntity <String> response = new ResponseEntity <> ("The courier has been initiated. The amount to be paid is " + amount, HttpStatus.CREATED);
			return response;
		}
	}
	
	@GetMapping("/checkStatus/{consignmentNo}")
	public ResponseEntity <String> checkCourierStatusAction(@PathVariable("consignmentNo") int consignmentNo) throws NotFoundException {

			String status = customerService.checkOnlineTrackingStatus(consignmentNo);
			ResponseEntity <String> response = new ResponseEntity <> ("The status of the courier is: " + status, HttpStatus.OK);
			return response;
	}
	
	@PostMapping("/registerComplaint")
	public ResponseEntity <String> initiateComplaintAction(@RequestBody @Valid ComplaintModel complaint, BindingResult result) throws DuplicateFoundException{
		
		if (result.hasErrors()) {
			
			throw new DuplicateFoundException(GlobalExceptionHandler.messageFrom(result));
		} else {
			
			int consignmentNo = customerService.registerComplaint(complaint);
			ResponseEntity <String> response = new ResponseEntity <> ("The complaint has been registered for courier with consignment number " + consignmentNo, HttpStatus.CREATED);
			return response;	
		}
	}
	
	@GetMapping("/getAllComplaints")
	public ResponseEntity <List<ComplaintModel>> getAllComplaintAction(@PathVariable("customerId") int customerId) {
		
		return new ResponseEntity <> (customerService.getComplaints(customerId), HttpStatus.OK);
	}
	
	@GetMapping("/getAllCouriers")
	public ResponseEntity <List<CourierModel>> getAllCourierAction(@PathVariable("customerId") int customerId) {
		
		return new ResponseEntity <> (customerService.getCouriers(customerId), HttpStatus.OK);
	}
	
}
