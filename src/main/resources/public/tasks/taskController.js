(function() {
	'use strict';
	angular.module('offlineApp').controller('TaskController', TaskController);

	TaskController.$inject = [ '$scope', 'TaskResource', '$state', '$stateParams' ];

	/* @ngInject */
	function TaskController($scope, TaskResource, $state, $stateParams) {
		var taskCtrl = this;
		var taskId = $stateParams.taskId;
		
		taskCtrl.task = [];
		
		activate();

		function activate() {
			taskCtrl.task = TaskResource.get({
				taskId : taskId
			});
		}
	}
})();