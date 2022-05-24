package com.techie.akshay.restclient;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Invocation;
import jakarta.ws.rs.core.Response;

public class InvocationDemoResource {
	
	public static void main(String[] args) {
		InvocationDemoResource idr=new InvocationDemoResource();
		Invocation invocation = idr.prepareRequestForMessageByYear(2015);
		Response response=invocation.invoke();//actual call happens here 
		System.out.println(response.getStatus());
	}

	private Invocation prepareRequestForMessageByYear(int year) {
		Client client =ClientBuilder.newClient();
		return client.target("/localhost/")
							.path("message")
							.queryParam("year", year)//message?year=2015
							.request()
							.buildGet();
		
	}

}
