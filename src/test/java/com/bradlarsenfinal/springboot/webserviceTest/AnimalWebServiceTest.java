package com.bradlarsenfinal.springboot.webserviceTest;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.bradlarsenfinal.springboot.entities.Animal;
import com.bradlarsenfinal.springboot.service.AnimalService;
import com.bradlarsenfinal.springboot.webservices.AnimalWebService;

public class AnimalWebServiceTest {

	private AnimalWebService animalWebService;
	private AnimalService animalService;
	private Animal animal;
	
	@Before
	public void setup(){
		
		animalWebService = new AnimalWebService();
		animalService = mock(AnimalService.class);
		animal = mock(Animal.class);
		animalWebService.setAnimalService(animalService);
		
	}
	
	@Test
	public void addNewAnimalTest(){
		
		Animal animal = new Animal();
		
		animalWebService.addNewAnimal(animal);
		verify(animalService).newAnimal(animal);
		
	}
	
	@Test
	public void getAnimalsTest(){
		
		List<Animal> animals = new ArrayList<Animal>();
		
		when(animalWebService.getAnimals()).thenReturn(animals);
		
		animalWebService.getAnimals();
		verify(animalService).getAllAnimals();
		
	}
	
	@Test
	public void updateAnimalTest(){
		
		Animal animal = new Animal();
		
		animalWebService.updateAnimal(animal);
		verify(animalService).editAnimal(animal);
		
	}
	
	@Test
	public void deleteAnimalTest(){
		
		animalWebService.deleteAnimal(anyInt());
		verify(animalService).deleteAnimal(anyInt());
		
	}
	
}
