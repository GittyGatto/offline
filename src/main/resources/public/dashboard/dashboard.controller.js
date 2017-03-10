(function() {
	'use strict';

	angular.module('offlineApp').controller('DashboardController',
			DashboardController);

	DashboardController.$inject = [ 'ProjectResource', '$state' ];

	/* @ngInject */
	function DashboardController(ProjectResource, $state) {

		var model = {
			projectsFromList : []
		};

		function getProjects() {
			model.projectsFromList = projectList;
		}

		$scope.model = model;
		getProjects();

	}
})();
