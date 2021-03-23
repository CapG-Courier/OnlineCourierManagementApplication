package com.cg.mts.service;
import com.cg.mts.entities.Courier;

public interface IShipmentService {

	public boolean initiateShipmentTransaction(Courier courier);
	public String checkShipmentStatus(Courier courier);
	public boolean closeShipmentTransaction(Courier courier);
	public boolean rejectShipmentTransaction(Courier courier);
	
}
