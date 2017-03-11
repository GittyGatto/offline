(function() {
	'use strict';

	angular.module('offlineApp').controller('DashboardController',
			DashboardController);

	DashboardController.$inject = [ 'ProjectResource', '$state' ];

	/* @ngInject */
	function DashboardController(ProjectResource, $scope, $state) {
		var dashboardCtrl = this;
		
		dashboardCtrl.projects = [];
		
		function getProjects() {
			dashboardCtrl.projects = ProjectResource.query();
		}

		getProjects();
	}
})();
