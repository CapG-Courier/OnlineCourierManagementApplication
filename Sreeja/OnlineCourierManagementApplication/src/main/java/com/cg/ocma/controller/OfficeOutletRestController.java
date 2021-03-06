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

import com.cg.ocma.exception.DuplicateOfficeOutletFoundException;
import com.cg.ocma.exception.OutletClosedException;
import com.cg.ocma.exception.OutletNotFoundException;
import com.cg.ocma.model.CourierOfficeOutletModel;
import com.cg.ocma.service.IOfficeOutletService;

@RestController
@RequestMapping("/home/{managerid}/office")
@CrossOrigin
public class OfficeOutletRestController {
	
	@Autowired
	private IOfficeOutletService officeService;
	
	@PostMapping("/addOffice")
	public ResponseEntity <String> addOfficeAction(@RequestBody @Valid CourierOfficeOutletModel office, BindingResult result) throws DuplicateOfficeOutletFoundException{
		
		if (result.hasErrors()) {
			throw new DuplicateOfficeOutletFoundException(GlobalExceptionHandler.messageFrom(result));
		} else {
			
			int officeid = officeService.addNewOffice(office);
			ResponseEntity <String> response = new ResponseEntity <> ("You have successfully added a new office with the id " + officeid, HttpStatus.CREATED);
			return response;
			
		}
		
	}
	
	@DeleteMapping("deleteOffice/{officeid}")
	public ResponseEntity <String> removeOfficeAction(@PathVariable("officeid") int officeid) throws OutletNotFoundException {
		
		boolean check = officeService.removeNewOffice(officeid);
		if(check) {
			
			ResponseEntity <String> response = new ResponseEntity <> ("You have successfully removed office with the id " + officeid, HttpStatus.OK);
			return response;
			
		} else {
			
			ResponseEntity <String> response = new ResponseEntity <> ("Office with the id " + officeid + " was not found", HttpStatus.NOT_FOUND);
			return response;
		}
	}
	
	@GetMapping("/getOffice/officeid={officeid}")
	public ResponseEntity <CourierOfficeOutletModel> getOfficeInfo(@PathVariable("officeid") int officeid) throws OutletNotFoundException{
		
		ResponseEntity <CourierOfficeOutletModel> response = new ResponseEntity <> (officeService.getOfficeInfo(officeid), HttpStatus.FOUND);
		return response;
		
	}
	
	@GetMapping("/getAllOffice")
	public ResponseEntity <List<CourierOfficeOutletModel>> getAllOfficesData() throws OutletNotFoundException{
		
		ResponseEntity <List<CourierOfficeOutletModel>> response = new ResponseEntity <> (officeService.getAllOfficesData(), HttpStatus.FOUND);
		return response;
		
	}
	
	@GetMapping("checkOfficeOpen/{officeid}")
	public ResponseEntity <String> isOfficeOpen(@PathVariable("officeid") int officeid) throws OutletClosedException {
		
		boolean status = officeService.isOfficeOpen(officeid);
		if(status) {
			
			ResponseEntity <String> response = new ResponseEntity <> ("The courier office outlet with id " + officeid + " is open: ", HttpStatus.OK);
			return response;
		} else {
			
			ResponseEntity <String> response = new ResponseEntity <> ("The courier office outlet with id " + officeid + " is closed: ", HttpStatus.OK);
			return response;
		}
	}
	
	@GetMapping("/checkOfficeClosed/{officeid}")
	public ResponseEntity <String> isOfficeClosed(@PathVariable("officeid") int officeid) throws OutletClosedException {
		
		boolean status = officeService.isOfficeClosed(officeid);
		if(status) {
			
			ResponseEntity <String> response = new ResponseEntity <> ("The courier office outlet with id " + officeid + " is closed: ", HttpStatus.OK);
			return response;
		} else {
			
			ResponseEntity <String> response = new ResponseEntity <> ("The courier office outlet with id " + officeid + " is opened: ", HttpStatus.OK);
			return response;
		}
	}

}
