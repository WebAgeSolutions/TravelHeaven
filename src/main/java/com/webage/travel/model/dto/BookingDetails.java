package com.webage.travel.model.dto;

import com.webage.travel.model.entity.Booking;
import com.webage.travel.model.entity.TravelPackage;

public class BookingDetails {
	private Booking booking;
	private TravelPackage travelPackage;
	
	public Booking getBooking() {
		return booking;
	}
	public void setBooking(Booking booking) {
		this.booking = booking;
	}
	public TravelPackage getTravelPackage() {
		return travelPackage;
	}
	public void setTravelPackage(TravelPackage travelPackage) {
		this.travelPackage = travelPackage;
	}
}
