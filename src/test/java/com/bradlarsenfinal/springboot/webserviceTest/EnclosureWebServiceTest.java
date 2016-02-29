package com.bradlarsenfinal.springboot.webserviceTest;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import com.bradlarsenfinal.springboot.entities.Enclosure;
import com.bradlarsenfinal.springboot.service.EnclosureService;
import com.bradlarsenfinal.springboot.webservices.EnclosureWebService;

public class EnclosureWebServiceTest {

	private EnclosureWebService enclosureWebService;
	private EnclosureService enclosureService;
	
	@Before
	public void setup(){
		
		enclosureWebService = new EnclosureWebService();
		enclosureService = mock(EnclosureService.class);
		enclosureWebService.setEnclosureService(enclosureService);
		
	}
	
	@Test
	public void addNewEnclosureTest(){
		
		Enclosure enclosure = new Enclosure();
		
		enclosureWebService.addNewEnclosure(enclosure);
		verify(enclosureService).newEnclosure(enclosure);
		
	}
	
	@Test
	public void getEnclosuresTest(){
		
		List<Enclosure> enclosures = new ArrayList<Enclosure>();
		
		when(enclosureWebService.getEnclosures()).thenReturn(enclosures);
		
		enclosureWebService.getEnclosures();
		verify(enclosureService).getAllEnclosures();
		
	}
	
	@Test
	public void updateEnclosureTest(){
		
		Enclosure enclosure = new Enclosure();
		
		enclosureWebService.updateEnclosure(enclosure);
		verify(enclosureService).editEnclosure(enclosure);
		
	}
	
	@Test
	public void deleteEnclosureTest(){
		
		enclosureWebService.deleteEnclosure(anyInt());
		verify(enclosureService).deleteEnclosure(anyInt());
		
	}
	
}

















