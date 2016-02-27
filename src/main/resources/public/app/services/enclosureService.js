angular.module('app').service('enclosureService', ['$http', 
function($http){
	
	/*
	 * initializes the currentEnclosure so it does not get deleted when
	 * the function is called
	 */
	var currentEnclosure;
	
	//Gets all enclosures in the database
	function getAllEnclosures(){
		
		return $http.get('/viewEnclosure')
		
	}

	//Deletes an eclosure based on the Id passed through
	function deleteEnclosures(enclosureId){
		
		return $http.delete('/deleteEnclosure/'+enclosureId);
		
	}
	
	/*
	 * holds onto the current enclosure while the pages are changed
	 * and the gets called by the enclosureCtrl
	 */
	function getSetEnclosure(num, enclosure){
		
		if(num == 1){
			currentEnclosure = enclosure;
		}
		else if (num == 2){
			return currentEnclosure;
		}
		
	}
	
	
	//Edits an existing enclosure in the database
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

	