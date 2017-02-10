var offlineApp = angular.module('offlineApp');


offlineApp.controller('TaskController', TaskController,  
		[ 'TaskResource' ]);

function TaskController($scope, TaskResource, $timeout) {

	var model = {
			tasksFromList : [],
			message : null,
			isError : false
		};
	
	function setMessage(msg, isError, timeout) {
		model.message = msg;
		model.isError = isError;
		if (timeout) {
			$timeout(clearMessage, timeout);
		}
	}

	function clearMessage() {
		setMessage('', false);
	}
	
	function getTasks() {
		TaskResource.query(onSuccess, onFailure);
		function onSuccess(taskList) {
			model.tasksFromList = taskList;
		}
		function onFailure() {
		}
	}
	
	function addTask() {
		clearMessage();
		var task = {
			name : model.name,
			projectId : model.projectId
		};		
		
		TaskResource.save(task, onSuccess, onFailure)
		function onSuccess(savedTask) {
			setMessage('task saved.', false, 2000);
			model.tasksFromList.push(savedTask);
		}
		function onFailure() {
			setMessage('Failed, can\'t save task.', true);
		}
	}

	$scope.addTask = addTask;
	$scope.model = model;
	getTasks();
}