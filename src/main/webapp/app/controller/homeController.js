app.controller("homeController", ['$scope', '$rootScope', function ($scope, $rootScope) {

    $scope.isAuthenticated = function () {
        if (($rootScope.LogginedUser != undefined) &&
            ($rootScope.LogginedUser != null))
            return true;
        else
            return false;
    }

}]);