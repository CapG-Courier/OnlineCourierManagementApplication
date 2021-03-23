package com.cg.project.service;

import java.util.List;

import com.cg.mts.entities.CourierOfficeOutlet;
import com.cg.mts.entities.OfficeStaffMember;
import com.cg.mts.exception.OutletClosedException;
import com.cg.mts.exception.OutletNotFoundException;
import com.cg.mts.exception.StaffMemberNotFoundException;

public interface IOfficeOutletService {
	
	public int addNewOffice(CourierOfficeOutlet officeoutlet);
	public boolean removeNewOffice(CourierOfficeOutlet officeoutlet);
	public CourierOfficeOutlet getOfficeInfo(int officeid) throws OutletNotFoundException;
	public List<CourierOfficeOutlet> getAllOfficesData();
	
	public boolean isOfficeOpen(CourierOfficeOutlet officeoutlet) throws OutletClosedException;
	public boolean isOfficeClosed(CourierOfficeOutlet officeoutlet)throws OutletClosedException;
	
}