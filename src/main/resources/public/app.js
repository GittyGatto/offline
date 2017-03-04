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
						url : '/project',
						templateUrl : 'projects/project.html',
						controller : 'ProjectController',
						controllerAs : 'projectCtrl'
					});
					$stateProvider.state('task', {
						url : '/task',
						templateUrl : 'tasks/task.html',
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

