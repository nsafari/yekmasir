'use strict';
app.factory('User', function () {
    var User = function (data) {
        angular.extend(this, {
            name: null,
            family: null,
            email: null,
            password: null,
            gender:null
        });
        angular.extend(this, data);
    };

    return User;
});