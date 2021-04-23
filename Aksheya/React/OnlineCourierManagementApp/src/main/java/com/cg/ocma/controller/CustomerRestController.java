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
@RequestMapping("/home/customerid={customerid}")
@CrossOrigin(origins = "*")
public class CustomerRestController {

	@Autowired
	private ICustomerService customerService;
	
	@GetMapping("/profile")
	public ResponseEntity <CustomerModel> getCustomerAction(@PathVariable("customerid") int customerid) throws NotFoundException{
		
		return new ResponseEntity <> (customerService.getCustomer(customerid), HttpStatus.OK);
	}
	
	@PostMapping("/profile/addAddress")
	public ResponseEntity <String> registerAddressAction(@RequestBody @Valid AddressModel address, BindingResult result) throws DuplicateFoundException{
		
		if (result.hasErrors()) {
			throw new DuplicateFoundException(GlobalExceptionHandler.messageFrom(result));
		} else {
			
			boolean flag = customerService.registerAddress(address);
			
			if(flag) {
				
				return new ResponseEntity <> ("You have successfully updated your address!", HttpStatus.CREATED);
				
			}else {
				
				return new ResponseEntity <> ("Unfortunately you couldn't update your address.", HttpStatus.BAD_REQUEST);
				
			}
			
		}
		
	}
	
	@PostMapping("/newCourier")
	public ResponseEntity <String> initiateCourierAction(@RequestBody @Valid CourierModel courier, BindingResult result) throws DuplicateFoundException{
		
		if (result.hasErrors()) {
			
			throw new DuplicateFoundException(GlobalExceptionHandler.messageFrom(result));
		} else {
			
			int consignmentno = customerService.initiateProcess(courier);
			
			return new ResponseEntity <> ("The courier has been successfully registered with consignment number " + consignmentno + " for your reference.", HttpStatus.CREATED);
		}
		
	}
	
	@GetMapping("/checkStatus/{consignmentno}")
	public ResponseEntity <String> checkCourierStatusAction(@PathVariable("consignmentno") int consignmentno) throws NotFoundException {
			
			String status = customerService.checkOnlineTrackingStatus(consignmentno);
			return new ResponseEntity <> ("The status of the courier is: " + status, HttpStatus.OK);
		
	}
	
	@PostMapping("/registerComplaint")
	public ResponseEntity <String> initiateComplaintAction(@RequestBody @Valid ComplaintModel complaint, BindingResult result) throws DuplicateFoundException{
		
		if (result.hasErrors()) {
			throw new DuplicateFoundException(GlobalExceptionHandler.messageFrom(result));
		} else {
			
			boolean flag = customerService.registerComplaint(complaint);
			
			if(flag) {
				
				return new ResponseEntity <> ("The complaint for courier with consignment id " + complaint.getConsignmentNo() + " has been successfully registered!", HttpStatus.CREATED);
				
			}else {
				
				return new ResponseEntity <> ("Unfortunately your complaint could not be registered", HttpStatus.BAD_REQUEST);
				
			}
			
		}
		
	}
	
	@GetMapping("/getCouriers")
	public ResponseEntity <List<CourierModel>> getCouriersAction(@PathVariable("customerid") int customerid) throws NotFoundException {
		
		return new ResponseEntity <> (customerService.getCouriers(customerid), HttpStatus.OK);
	}
	
	@GetMapping("/getComplaints")
	public ResponseEntity <List<ComplaintModel>> getComplaintsAction(@PathVariable("customerid") int customerid) throws NotFoundException {
		
		return new ResponseEntity <> (customerService.getComplaints(customerid), HttpStatus.OK);
	}
	
}
