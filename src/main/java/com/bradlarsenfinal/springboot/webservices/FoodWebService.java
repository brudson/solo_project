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

/**
 * Receives all the data from the JS foodService and passes it onto 
 * the java foodService
 * @author Bradley
 *
 */
@RestController
public class FoodWebService {

	@Autowired(required = true)
	FoodService foodService;
	
	public void setFoodService(FoodService foodService){
		
		this.foodService = foodService;
		
	}
	
	/**
	 * Receives the new food Object and passes it to the foodService
	 * @param food
	 */
	@RequestMapping(value="/addFood", method = RequestMethod.POST)
	public void addNewFood(@RequestBody Food food){
		
		foodService.newFood(food);
		
	}
	
	/**
	 * Receives the request to view all animals and then returns the 
	 * data provided by the databse
	 * @return
	 */
	@RequestMapping(value="/viewFood", method = RequestMethod.GET)
	public List<Food> getFood(){
		
		return foodService.getAllFood();
		
	}
	
	/**
	 * Receives the edited food and passes the object back to the 
	 * foodService
	 * @param editedFood
	 */
	@RequestMapping(value="/editFood", method = RequestMethod.PUT)
	public void updateFood(@RequestBody Food editedFood){
		
		foodService.editFood(editedFood);
		
	}
	
	/**
	 * Recieves the food Id an passes it to the foodService 
	 * @param foodId
	 */
	@RequestMapping(value="/deleteFood/{foodId}", method = RequestMethod.DELETE)
	public void deleteFood(@PathVariable Integer foodId){
		System.out.println(foodId);
		foodService.deleteFood(foodId);
		
	}
}
