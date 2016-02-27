angular.module('app').service('animalService', ['$http',
function($http){
	
	/*
	 * initializes the currentAnimal so it does not get deleted when
	 * the function is called
	 */
	var currentAnimal;
	
	//Gets all animals in the database
	function getAllAnimals(){
		
		return $http.get('/viewAnimal')
		
	}

	//Deletes an animal based on the Id passed through
	function deleteAnimal(animalId){
		console.log("deleting animal");
		return $http.delete('/deleteAnimal/'+animalId);
		
	}
	
	/*
	 * holds onto the current enclosure while the pages are changed
	 * and the gets called by the enclosureCtrl
	 */
	function getSetAnimal(num, animal){
		
		if(num == 1){
			currentAnimal = animal;
		}
		else if (num == 2){
			return currentAnimal;
		}
		
	}
	
	
	//Edits an existing enclosure in the database
	function editAnimal(editedAnimal){
		console.log(editedAnimal);
		return $http.put("/editAnimal", editedAnimal);
	}

	
	return {
		
    	getAllAnimals : getAllAnimals,
    	deleteAnimal : deleteAnimal,
    	getSetAnimal : getSetAnimal,
    	editAnimal : editAnimal
    	
    };
    
}]);