package com.cg.project.service;

import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.project.exception.DuplicateOfficeOutletFoundException;
import com.cg.project.exception.OutletClosedException;
import com.cg.project.exception.OutletNotFoundException;
import com.cg.project.model.CourierOfficeOutletModel;
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

	@Transactional
	@Override
	public int addNewOffice(CourierOfficeOutletModel officeoutlet) throws DuplicateOfficeOutletFoundException{
		
		if(officeoutlet != null) {
			if(officeRepo.existsById(officeoutlet.getOfficeid())) {
				throw new DuplicateOfficeOutletFoundException("Office Outlet with id " + officeoutlet.getOfficeid() + " already exists!");
			} else {
				parser.parse(officeRepo.save(parser.parse(officeoutlet)));
			}
		} 
		return officeoutlet.getOfficeid();
		
	}

	@Transactional
	@Override
	public boolean removeNewOffice(int officeid) throws OutletNotFoundException {
		
		boolean flag = false;
		if(officeRepo.existsById(officeid) == false) {
			throw new OutletNotFoundException("Office Outlet with id " + officeid + " doesn't exist!");	
		} else {
			officeRepo.deleteById(officeid);
			flag = true;
		}
		return flag;
		
	}

	@Override
	public CourierOfficeOutletModel getOfficeInfo(int officeid) throws OutletNotFoundException {
		
		if(officeRepo.existsById(officeid) == false) {
			throw new OutletNotFoundException("Office with id " + officeid + " doesn't exist!");
		} else {
			return parser.parse(officeRepo.findById(officeid).orElse(null));
		}
	}

	@Override
	public List<CourierOfficeOutletModel> getAllOfficesData() throws OutletNotFoundException{
		
		if(officeRepo.count() == 0) {
			
			throw new OutletNotFoundException("No Offices exist!");
			
		} else {
			
			return officeRepo.findAll().stream().map(parser::parse).collect(Collectors.toList());
			
		}
	}

	@Override
	public boolean isOfficeOpen(int officeid) throws OutletClosedException {
		
		if(officeRepo.findById(officeid) == null) {
			throw new OutletClosedException("Office with id " + officeid + " doesn't exist!");
		} else {
			
			CourierOfficeOutletModel office = parser.parse(officeRepo.findById(officeid).get());
			if((office.getOpeningTime().equals(LocalTime.now()) || office.getOpeningTime().isBefore(LocalTime.now())) && office.getClosingTime().isAfter(LocalTime.now())) {
				
				return true;
			} else {
				
				return false;
				
			}
		}
	}

	@Override
	public boolean isOfficeClosed(int officeid) throws OutletClosedException {
		if(officeRepo.findById(officeid) == null) {
			throw new OutletClosedException("Office with id " + officeid + " doesn't exist!");
		} else {
			
			CourierOfficeOutletModel office = parser.parse(officeRepo.findById(officeid).get());
			if((office.getClosingTime().equals(LocalTime.now()) || office.getClosingTime().isBefore(LocalTime.now())) && office.getOpeningTime().isAfter(LocalTime.now())) {
				
				return true;
			} else {
				
				return false;
				
			}
		}
	}

	

}
