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
	
	public List<TravelPackage> getAllPackages(String sortBy) {
		Query q = em.createNativeQuery(
				"select * from TravelPackage order by ?",
				TravelPackage.class);
		q.setParameter(1, sortBy);
		
		return (List<TravelPackage>) q.getResultList();
	}
}
