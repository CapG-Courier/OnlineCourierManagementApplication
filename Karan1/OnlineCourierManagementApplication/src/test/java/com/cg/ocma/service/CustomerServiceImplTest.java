package com.cg.ocma.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cg.ocma.entities.ComplaintEntity;
import com.cg.ocma.entities.CourierEntity;
import com.cg.ocma.entities.CourierStatus;
import com.cg.ocma.exception.CourierNotFoundException;
import com.cg.ocma.exception.DuplicateComplaintFoundException;
import com.cg.ocma.exception.DuplicateCourierFoundException;
import com.cg.ocma.model.ComplaintModel;
import com.cg.ocma.model.CourierModel;
import com.cg.ocma.repository.ComplaintRepo;
import com.cg.ocma.repository.CourierRepo;
import com.cg.ocma.repository.CustomerRepo;

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
	
	/*
	@Test
	@DisplayName("CustomerServiceImpl:: register should return customer id if customer object is successfully created")
	void register() throws DuplicateCustomerFoundException {
		int expected = 5;
		int customerid = 5;
		Customer testdata = new Customer(5,1736254879,"Ram","Kumar", 988762456);
		CustomerModel check = new CustomerModel(5,1736254879,"Ram","Kumar", 988762456);
		Mockito.when(customerRepo.existsById(customerid)).thenReturn(false);
		Mockito.when(customerRepo.save(testdata)).thenReturn(testdata);
		int actual = csImpl.register(check);
		assertEquals(expected, actual);
	}
	*/
	
	/*
	@Test
	@DisplayName("CustomerServiceImpl:: register should return exception if customer already exists")
	void registerCheck() throws DuplicateCustomerFoundException{
		
		CustomerModel check = new CustomerModel(5,1736254879,"Ram","Kumar", 988762456);
		Mockito.when(customerRepo.existsById(check.getCustomerid())).thenReturn(true);
		assertThrows(DuplicateCustomerFoundException.class, () -> {
			csImpl.register(check);
		});
	}
	*/
	
	@Test
	@DisplayName("CustomerServiceImpl:: initiateProcess should return consignment number if courier object is successfully created")
	void initiateProcess() throws DuplicateCourierFoundException {
		int expected = 5000;
		CourierEntity testdata = new CourierEntity(1,5000,LocalDate.parse("2020-11-03"));
		CourierModel model = new CourierModel(1,5000,LocalDate.parse("2020-11-03"));
		Mockito.when(courierRepo.existsById(testdata.getCourierId())).thenReturn(false);
		Mockito.when(courierRepo.save(testdata)).thenReturn(testdata);
		Mockito.when(courierRepo.findById(testdata.getCourierId())).thenReturn(Optional.of(testdata));
		int actual = csImpl.initiateProcess(model);
		assertEquals(expected, actual);
	}
	
	@Test
	@DisplayName("CustomerServiceImpl:: initiateProcess should return exception if courier already exists")
	void initiateProcessCheck() throws DuplicateCourierFoundException{
		
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
		CourierEntity testdata = new CourierEntity(1,5123,LocalDate.parse("2020-11-03"),LocalDate.parse("2021-03-20"),CourierStatus.INITIATED);
		int consignmentno = 5123;
		Mockito.when(courierRepo.findByConsignmentNo(consignmentno)).thenReturn(testdata);
		String actual = csImpl.checkOnlineTrackingStatus(consignmentno);
		assertEquals(expected, actual);
	}
	
	@Test
	@DisplayName("CustomerServiceImpl:: checkOnlineTrackingStatusCheck should give an exception when the Courier is not found")
	void checkOnlineTrackingStatusCheck() throws CourierNotFoundException {
		
		CourierEntity testdata = new CourierEntity(1,5123,LocalDate.parse("2020-11-03"),LocalDate.parse("2021-03-20"),CourierStatus.INITIATED);
		int consignmentno = 5123;
		Mockito.when(courierRepo.existsByConsignmentNo(testdata.getConsignmentNo())).thenReturn(false);
		assertThrows(CourierNotFoundException.class, () -> {
			csImpl.checkOnlineTrackingStatus(consignmentno);
		});
		
	}
	
	@Test
	@DisplayName("CustomerServiceImpl:: registerComplaint should return exception if complaint already exists")
	void registerComplaintCheck() throws DuplicateComplaintFoundException{
		
		ComplaintModel model = new ComplaintModel(10,5123, "Courier was lost", "The courier was lost during transfer");
		Mockito.when(complaintRepo.existsById(model.getComplaintId())).thenReturn(true);
		assertThrows(DuplicateComplaintFoundException.class, () -> {
			csImpl.registerComplaint(model);
		});
	}
	
	@Test
	@DisplayName("CustomerServiceImpl:: register complaint should return the complaint id")
	void registerComplaint() throws DuplicateComplaintFoundException {
		int expected = 7;
		ComplaintEntity testdata = new ComplaintEntity(7,5123, "Courier was lost", "The courier was lost during transfer");
		ComplaintModel model = new ComplaintModel(7,5123, "Courier was lost", "The courier was lost during transfer");
		Mockito.when(complaintRepo.existsById(testdata.getComplaintId())).thenReturn(false);
		Mockito.when(complaintRepo.save(testdata)).thenReturn(testdata);
		int actual = csImpl.registerComplaint(model);
		assertEquals(expected, actual);
	}

}
