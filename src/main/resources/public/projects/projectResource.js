var offlineApp = angular.module('offlineApp');
		
offlineApp.factory('ProjectResource', [ '$resource', function($resource) {
	return $resource('/project/:id', null, {
		'update' : {
			method : 'PUT'
		}
	});
} ]);
