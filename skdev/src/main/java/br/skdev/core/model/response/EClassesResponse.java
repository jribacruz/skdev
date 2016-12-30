package br.skdev.core.model.response;

import java.io.Serializable;
import java.util.SortedSet;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.skdev.core.model.EClass;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EClassesResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SortedSet<EClass> classes;

	public EClassesResponse() {
		super();
	}

	public EClassesResponse(SortedSet<EClass> classes) {
		super();
		this.classes = classes;
	}

	public SortedSet<EClass> getClasses() {
		return classes;
	}

	public void setClasses(SortedSet<EClass> classes) {
		this.classes = classes;
	}

}