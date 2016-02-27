package com.bradlarsenfinal.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bradlarsenfinal.springboot.dao.FoodDao;
import com.bradlarsenfinal.springboot.entities.Food;

@Service
public class FoodService {

	@Autowired(required = true)
	private FoodDao foodDao;
	
	public void setFoodDao(FoodDao foodDao){
		
		this.foodDao = foodDao;
	}
	
	
	public void newFood(Food food) {
		
		foodDao.newFood(food);
		
	}

	public List<Food> getAllFood() {
		
		return foodDao.getAllFood();
		
	}

	public void editFood(Food editedFood) {
		
		foodDao.editFood(editedFood);
		
	}

	public void deleteFood(Integer foodId) {
		
		foodDao.deleteFood(foodId);
		
	}

}
