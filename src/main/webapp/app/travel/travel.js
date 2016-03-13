//Main module goes here
angular.module("TravelApp", ["ngRoute"])
.config(function ($routeProvider) {
    $routeProvider.when("/package-list", {
        templateUrl: "app/travel/package_list.tpl.html"
    })
    .when("/booked-items", {
        templateUrl: "app/travel/booked_items.tpl.html"
    })
    .otherwise("/package-list");
})