angular.module('app').controller('editEnclosureCtrl', ['$scope', '$location', 'enclosureService', 
function($scope, $location, enclosureService){
	
	var getEnclosure = 2;
	
	$scope.editEnclosure = enclosureService.getSetEnclosure(getEnclosure);
	
	console.log("editEnclosureCtrl");
	console.log($scope.editEnclosure);
	
	$scope.editEnclosureName = $scope.editEnclosure.enclosureName;
	$scope.editEnclosureAnimals = $scope.editEnclosure.animal;
	$scope.editEnclosureNumAnimals = $scope.editEnclosure.numberOfAnimals;
	$scope.editEnclosureCondition = $scope.editEnclosure.condition;
	$scope.editEnclosureFeedTime = $scope.editEnclosure.feedingTime;
	
	$scope.newEnclosure = function newEnclosure(enclosureId){
		
		var data = ({
				enclosureId:		enclosureId,
				enclosureName: 		$scope.editEnclosureName,
				animal: 			$scope.editEnclosureAnimals,
				numberOfAnimals: 	$scope.editEnclosureNumAnimals,
				feedingTime: 		$scope.editEnclosureFeedTime,
				condition: 			$scope.editEnclosureCondition
		});
		
		console.log(data);
		
		enclosureService.editEnclosure(data);
		
		$location.path('/enclosure');
	
	}
}]);