package com.bradlarsenfinal.springboot.webservices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bradlarsenfinal.springboot.entities.Enclosure;
import com.bradlarsenfinal.springboot.entities.Food;
import com.bradlarsenfinal.springboot.service.FoodService;

@RestController
public class FoodWebService {

	@Autowired(required = true)
	FoodService foodService;
	
	public void setFoodService(FoodService foodService){
		
		this.foodService = foodService;
		
	}
	
	@RequestMapping(value="/addFood", method = RequestMethod.POST)
	public void addNewFood(@RequestBody Food food){
		
		foodService.newFood(food);
		
	}
	
	@RequestMapping(value="/viewFood", method = RequestMethod.GET)
	public List<Food> getFood(){
		
		return foodService.getAllFood();
		
	}
	
	@RequestMapping(value="/editFood", method = RequestMethod.PUT)
	public void updateFood(@RequestBody Food editedFood){
		
		foodService.editFood(editedFood);
		
	}
	
	@RequestMapping(value="/deleteFood/{foodId}", method = RequestMethod.DELETE)
	public void deleteFood(@PathVariable Integer foodId){
		System.out.println(foodId);
		foodService.deleteFood(foodId);
		
	}
}
