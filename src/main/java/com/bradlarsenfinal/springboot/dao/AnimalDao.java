package com.bradlarsenfinal.springboot.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.bradlarsenfinal.springboot.entities.Animal;

/**
 * Stores and Recieves data from the database for all animals
 * 
 * @author Bradley
 *
 */
@Transactional
@Component
public class AnimalDao {
	
	@PersistenceContext
	private EntityManager em;
	
	public void setEm(EntityManager em){
		this.em = em;
	}
	
	/**
	 * Gets a new animal object and stores it into the database
	 */
	public Animal newAnimal(Animal animal) {
		
		em.persist(animal);
		em.flush();
		
		return animal;
		
	}
	
	/**
	 * gets a list of all animals currently in the database and
	 * returns it to the front end
	 * @return
	 */
	public List<Animal> getAllAnimals() {
		
		List<Animal> allAnimals = em.createQuery("SELECT d FROM animals d", Animal.class).getResultList();
		
		return allAnimals;
	}

	/**
	 * Gets an edited animal and merges the edited data with an existing one
	 * @param editedAnimal
	 */
	public void editAnimal(Animal editedAnimal) {
		
		em.merge(editedAnimal);
		em.flush();
		
	}

	/**
	 * Deletes an animal based on the animal id
	 * @param animalId
	 */
	public void deleteAnimal(Integer animalId) {
		
		Animal animal = em.find(Animal.class, animalId);
		em.remove(animal);
		em.flush();
		
	}

}
