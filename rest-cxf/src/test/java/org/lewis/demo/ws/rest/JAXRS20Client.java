package org.lewis.demo.ws.rest;

import java.util.List;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

public class JAXRS20Client {

	public static void main(String[] args) {
		String baseAddress = "http://localhost:8080/ws/rest";

		JacksonJsonProvider jsonProvider = new JacksonJsonProvider();

		// List productList =
		// ClientBuilder.newClient().register(jsonProvider).target(baseAddress).path("/products")
		// .request(MediaType.APPLICATION_JSON).get(List.class);
		// for (Object product : productList) {
		// System.out.println(product);
		// }

		List<Product> productList = ClientBuilder.newClient().register(jsonProvider).target(baseAddress)
				.path("/products").request(MediaType.APPLICATION_JSON).get(new GenericType<List<Product>>() {
				});

		for (Product product : productList) {
			System.out.println(product);
		}
	}

}
