package com.cg.project.service;

import com.cg.project.exception.CourierNotFoundException;

public interface IShipmentService {

	public boolean initiateShipmentTransaction(int courierid) throws CourierNotFoundException;
	public String checkShipmentStatus(int courierid) throws CourierNotFoundException;
	public boolean closeShipmentTransaction(int courierid) throws CourierNotFoundException;
	public boolean rejectShipmentTransaction(int courierid) throws CourierNotFoundException;
	
}
