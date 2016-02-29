package com.bradlarsenfinal.springboot.service;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;

import com.bradlarsenfinal.springboot.dao.AnimalDao;
import com.bradlarsenfinal.springboot.entities.Animal;



public class AnimalServiceTest {
	
	private AnimalService animalService;
	private AnimalDao animalDao;
	private Animal animal;
	@Before
	public void setup(){
		
		animalService = new AnimalService();
		animalDao = mock(AnimalDao.class);
		animal = mock(Animal.class);
		animalService.setAnimalDao(animalDao);
		
	}
	
	@Test
	public void newAnimalTest(){
		
		animalService.newAnimal(animal);
		verify(animalDao).newAnimal(animal);
			
	}
	
	@Test
	public void getAllAnimalsTest(){
		
		animalService.getAllAnimals();
		verify(animalDao).getAllAnimals();
		
	}
	
	@Test
	public void editAnimalTest(){
		
		animalService.editAnimal(animal);
		verify(animalDao).editAnimal(animal);
	}
	
	@Test
	public void deleteAnimalTest(){
		
		animalService.deleteAnimal(anyInt());
		verify(animalDao).deleteAnimal(anyInt());
		
	}
	
}
