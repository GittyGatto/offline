(function() {
	'use strict';

	angular.module('offlineApp')
			.controller('DashboardController', DashboardController);

	DashboardController.$inject = [ 'ProjectResource', '$scope', '$timeout'  ];

	/* @ngInject */
	function DashboardController($scope, ProjectResource, $timeout) {

		function greetings() {
			
		}
		
		greetings();
	}
})();
