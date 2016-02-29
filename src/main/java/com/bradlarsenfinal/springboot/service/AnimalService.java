package com.bradlarsenfinal.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bradlarsenfinal.springboot.dao.AnimalDao;
import com.bradlarsenfinal.springboot.entities.Animal;

/**
 * Passes data from the AnimalWebService to the AnimalDao
 * @author Bradley
 *
 */
@Service
public class AnimalService {
	
	@Autowired(required = true)
	private AnimalDao animalDao;
	
	public void setAnimalDao (AnimalDao animalDao){
		
		this.animalDao = animalDao;
		
	}
	
	/**
	 * Passes the new animal object to the Dao
	 * @param animal
	 */
	public void newAnimal(Animal animal) {
		
		animalDao.newAnimal(animal);
		
	}
	
	/**
	 * Returns the list of all the animals in the database
	 * @return
	 */
	public List<Animal> getAllAnimals() {
		
		return animalDao.getAllAnimals();
		
	}
	
	/**
	 * Passes on the animal object to be edited to the Dao
	 * @param editedAnimal
	 */
	public void editAnimal(Animal editedAnimal) {
		
		animalDao.editAnimal(editedAnimal);
		
	}
	
	/**
	 * Passes the Id to the Dao for deletion
	 * @param animalId
	 */
	public void deleteAnimal(Integer animalId) {
		
		animalDao.deleteAnimal(animalId);
		
	}

}
