package com.github.nordinh.apidoc;

import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.client.HttpClientBuilder;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import org.apache.http.client.HttpClient;

import com.github.nordinh.apidoc.resources.DocumentedServices;

public class ApiDocApplication extends Application<ApiDocConfiguration> {

	public static void main(String[] args) throws Exception {
		new ApiDocApplication().run(args);
	}

	@Override
	public String getName() {
		return "Web API Documentation";
	}

	@Override
	public void initialize(Bootstrap<ApiDocConfiguration> bootstrap) {
		bootstrap.addBundle(new AssetsBundle("/assets", "/", "index.html"));
	}

	@Override
	public void run(ApiDocConfiguration configuration, Environment environment) throws Exception {
		final HttpClient httpClient = new HttpClientBuilder(environment)
				.using(configuration.getHttpClientConfiguration())
				.build("swagger");
		environment.jersey().register(
				new DocumentedServices(configuration.getServices(), httpClient));
	}

}
