package com.cg.ocma.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ocma.exception.DuplicateFoundException;
import com.cg.ocma.model.CustomerModel;
import com.cg.ocma.service.ICustomerService;
import com.cg.ocma.service.IManagerService;

@RestController
@RequestMapping(path = {"","/","/home"})
@CrossOrigin(origins = "*")
public class HomeController {
	
	@Autowired
	private ICustomerService customerService;
	
	@Autowired
	private IManagerService managerService;
	
	@GetMapping
	public ResponseEntity <String> defaultAction(){

		return new ResponseEntity <> ("Welcome to Online Courier Management Application", HttpStatus.OK);

	}
	
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
	public ResponseEntity <String> registerAction(@RequestBody @Valid CustomerModel customer, BindingResult result) throws DuplicateFoundException{
		
		if (result.hasErrors()) {
			throw new DuplicateFoundException(GlobalExceptionHandler.messageFrom(result));
		} else {
			
			boolean flag = customerService.register(customer);
			
			if(flag) {
				
				return new ResponseEntity <> ("Welcome" + customer.getFirstname() + "! You have successfully registered with our services ", HttpStatus.CREATED);
				
			}else {
				
				return new ResponseEntity <> ("Unfortunately you couldn't register with us.", HttpStatus.CREATED);
			}
			
		}
		
	}
	
	@PostMapping("/managerLogin")
	public ResponseEntity <String> managerloginAction(@RequestParam int empId, @RequestParam String password) {
		
		boolean flag = managerService.loginManager(empId, password);
		if(flag) {
			
			return new ResponseEntity <> ("Admin with employee id " + empId + " has successfully logged in!", HttpStatus.ACCEPTED);
		} else {
			
			return new ResponseEntity <> ("Incorrect Login Credentials!", HttpStatus.NOT_ACCEPTABLE);
		}
	}

}
