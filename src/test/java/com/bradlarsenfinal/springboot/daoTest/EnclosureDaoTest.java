package com.bradlarsenfinal.springboot.daoTest;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import com.bradlarsenfinal.springboot.dao.EnclosureDao;
import com.bradlarsenfinal.springboot.entities.Enclosure;

public class EnclosureDaoTest {
	
	private EnclosureDao enclosureDao;
	private EntityManager entityManager;
	private Enclosure enclosure;
	
	@Before
	public void setup(){
		
		enclosureDao = new EnclosureDao();
		entityManager = mock(EntityManager.class);
		enclosureDao.setEm(entityManager);
		enclosure = mock(Enclosure.class);
		
	}
	
	@Test
	public void getAllEnclosuresTest(){
		
		TypedQuery<Enclosure> mockTypedQuery = mock(TypedQuery.class);
		
		List<Enclosure> expected = new ArrayList<Enclosure>();
		
		when(entityManager.createQuery(anyString(), eq(Enclosure.class))).thenReturn(mockTypedQuery);
		when(mockTypedQuery.getResultList()).thenReturn(expected);
		
		enclosureDao.getAllEnclosures();
		
		verify(mockTypedQuery).getResultList();
		
	}
	
	@Test
	public void newEnclosureTest(){
		
		enclosureDao.newEnclosure(enclosure);
		verify(entityManager).persist(enclosure);
		
	}
	
	@Test
	public void editEnclosureTest(){
		
		enclosureDao.editEnclosure(enclosure);
		verify(entityManager).merge(enclosure);
		
	}
	
	@Test
	public void deleteEnclosureTest(){
		
		enclosureDao.deleteEnclosure(null);
		verify(entityManager).remove(null);
		
	}
	
}
