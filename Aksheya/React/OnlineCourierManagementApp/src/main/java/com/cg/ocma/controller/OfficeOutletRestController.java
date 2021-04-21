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
import com.cg.ocma.exception.OutletClosedException;
import com.cg.ocma.model.AddressModel;
import com.cg.ocma.model.CourierOfficeOutletModel;
import com.cg.ocma.service.IOfficeOutletService;

@RestController
@RequestMapping("/home/managerid={managerid}")
@CrossOrigin(origins = "*")
public class OfficeOutletRestController {
	
	private static final String CHECK = "The courier office outlet with id ";
	
	@Autowired
	private IOfficeOutletService officeService;
	
	@PostMapping("/addOffice")
	public ResponseEntity <String> addOfficeAction(@RequestBody @Valid CourierOfficeOutletModel office, BindingResult result) throws DuplicateFoundException{
		
		if (result.hasErrors()) {
			throw new DuplicateFoundException(GlobalExceptionHandler.messageFrom(result));
		} else {
			
			boolean flag = officeService.addNewOffice(office);
			
			if(flag) {
				
				return new ResponseEntity <> ("You have successfully added a new office!", HttpStatus.CREATED);
				
			}else {
				
				return new ResponseEntity <> ("Unfortunately you couldn't add a new office.", HttpStatus.CREATED);
				
			}
			
		}
		
	}
	
	@PostMapping("/registerAddress")
	public ResponseEntity <String> registerAddressAction(@RequestBody @Valid AddressModel address, BindingResult result) throws DuplicateFoundException{
		
		if (result.hasErrors()) {
			throw new DuplicateFoundException(GlobalExceptionHandler.messageFrom(result));
		} else {
			
			boolean flag = officeService.registerOfficeAddress(address);
			
			if(flag) {
				
				return new ResponseEntity <> ("You have successfully registered the office address!", HttpStatus.CREATED);
				
			}else {
				
				return new ResponseEntity <> ("Unfortunately you couldn't update the address for the office", HttpStatus.CREATED);
				
			}
			
		}
		
	}
	
	@DeleteMapping("deleteOffice/{officeid}")
	public ResponseEntity <String> removeOfficeAction(@PathVariable("officeid") int officeid) throws NotFoundException {
		
		boolean check = officeService.removeNewOffice(officeid);
		if(check) {
			
			return new ResponseEntity <> ("You have successfully removed office with the id " + officeid, HttpStatus.OK);
			
		} else {
			
			return new ResponseEntity <> ("Office with the id " + officeid + " was not found", HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/getOffice/{officeid}")
	public ResponseEntity <CourierOfficeOutletModel> getOfficeInfo(@PathVariable("officeid") int officeid) throws NotFoundException{
		
		return new ResponseEntity <> (officeService.getOfficeInfo(officeid), HttpStatus.OK);
		
	}
	
	@GetMapping("/getAllOffice")
	public ResponseEntity <List<CourierOfficeOutletModel>> getAllOfficesData() throws NotFoundException{
		
		return new ResponseEntity <> (officeService.getAllOfficesData(), HttpStatus.OK);
		
	}
	
	@GetMapping("checkOfficeOpen/{officeid}")
	public ResponseEntity <String> isOfficeOpen(@PathVariable("officeid") int officeid) throws OutletClosedException {
		
		boolean status = officeService.isOfficeOpen(officeid);
		if(status) {
			
			return new ResponseEntity <> (CHECK + officeid + " is open: ", HttpStatus.OK);
		} else {
			
			return new ResponseEntity <> (CHECK + officeid + " is closed: ", HttpStatus.OK);
		}
	}
	
	@GetMapping("/checkOfficeClosed/{officeid}")
	public ResponseEntity <String> isOfficeClosed(@PathVariable("officeid") int officeid) throws OutletClosedException {
		
		boolean status = officeService.isOfficeClosed(officeid);
		if(status) {
			
			return new ResponseEntity <> (CHECK + officeid + " is closed: ", HttpStatus.OK);
			
		} else {
			
			return new ResponseEntity <> (CHECK + officeid + " is opened: ", HttpStatus.OK);
	
		}
	}

}
