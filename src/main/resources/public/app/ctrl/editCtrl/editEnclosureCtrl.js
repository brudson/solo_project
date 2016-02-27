angular.module('app').controller('editEnclosureCtrl', ['$scope', '$location', 'enclosureService', 
function($scope, $location, enclosureService){
	
	//Used to get the current object from the service
	var getEnclosure = 2;
	
	//Pulls the data from the enclosureService
	$scope.editEnclosure = enclosureService.getSetEnclosure(getEnclosure);
	
	
	//Populates the form with the data form getSetEnclosure
	$scope.editEnclosureName = $scope.editEnclosure.enclosureName;
	$scope.editEnclosureAnimals = $scope.editEnclosure.animal;
	$scope.editEnclosureNumAnimals = $scope.editEnclosure.numberOfAnimals;
	$scope.editEnclosureCondition = $scope.editEnclosure.condition;
	$scope.editEnclosureFeedTime = $scope.editEnclosure.feedingTime;
	
	/*
	 *Creates a new object with data from the form and calls the 
	 *editEnclosure service to merge the new data with the existing data 
	 */
	$scope.newEnclosure = function newEnclosure(enclosureId){
		
		var data = ({
				enclosureId:		enclosureId,
				enclosureName: 		$scope.editEnclosureName,
				animal: 			$scope.editEnclosureAnimals,
				numberOfAnimals: 	$scope.editEnclosureNumAnimals,
				feedingTime: 		$scope.editEnclosureFeedTime,
				condition: 			$scope.editEnclosureCondition
		});
		
		enclosureService.editEnclosure(data);
		
		$location.path('/enclosure');
	
	}
}]);