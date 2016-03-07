package com.webage.travel.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.webage.travel.model.dao.PackageDAO;
import com.webage.travel.model.entity.TravelPackage;

@Path("/catalog")
public class CatalogService {
	@EJB
	PackageDAO pDAO;
	
	@GET
	@Path("/package")
	@Produces(MediaType.APPLICATION_JSON)
	public List<TravelPackage> getAllPackages(@QueryParam("sort") String sortBy) {
		if (sortBy == null) {
			sortBy = "title";
		}
		
		return pDAO.getAllPackages(sortBy);
	}
}
