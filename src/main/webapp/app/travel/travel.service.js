//Service code goes here
angular.module("TravelApp")
.factory("LoginService", function($http) {
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
})
.factory("BookingService", function($http) {
	var svc = {};
	
	svc.fetchPackageList = function() {
		return $http.get("/TravelHeaven/booking/package");
	};
	
	svc.bookPackage = function(packageToBook) {
		return $http.post("/TravelHeaven/booking/book-package", packageToBook);
	}
	
	svc.getBookedPackages = function() {
		return $http.get("/TravelHeaven/booking/book-package");
	}
	
	svc.cancelBooking = function(bookingId) {
		var url = "/TravelHeaven/booking/book-package/" + bookingId;
		
		return $http.delete(url);
	}
	
	return svc;
});