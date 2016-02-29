package com.bradlarsenfinal.springboot.webserviceTest;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.bradlarsenfinal.springboot.entities.Food;
import com.bradlarsenfinal.springboot.service.FoodService;
import com.bradlarsenfinal.springboot.webservices.FoodWebService;

public class FoodWebServiceTest {

	private FoodWebService foodWebService;
	private FoodService foodService;
	
	@Before
	public void setup(){
		
		foodWebService = new FoodWebService();
		foodService = mock(FoodService.class);
		foodWebService.setFoodService(foodService);
		
	}
	
	@Test
	public void addNewFoodTest(){
		
		Food food = new Food();
		
		foodWebService.addNewFood(food);
		verify(foodService).newFood(food);
		
	}
	
	@Test
	public void getFoodsTest(){
		
		List<Food> foods = new ArrayList<Food>();
		
		when(foodWebService.getFood()).thenReturn(foods);
		
		foodWebService.getFood();
		verify(foodService).getAllFood();
		
	}
	
	@Test
	public void updateFoodTest(){
		
		Food food = new Food();
		
		foodWebService.updateFood(food);
		verify(foodService).editFood(food);
		
	}
	
	@Test
	public void deleteFoodTest(){
		
		foodWebService.deleteFood(anyInt());
		verify(foodService).deleteFood(anyInt());
		
	}
	
}
