angular.module('app').controller('enclosureCtrl', ['$scope', '$http', '$location', 'enclosureService', 
function($scope, $http, $location, enclosureService){
	
	$scope.toggleSelect 		= 0;
	$scope.enclosureStatus 		= "Show Enclosures";
	
	/*
	 * newEnclosure creates an object from data provided by the user and passes
	 * it into the EnclosureWebService to be added into the database
	 */
	$scope.newEnclosure = function newEnclosure(){
		
		var data = ({
				enclosureName: 		$scope.enclosureName,
				animal: 			$scope.enclosureAnimals,
				numberOfAnimals: 	$scope.enclosureNumAnimals,
				feedingTime: 		$scope.enclosureFeedTime,
				condition: 			$scope.enclosureCondition
		});
		
		$http.post("/addEnclosure", data).success(function(status){

			alert("success");
			
			$scope.enclosureName		= "";
			$scope.enclosureAnimals		= "";
			$scope.enclosureNumAnimals	= "";
			$scope.enclosureFeedTime	= "";
			$scope.enclosureCondition	= "";

		}).error(function(){
			
			alert("failure");
			
		})
		
		
		
	}
	
	$scope.viewEnclosures = function viewEnclosures(){
		
		enclosureService.getAllEnclosures().then(function(data){
			
			return $scope.enclosureObjects = data.data;
			
		});
		
	}
	
	$scope.toggle = function(){
		$scope.showTable = !$scope.showTable;
		
		if($scope.toggleSelect == 1){
			$scope.enclosureStatus = "Show Enclosures";
			$scope.toggleSelect--;
			console.log($scope.toggleSelect);
		}
		else{
			$scope.enclosureStatus = "Hide Enclosures";
			$scope.toggleSelect++;
		}
		
	}
	
	$scope.modifyRow = function(){
		
		console.log("hello");
		
	}
	
	$scope.deleteEnclosure = function(id){
		
		enclosureService.deleteEnclosures(id);
		
	}
	
	$scope.updateEnclosure = function(enclosure){
		
		var getEnclosure = 1;
		var setEnclosure = 2;
		
		console.log(enclosure);
		
		enclosureService.getSetEnclosure(getEnclosure, enclosure);
		
		$location.path('/editEnclosure');
		
	}
	
}]);

















