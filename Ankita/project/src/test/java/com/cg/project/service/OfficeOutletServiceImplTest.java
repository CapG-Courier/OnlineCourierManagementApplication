package com.cg.project.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalTime;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cg.project.entity.CourierOfficeOutlet;
import com.cg.project.exception.OutletNotFoundException;
import com.cg.project.model.CourierOfficeOutletModel;
import com.cg.project.repository.OfficeOutletRepo;

@ExtendWith(MockitoExtension.class)
public class OfficeOutletServiceImplTest {
	
	@Mock
	private OfficeOutletRepo officeRepo;
	
	@InjectMocks
	private OfficeOutletServiceImpl ofImpl;
	
	/*@Test
	@DisplayName("OfficeOutletServiceImpl:: addNewOffice should return the new office id")
	void addNewOffice() {
		int expected = 2;
		CourierOfficeOutlet testdata = new CourierOfficeOutlet(7,LocalTime.parse("08:30:00"),LocalTime.parse("22:00:00"));
		Mockito.when(officeRepo.save(testdata)).thenReturn(testdata);
		int actual = ofImpl.addNewOffice(testdata);
		assertEquals(expected, actual);
	}*/
	
	@Test
	@DisplayName("OfficeOutletServiceImpl:: removeNewOffice should return true if the office object is successfully deleted")
	void removeNewOffice() throws OutletNotFoundException{
		int testdata = 6;
		Mockito.when(officeRepo.existsById(testdata)).thenReturn(true);
		assertTrue(ofImpl.removeNewOffice(testdata));
	}
	
	@Test
	@DisplayName("OfficeOutletServiceImpl:: getOfficeInfo should return office info of specified office id")
	void getOfficeInfo() throws OutletNotFoundException{
		
		int officeid = 6;
		Mockito.when(officeRepo.existsById(officeid)).thenReturn(true);
		
		CourierOfficeOutlet testdata = new CourierOfficeOutlet(6, LocalTime.parse("08:30:00"), LocalTime.parse("22:00:00"));
		CourierOfficeOutletModel expected = new CourierOfficeOutletModel(6, LocalTime.parse("08:30:00"), LocalTime.parse("22:00:00"));
		Mockito.when(officeRepo.findById(officeid)).thenReturn(Optional.of(testdata));
		
		CourierOfficeOutletModel actual = ofImpl.getOfficeInfo(officeid);
		assertEquals(expected, actual);
	}
}
