var offlineApp = angular.module('offlineApp');

offlineApp.controller('ProjectController', ProjectController,  
		[ 'ProjectResource' ]);

function ProjectController($scope, ProjectResource, $timeout) {

	var model = {
			projectsFromList : [],
		};
	
	function getProjects() {
		ProjectResource.query(onSuccess, onFailure);
		function onSuccess(projectList) {
			model.projectsFromList = projectList;
		}
		function onFailure() {
		}
	}
	
	$scope.model = model;
	getProjects();
}