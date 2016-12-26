package br.skdev.core.model.response;

import java.io.Serializable;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.skdev.core.model.EDirectory;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EDirectoriesResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Set<EDirectory> elements;

	public EDirectoriesResponse() {
		super();
	}

	public EDirectoriesResponse(Set<EDirectory> elements) {
		super();
		this.elements = elements;
	}

	public Set<EDirectory> getElements() {
		return elements;
	}

	public void setElements(Set<EDirectory> elements) {
		this.elements = elements;
	}

}
