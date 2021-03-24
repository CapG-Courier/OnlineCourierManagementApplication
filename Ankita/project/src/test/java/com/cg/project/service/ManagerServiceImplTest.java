package com.cg.project.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cg.project.entity.Complaint;
import com.cg.project.entity.Courier;
import com.cg.project.entity.CourierStatus;
import com.cg.project.entity.OfficeStaffMembers;
import com.cg.project.exception.ComplaintNotFoundException;
import com.cg.project.exception.CourierNotFoundException;
import com.cg.project.exception.CustomerNotFoundException;
import com.cg.project.exception.DuplicateStaffMember;
import com.cg.project.exception.OutletNotFoundException;
import com.cg.project.exception.StaffMemberNotFoundException;
import com.cg.project.model.ComplaintModel;
import com.cg.project.model.OfficeStaffMembersModel;
import com.cg.project.repository.ComplaintRepo;
import com.cg.project.repository.CourierRepo;
import com.cg.project.repository.CustomerRepo;
import com.cg.project.repository.ManagerRepo;
import com.cg.project.repository.OfficeOutletRepo;

@ExtendWith(MockitoExtension.class)
public class ManagerServiceImplTest {
	
	@Mock
	private ManagerRepo managerRepo;
	
	@Mock
	private CourierRepo courierRepo;
	
	@Mock
	private OfficeOutletRepo officeRepo;
	
	@Mock
	private ComplaintRepo complaintRepo;
	
	@Mock
	private CustomerRepo customerRepo;
	
	@InjectMocks
	private ManagerServiceImpl msImpl;
	
	
	/*@Test
	@DisplayName("ManagerServiceImpl:: addStaffMember should return the staff members id")
	void addStaffMember() throws DuplicateStaffMember {
		int expected = 2;
		OfficeStaffMembers testdata = new OfficeStaffMembers(1,"Karan","Manager");
		CourierStaffMembersModel model = new CourierStaffMembersModel(1,"Karan","Manager");
		Mockito.when(managerRepo.save(testdata)).thenReturn(testdata);
		int actual = msImpl.addStaffMember(model);
		assertEquals(expected, actual);
	}*/
	
	@Test
	@DisplayName("ManagerServiceImpl:: addStaffMember should throw an exception if the staff already exits")
	void addStaffMember() throws DuplicateStaffMember{
		
		OfficeStaffMembersModel check = new OfficeStaffMembersModel(1,"Sid","Manager");
		Mockito.when(managerRepo.existsById(check.getEmpid())).thenReturn(true);
		assertThrows(DuplicateStaffMember.class, () -> {
			msImpl.addStaffMember(check);
		});
	}
	
	@Test
	@DisplayName("ManagerServiceImpl:: removeStaffMember should return true if the staff member object is successfully deleted")
	void removeStaffMember() throws StaffMemberNotFoundException{
		int testdata = 6;
		Mockito.when(managerRepo.existsById(testdata)).thenReturn(false);
		assertTrue(msImpl.removeStaffMember(testdata));
	}
	

	@Test
	@DisplayName("ManagerServiceImpl:: removeStaffMember should throws an exception if staff does not exsit")
	void removeStaffMemberCheck() throws StaffMemberNotFoundException{
		
		OfficeStaffMembersModel check = new OfficeStaffMembersModel(1,"Sid","Manager");
		Mockito.when(managerRepo.findById(check.getEmpid())).thenReturn(null);
		assertThrows(StaffMemberNotFoundException.class, () -> {
			msImpl.removeStaffMember(check.getEmpid());
		});
	}
	
	
	@Test
	@DisplayName("ManagerServiceImpl:: getStaffMember should return the staff member with specified id")
	void getStaffMember() throws StaffMemberNotFoundException {
		
		OfficeStaffMembers testdata =  new OfficeStaffMembers(5,"Karan","Manager");
		OfficeStaffMembersModel expected = new OfficeStaffMembersModel(5,"Karan","Manager");
		Mockito.when(managerRepo.findById(testdata.getEmpid())).thenReturn(Optional.of(testdata));
		OfficeStaffMembersModel actual = msImpl.getStaffMember(testdata.getEmpid());
		assertEquals(expected, actual);
		
	}
	
	@Test
	@DisplayName("ManagerServiceImpl:: getAllStaffMember should return the all staff member with specified office id")
	void getAllStaffMembers() throws OutletNotFoundException {
		
		int officeid = 6;
		
		Mockito.when(officeRepo.existsById(officeid)).thenReturn(true);

		List<OfficeStaffMembers> testdata = Arrays.asList(new OfficeStaffMembers[] {
				new OfficeStaffMembers(7,"Ram","Staff"),
				new OfficeStaffMembers(8,"Ramu", "Manager")
			});
		
		List<OfficeStaffMembersModel> expected = Arrays.asList(new OfficeStaffMembersModel[] {
				new OfficeStaffMembersModel(7,"Ram","Staff"),
				new OfficeStaffMembersModel(8,"Ramu", "Manager")
			});
		
		Mockito.when(managerRepo.findAllByOfficeId(officeid)).thenReturn(testdata);
		List<OfficeStaffMembersModel> actual = msImpl.getAllStaffMembers(officeid);
		assertEquals(expected, actual);
	}
	
	@Test
	@DisplayName("ManagerServiceImpl:: getCourierStatus should return the status of the courier")
	void getCourierStatus() throws CourierNotFoundException{
		
		String expected = "INITIATED";
		int courierid = 6;
		
		Courier testdata = new Courier(6, 5436, LocalDate.parse("2021-01-13"), LocalDate.parse("2021-01-22"), CourierStatus.INITIATED);
		
		Mockito.when(courierRepo.existsById(courierid)).thenReturn(true);
		Mockito.when(courierRepo.findById(courierid)).thenReturn(Optional.of(testdata));
		
		String actual = msImpl.getCourierStatus(courierid);
		assertEquals(expected, actual);
	}
	

	@Test
	@DisplayName("ManagerServiceImpl:: getRegistedComplaint should return the complaint of specified complaint id")
	void getRegistedComplaint() throws ComplaintNotFoundException {
		
		ComplaintModel expected = new ComplaintModel(7,5123, "Courier was lost", "The courier was lost during transfer");	
		int complaintid = 7;
		Complaint testdata = new Complaint(7,5123, "Courier was lost", "The courier was lost during transfer");
		
		Mockito.when(complaintRepo.existsById(complaintid)).thenReturn(true);
		Mockito.when(complaintRepo.findById(complaintid)).thenReturn(Optional.of(testdata));
		
		ComplaintModel actual = msImpl.getRegistedComplaint(complaintid);
		
		assertEquals(expected, actual);
		
	}
	
	@Test
	@DisplayName("ManagerServiceImpl:: getAllComplaints should return the complaint of specified customer id")
	void getAllComplaints() throws CustomerNotFoundException {
		
		int customerid = 10;
		
		Mockito.when(customerRepo.existsById(customerid)).thenReturn(true);

		List<Complaint> testdata = Arrays.asList(new Complaint[] {
				new Complaint(7,5123, "Courier was lost", "The courier was lost during transfer"),
				new Complaint(8,5124, "Courier was missing", "The courier was missing during transfer")
			});
		
		List<ComplaintModel> expected = Arrays.asList(new ComplaintModel[] {
				new ComplaintModel(7,5123, "Courier was lost", "The courier was lost during transfer"),
				new ComplaintModel(8,5124, "Courier was missing", "The courier was missing during transfer")
			});
		
		Mockito.when(complaintRepo.findAllByCustomerId(customerid)).thenReturn(testdata);
		List <ComplaintModel> actual = msImpl.getAllComplaints(customerid);
		assertEquals(expected, actual);
		
	}
}
