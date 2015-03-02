package com.github.nordinh.apidoc;

import io.dropwizard.Configuration;
import io.dropwizard.client.HttpClientConfiguration;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ApiDocConfiguration extends Configuration {

	@NotNull
	private List<DocumentedService> services = new ArrayList<>();

	@Valid
	@NotNull
	@JsonProperty
	private HttpClientConfiguration httpClient = new HttpClientConfiguration();

	public HttpClientConfiguration getHttpClientConfiguration() {
		return httpClient;
	}

	@JsonProperty
	public List<DocumentedService> getServices() {
		return services;
	}

	@JsonProperty
	public void setServices(List<DocumentedService> services) {
		this.services = services;
	}

}
