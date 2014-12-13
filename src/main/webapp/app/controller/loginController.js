'use strict';
app.controller('loginController', ['$scope', '$rootScope', '$location', 'User', 'userService',
function ($scope, $rootScope, $location, User, userService) {

    $scope.user = new User();

    $scope.login = function () {
        if (!$scope.loginform.$invalid) {
            userService.Login($scope.user)
                .then(function (result) {
                    $rootScope.LogginedUser = result;
                    $location.path('#');
                });
        }
    };
}]);