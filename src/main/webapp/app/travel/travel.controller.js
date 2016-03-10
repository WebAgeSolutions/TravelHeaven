//Controller code goes here
angular.module("TravelApp")
.controller("LoginController", function(LoginSvc) {
	this.userName = "";
	this.password = "";
	this.errorMessage = undefined;
	
	this.login = function() {
		LoginSvc.login(this.userName, this.password).then(
				function(response) {
					if (response.status === 204) {
						document.location = "index.html";
					} else {
						this.errorMessage = "Login failed.";
					}
				},
				function() {
					this.errorMessage = "Login failed.";
				}
		);
	}
});