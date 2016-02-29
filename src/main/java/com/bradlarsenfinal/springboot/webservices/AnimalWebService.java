package com.bradlarsenfinal.springboot.webservices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bradlarsenfinal.springboot.entities.Animal;
import com.bradlarsenfinal.springboot.service.AnimalService;

@RestController
public class AnimalWebService {
	
	@Autowired(required = true)
	AnimalService animalService;
	
	public void setAnimalService(AnimalService animalService){
		
		this.animalService = animalService;
		
	}
	
	@RequestMapping(value="/addAnimal", method = RequestMethod.POST)
	public void addNewAnimal(@RequestBody Animal animal){
		
		animalService.newAnimal(animal);
		
	}
	
	@RequestMapping(value="/viewAnimal", method = RequestMethod.GET)
	public List<Animal> getAnimals(){
		
		return animalService.getAllAnimals();
		
	}
	
	@RequestMapping(value="/editAnimal", method = RequestMethod.PUT)
	public void updateAnimal(@RequestBody Animal editedAnimal){
		
		animalService.editAnimal(editedAnimal);
		
	}
	
	@RequestMapping(value="/deleteAnimal/{animalId}", method = RequestMethod.DELETE)
	public void deleteAnimal(@PathVariable Integer animalId){
		
		animalService.deleteAnimal(animalId);
		
	}

}






