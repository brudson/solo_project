angular.module('app').controller('animalsCtrl', ['$scope', '$http', '$location', 'animalService',
function($scope, $http, $location, animalService){
	
	//Used in the toggle function to determine text output
	$scope.toggleSelect 		= 0;
	//Defaults the Show Animals button to Show Animals on page load
	$scope.animalStatus 		= "Show Animals";
	
	/*
	 * newAnimal creates an object from data provided by the user and passes
	 * it into the AnimalWebService to be added into the database
	 */
	$scope.newAnimal = function newAnimal(){
		
		//Creates the object form the front end to send to the database
		var data = ({
				name: 			$scope.animalName,
				scientificName: $scope.scientificName,
				favFood: 		$scope.favoriteFood,
				infoLink: 		$scope.informationLink
		});
		
		//Sends the data object to the /addAnimal webservice
		$http.post("/addAnimal", data).success(function(status){
		
			alert("success");
			
			//clears the form after a successful submit
			$scope.animalName		= "";
			$scope.scientificName	= "";
			$scope.favoriteFood		= "";
			$scope.informationLink	= "";

		}).error(function(){
			
			alert("failure");
			
		})
		
	}
	
	/*
	 * Gets all the animals from the database and pulls
	 * them out of the promise to give $scope.enclosureObjects
	 * and array of objects that is easier to pull from
	 */
	
	$scope.viewAnimals = function viewAnimals(){
		
		animalService.getAllAnimals().then(function(data){
			
			console.log(data);
			
			return $scope.animalObjects = data.data;
			
		});
		
	}
	
	/*
	 * Shows and hides all the data from viewAnimals
	 */
	$scope.toggle = function(){
		
		//Interacts with ng-hide to make the table alternate on the front end
		$scope.showTable = !$scope.showTable;
		
		if($scope.toggleSelect == 1){
			$scope.animalStatus = "Show Animals";
			$scope.toggleSelect--;
		}
		else{
			$scope.animalStatus = "Hide Animals";
			$scope.toggleSelect++;
		}
		
	}
	
	/*
	 * Calls deleteAnimal from animalService and passes in the id
	 * to be deleted from the database
	 */
	$scope.deleteAnimal = function(id){
		
		console.log("deleting animal");
		
		animalService.deleteAnimal(id);
		
	}
	
	/*
	 * Gets and sets the current object for editing when the pages controller 
	 * is changed
	 */
	$scope.updateAnimal = function(animal){
		
		var setAnimal = 1;
		
		console.log(animal);
		
		animalService.getSetAnimal(setAnimal, animal);
		
		$location.path('/editAnimal');
		
		
	}
	
}]);