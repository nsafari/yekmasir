﻿'use strict';
app.factory('Lift', function () {
    var Lift = function (data) {
        angular.extend(this, {
            OfferRequest: null,
            Frequency: null,
            ShamsiDate: null,
            DepartureFlexibility: null,
            Source: null,
            Destination: null,
            Places: null,
            Luggage: null,
            Vehicle: null,
            Smoker: null,
            Comment: null,
            PricePerSeat: null,
            Payment: null
        });
        angular.extend(this, data);
    };

    return Lift;
});