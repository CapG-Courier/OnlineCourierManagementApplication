package com.cg.ocma.service;

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

import com.cg.ocma.entities.Complaint;
import com.cg.ocma.entities.Courier;
import com.cg.ocma.entities.CourierStatus;
import com.cg.ocma.entities.OfficeStaffMembers;
import com.cg.ocma.exception.ComplaintNotFoundException;
import com.cg.ocma.exception.CourierNotFoundException;
import com.cg.ocma.exception.DuplicateCustomerFoundException;
import com.cg.ocma.exception.DuplicateStaffMember;
import com.cg.ocma.exception.StaffMemberNotFoundException;
import com.cg.ocma.model.ComplaintModel;
import com.cg.ocma.model.OfficeStaffMembersModel;
import com.cg.ocma.repository.ComplaintRepo;
import com.cg.ocma.repository.CourierRepo;
import com.cg.ocma.repository.CustomerRepo;
import com.cg.ocma.repository.ManagerRepo;
import com.cg.ocma.repository.OfficeOutletRepo;

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
	
	
	@Test
	@DisplayName("ManagerServiceImpl:: addStaffMember should return the staff members id")
	void addStaffMember() throws DuplicateStaffMember {
		int expected = 2;
		OfficeStaffMembers testdata = new OfficeStaffMembers(2,"Karan","Manager");
		OfficeStaffMembersModel model = new OfficeStaffMembersModel(2,"Karan","Manager");
		Mockito.when(managerRepo.existsById(testdata.getEmpid())).thenReturn(false);
		Mockito.when(managerRepo.save(testdata)).thenReturn(testdata);
		int actual = msImpl.addStaffMember(model);
		assertEquals(expected, actual);
	}
	
	@Test
	@DisplayName("ManagerServiceImpl:: addStaffMember should throw an exception if the staff already exits")
	void addStaffMemberCheck() throws DuplicateStaffMember{
		
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
	@DisplayName("ManagerServiceImpl:: getStaffMember should throws an exception if staff does not exsit")
	void getStaffMemberCheck() throws StaffMemberNotFoundException{
		
		OfficeStaffMembersModel check = new OfficeStaffMembersModel(1,"Sid","Manager");
		Mockito.when(managerRepo.findById(check.getEmpid())).thenReturn(null);
		assertThrows(StaffMemberNotFoundException.class, () -> {
			msImpl.getStaffMember(check.getEmpid());
		});
	}

	@Test
	@DisplayName("ManagerServiceImpl:: getAllStaffMember should throws an exception if office does not exsit")
	void getAllStaffMemberCheck() throws StaffMemberNotFoundException{
	
		assertThrows(StaffMemberNotFoundException.class, () -> {
			msImpl.getAllStaffMembers();
		});
	}
	
	
	@Test
	@DisplayName("ManagerServiceImpl:: getAllStaffMember should return the all staff member with specified office id")
	void getAllStaffMembers() throws StaffMemberNotFoundException {
		
		Mockito.when(officeRepo.count()).thenReturn(9L);

		List<OfficeStaffMembers> testdata = Arrays.asList(new OfficeStaffMembers[] {
				new OfficeStaffMembers(7,"Ram","Staff"),
				new OfficeStaffMembers(8,"Ramu", "Manager")
			});
		
		List<OfficeStaffMembersModel> expected = Arrays.asList(new OfficeStaffMembersModel[] {
				new OfficeStaffMembersModel(7,"Ram","Staff"),
				new OfficeStaffMembersModel(8,"Ramu", "Manager")
			});
		
		Mockito.when(managerRepo.findAll()).thenReturn(testdata);
		List<OfficeStaffMembersModel> actual = msImpl.getAllStaffMembers();
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
	@DisplayName("CustomerServiceImpl:: checkOnlineTrackingStatusCheck should give an exception when the Courier is not found")
	void getCourierStatusCheck() throws CourierNotFoundException {
		
		//Courier testdata = new Courier(1,5123,LocalDate.parse("2020-11-03"),LocalDate.parse("2021-03-20"),CourierStatus.INITIATED);
		int courierid = 1;
		Mockito.when(courierRepo.existsById(courierid)).thenReturn(false);
		assertThrows(CourierNotFoundException.class, () -> {
			msImpl.getCourierStatus(courierid);
		});
		
	}

	@Test
	@DisplayName("ManagerServiceImpl:: getRegistedComplaint should return the complaint of specified complaint id")
	void getRegistedComplaint() throws DuplicateCustomerFoundException {
		
		ComplaintModel expected = new ComplaintModel(7,5123, "Courier was lost", "The courier was lost during transfer");	
		int complaintid = 7;
		Complaint testdata = new Complaint(7,5123, "Courier was lost", "The courier was lost during transfer");
		
		Mockito.when(complaintRepo.existsById(complaintid)).thenReturn(true);
		Mockito.when(complaintRepo.findById(complaintid)).thenReturn(Optional.of(testdata));
		
		ComplaintModel actual = msImpl.getRegistedComplaint(complaintid);
		
		assertEquals(expected, actual);
		
	}
	

	@Test
	@DisplayName("ManagerServiceImpl:: getRegisteredComplaint should throws an exception if complaint does not exsit")
	void getRegistedComplaintCheck() throws DuplicateCustomerFoundException{
		
		//OfficeStaffMembersModel check = new OfficeStaffMembersModel(1,"Sid","Manager");
		int customerid=1;
	//	Mockito.when(managerRepo.existsById(customerid)).thenReturn(false);
		assertThrows(DuplicateCustomerFoundException.class, () -> {
			msImpl.getRegistedComplaint(customerid);
		});
	}
	
	@Test
	@DisplayName("ManagerServiceImpl:: getAllComplaints should return the complaint of specified customer id")
	void getAllComplaints() throws ComplaintNotFoundException {
		
		Mockito.when(complaintRepo.count()).thenReturn(9L);

		List<Complaint> testdata = Arrays.asList(new Complaint[] {
				new Complaint(7,5123, "Courier was lost", "The courier was lost during transfer"),
				new Complaint(8,5124, "Courier was missing", "The courier was missing during transfer")
			});
		
		List<ComplaintModel> expected = Arrays.asList(new ComplaintModel[] {
				new ComplaintModel(7,5123, "Courier was lost", "The courier was lost during transfer"),
				new ComplaintModel(8,5124, "Courier was missing", "The courier was missing during transfer")
			});
		
		Mockito.when(complaintRepo.findAll()).thenReturn(testdata);
		List<ComplaintModel> actual = msImpl.getAllComplaints();
		assertEquals(expected, actual);
	}
}
