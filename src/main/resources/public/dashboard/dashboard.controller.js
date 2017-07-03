(function() {
    'use strict';

    angular.module('offlineApp').controller('DashboardController', DashboardController);

    DashboardController.$inject = [ 'ProjectResource', '$scope', 'myService' ];

    /* @ngInject */
    function DashboardController(ProjectResource, $scope, myService) {
        $scope.myService = myService;
        $scope.myService.projects = [];

        $scope.delProject = delProject;
        $scope.numberOfProjects;

        init();

        function init(){
            getProjects();
            getNumberOfProjects();
        }

        function getProjects() {
            $scope.myService.projects = ProjectResource.query();
        }

        function delProject(projectId, index){
            ProjectResource.remove(projectId);
            $scope.myService.projects.splice(index, 1)
        }

        function getNumberOfProjects(){

        }
    }
}
)();
