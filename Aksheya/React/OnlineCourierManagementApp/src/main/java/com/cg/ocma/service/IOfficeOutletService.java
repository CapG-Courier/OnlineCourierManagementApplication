package com.cg.ocma.service;

import java.util.List;
import com.cg.ocma.exception.NotFoundException;
import com.cg.ocma.exception.OutletClosedException;
import com.cg.ocma.model.AddressModel;
import com.cg.ocma.model.CourierOfficeOutletModel;

public interface IOfficeOutletService {
	
	public boolean addNewOffice(CourierOfficeOutletModel officeoutlet);
	public boolean registerOfficeAddress(AddressModel address);
	public boolean removeNewOffice(int officeid) throws NotFoundException;
	public CourierOfficeOutletModel getOfficeInfo(int officeid) throws NotFoundException;
	public List<CourierOfficeOutletModel> getAllOfficesData() throws NotFoundException;
	public boolean isOfficeOpen(int officeid) throws OutletClosedException;
	public boolean isOfficeClosed(int officeid)throws OutletClosedException;
	
}