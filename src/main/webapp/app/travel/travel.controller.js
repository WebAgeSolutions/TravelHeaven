//Controller code goes here
angular.module("TravelApp")
.controller("LoginController", function(LoginSvc) {
	this.userName = "";
	this.password = "";
	this.errorMessage = undefined;
	
	this.login = function() {
		var self = this;
		
		LoginSvc.login(this.userName, this.password).then(
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
});