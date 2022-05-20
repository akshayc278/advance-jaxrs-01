package com.techie.akshay.resources;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Path("/{pathParam}/test")
public class PathParamResource {

	@PathParam("pathParam")
	private String pathParameter;
	@QueryParam("query")
	private String queryParameter;
	//this injection is not applicable for singleton . It gives error
	//http://localhost:8080/advance-jaxrs-01/web/pathvalue/test?query=akshay
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String testPathQuery() {
		return "Path paramer is " + pathParameter + " Query Parameter is " + queryParameter;
	}
}
