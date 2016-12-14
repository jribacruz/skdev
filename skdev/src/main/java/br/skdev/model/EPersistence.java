package br.skdev.model;

import java.io.Serializable;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EPersistence implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected Set<String> classes;

	public Set<String> getClasses() {
		return classes;
	}

	public void setClasses(Set<String> classes) {
		this.classes = classes;
	}

}
