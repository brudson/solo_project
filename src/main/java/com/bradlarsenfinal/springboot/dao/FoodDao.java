package com.bradlarsenfinal.springboot.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.bradlarsenfinal.springboot.entities.Food;

@Transactional
@Component
public class FoodDao {

	@PersistenceContext
	private EntityManager em;
	
	
	public void setEm(EntityManager em) {
		this.em = em;
	}
	
	public Food newFood(Food food) {
		
		em.persist(food);
		em.flush();
		
		return food;
		
	}

	public List<Food> getAllFood() {
		
		List<Food> allFood = em.createQuery("SELECT d FROM food d", Food.class).getResultList();
		
		return allFood;
		
	}

	public void editFood(Food editedFood) {
		
		em.merge(editedFood);
		em.flush();
		
	}

	public void deleteFood(Integer foodId) {
		
		Food food = em.find(Food.class, foodId);
		em.remove(food);
		em.flush();
		
	}

}
