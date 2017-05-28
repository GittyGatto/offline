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
		
		var model = {
				tasksFromList : []
			};

		function activate() {
			taskCtrl.task = TaskResource.get({
				taskId : taskId
			});
		}
		
		function addNewTask(){
			var task = {
				name : model.name,
				projectId : model.projectId
			};		
			TaskResource.save(task);
		}
	}
})();