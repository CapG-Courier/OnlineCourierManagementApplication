package com.cg.project.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cg.project.entity.Complaint;
import com.cg.project.entity.Courier;
import com.cg.project.repository.ComplaintRepo;
import com.cg.project.repository.CourierRepo;
import com.cg.project.repository.CustomerRepo;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceImplTest {
	
	@Mock
	private CustomerRepo customerRepo;
	
	@Mock
	private CourierRepo courierRepo;
	
	@Mock
	private ComplaintRepo complaintRepo;
	
	@InjectMocks
	private CustomerServiceImpl csImpl;
	
	@Test
	@DisplayName("CustomerServiceImpl:: initiateProcess should return true if courier object is successfully created")
	void initiateProcess() {
		boolean expected = true;
		Courier testdata = new Courier(1,5000,LocalDate.parse("2020-11-03"),LocalDate.parse("2021-03-20"));
		Mockito.when(courierRepo.save(testdata)).thenReturn(testdata);
		boolean actual = csImpl.initiateProcess();
		assertEquals(expected, actual);
	}
	
	@Test
	@DisplayName("CustomerServiceImpl:: checkOnlineTrackingStatus should return the status of the courier")
	void checkOnlineTrackingStatus() {
		String expected="INITIATED";
		Courier testdata = new Courier(1,5123,LocalDate.parse("2020-11-03"),LocalDate.parse("2021-03-20"));
		int consignmentno = 5123;
		Mockito.when(courierRepo.findByConsignmentNo(consignmentno)).thenReturn(testdata);
		String actual = csImpl.checkOnlineTrackingStatus(testdata.getConsignmentNo());
		assertEquals(expected, actual);
	}
	
	@Test
	@DisplayName("CustomerServiceImpl:: register complaint should return the complaint id")
	void registerComplaint() {
		int expected=6;
		Complaint testdata = new Complaint(6,5000,"The courier got lost","When I did not receive the courier, the staff members says that the courier is lost");
		Mockito.when(complaintRepo.save(testdata)).thenReturn(testdata);
		int actual = csImpl.registerComplaint(testdata);
		assertEquals(expected, actual);
	}

}
