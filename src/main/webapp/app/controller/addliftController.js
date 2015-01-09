'use strict';
app.controller('addliftController', ['$scope', '$rootScope', '$location', 'Lift', 'liftService',
function ($scope, $rootScope, $location, Lift, liftService) {

    $scope.lift = new Lift();

    $scope.OneOffYear = '1393';
    $scope.OneOffMonth = '01';
    $scope.OneOffDay = '01';
    
    $scope.DepartureFlexibilityHour = '00';
    $scope.DepartureFlexibilityMinute = '00';

    $scope.ArrivalTimeHour = '00';
    $scope.ArrivalTimeMinute = '00';

    $scope.addLift = function () {
        if (!$scope.addliftform.$invalid) {

            $scope.lift.shamsiDate = $scope.OneOffYear + $scope.OneOffMonth + $scope.OneOffDay;
            $scope.lift.departureFlexibility = $scope.DepartureFlexibilityHour + $scope.DepartureFlexibilityMinute;
            $scope.lift.arrivalTime = $scope.ArrivalTimeHour + $scope.ArrivalTimeMinute;

            liftService.AddLift($scope.lift)
                .then(function (result) {
                    alert('added');
                });
        }
        else {
            alert('Invalid');
        }
    };
}]);
