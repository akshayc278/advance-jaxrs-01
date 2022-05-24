package com.techie.akshay.restclient;


import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;
import java.util.*; 

public class GenericRestResource {
	public static void main(String[] args) {
		Client client=ClientBuilder.newClient();
		List<MessageClass> response=client.target("")
				.path("message")
				.queryParam("year", 2015)
				.request(MediaType.APPLICATION_JSON)
				.get(new GenericType<List<MessageClass>>() {});
		System.out.println(response);
	}
}
