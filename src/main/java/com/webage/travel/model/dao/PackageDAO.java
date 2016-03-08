package com.webage.travel.model.dao;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.sql.DataSource;

import com.webage.travel.model.dto.BookingDetails;
import com.webage.travel.model.entity.Booking;
import com.webage.travel.model.entity.TravelPackage;

@Stateless
public class PackageDAO {
	@Resource(name="TravelDS")
	DataSource ds;
	
	@PersistenceContext(unitName="TravelPersistenceUnit")
	private EntityManager em;
	
	public List<TravelPackage> getAllPackages() {
		Query q = em.createNativeQuery(
				"select * from TravelPackage",
				TravelPackage.class);
		
		return (List<TravelPackage>) q.getResultList();
	}
	
	public TravelPackage getPackageById(long packageId) {
		return em.find(TravelPackage.class, packageId);
	}
	
	public void addToBooking(Booking b) {
		em.persist(b);
	}
	
	public List<BookingDetails> getUserBookings(String userId) {
		Query q = em.createQuery("select b, p from Booking b, TravelPackage p where b.packageId=p.packageId and b.userId=:userId");
		
		q.setParameter("userId", userId);
		
		List<Object[]> list = q.getResultList();
		ArrayList<BookingDetails> result = new ArrayList();
		
		for (Object[] item : list) {
			BookingDetails d = new BookingDetails();
			
			d.setBooking((Booking) item[0]); 
			d.setTravelPackage((TravelPackage) item[1]);
			
			result.add(d);
		}
		
		return result;
	}
}
