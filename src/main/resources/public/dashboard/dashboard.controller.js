(function() {
    'use strict';

    angular.module('offlineApp').controller('DashboardController', DashboardController);

    DashboardController.$inject = [ 'ProjectResource', '$scope', '$state', '$stateParams', 'myService' ];

    /* @ngInject */
    function DashboardController(ProjectResource, $scope, $state, $stateParams, myService) {
        var dashboardCtrl = this;

        $scope.myService = myService;
        $scope.myService.projects = [];

        $scope.delProject = delProject;

        getProjects();

        function getProjects() {
            $scope.myService.projects = ProjectResource.query();
        }
        function delProject(projectId){                       
            ProjectResource.remove(projectId);
        }
    }
}
)();
