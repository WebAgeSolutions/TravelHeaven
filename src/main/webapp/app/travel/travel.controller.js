//Controller code goes here
angular.module("TravelApp")
.controller("LoginController", function(LoginService) {
	this.userName = "";
	this.password = "";
	this.errorMessage = undefined;
	
	this.login = function() {
		var self = this;
		
		LoginService.login(this.userName, this.password).then(
				function(response) {
					if (response.status === 204) {
						document.location = "index.html";
					} else {
						self.errorMessage = "Login failed.";
					}
				},
				function() {
					self.errorMessage = "Login failed.";
				}
		);
	}
})
.controller("PackageListController", function(BookingService) {
	this.packageList = undefined;
	
	this.init = function() {
		var self = this;
		
		BookingService.fetchPackageList().then(function(response) {
			self.packageList = response.data;
		});
	}
	
	this.init();
});