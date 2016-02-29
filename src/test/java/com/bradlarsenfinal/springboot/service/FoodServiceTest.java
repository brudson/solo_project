package com.bradlarsenfinal.springboot.service;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;

import com.bradlarsenfinal.springboot.dao.FoodDao;
import com.bradlarsenfinal.springboot.entities.Food;

public class FoodServiceTest {
	private FoodService foodService;
	private FoodDao foodDao;
	private Food food;
	
	@Before
	public void setup(){
		
		foodService = new FoodService();
		foodDao = mock(FoodDao.class);
		food = mock(Food.class);
		foodService.setFoodDao(foodDao);
		
	}
	
	@Test
	public void newFoodTest(){
		
		foodService.newFood(food);
		verify(foodDao).newFood(food);
			
	}
	
	@Test
	public void getAllFoodsTest(){
		
		foodService.getAllFood();
		verify(foodDao).getAllFood();
		
	}
	
	@Test
	public void editFoodTest(){
		
		foodService.editFood(food);
		verify(foodDao).editFood(food);
	}
	
	@Test
	public void deleteFoodTest(){
		
		foodService.deleteFood(anyInt());
		verify(foodDao).deleteFood(anyInt());
		
	}
}
