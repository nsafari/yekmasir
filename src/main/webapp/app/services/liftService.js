app.service('liftService', ['$http', 'webAPISetting', 'Lift', function ($http, webAPISetting, Lift) {

    var serviceBase = webAPISetting.apiServiceBaseUri;

    this.GetLifts = function () {
        return $http.get(serviceBase + '/lift');
    };

    this.AddLift = function (lift) {
        return $http.post(serviceBase + '/lift/AddLift', lift);
    }

}]);