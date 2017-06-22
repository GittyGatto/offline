(function() {
	'use strict';
	angular.module('offlineApp').controller('ProjectController',
			ProjectController);

	ProjectController.$inject = [ 'TaskResource', '$scope', 'ProjectResource',
			'$state', '$stateParams', 'myService' ];

	/* @ngInject */
	function ProjectController(TaskResource, $scope, ProjectResource, $state,
			$stateParams, myService) {
		var projectCtrl = this;
		var projectId = $stateParams.projectId;

		$scope.myService = myService;
		$scope.myService.project = {};

		activate();

		function activate() {
			$scope.myService.projects = ProjectResource.get({
				projectId : projectId
			});
		}
	}
})();