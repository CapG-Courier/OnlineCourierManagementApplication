package com.cg.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.project.entity.Complaint;
import com.cg.project.entity.CourierOfficeOutlet;
import com.cg.project.entity.OfficeStaffMembers;
import com.cg.project.exception.ComplaintNotFoundException;
import com.cg.project.exception.CourierNotFoundException;
import com.cg.project.exception.StaffMemberNotFoundException;
import com.cg.project.repository.ComplaintRepo;
import com.cg.project.repository.CourierRepo;
import com.cg.project.repository.ManagerRepo;
import com.cg.project.repository.OfficeOutletRepo;

@Service
public class ManagerServiceImpl implements IManagerService {
	
	@Autowired
	private ManagerRepo managerRepo;
	
	@Autowired
	private CourierRepo courierRepo;
	
	@Autowired
	private OfficeOutletRepo officeRepo;
	
	@Autowired
	private ComplaintRepo complaintRepo;
	
	@Autowired
	private EMParser parser;
	

	public ManagerServiceImpl() {
		/* No implementation */
	}

	public ManagerServiceImpl(ManagerRepo managerRepo, CourierRepo courierRepo, OfficeOutletRepo officeRepo,
			ComplaintRepo complaintRepo) {
		super();
		this.managerRepo = managerRepo;
		this.courierRepo = courierRepo;
		this.officeRepo = officeRepo;
		this.complaintRepo = complaintRepo;
		this.parser=new EMParser();
	}

	@Override
	public int addStaffMember(OfficeStaffMembers staffmember) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean removeStaffMember(int empid) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public OfficeStaffMembers getStaffMember(int empid) throws StaffMemberNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OfficeStaffMembers> getAllStaffMembers(CourierOfficeOutlet officeoutlet) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getCourierStatus(int courierid) throws CourierNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Complaint getRegistedComplaint(int complaintid) throws ComplaintNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Complaint> getAllComplaints() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
