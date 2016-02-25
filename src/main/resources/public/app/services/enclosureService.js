angular.module('app').service('enclosureService', ['$http', 
function($http){
	
	var currentEnclosure;
	
	function getAllEnclosures(){
		
		return $http.get('/viewEnclosure')
		
	}

	function deleteEnclosures(enclosureId){
		
		console.log(enclosureId);
		
		return $http.delete('/deleteEnclosure/'+enclosureId);
		
	}
	
	function getSetEnclosure(num, enclosure){
		
		if(num == 1){
			currentEnclosure = enclosure;
		}
		else if (num == 2){
			return currentEnclosure;
		}
		
	}
	
	function editEnclosure(editedEnclosure){
		return $http.put("/editEnclosure", editedEnclosure);
	}

	
	return {
		
    	getAllEnclosures : getAllEnclosures,
    	deleteEnclosures : deleteEnclosures,
    	getSetEnclosure : getSetEnclosure,
    	editEnclosure : editEnclosure
    	
    };
	
}]);	

	