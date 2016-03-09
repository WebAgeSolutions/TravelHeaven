package com.webage.travel.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import com.webage.travel.model.dto.LoginCredential;

@Path("/auth")
public class AuthenticationService {
	@POST
	@Path("/login")
	@Consumes(MediaType.APPLICATION_JSON)
	public void login(LoginCredential creds, 
			@Context final HttpServletRequest request, 
			@Context final HttpServletResponse response) {
		
		if ("pa$$word".equals(creds.getPassword())) {
			request.getSession().setAttribute("userId", creds.getUserName());
		} else {
			//Indicate login failure using 401 status code.
			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);			
		}
	}
	
	@POST
	@Path("/logout")
	public void login(@Context final HttpServletRequest request, 
			@Context final HttpServletResponse response) {
		//Clear out session
		request.getSession().invalidate();;
	}
}
