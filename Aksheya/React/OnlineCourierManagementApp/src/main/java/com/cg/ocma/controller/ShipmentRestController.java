package com.cg.ocma.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ocma.exception.NotFoundException;
import com.cg.ocma.service.IShipmentService;

@RestController
@RequestMapping("/home/managerid={managerid}/shipment")
@CrossOrigin(origins = "*")
public class ShipmentRestController {
	
	private static final String CHECK = "The courier with id ";
	
	@Autowired
	private IShipmentService shipmentService;
	
	@PatchMapping("/initiate/{courierid}")
	public ResponseEntity <String> initiateShipmentAction(@PathVariable("courierid") int courierid) throws NotFoundException {
		
		boolean flag = shipmentService.initiateShipmentTransaction(courierid);
		if(flag) {
			
			return new ResponseEntity <> ("You have successfully initiated the shipment process for the courier with id " + courierid, HttpStatus.OK);

		} else {
			
			return new ResponseEntity <> (CHECK + courierid + " not found", HttpStatus.NOT_FOUND);
			
		}
		
	}
	
	@GetMapping("/checkStatus/{courierid}")
	public ResponseEntity <String> checkShipmentStatusAction(@PathVariable("courierid") int courierid) throws NotFoundException {
		
		String status = shipmentService.checkShipmentStatus(courierid);
		return new ResponseEntity <> ("The status of the courier with courier id " + courierid + " is: " + status, HttpStatus.OK);
		
	}
	
	@PatchMapping("/close/{courierid}")
	public ResponseEntity <String> closeShipmentAction(@PathVariable("courierid") int courierid) throws NotFoundException {
		
		boolean flag = shipmentService.closeShipmentTransaction(courierid);
		if(flag) {
			
			return new ResponseEntity <> ("You have successfully closed the shipment process for the courier with id " + courierid, HttpStatus.OK);
		
		} else {
			
			return new ResponseEntity <> (CHECK + courierid + " not found", HttpStatus.NOT_FOUND);
			
		}
		
	}
	
	@PatchMapping("/reject/{courierid}")
	public ResponseEntity <String> rejectShipmentAction(@PathVariable("courierid") int courierid) throws NotFoundException {
		
		boolean flag = shipmentService.rejectShipmentTransaction(courierid);
		if(flag) {
			
			return new ResponseEntity <> ("You have successfully rejected the shipment process for the courier with id " + courierid, HttpStatus.OK);
			
		} else {
			
			return new ResponseEntity <> (CHECK + courierid + " not found", HttpStatus.NOT_FOUND);
			
		}
		
	}
	
	
}
