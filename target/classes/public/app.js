angular.module('offlineApp', [ 'ui.router', 'ngResource' ]).config(
		[ '$stateProvider', '$urlRouterProvider',
				function($stateProvider, $urlRouterProvider) {

					$stateProvider.state('dashboard', {
						url : '/',
						templateUrl : 'dashboard/dashboard.html',
						controller : 'DashboardController',
						controllerAs : 'dashboardCtrl'
					});
					$stateProvider.state('project', {
						url : '^/project/{projectId}',
						templateUrl : 'projects/project.html',
						controller : 'ProjectController',
						controllerAs : 'projectCtrl'
					});
					$stateProvider.state('project.task', {
						url : '/task/{taskId}',
						templateUrl : '/tasks/taskdetails.html',
						controller : 'TaskController',
						controllerAs : 'taskCtrl'
					});

					$urlRouterProvider.otherwise('/');

				}//
		])//

.config([ '$resourceProvider', function($resourceProvider) {
	// Don't strip trailing slashes from calculated URLs
	$resourceProvider.defaults.stripTrailingSlashes = false;
} ]) //
;

