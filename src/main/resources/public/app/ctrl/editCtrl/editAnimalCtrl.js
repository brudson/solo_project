angular.module('app').controller('editAnimalCtrl', ['$scope', '$location', 'animalService', 
function($scope, $location, animalService){
	
	//Used to get the current object from the service
	var getAnimal = 2;
	
	//Pulls the data from the animalService
	$scope.editAnimal = animalService.getSetAnimal(getAnimal);
	
	//Populates the form with the data form getSetAnimal
	$scope.editAnimalName 		= $scope.editAnimal.name;
	$scope.editScientificName 	= $scope.editAnimal.scientificName;
	$scope.editFavoriteFood		= $scope.editAnimal.favFood;
	$scope.editInformationLink 	= $scope.editAnimal.infoLink;
	
	/*
	 *Creates a new object with data from the form and calls the 
	 *editAnimal service to merge the new data with the existing data 
	 */
	$scope.newAnimal = function newAnimal(animalId){
		
		console.log(animalId);
		
		var data = ({
				animalId:		animalId,
				name: 			$scope.editAnimalName,
				scientificName: $scope.editScientificName,
				favFood: 		$scope.editFavoriteFood,
				infoLink: 		$scope.editInformationLink
		});
		
		animalService.editAnimal(data);
		
		$location.path('/animals');
	
	}
}]);