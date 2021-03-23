package com.cg.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.project.entity.CourierOfficeOutlet;
import com.cg.project.exception.OutletClosedException;
import com.cg.project.exception.OutletNotFoundException;
import com.cg.project.repository.OfficeOutletRepo;

@Service
public class OfficeOutletServiceImpl implements IOfficeOutletService {
	
	@Autowired
	private OfficeOutletRepo officeRepo;
	
	@Autowired
	private EMParser parser;

	public OfficeOutletServiceImpl() {
		/* No implementation */
	}

	public OfficeOutletServiceImpl(OfficeOutletRepo officeRepo) {
		super();
		this.officeRepo = officeRepo;
		this.parser=new EMParser();
	}

	@Override
	public int addNewOffice(CourierOfficeOutlet officeoutlet) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean removeNewOffice(int officeid) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public CourierOfficeOutlet getOfficeInfo(int officeid) throws OutletNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CourierOfficeOutlet> getAllOfficesData() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isOfficeOpen(int officeid) throws OutletClosedException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isOfficeClosed(int officeid) throws OutletClosedException {
		// TODO Auto-generated method stub
		return false;
	}

	

}
