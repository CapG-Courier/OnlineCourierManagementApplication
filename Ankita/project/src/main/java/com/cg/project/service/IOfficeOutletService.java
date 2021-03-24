package com.cg.project.service;

import java.util.List;

import com.cg.project.exception.DuplicateOfficeOutletFoundException;
import com.cg.project.exception.OutletClosedException;
import com.cg.project.exception.OutletNotFoundException;
import com.cg.project.model.CourierOfficeOutletModel;

public interface IOfficeOutletService {
	
	public int addNewOffice(CourierOfficeOutletModel officeoutlet) throws DuplicateOfficeOutletFoundException;
	public boolean removeNewOffice(int officeid) throws OutletNotFoundException;
	public CourierOfficeOutletModel getOfficeInfo(int officeid) throws OutletNotFoundException;
	public List<CourierOfficeOutletModel> getAllOfficesData() throws OutletNotFoundException;
	public boolean isOfficeOpen(int officeid) throws OutletClosedException;
	public boolean isOfficeClosed(int officeid)throws OutletClosedException;
	
}