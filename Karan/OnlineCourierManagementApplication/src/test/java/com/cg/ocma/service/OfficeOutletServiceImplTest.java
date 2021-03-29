package com.cg.ocma.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

import com.cg.ocma.entities.CourierOfficeOutlet;
import com.cg.ocma.exception.DuplicateOfficeOutletFoundException;
import com.cg.ocma.exception.OutletNotFoundException;
import com.cg.ocma.model.CourierOfficeOutletModel;
import com.cg.ocma.repository.OfficeOutletRepo;

@ExtendWith(MockitoExtension.class)
public class OfficeOutletServiceImplTest {
	
	@Mock
	private OfficeOutletRepo officeRepo;
	
	@InjectMocks
	private OfficeOutletServiceImpl ofImpl;
	
	@Test
	@DisplayName("OfficeOutletServiceImpl:: addNewOffice should return the new office id")
	void addNewOffice() throws DuplicateOfficeOutletFoundException {
		int expected = 2;
		CourierOfficeOutlet testdata = new CourierOfficeOutlet(2,"08:30:00","22:00:00");
		CourierOfficeOutletModel check = new CourierOfficeOutletModel(2,"08:30:00","22:00:00");
		Mockito.when(officeRepo.save(testdata)).thenReturn(testdata);
		int actual = ofImpl.addNewOffice(check);
		assertEquals(expected, actual);
	}
	
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
		
		CourierOfficeOutlet testdata = new CourierOfficeOutlet(6, "08:30:00", "22:00:00");
		CourierOfficeOutletModel expected = new CourierOfficeOutletModel(6, "08:30:00", "22:00:00");
		Mockito.when(officeRepo.findById(officeid)).thenReturn(Optional.of(testdata));
		
		CourierOfficeOutletModel actual = ofImpl.getOfficeInfo(officeid);
		assertEquals(expected, actual);
	}
	
	@Test
	@DisplayName("OfficeOutletServiceImpl:: getAllOfficesData should return office info of all offices in the repo")
	void getAllOfficesData() throws OutletNotFoundException{
		
		Mockito.when(officeRepo.count()).thenReturn(1L);
		
		List<CourierOfficeOutlet> testdata = Arrays.asList(new CourierOfficeOutlet[] {
				new CourierOfficeOutlet(6, "08:30:00", "22:00:00"),
				new CourierOfficeOutlet(7, "08:30:00","22:00:00")
			});
		
		Mockito.when(officeRepo.findAll()).thenReturn(testdata);
		
		List<CourierOfficeOutletModel> expected = Arrays.asList(new CourierOfficeOutletModel[] {
				new CourierOfficeOutletModel(6, "08:30:00", "22:00:00"),
				new CourierOfficeOutletModel(7, "08:30:00","22:00:00")
		});
		
		List <CourierOfficeOutletModel> actual = ofImpl.getAllOfficesData();
		assertEquals(expected, actual);
		
	}
}
