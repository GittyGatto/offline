(function() {
    'use strict';

    angular.module('offlineApp').controller('DashboardController', DashboardController);

    DashboardController.$inject = [ 'ProjectResource', '$scope', '$state', '$stateParams' ];

    /* @ngInject */
    function DashboardController(ProjectResource, $scope, $state, $stateParams) {
        var dashboardCtrl = this;

        dashboardCtrl.projects = [];

        $scope.delProject = delProject;

        getProjects();

        function getProjects() {
            dashboardCtrl.projects = ProjectResource.query();
        }
        function delProject(projectId){
                       
            ProjectResource.remove(projectId);
        }
    }
}
)();
