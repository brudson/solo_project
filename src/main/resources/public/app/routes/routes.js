angular.module('app').config(['$stateProvider', '$urlRouterProvider',
function($stateProvider, $urlRouteProvider){
	
	$urlRouteProvider.otherwise('/home');
	
	$stateProvider
	
	.state('enclosure',{
		url: '/enclosure',
		templateUrl: 'views/partials/enclosure.html',
		controller: 'enclosureCtrl'
	}).state('animals',{
		url: '/animals',
		templateUrl: 'views/partials/animals.html',
		controller: 'animalsCtrl'
	}).state('favFood',{
		url: '/favFood',
		templateUrl: 'views/partials/favFood.html',
		controller: 'favFoodCtrl'
	}).state('editEnclosure',{
		url: '/editEnclosure',
		templateUrl: 'views/partials/editPages/editEnclosure.html',
		controller: 'editEnclosureCtrl'
	}).state('editAnimal',{
		url: '/editAnimal',
		templateUrl: 'views/partials/editPages/editAnimal.html',
		controller: 'editAnimalCtrl'
	}).state('editFood',{
		url: '/editFood',
		templateUrl: 'views/partials/editPages/editFoods.html',
		controller: 'editFavFoodCtrl'
	});
}]);