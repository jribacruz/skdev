package br.skdev.core.model.request;

import java.io.Serializable;
import java.util.SortedSet;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.skdev.core.model.ETemplateModel;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EClassesResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SortedSet<? extends ETemplateModel> elements;

	public EClassesResponse() {
		super();
	}

	public EClassesResponse(SortedSet<? extends ETemplateModel> elements) {
		super();
		this.elements = elements;
	}

	public SortedSet<? extends ETemplateModel> getElements() {
		return elements;
	}

	public void setElements(SortedSet<? extends ETemplateModel> elements) {
		this.elements = elements;
	}

	

}