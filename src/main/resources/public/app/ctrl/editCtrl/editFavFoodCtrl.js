angular.module('app').controller('editFavFoodCtrl', ['$scope', '$location', 'favFoodService', 
function($scope, $location, favFoodService){
	
	//Used to get the current object from the service
	var getFood = 2;
	
	//Pulls the data from the foodService
	$scope.editFood = favFoodService.getSetFood(getFood);
	
	//Populates the form with the data form getSetFood
	$scope.editFoodName = $scope.editFood.name;
	$scope.editVendor 	= $scope.editFood.vendorName;
	$scope.editCategory	= $scope.editFood.category;
	
	/*
	 *Creates a new object with data from the form and calls the 
	 *editFood service to merge the new data with the existing data 
	 */
	$scope.newFood = function newFood(foodId){
		
		console.log(foodId);
		
		var data = ({
				foodId:		foodId,
				name: 		$scope.editFoodName,
				vendorName:	$scope.editVendor,
				category: 	$scope.editCategory,
		});
		
		favFoodService.editFood(data);
		
		$location.path('/favFood');
	
	}
}]);