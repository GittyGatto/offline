(function() {
    'use strict';
    angular.module('offlineApp').controller('NewProjectController', NewProjectController);

    NewProjectController.$inject = [ '$scope', 'ProjectResource', 'myService' ];

    /* @ngInject */
    function NewProjectController($scope, ProjectResource, myService) {
        $scope.addProject = addProject;
        
        $scope.myService = myService;
        $scope.myService.projects = {};

        function addProject(){
            var project = {
                name: $scope.name,
            }
            $scope.myService.projects = ProjectResource.save(project);
        }
    }
})();

