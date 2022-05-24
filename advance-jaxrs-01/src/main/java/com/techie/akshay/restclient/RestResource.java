package com.techie.akshay.restclient;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.Invocation.Builder;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Request;
import jakarta.ws.rs.core.Response;

public class RestResource {

	public static void main(String[] args) {

		Client client = ClientBuilder.newClient();
		// work as consumer of service

		Response response = client.target("http://localhost:8080/messenger/webapi/message/2").request().get();
		MessageClass msc = response.readEntity(MessageClass.class);
		System.out.println(msc.getMessageBody());

		// This actually work like given below
		// Same code in breakdown way

		WebTarget target = client.target("http://localhost:8080/messenger/webapi/message/2");
		Builder builder = target.request();
		Response responseDemo = builder.get();// there is delete,put,post etc.
		MessageClass mscDemo = responseDemo.readEntity(MessageClass.class);
		System.out.println(mscDemo.getMessageBody());

		// Other stuffs you can include
		MessageClass msc3 = client.target("http://localhost:8080/messenger/webapi/message/2")
				.request(MediaType.APPLICATION_JSON)// default is string
				.get(MessageClass.class);// direct way to include

		System.out.println(msc3.getMessageBody());

		String allJsonDataMessage = client.target("http://localhost:8080/messenger/webapi/message/2")
				.request(MediaType.APPLICATION_JSON).get(String.class);// all pay load gets into response

		System.out.println(allJsonDataMessage);

		// Best Practice to implement above code ( Recommended way )

		WebTarget webTarget2 = client.target("http://localhost:8080/messenger/webapi/");
		WebTarget messageTarget = webTarget2.path("message");
		WebTarget messageIdTarget = messageTarget.path("{messageId}");

		MessageClass messageClass2 = messageIdTarget.resolveTemplate("messageId", "2")
				.request(MediaType.APPLICATION_JSON).get(MessageClass.class);
		System.out.println(messageClass2);

		MessageClass newMessage = new MessageClass(4L, "this is new message", "message class");
		Response postResponse = messageTarget
								   .request()
								   .post(Entity.json(newMessage));
		if(postResponse.getStatus() != 201) {
			System.out.println("error");
		}
		System.out.println(postResponse.readEntity(MessageClass.class).getMessageBody());
		
		

	}
}
