package com.bradlarsenfinal.springboot.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.bradlarsenfinal.springboot.entities.Food;

/**
 * Stores and receives all data from the database concerning food
 * @author Bradley
 *
 */
@Transactional
@Component
public class FoodDao {

	@PersistenceContext
	private EntityManager em;
	
	
	public void setEm(EntityManager em) {
		this.em = em;
	}
	
	/**
	 * Gets a new Food object and stores it into the database
	 * @param food
	 * @return
	 */
	public Food newFood(Food food) {
		
		em.persist(food);
		em.flush();
		
		return food;
		
	}

	/**
	 * Gets a list of all the food currently stored in the database
	 * @return
	 */
	public List<Food> getAllFood() {
		
		List<Food> allFood = em.createQuery("SELECT d FROM food d", Food.class).getResultList();
		
		return allFood;
		
	}
	
	/**
	 * Merges an edited food with an existing one and updates the data
	 * @param editedFood
	 */
	public void editFood(Food editedFood) {
		
		em.merge(editedFood);
		em.flush();
		
	}
	
	/**
	 * Deletes a food based on the foodid from the databse
	 * @param foodId
	 */
	public void deleteFood(Integer foodId) {
		
		Food food = em.find(Food.class, foodId);
		em.remove(food);
		em.flush();
		
	}

}
