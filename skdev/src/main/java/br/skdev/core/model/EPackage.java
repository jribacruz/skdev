package br.skdev.core.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.EqualsAndHashCode;

@JsonIgnoreProperties(ignoreUnknown = true)
@EqualsAndHashCode(of = "name")
public class EPackage implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected String name;

	protected String directory;

	public EPackage() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDirectory() {
		return directory;
	}

}
