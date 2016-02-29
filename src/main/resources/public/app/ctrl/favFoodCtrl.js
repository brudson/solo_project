angular.module('app').controller('favFoodCtrl', ['$scope', '$http', '$location', 'favFoodService',
function($scope, $http, $location, favFoodService){
	
	//Used in the toggle function to determine text output
	$scope.toggleSelect 		= 0;
	//Defaults the Show Animals button to Show Animals on page load
	$scope.foodStatus 		= "Show Food";
	
	/*
	 * newFood creates an object from data provided by the user and passes
	 * it into the FoodWebService to be added into the database
	 */
	$scope.newFood = function newFood(){
		
		//Creates the object form the front end to send to the database
		var data = ({
				name: 		$scope.food,
				vendorName: $scope.vendorName,
				category: 	$scope.category
		});
		
		console.log(data);
		console.log("hey");
		
		//Sends the data object to the /addFood webService
		$http.post("/addFood", data).success(function(status){
		
			alert("success");
			
			//clears the form after a successful submit
			$scope.food			= "";
			$scope.vendorName	= "";
			$scope.category		= "";

		}).error(function(){
			
			alert("failure");
			
		})
		
	}
	
	/*
	 * Gets all the foods from the database and pulls
	 * them out of the promise to give $scope.foodObjects
	 * and array of objects that is easier to pull from
	 */
	
	$scope.viewFood = function viewFood(){
		
		favFoodService.getAllFood().then(function(data){
			
			return $scope.foodObjects = data.data;
			
		});
		
	}
	
	/*
	 * Shows and hides all the data from viewFood
	 */
	$scope.toggle = function(){
		
		//Interacts with ng-hide to make the table alternate on the front end
		$scope.showTable = !$scope.showTable;
		
		
		
		if($scope.toggleSelect == 1){
			$scope.foodStatus = "Show Food";
			$scope.toggleSelect--;
		}
		else{
			$scope.foodStatus = "Hide Food";
			$scope.toggleSelect++;
		}
		
	}
	
	/*
	 * Calls deleteFood from foodService and passes in the id
	 * to be deleted from the database
	 */
	$scope.deleteFood = function(id){
		
		favFoodService.deleteFood(id);
		
	}
	
	/*
	 * Gets and sets the current object for editing when the pages controller 
	 * is changed
	 */
	$scope.updateFood = function(food){
		
		var setFood = 1;
		
		favFoodService.getSetFood(setFood, food);
		
		$location.path('/editFood');
		
		
	}
	
}]);