package br.skdev.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@JsonIgnoreProperties(ignoreUnknown = true)
@EqualsAndHashCode(of = { "name", "type" })
@ToString(of = { "name", "type" })
public class EMethodParameter implements Serializable {

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
	protected String type;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
