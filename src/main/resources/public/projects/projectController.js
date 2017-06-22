(function() {
	'use strict';
	angular.module('offlineApp').controller('ProjectController',
			ProjectController);

	ProjectController.$inject = [ 'TaskResource', '$scope', 'ProjectResource',
			'$state', '$stateParams', 'myService', 'TaskResource' ];

	/* @ngInject */
	function ProjectController(TaskResource, $scope, ProjectResource, $state,
			$stateParams, myService) {
		var projectCtrl = this;
		var projectId = $stateParams.projectId;

		$scope.myService = myService;
		$scope.myService.project = {};
		$scope.delTask = delTask;

		activate();

		function activate() {
			$scope.myService.projects = ProjectResource.get({
				projectId : projectId
			});
		}

		function delTask(taskId){
            TaskResource.remove(taskId);
        }
	}
})();