package br.skdev.model;

import java.io.Serializable;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.EqualsAndHashCode;

@JsonIgnoreProperties(ignoreUnknown = true)
@EqualsAndHashCode(of = { "name", "parameters" })
public class EMethod implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	protected String name;

	/**
	 * 
	 */
	protected String body;

	/**
	 * 
	 */
	protected Map<Integer, EMethodParameter> parameters;

	public EMethod() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public Map<Integer, EMethodParameter> getParameters() {
		return parameters;
	}

	public void setParameters(Map<Integer, EMethodParameter> parameters) {
		this.parameters = parameters;
	}

}
