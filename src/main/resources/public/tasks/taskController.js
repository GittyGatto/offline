(function() {
	'use strict';
	angular.module('offlineApp').controller('TaskController', TaskController);

	TaskController.$inject = ['TaskResource', '$stateParams' ];

	/* @ngInject */
	function TaskController(TaskResource, $stateParams) {
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