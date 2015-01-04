'use strict';
app.controller('addliftController', ['$scope', '$rootScope', '$location', 'Lift', 'liftService',
function ($scope, $rootScope, $location, Lift, liftService) {

    $scope.lift = new Lift();

    $scope.OneOffYear = '1393';
    $scope.OneOffMonth = '01';
    $scope.OneOffDay = '01';
    
    $scope.addLift = function () {
        if (!$scope.addliftform.$invalid) {
            liftService.AddLift($scope.lift)
                .then(function (result) {
                    alert('added');
                });
        }
    };
}]);
