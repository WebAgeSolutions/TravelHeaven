//Service code goes here
angular.module("TravelApp")
.factory("LoginSvc", function($http) {
	var svc = {};
	
	svc.login = function(userId, password) {
		return $http.post("/TravelHeaven/auth/login", {
			userName: userId,
			password: password
		});
	}
	
	svc.logout = function() {
		return $http.post("/TravelHeaven/auth/logout");
	}

	return svc;
});