var offlineApp = angular.module('offlineApp');

offlineApp.controller('ProjectController', ProjectController,
		[ 'ProjectResource' ]);

function ProjectController($scope, ProjectResource, $timeout) {

	var model = {
		projectsFromList : [],
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

	function getProjects() {
		clearMessage();
		ProjectResource.query(onSuccess, onFailure);
		function onSuccess(projectList) {
			model.projectsFromList = projectList;
		}
		function onFailure() {
			setMessage('Failed, can\'t get projects.', true);
		}
	}

	function delProject(projectId) {
		clearMessage();
		var project = {
			id : projectId
		};

		ProjectResource.remove(project, onSuccess, onFailure)

		function onSuccess() {
			getProjects();
			setMessage('project deleted.', false, 2000);
		}
		function onFailure() {
			setMessage('Failed, can\'t remove project.', true);
		}

	}

	function updateProject(project) {
		clearMessage();
		ProjectResource.update(project, onSuccess, onFailure)
		function onSuccess() {
			setMessage('project updated.', false, 2000);
		}
		function onFailure() {

			setMessage('Failed, can\'t update project.', true);
		}
	}

	function addProject() {
		clearMessage();
		var project = {
			name : ""
		};
		ProjectResource.save(project, onSuccess, onFailure)
		function onSuccess(savedProject) {
			setMessage('project saved.', false, 2000);
			model.projectsFromList.push(savedProject);
		}
		function onFailure() {
			setMessage('Failed, can\'t save project.', true);
		}
	}

	

	$scope.delProject = delProject;
	$scope.updateProject = updateProject;
	$scope.addProject = addProject;
	$scope.model = model;
	getProjects();
}