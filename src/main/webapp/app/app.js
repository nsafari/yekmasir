﻿var app = angular.module('CarpoolingApp', ['ngRoute']);
var routeProvider = null;

app.config(function($routeProvider) {

    $routeProvider.when("/home", {
        controller: "homeController",
        templateUrl: "app/views/home.html"
    });

    $routeProvider.when("/login", {
        controller: "homeController",
        templateUrl: "app/views/login.html"
    });

    $routeProvider.when("/faq", {
        controller: "homeController",
        templateUrl: "app/views/faq.html"
    });

    $routeProvider.when("/search", {
        controller: "homeController",
        templateUrl: "app/views/search.html"
    });

    $routeProvider.when("/addlift", {
        controller: "addliftController",
        templateUrl: "app/views/addlift.html"
    });

    $routeProvider.when("/registration", {
        controller: "registrationController",
        templateUrl: "app/views/registration.html"
    });

    $routeProvider.otherwise({ redirectTo: "/home" });
});

app.factory('webAPISetting', ['$location', function($location){
    return {
        apiServiceBaseUri: $location.protocol() + '://'+ $location.host(),
        clientId: 'webAPISetting'
    }
}]);
