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
@RequestMapping("/home/managerId={managerId}/shipment/{courierId}")
@CrossOrigin(origins = "*")
public class ShipmentRestController {
	
	@Autowired
	private IShipmentService shipmentService;
	
	private static final String courierWithId="The courier with id ";
	private static final String notFound=" not found";
	
	@PatchMapping("/initiate")
	public ResponseEntity <String> initiateShipmentAction(@PathVariable("courierId") int courierId) throws NotFoundException {
		
			boolean flag = shipmentService.initiateShipmentTransaction(courierId);
			if(flag) {
				
				return new ResponseEntity <> ("You have successfully initiated the shipment process for the courier with id " + courierId, HttpStatus.OK);
			} else {
				
				return new ResponseEntity <> (courierWithId + courierId + notFound, HttpStatus.NOT_FOUND);
			}
	}
	
	@GetMapping("/checkStatus")
	public ResponseEntity <String> checkShipmentStatusAction(@PathVariable("courierId") int courierId) throws NotFoundException {
		
			String status = shipmentService.checkShipmentStatus(courierId);
			return new ResponseEntity <> ("The status of the courier with courier id " + courierId + " is: " + status, HttpStatus.OK);
		
	}
	
	@PatchMapping("/close")
	public ResponseEntity <String> closeShipmentAction(@PathVariable("courierId") int courierId) throws NotFoundException {
		
			boolean flag = shipmentService.closeShipmentTransaction(courierId);
			if(flag) {
				
				return new ResponseEntity <> ("You have successfully closed the shipment process for the courier with id " + courierId, HttpStatus.OK);
			} else {
				
				return new ResponseEntity <> (courierWithId + courierId + notFound, HttpStatus.NOT_FOUND);
			}
	}
	
	@PatchMapping("/reject")
	public ResponseEntity <String> rejectShipmentAction(@PathVariable("courierId") int courierId) throws NotFoundException {
		
			boolean flag = shipmentService.rejectShipmentTransaction(courierId);
			if(flag) {
				
				return new ResponseEntity <> ("You have successfully rejected the shipment process for the courier with id " + courierId, HttpStatus.OK);
			} else {
				
				return new ResponseEntity <> (courierWithId + courierId + notFound, HttpStatus.NOT_FOUND);			
			}
		
	}
	
	
}
