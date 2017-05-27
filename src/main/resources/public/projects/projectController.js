(function() {
	'use strict';
	angular.module('offlineApp').controller('ProjectController',
			ProjectController);

	ProjectController.$inject = [ 'TaskResource', '$scope', 'ProjectResource', '$state',
			'$stateParams' ];

	/* @ngInject */
	function ProjectController(TaskResource, $scope, ProjectResource, $state, $stateParams) {
		var projectCtrl = this;
		var projectId = $stateParams.projectId;

		projectCtrl.project = {};

		activate();

		function activate() {
			projectCtrl.project = ProjectResource.get({
				projectId : projectId
			});
		}
	}
})();