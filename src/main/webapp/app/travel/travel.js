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
.config(function ($httpProvider) {
	$httpProvider.interceptors.push(function($q) {
		  return {
		    'responseError': function(response) {
		    		if (response.status === 401) {
		    			document.location = "login.html";
		    		}
		    		
		    		return $q.reject(response);
		    }
		  };
		});	
})