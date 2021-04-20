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
@RequestMapping("/home/managerId={managerid}")
@CrossOrigin(origins = "*")
public class OfficeOutletRestController {
	
	@Autowired
	private IOfficeOutletService officeService;
	
	private static final String toCheckOffice="The courier office outlet with id ";
	
	@PostMapping("/addOffice")
	public ResponseEntity <String> addOfficeAction(@RequestBody @Valid CourierOfficeOutletModel office, BindingResult result) throws DuplicateFoundException{
		
		if (result.hasErrors()) {
			throw new DuplicateFoundException(GlobalExceptionHandler.messageFrom(result));
		} else {
			
			int officeid = officeService.addNewOffice(office);
			return new ResponseEntity <> ("You have successfully added a new office with the id " + officeid, HttpStatus.CREATED);
			
		}
		
	}
	
	@DeleteMapping("deleteOffice/{officeId}")
	public ResponseEntity <String> removeOfficeAction(@PathVariable("officeId") int officeId) throws NotFoundException {
		
			boolean check = officeService.removeNewOffice(officeId);
			if(check) {
				
				return new ResponseEntity <> ("You have successfully removed office with the id " + officeId, HttpStatus.OK);
				
			} else {
				
				return new ResponseEntity <> ("Office with the id " + officeId + " was not found", HttpStatus.NOT_FOUND);
				
			}
		
		
	}
	
	@GetMapping("/getOffice/{officeId}")
	public ResponseEntity <CourierOfficeOutletModel> getOfficeInfo(@PathVariable("officeId") int officeId) throws NotFoundException{
		
		return new ResponseEntity <> (officeService.getOfficeInfo(officeId), HttpStatus.OK);
			
	}
	
	@GetMapping("/getAllOffice")
	public ResponseEntity <List<CourierOfficeOutletModel>> getAllOfficesData() throws NotFoundException{
		
		return new ResponseEntity <> (officeService.getAllOfficesData(), HttpStatus.OK);
			
	}
	
	@PostMapping("/registerAddress")
	public ResponseEntity <String> registerAddressAction(@RequestBody @Valid AddressModel address, BindingResult result) throws DuplicateFoundException{
		
		if (result.hasErrors()) {
			throw new DuplicateFoundException(GlobalExceptionHandler.messageFrom(result));
		} else {
			
			int addressid = officeService.registerOfficeAddress(address);
			return new ResponseEntity <> ("You have successfully registered your address with the id " + addressid, HttpStatus.CREATED);
			
		}
		
	}

	@GetMapping("/{officeId}")
	public ResponseEntity <AddressModel> getAddressAction(@PathVariable("officeId") int officeId) throws NotFoundException{
		
		return new ResponseEntity <> (officeService.findOfficeAddress(officeId), HttpStatus.FOUND);
		
	}
	
	@GetMapping("checkOfficeOpen/{officeId}")
	public ResponseEntity <String> isOfficeOpen(@PathVariable("officeId") int officeId) throws OutletClosedException {
		
			boolean status = officeService.isOfficeOpen(officeId);
			if(status) {
				
				return new ResponseEntity <> (toCheckOffice + officeId + " is open: ", HttpStatus.OK);
				
			} else {
				
				return new ResponseEntity <> (toCheckOffice + officeId + " is closed: ", HttpStatus.OK);
				
			}
	}
	
	@GetMapping("/checkOfficeClosed/{officeId}")
	public ResponseEntity <String> isOfficeClosed(@PathVariable("officeId") int officeId) throws OutletClosedException {
		
			boolean status = officeService.isOfficeClosed(officeId);
			if(status) {
				
				return new ResponseEntity <> (toCheckOffice + officeId + " is closed: ", HttpStatus.OK);
			} else {
				
				return new ResponseEntity <> (toCheckOffice + officeId + " is opened: ", HttpStatus.OK);
			}
	}
	

}
