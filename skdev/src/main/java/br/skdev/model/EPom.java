package br.skdev.model;

import java.io.Serializable;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EPom implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Set<EPomDependency> dependecies;

	public EPom() {
		super();
	}

	public Set<EPomDependency> getDependecies() {
		return dependecies;
	}

	public void setDependecies(Set<EPomDependency> dependecies) {
		this.dependecies = dependecies;
	}

}
