package com.webage.travel.model.dao;

import java.util.List;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.sql.DataSource;

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
}
