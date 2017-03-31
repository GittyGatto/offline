(function() {
	'use strict';
	angular.module('offlineApp').controller('ProjectController',
			ProjectController);

	ProjectController.$inject = [ '$scope', 'ProjectResource', '$state',
			'$stateParams', '$timeout' ];

	/* @ngInject */
	function ProjectController($scope, ProjectResource, $state, $stateParams,
			$timeout) {
		var projectCtrl = this;
		var projectId = $stateParams.projectId;

		projectCtrl.project = {};

		activate();

		function activate() {
			projectCtrl.project = ProjectResource.get({
				id : projectId
			});
		}
	}
})();