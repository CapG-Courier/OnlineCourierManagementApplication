package com.cg.project.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cg.project.entity.OfficeStaffMembers;
import com.cg.project.exception.StaffMemberNotFoundException;
import com.cg.project.model.CourierStaffMembersModel;
import com.cg.project.repository.ComplaintRepo;
import com.cg.project.repository.CourierRepo;
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
	
	@InjectMocks
	private ManagerServiceImpl msImpl;
	
	
	@Test
	@DisplayName("ManagerServiceImpl:: addStaffMember should return the staff members id")
	void addStaffMember() {
		int expected = 2;
		OfficeStaffMembers testdata = new OfficeStaffMembers(1,"Karan","Manager");
		Mockito.when(managerRepo.save(testdata)).thenReturn(testdata);
		int actual = msImpl.addStaffMember(testdata);
		assertEquals(expected, actual);
	}

	/*@Test
	@DisplayName("ManagerServiceImpl:: removeStaffMember should return true if the staff member object is successfully deleted")
	void removeStaffMember() {
		boolean expected = true;
		//OfficeStaffMembers testdata = new OfficeStaffMembers(1,"Karan","Manager");
		int testdata=6;
		Mockito.when(managerRepo.deleteById(testdata)).thenReturn(null);
		boolean actual = msImpl.removeStaffMember(testdata);
		assertEquals(expected, actual);
	}*/
	
	@Test
	@DisplayName("ManagerServiceImpl:: getStaffMember should return the staff member with specified id")
	void getStaffMember() throws StaffMemberNotFoundException {
		
		OfficeStaffMembers testdata =  new OfficeStaffMembers(5,"Karan","Manager");
		OfficeStaffMembers expected = new OfficeStaffMembers(5,"Karan","Manager");
		Mockito.when(managerRepo.findById(testdata.getEmpid())).thenReturn(Optional.of(testdata));
		OfficeStaffMembers actual = msImpl.getStaffMember(testdata.getEmpid());
		assertEquals(expected, actual);
		
	}
	
	
	
	
	
	
	
	
	
	
}
