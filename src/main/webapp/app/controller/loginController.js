'use strict';
app.controller('loginController', ['$scope', '$rootScope', '$window', '$location', 'User', 'userService',
function ($scope, $rootScope, $window, $location, User, userService) {

    $scope.user = new User();

    $scope.login = function () {
        if (!$scope.loginform.$invalid) {
            userService.Login($scope.user)
                .then(function (result) {
                    $rootScope.LogginedUser = result;
                    if($location.path() === "/login"){
                        $location.path('#');
                    }else{
                        $window.location.reload();
                    }

                }, function(result){
                    console.log(result.data);
                });
        }
    };
}]);