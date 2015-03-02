package com.github.nordinh.apidoc;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DocumentedService {

	@NotEmpty
	private String name;

	@NotEmpty
	private String apidoc;

	@JsonProperty
	public String getName() {
		return name;
	}

	@JsonProperty
	public void setName(String name) {
		this.name = name;
	}

	@JsonProperty
	public String getApidoc() {
		return apidoc;
	}

	@JsonProperty
	public void setApidoc(String apidoc) {
		this.apidoc = apidoc;
	}

}
