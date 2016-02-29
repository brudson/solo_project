package com.bradlarsenfinal.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bradlarsenfinal.springboot.dao.FoodDao;
import com.bradlarsenfinal.springboot.entities.Food;

/**
 * Passes data from the FoodWebService to the FoodDao
 * @author Bradley
 *
 */
@Service
public class FoodService {

	@Autowired(required = true)
	private FoodDao foodDao;
	
	public void setFoodDao(FoodDao foodDao){
		
		this.foodDao = foodDao;
	}
	
	/**
	 * Passes the newFood object to the FoodDao
	 * @param food
	 */
	public void newFood(Food food) {
		
		foodDao.newFood(food);
		
	}
	
	/**
	 * Returns the list of all Foods
	 * @return
	 */
	public List<Food> getAllFood() {
		
		return foodDao.getAllFood();
		
	}
	
	/**
	 * Passes the edited food to the Dao to be merged
	 * @param editedFood
	 */
	public void editFood(Food editedFood) {
		
		foodDao.editFood(editedFood);
		
	}
	
	/**
	 * Passes the foodId to the Dao for Deletion
	 * @param foodId
	 */
	public void deleteFood(Integer foodId) {
		
		foodDao.deleteFood(foodId);
		
	}

}
