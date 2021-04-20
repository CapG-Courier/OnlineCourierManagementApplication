package com.cg.ocma.service;

import com.cg.ocma.exception.NotFoundException;

public interface IShipmentService {

	public boolean initiateShipmentTransaction(int courierid) throws NotFoundException;
	public String checkShipmentStatus(int courierid) throws NotFoundException;
	public boolean closeShipmentTransaction(int courierid) throws NotFoundException;
	public boolean rejectShipmentTransaction(int courierid) throws NotFoundException;
	
}
