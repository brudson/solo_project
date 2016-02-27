angular.module('app').controller('enclosureCtrl', ['$scope', '$http', '$location', 'enclosureService', 
function($scope, $http, $location, enclosureService){
	
	//Used in the toggle function to determine text output
	$scope.toggleSelect 		= 0;
	//Defaults the Show Enclosure button to Show Enclosure on page load
	$scope.enclosureStatus 		= "Show Enclosures";
	
	/*
	 * newEnclosure creates an object from data provided by the user and passes
	 * it into the EnclosureWebService to be added into the database
	 */
	$scope.newEnclosure = function newEnclosure(){
		
		//Creates the object form the front end to send to the database
		var data = ({
				enclosureName: 		$scope.enclosureName,
				animal: 			$scope.enclosureAnimals,
				numberOfAnimals: 	$scope.enclosureNumAnimals,
				feedingTime: 		$scope.enclosureFeedTime,
				condition: 			$scope.enclosureCondition
		});
		
		//Sends the data object to the /addEnclosure webservice
		$http.post("/addEnclosure", data).success(function(status){
		
			alert("success");
			
			//clears the form after a successful submit
			$scope.enclosureName		= "";
			$scope.enclosureAnimals		= "";
			$scope.enclosureNumAnimals	= "";
			$scope.enclosureFeedTime	= "";
			$scope.enclosureCondition	= "";

		}).error(function(){
			
			alert("failure");
			
		})
		
	}
	
	/*
	 * Gets all the enclosures from the database and pulls
	 * them out of the promise to give $scope.enclosureObjects
	 * and array of objects that is easier to pull from
	 */
	
	$scope.viewEnclosures = function viewEnclosures(){
		
		enclosureService.getAllEnclosures().then(function(data){
			
			return $scope.enclosureObjects = data.data;
			
		});
		
	}
	
	/*
	 * Shows and hides all the data from viewEnclosures
	 */
	$scope.toggle = function(){
		
		//Interacts with ng-hide to make the table alternate on the front end
		$scope.showTable = !$scope.showTable;
		
		if($scope.toggleSelect == 1){
			$scope.enclosureStatus = "Show Enclosures";
			$scope.toggleSelect--;
		}
		else{
			$scope.enclosureStatus = "Hide Enclosures";
			$scope.toggleSelect++;
		}
		
	}
	
	/*
	 * Calls the deleteEnclosure fomr enclosureService and passes in the id
	 * to be deleted from the database
	 */
	$scope.deleteEnclosure = function(id){
		
		enclosureService.deleteEnclosures(id);
		
	}
	
	/*
	 * Gets and sets the current object for editing when the pages controller 
	 * is changed
	 */
	$scope.updateEnclosure = function(enclosure){
		
		var setEnclosure = 1;
		
		console.log(enclosure);
		
		enclosureService.getSetEnclosure(setEnclosure, enclosure);
		
		$location.path('/editEnclosure');
		
	}
	
}]);

















