angular.module('app').service('favFoodService', ['$http',
function($http){
	
	/*
	 * initializes the currentFood so it does not get deleted when
	 * the function is called
	 */
	var currentFood;
	
	//Gets all food in the database
	function getAllFood(){
		
		return $http.get('/viewFood')
		
	}

	//Deletes a food based on the Id passed through
	function deleteFood(foodId){
		console.log(foodId);
		return $http.delete('/deleteFood/'+foodId);
		
	}
	
	/*
	 * holds onto the current food while the pages are changed
	 * and the gets called by the favFoodCtrl
	 */
	function getSetFood(num, food){
		
		if(num == 1){
			currentFood = food;
		}
		else if (num == 2){
			return currentFood;
		}
		
	}
	
	
	//Edits an existing food in the database
	function editFood(editFood){
		
		return $http.put("/editFood", editFood);
		
	}

	
	return {
		
    	getAllFood : getAllFood,
    	deleteFood : deleteFood,
    	getSetFood : getSetFood,
    	editFood : editFood
    	
    };
    
}]);