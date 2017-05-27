(function() {
    'use strict';
    angular.module('offlineApp').controller('NewProjectController', NewProjectController);

    NewProjectController.$inject = [ '$scope', 'ProjectResource', '$state', '$stateParams' ];

    /* @ngInject */
    function NewProjectController($scope, ProjectResource, $state, $stateParams) {
        var newProjectCtrl = this;
        $scope.addProject = addProject;

        function addProject(){
            var project = {
                name: $scope.name,
            }
            ProjectResource.save(project);
        }
    }
})();

