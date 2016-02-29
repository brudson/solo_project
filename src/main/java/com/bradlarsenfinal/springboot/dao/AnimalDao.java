package com.bradlarsenfinal.springboot.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.bradlarsenfinal.springboot.entities.Animal;


@Transactional
@Component
public class AnimalDao {
	
	@PersistenceContext
	private EntityManager em;
	
	public void setEm(EntityManager em){
		this.em = em;
	}
	
	public Animal newAnimal(Animal animal) {
		
		em.persist(animal);
		em.flush();
		
		return animal;
		
	}

	public List<Animal> getAllAnimals() {
		
		List<Animal> allAnimals = em.createQuery("SELECT d FROM animals d", Animal.class).getResultList();
		
		return allAnimals;
	}

	public void editAnimal(Animal editedAnimal) {
		
		em.merge(editedAnimal);
		em.flush();
		
	}

	public void deleteAnimal(Integer animalId) {
		
		Animal animal = em.find(Animal.class, animalId);
		em.remove(animal);
		em.flush();
		
	}

}
