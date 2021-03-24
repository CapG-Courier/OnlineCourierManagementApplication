package com.cg.project.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cg.project.entity.Courier;
import com.cg.project.entity.CourierStatus;
import com.cg.project.exception.CourierNotFoundException;
import com.cg.project.exception.DuplicateComplaintFoundException;
import com.cg.project.exception.DuplicateCourierFoundException;
import com.cg.project.model.ComplaintModel;
import com.cg.project.model.CourierModel;
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
	
	/*@Test
	@DisplayName("CustomerServiceImpl:: initiateProcess should return true if courier object is successfully created")
	void initiateProcess() throws DuplicateCourierFoundException {
		int expected = 5000;
		Courier testdata = new Courier(1,5000,LocalDate.parse("2020-11-03"));
		CourierModel model = new CourierModel(1,5000,LocalDate.parse("2020-11-03"));
		Mockito.when(courierRepo.save(testdata)).thenReturn(testdata);
		int actual = csImpl.initiateProcess(model);
		assertEquals(expected, actual);
	}*/
	
	@Test
	@DisplayName("CustomerServiceImpl:: initiateProcess should return exception if courier already exists")
	void initiateProcess() throws DuplicateCourierFoundException{
		
		CourierModel check = new CourierModel(1,5000,LocalDate.parse("2020-11-03"));
		Mockito.when(courierRepo.existsById(check.getCourierId())).thenReturn(true);
		assertThrows(DuplicateCourierFoundException.class, () -> {
			csImpl.initiateProcess(check);
		});
	}
	
	
	@Test
	@DisplayName("CustomerServiceImpl:: checkOnlineTrackingStatus should return the status of the courier")
	void checkOnlineTrackingStatus() throws CourierNotFoundException{
		String expected="INITIATED";
		Courier testdata = new Courier(1,5123,LocalDate.parse("2020-11-03"),LocalDate.parse("2021-03-20"),CourierStatus.INITIATED);
		int consignmentno = 5123;
		Mockito.when(courierRepo.findByConsignmentNo(consignmentno)).thenReturn(testdata);
		String actual = csImpl.checkOnlineTrackingStatus(consignmentno);
		assertEquals(expected, actual);
	}
	
	@Test
	@DisplayName("CustomerServiceImpl:: registerComplaint should return exception if complaint already exists")
	void registerComplaint() throws DuplicateComplaintFoundException{
		
		ComplaintModel model = new ComplaintModel(10,5123, "Courier was lost", "The courier was lost during transfer");
		Mockito.when(complaintRepo.existsById(model.getComplaintId())).thenReturn(true);
		assertThrows(DuplicateComplaintFoundException.class, () -> {
			csImpl.registerComplaint(model);
		});
	}
	
	/*@Test
	@DisplayName("CustomerServiceImpl:: register complaint should return the complaint id")
	void registerComplaint() throws DuplicateComplaintFoundException {
		int expected = 7;
		Complaint testdata = new Complaint(7,5123, "Courier was lost", "The courier was lost during transfer");
		ComplaintModel model = new ComplaintModel(7,5123, "Courier was lost", "The courier was lost during transfer");
		Mockito.when(complaintRepo.save(testdata)).thenReturn(testdata);
		int actual = csImpl.registerComplaint(model);
		assertEquals(expected, actual);
	}*/

}
