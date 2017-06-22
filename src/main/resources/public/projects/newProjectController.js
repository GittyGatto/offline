(function() {
    'use strict';
    angular.module('offlineApp').controller('NewProjectController', NewProjectController);

    NewProjectController.$inject = [ '$scope', 'ProjectResource', '$state', '$stateParams', 'myService' ];

    /* @ngInject */
    function NewProjectController($scope, ProjectResource, $state, $stateParams, myService) {
        var newProjectCtrl = this;
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

