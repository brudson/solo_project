angular.module('app').service('enclosureService', ['$http', 
function($http){
	
	function getAllEnclosures(){
		
		return $http.get('/viewEnclosure')
		
	}
	
	function updateEnclosures(enclosure){
		console.log("im in the service");
		console.log(enclosure);
	}
	
	function deleteEnclosures(id){
		
		
	}
	
	return {
		
    	getAllEnclosures : getAllEnclosures,
    	deleteEnclosures : deleteEnclosures,
    	updateEnclosures : updateEnclosures
    	
    };
	
}]);	

	