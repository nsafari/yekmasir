app.service('userService', ['$http', 'webAPISetting', 'User', function ($http, webAPISetting, User) {

    var serviceBase = webAPISetting.apiServiceBaseUri;

    this.GetUsers = function () {
        return $http.get(serviceBase + '/user');
    };

    this.RegisterUser = function (user) {
        return $http.post(serviceBase + '/user/registerUser', user);
    }

    this.Login = function (user) {
        return $http.post(serviceBase + '/user/login', user);
    }

}]);