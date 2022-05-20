package com.techie.akshay;

import jakarta.inject.Singleton;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/test")
@Singleton
public class MyResource {
	private  int  i=0;
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String test() {
		
		return "It worked"+ ++i;
	}
	
}
