package com.bradlarsenfinal.springboot.service;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

import com.bradlarsenfinal.springboot.dao.EnclosureDao;
import com.bradlarsenfinal.springboot.entities.Enclosure;

public class EnclosureServiceTest {

	private EnclosureService enclosureService;
	private EnclosureDao enclosureDao;
	private Enclosure enclosure;
	
	@Before
	public void setup(){
		
		enclosureService = new EnclosureService();
		enclosureDao = mock(EnclosureDao.class);
		enclosure = mock(Enclosure.class);
		enclosureService.setEnclosureDao(enclosureDao);
		
	}
	
	@Test
	public void newEnclosureTest(){
		
		enclosureService.newEnclosure(enclosure);
		verify(enclosureDao).newEnclosure(enclosure);
			
	}
	
	@Test
	public void getAllEnclosuresTest(){
		
		enclosureService.getAllEnclosures();
		verify(enclosureDao).getAllEnclosures();
		
	}
	
	@Test
	public void editEnclosureTest(){
		
		enclosureService.editEnclosure(enclosure);
		verify(enclosureDao).editEnclosure(enclosure);
	}
	
	@Test
	public void deleteEnclosureTest(){
		
		enclosureService.deleteEnclosure(anyInt());
		verify(enclosureDao).deleteEnclosure(anyInt());
		
	}
	
}







