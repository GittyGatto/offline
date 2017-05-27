var offlineApp = angular.module('offlineApp');
		
offlineApp.factory('ProjectResource', [ '$resource', function($resource) {
	return $resource('/project/:projectId', null, {
		'update' : {
			method : 'PUT'
		}
	});
} ]);
