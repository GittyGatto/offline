var offlineApp = angular.module('offlineApp');
		
offlineApp.factory('ProjectResource', [ '$resource', function($resource) {
	return $resource('/projects/:id', null, {
		'update' : {
			method : 'PUT'
		}
	});
} ]);
