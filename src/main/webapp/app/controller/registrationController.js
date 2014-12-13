'use strict';
app.controller('registrationController', ['$scope', '$rootScope', 'User', 'userService',
function($scope, $rootScope, User, userService) {

    $scope.user = new User();
    $scope.isRegistered = false;

    $scope.register = function() {

        userService.RegisterUser($scope.user)
            .then(function(result) {
                $scope.isRegistered = true;
            });
    };
} ]);