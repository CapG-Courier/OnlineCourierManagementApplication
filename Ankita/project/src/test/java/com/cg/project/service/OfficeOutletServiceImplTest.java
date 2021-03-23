package com.cg.project.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalTime;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cg.project.entity.CourierOfficeOutlet;
import com.cg.project.repository.OfficeOutletRepo;

@ExtendWith(MockitoExtension.class)
public class OfficeOutletServiceImplTest {
	
	@Mock
	private OfficeOutletRepo officeRepo;
	
	@InjectMocks
	private OfficeOutletServiceImpl ofImpl;
	
	@Test
	@DisplayName("OfficeOutletServiceImpl:: addNewOffice should return the new office id")
	void addNewOffice() {
		int expected = 2;
		CourierOfficeOutlet testdata = new CourierOfficeOutlet(7,LocalTime.parse("08:30:00"),LocalTime.parse("22:00:00"));
		Mockito.when(officeRepo.save(testdata)).thenReturn(testdata);
		int actual = ofImpl.addNewOffice(testdata);
		assertEquals(expected, actual);
	}
	
	/*@Test
	@DisplayName("OfficeOutletServiceImpl:: removeNewOffice should return true if the office object is successfully deleted")
	void removeNewOffice() {
		boolean expected = true;
		//CourierOfficeOutlet testdata = new CourierOfficeOutlet(7,LocalTime.parse("08:30:00"),LocalTime.parse("22:00:00")));
		int testdata = 6;
		Mockito.when(officeRepo.deleteById(testdata)).thenReturn(null);
		boolean actual = ofImpl.removeNewOffice(testdata);
		assertEquals(expected, actual);
	}*/

}
