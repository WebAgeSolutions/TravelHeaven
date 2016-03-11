//Main module goes here
angular.module("TravelApp", ["ngRoute"])
.config(function ($routeProvider) {
    $routeProvider.when("/package-list", {
        templateUrl: "app/travel/package_list.tpl.html"
    })
    /*
    .when("/shipping", {
        templateUrl: "ship.html"
    })
    */
    .otherwise("/package-list");
})