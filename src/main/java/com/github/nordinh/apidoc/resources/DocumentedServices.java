package com.github.nordinh.apidoc.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;

import com.github.nordinh.apidoc.DocumentedService;

@Path("/documented-services")
public class DocumentedServices {

	private List<DocumentedService> documentedServices;
	private HttpClient httpClient;

	public DocumentedServices(List<DocumentedService> documentedServices, HttpClient httpClient) {
		this.documentedServices = documentedServices;
		this.httpClient = httpClient;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<DocumentedService> getDocumentedServices() {
		return documentedServices;
	}

	@Path("/{service}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getServiceApiDoc(String service) {
		try {
			return Response
					.ok(httpClient.execute(new HttpGet("")).getEntity())
					.build();
		} catch (Exception e) {
			return Response.serverError().build();
		}
	}

}
