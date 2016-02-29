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

/**
 * Communicates with the JS animalService and passes data back to the front end
 * @author Bradley
 *
 */
@RestController
public class AnimalWebService {
	
	@Autowired(required = true)
	AnimalService animalService;
	
	public void setAnimalService(AnimalService animalService){
		
		this.animalService = animalService;
		
	}
	
	/**
	 * Receives the new Animal object from the front end and passes it 
	 * to the animalService
	 * @param animal
	 */
	@RequestMapping(value="/addAnimal", method = RequestMethod.POST)
	public void addNewAnimal(@RequestBody Animal animal){
		
		animalService.newAnimal(animal);
		
	}
	
	/**
	 * Receives the request for all animals from the front end and 
	 * calls the function in animalService
	 * @return
	 */
	@RequestMapping(value="/viewAnimal", method = RequestMethod.GET)
	public List<Animal> getAnimals(){
		
		return animalService.getAllAnimals();
		
	}
	
	/**
	 * Receives the editedAnimal and passes the object to the animalService
	 * @param editedAnimal
	 */
	@RequestMapping(value="/editAnimal", method = RequestMethod.PUT)
	public void updateAnimal(@RequestBody Animal editedAnimal){
		
		animalService.editAnimal(editedAnimal);
		
	}
	
	/**
	 * Receives an Id from the front end for the animal to be deleted and 
	 * passes it to the animalService
	 * @param animalId
	 */
	@RequestMapping(value="/deleteAnimal/{animalId}", method = RequestMethod.DELETE)
	public void deleteAnimal(@PathVariable Integer animalId){
		
		animalService.deleteAnimal(animalId);
		
	}

}






