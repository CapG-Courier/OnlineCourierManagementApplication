package com.cg.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.project.exception.CourierNotFoundException;
import com.cg.project.repository.CourierRepo;

@Service
public class ShipmentServiceImpl implements IShipmentService {
	
	@Autowired
	private CourierRepo courierRepo;
	
	@Autowired
	private EMParser parser;

	public ShipmentServiceImpl() {
		
		/* No implementation */
	}

	public ShipmentServiceImpl(CourierRepo courierRepo) {
		super();
		this.courierRepo = courierRepo;
		this.parser=new EMParser();
	}

	@Override
	public boolean initiateShipmentTransaction(int courierid) throws CourierNotFoundException{
		
		if(courierRepo.existsById(courierid) == false) {
			
			throw new CourierNotFoundException("Courier with id " + courierid + " does not exist");
			
		} else{
			
			parser.parse(courierRepo.findById(courierid).orElse(null)).setStatus("INTRANSIT");
			return true;
			
		}
		
	}

	@Override
	public String checkShipmentStatus(int courierid) throws CourierNotFoundException{

		if(courierRepo.findById(courierid) == null) {
			throw new CourierNotFoundException("Courier with id " + courierid + " doesn't exist!");
		} else {
			return (courierRepo.findById(courierid).orElse(null)).getStatus().toString();
		}
		
	}

	@Override
	public boolean closeShipmentTransaction(int courierid) throws CourierNotFoundException{
		
		if(courierRepo.existsById(courierid) == false) {
			
			throw new CourierNotFoundException("Courier with id " + courierid + " does not exist");
			
		} else{
			
			parser.parse(courierRepo.findById(courierid).orElse(null)).setStatus("DELIVERED");
			return true;
			
		}
		
	}

	@Override
	public boolean rejectShipmentTransaction(int courierid) throws CourierNotFoundException{
		if(courierRepo.existsById(courierid) == false) {
			
			throw new CourierNotFoundException("Courier with id " + courierid + " does not exist");
			
		} else{
			
			parser.parse(courierRepo.findById(courierid).orElse(null)).setStatus("REJECTED");
			return true;
			
		}
	}

}
