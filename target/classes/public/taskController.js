var offlineApp = angular.module('offlineApp');


offlineApp.controller('TaskController', TaskController,  
		[ 'TaskResource' ]);

function TaskController($scope, TaskResource, $timeout) {

	var model = {
			tasksFromList : [],
		};
	
	function getTasks() {
		TaskResource.query(onSuccess, onFailure);
		function onSuccess(taskList) {
			model.tasksFromList = taskList;
		}
		function onFailure() {
		}
	}
	
	$scope.model = model;
	getTasks();
}