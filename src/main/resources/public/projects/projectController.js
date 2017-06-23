(function() {
	'use strict';
	angular.module('offlineApp').controller('ProjectController',
			ProjectController);

	ProjectController.$inject = [ 'TaskResource', '$scope', 'ProjectResource', '$stateParams', 'myService', 'TaskResource' ];

	/* @ngInject */
	function ProjectController(TaskResource, $scope, ProjectResource,
			$stateParams, myService) {
		var projectId = $stateParams.projectId;

		$scope.myService = myService;
		$scope.myService.projects = {};
		$scope.delTask = delTask;

		activate();

		function activate() {
			$scope.myService.projects = ProjectResource.get({
				projectId : projectId
			});
		}

		function delTask(taskId, index){
            TaskResource.remove(taskId);
            $scope.myService.projects.tasks.splice(index, 1);
        }
	}
})();