package com.webage.travel.service;

import java.util.List;

import javax.ejb.EJB;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.webage.travel.model.dao.PackageDAO;
import com.webage.travel.model.dto.BookingDetails;
import com.webage.travel.model.entity.Booking;
import com.webage.travel.model.entity.TravelPackage;

@Path("/booking")
public class BookingService {
	@EJB
	PackageDAO pDAO;
	
	@GET
	@Path("/package")
	@Produces(MediaType.APPLICATION_JSON)
	public List<TravelPackage> getAllPackages() {
		return pDAO.getAllPackages();
	}
	
	@GET
	@Path("/package/{packageId}")
	@Produces(MediaType.APPLICATION_JSON)
	public TravelPackage getAllPackage(@PathParam("packageId") long packageId, @Context final HttpServletResponse response) {
		TravelPackage p = pDAO.getPackageById(packageId);
		
		if (p == null) {
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
		}
		
		return p;
	}

	@POST
	@Path("/book-package")
	@Consumes(MediaType.APPLICATION_JSON)
	public void addToBooking(Booking b) {
		pDAO.addToBooking(b);
	}

	@GET
	@Path("/user/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<BookingDetails> getUserBookings(@PathParam("userId") String userId) {
		return pDAO.getUserBookings(userId);
	}
}
