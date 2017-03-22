var offlineApp = angular.module('offlineApp');
		
offlineApp.factory('TaskResource', [ '$resource', function($resource) {
	return $resource('/task/:taskId', null, {
		'update' : {
			method : 'PUT'
		}
	});
} ]);
