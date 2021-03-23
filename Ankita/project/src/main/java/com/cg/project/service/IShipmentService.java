package com.cg.project.service;
import com.cg.project.entity.Courier;

public interface IShipmentService {

	public boolean initiateShipmentTransaction(Courier courier);
	public String checkShipmentStatus(int courierid);
	public boolean closeShipmentTransaction(int courierid);
	public boolean rejectShipmentTransaction(int courierid);
	
}
