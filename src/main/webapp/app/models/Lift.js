'use strict';
app.factory('Lift', function () {
    var Lift = function (data) {
        angular.extend(this, {
            offerRequest: null,
            frequency: null,
            shamsiDate: null,
            departureFlexibility: null,
            source: null,
            destination: null,
            arrivalTime: null,
            places: null,
            luggagePerSeat: null,
            vehicle: null,
            smoker: null,
            comment: null,
            pricePerSeat: null,
            payment: null
        });
        angular.extend(this, data);
    };

    return Lift;
});
