package com.cg.project.service;

import java.util.List;

import com.cg.project.entity.CourierOfficeOutlet;
import com.cg.project.exception.OutletClosedException;
import com.cg.project.exception.OutletNotFoundException;

public interface IOfficeOutletService {
	
	public int addNewOffice(CourierOfficeOutlet officeoutlet);
	public boolean removeNewOffice(int officeid);
	public CourierOfficeOutlet getOfficeInfo(int officeid) throws OutletNotFoundException;
	public List<CourierOfficeOutlet> getAllOfficesData();
	public boolean isOfficeOpen(int officeid) throws OutletClosedException;
	public boolean isOfficeClosed(int officeid)throws OutletClosedException;
	
}