package com.bradlarsenfinal.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bradlarsenfinal.springboot.dao.AnimalDao;
import com.bradlarsenfinal.springboot.entities.Animal;

@Service
public class AnimalService {
	
	@Autowired(required = true)
	private AnimalDao animalDao;
	
	public void setAnimalDao (AnimalDao animalDao){
		
		this.animalDao = animalDao;
		
	}
	

	public void newAnimal(Animal animal) {
		
		animalDao.newAnimal(animal);
		
	}

	public List<Animal> getAllAnimals() {
		
		return animalDao.getAllAnimals();
		
	}

	public void editAnimal(Animal editedAnimal) {
		
		animalDao.editAnimal(editedAnimal);
		
	}

	public void deleteAnimal(Integer animalId) {
		
		animalDao.deleteAnimal(animalId);
		
	}

}
