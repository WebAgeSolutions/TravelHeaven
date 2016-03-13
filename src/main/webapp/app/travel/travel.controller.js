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
	
	this.bookPackage = function(p) {
		var forDateStr = "" + (p.forDate.getMonth() + 1) + "/" + p.forDate.getDate() + "/" + p.forDate.getFullYear();
		
		BookingService.bookPackage({
			packageId: p.packageId,
			forDate: forDateStr
		}).then(function() {
			alert("Package was added to your booking.");
		})
	}
	
	this.init = function() {
		var self = this;
		
		BookingService.fetchPackageList().then(function(response) {
			self.packageList = response.data;
		});
	}
	
	this.init();
})
.controller("BookedItemsController", function(BookingService) {
	this.bookedItems = undefined;
	
	this.cancelBooking = function(bookingId) {
		var self = this;

		BookingService.cancelBooking(bookingId).then(function() {
			//Reload the booked items
			self.init();
		});
	}
	
	this.init = function() {
		var self = this;
		
		BookingService.getBookedPackages().then(function(response) {
			self.bookedItems = response.data;
		});
	}
	
	this.init();
});