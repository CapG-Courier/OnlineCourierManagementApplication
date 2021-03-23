package com.cg.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.project.entity.Courier;
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
	public boolean initiateShipmentTransaction(Courier courier) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String checkShipmentStatus(int courierid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean closeShipmentTransaction(int courierid) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean rejectShipmentTransaction(int courierid) {
		// TODO Auto-generated method stub
		return false;
	}

}
