(function() {
	'use strict';
	angular.module('offlineApp').controller('NewTaskController', NewTaskController);

	NewTaskController.$inject = [ '$scope', 'TaskResource', '$stateParams' ];

	/* @ngInject */
	function NewTaskController($scope, TaskResource, $stateParams) {
		$scope.addTask = addTask;
        $scope.projectId = $stateParams.projectId;

		function addTask(){
			var task = {
				name: $scope.name,
				projectId: $stateParams.projectId
			}
			TaskResource.save(task);
		}
	}
})();
