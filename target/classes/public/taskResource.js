var offlineApp = angular.module('offlineApp');
		
offlineApp.factory('TaskResource', [ '$resource', function($resource) {
	return $resource('/task/:id', null, {
		'update' : {
			method : 'PUT'
		}
	});
} ]);
