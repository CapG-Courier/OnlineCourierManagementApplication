package com.cg.ocma.service;

import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.ocma.exception.DuplicateFoundException;
import com.cg.ocma.exception.NotFoundException;
import com.cg.ocma.exception.OutletClosedException;
import com.cg.ocma.model.AddressModel;
import com.cg.ocma.model.CourierOfficeOutletModel;
import com.cg.ocma.repository.AddressRepo;
import com.cg.ocma.repository.OfficeOutletRepo;

@Service
public class OfficeOutletServiceImpl implements IOfficeOutletService {
	
	@Autowired
	private OfficeOutletRepo officeRepo;
	
	@Autowired
	private AddressRepo addressRepo;
	
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
	public boolean addNewOffice(CourierOfficeOutletModel officeoutlet) {
		
		boolean flag = false;
		
		if(officeoutlet != null) {
			
			parser.parse(officeRepo.save(parser.parse(officeoutlet)));
			flag = true;
		} 
		return flag;
		
	}
	
	@Transactional
	@Override
	public boolean registerOfficeAddress(AddressModel address) throws DuplicateFoundException{
		
		boolean flag = false;
		if(address != null) {
			if(addressRepo.existsByHouseNo(address.getHouseNo())) {
				
				throw new DuplicateFoundException("Address with the same house number " + address.getHouseNo() + " already exists!");
			} else {
				
				parser.parseOffice(addressRepo.save(parser.parseOffice(address)));
				flag = true;
			}
		}
		return flag;
	}

	@Transactional
	@Override
	public boolean removeNewOffice(int officeid) throws NotFoundException {
		
		boolean flag = false;
		if(officeRepo.existsById(officeid) == false) {
			throw new NotFoundException("Office Outlet with id " + officeid + " doesn't exist!");	
		} else {
			officeRepo.deleteById(officeid);
			flag = true;
		}
		return flag;
		
	}

	@Override
	public CourierOfficeOutletModel getOfficeInfo(int officeid) throws NotFoundException {
		
		if(officeRepo.existsById(officeid) == false) {
			throw new NotFoundException("Office with id " + officeid + " doesn't exist!");
		} else {
			return parser.parse(officeRepo.findById(officeid).orElse(null));
		}
	}

	@Override
	public List<CourierOfficeOutletModel> getAllOfficesData() throws NotFoundException{
		
		if(officeRepo.count() == 0) {
			
			throw new NotFoundException("No Offices exist!");
			
		} else {
			
			return officeRepo.findAll().stream().map(parser::parse).collect(Collectors.toList());
			
		}
	}

	@Override
	public boolean isOfficeOpen(int officeid) throws OutletClosedException {
		
		if(officeRepo.existsById(officeid) == false) {
			
			throw new OutletClosedException("Office with id " + officeid + " doesn't exist!");
		} else {
			
			CourierOfficeOutletModel office = parser.parse(officeRepo.findById(officeid).get());
			LocalTime open = LocalTime.parse(office.getOpeningTime());
			LocalTime close = LocalTime.parse(office.getClosingTime());
			if((open.equals(LocalTime.now()) || open.isBefore(LocalTime.now())) && close.isAfter(LocalTime.now())) {
				
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
			LocalTime close = LocalTime.parse(office.getClosingTime());
			if((close.equals(LocalTime.now()) || close.isBefore(LocalTime.now()))) {
				
				return true;
			} else {
				
				return false;
				
			}
		}
	}

	

}
