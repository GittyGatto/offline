angular.module('offlineApp', [ 'ui.router', 'ngResource' ]).config(
		[ '$stateProvider', '$urlRouterProvider',
				function($stateProvider, $urlRouterProvider) {

					$stateProvider.state('dashboard', {
						url : '/',
						templateUrl : 'dashboard/dashboard.html',
						controller : 'DashboardController',
						controllerAs : 'dashboardCtrl'
					});

					$urlRouterProvider.otherwise('/');

				}//
		])//


.config([ '$resourceProvider', function($resourceProvider) {
	// Don't strip trailing slashes from calculated URLs
	$resourceProvider.defaults.stripTrailingSlashes = false;
} ]) //
;

