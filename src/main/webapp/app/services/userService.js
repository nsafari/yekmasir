app.service('userService', ['$http', 'webAPISetting', 'User', function ($http, webAPISetting, User) {

    var serviceBase = webAPISetting.apiServiceBaseUri;

    this.GetUsers = function () {
        return $http.get(serviceBase + '/user');
    };

    this.RegisterUser = function (user) {
        return $http.post(serviceBase + '/user/registerUser', user);
    }

    var transform = function(data){
        return $.param(data);
    }

    this.Login = function (user) {
        return $http.post(serviceBase + '/user/login', {username: user.email, password: user.password},{
            headers: { 'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'},
            transformRequest: transform
        });
    }

}]);