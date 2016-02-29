package com.bradlarsenfinal.springboot.daoTest;

import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.junit.Before;
import org.junit.Test;

import com.bradlarsenfinal.springboot.dao.AnimalDao;
import com.bradlarsenfinal.springboot.entities.Animal;

public class AnimalDaoTest {

	private AnimalDao animalDao;
	private EntityManager entityManager;
	private Animal animal;
	
	@Before
	public void setup(){
		
		animalDao = new AnimalDao();
		entityManager = mock(EntityManager.class);
		animalDao.setEm(entityManager);
		animal = mock(Animal.class);
		
	}
	
	@Test
	public void getAllAnimalsTest(){
		
		TypedQuery<Animal> mockTypedQuery = mock(TypedQuery.class);
		
		List<Animal> expected = new ArrayList<Animal>();
		
		when(entityManager.createQuery(anyString(), eq(Animal.class))).thenReturn(mockTypedQuery);
		when(mockTypedQuery.getResultList()).thenReturn(expected);
		
		animalDao.getAllAnimals();
		
		verify(mockTypedQuery).getResultList();
		
	}
	
	@Test
	public void newAnimalTest(){
		
		animalDao.newAnimal(animal);
		verify(entityManager).persist(animal);
		
	}
	
	@Test
	public void editAnimalTest(){
		
		animalDao.editAnimal(animal);
		verify(entityManager).merge(animal);
		
	}
	
	@Test
	public void deleteAnimalTest(){
		
		animalDao.deleteAnimal(null);
		verify(entityManager).remove(null);
		
	}
	
}
