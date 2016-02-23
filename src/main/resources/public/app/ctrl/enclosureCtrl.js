angular.module('app').controller('enclosureCtrl', ['$scope', '$http',
function($scope, $http){
	
	$scope.welcome = "hey";
	
	
	$scope.newEnclosure = function newEnclosure(){
		var data = $.param({
			'enclosure': $scope.enclosureName,
			'enclosureAnimals': $scope.enclosureAnimals,
			'enclosureNumAnimals': $scope.enclosureNumAnimals,
			'enclosureFeedTime': $scope.enclosureFeedTime,
			'enclosureCondition': $scope.enclosureCondition
		});
		
		$http({
			method: 'POST',
			url: '/enclosure'
		}).then(function success(response){
			console.log(data);
		}, function error(response){
			alert("failure");
		});
		
		console.log(data);
	}
	
	
	
}]);