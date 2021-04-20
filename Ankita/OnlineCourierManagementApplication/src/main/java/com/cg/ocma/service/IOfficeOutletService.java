package com.cg.ocma.service;

import java.util.List;

import com.cg.ocma.exception.DuplicateFoundException;
import com.cg.ocma.exception.NotFoundException;
import com.cg.ocma.exception.OutletClosedException;
import com.cg.ocma.model.AddressModel;
import com.cg.ocma.model.CourierOfficeOutletModel;

public interface IOfficeOutletService {
	
	public int addNewOffice(CourierOfficeOutletModel officeoutlet) throws DuplicateFoundException;
	public int registerOfficeAddress(AddressModel address) throws DuplicateFoundException;
	public boolean removeNewOffice(int officeid) throws NotFoundException;
	public CourierOfficeOutletModel getOfficeInfo(int officeid) throws NotFoundException;
	public List<CourierOfficeOutletModel> getAllOfficesData() throws NotFoundException;
	public boolean isOfficeOpen(int officeid) throws OutletClosedException;
	public boolean isOfficeClosed(int officeid)throws OutletClosedException;
	public AddressModel findOfficeAddress(int officeId) throws NotFoundException;
	
}