angular.module('offlineApp', [ 'ui.router', 'ngResource' ]).config(
		[ '$stateProvider', '$urlRouterProvider',
				function($stateProvider, $urlRouterProvider) {

					$stateProvider.state('dashboard', {
						url : '/',
						template : require('dashboard/dashboard.html'),
						controller : 'DashboardController',
						controllerAs : 'dashboardCtrl'
					});
					$stateProvider.state('project', {
						url : '^/project/:projectId',
								template : require('projects/project.html'),
								controller : 'ProjectController',
								controllerAs : 'projectCtrl'
						}
					);
					
					$stateProvider.state('project.task', {
						url : '/task/:taskId',
						views: {
							"@":{
								template : require('tasks/taskdetails.html'),
								controller : 'TaskController',
								controllerAs : 'taskCtrl'			
							}
						}
					});
					
					$stateProvider.state('project.newtask', {
						url : '^/project/:projectId',
						views: {
							"@":{
								template : require('tasks/newTask.html'),
								controller : 'NewTaskController',
								controllerAs : 'newTaskCtrl'
							}
						}
					});

					$urlRouterProvider.otherwise('/');

				}//
		])//

.config([ '$resourceProvider', function($resourceProvider) {
	// Don't strip trailing slashes from calculated URLs
	$resourceProvider.defaults.stripTrailingSlashes = false;
} ]) //
;

