angular.module('app').controller('enclosureCtrl', ['$scope', '$http', '$uibModal', 'enclosureService', 
function($scope, $http, $uibModal, enclosureService){
	
	$scope.toggleSelect 		= 0;
	$scope.enclosureStatus 		= "Show Enclosures";
	$scope.animationsEnabled 	= true;
	
	
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
		
		console.log(id);
		
		enclosureService.deleteEnclosures(id);
		
	}
	
	$scope.open = function(enclosure) {
		
		console.log(enclosure);
		
		var modalInstance = $uibModal.open({
			animation: $scope.animationsEnabled,
			templateUrl: 'myModalContent.html',
			controller: 'ModalInstanceCtrl',
			resolve:{
				
			}
		});
		
	};
	
	$scope.toggleAnimation = function () {
		$scope.animationsEnabled = !$scope.animationsEnabled;
	};
	
}]);



angular.module('app').controller('ModalInstanceCtrl', [ '$scope', '$uibModalInstance', 'enclosureService', 'enclosureId',
function ($scope, $uibModalInstance, enclosureService, enclosureId) {

	$scope.cancel = function () {
		
		$uibModalInstance.dismiss('cancel');
		
	};
	
	$scope.updateEnclosure = function(enclosure){
		
		console.log(enclosure);
		
		var enclosure = ({
			enclosureName: 		$scope.updateEnclosureName,
			animal: 			$scope.updateEnclosureAnimals,
			numberOfAnimals: 	$scope.updateEnclosureNumAnimals,
			feedingTime: 		$scope.updateEnclosureFeedTime,
			condition:			$scope.updateEnclosureCondition
		});
		
		console.log(enclosure);
		
		enclosureService.updateEnclosures(enclosure);
		
	}
	
}]);

















