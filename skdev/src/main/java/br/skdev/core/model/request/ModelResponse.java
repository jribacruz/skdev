package br.skdev.core.model.request;

import java.io.Serializable;
import java.util.SortedSet;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.skdev.core.model.ETemplateModel;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ModelResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SortedSet<? extends ETemplateModel> models;

	public ModelResponse() {
		super();
	}

	public ModelResponse(SortedSet<? extends ETemplateModel> models) {
		super();
		this.models = models;
	}

	public SortedSet<? extends ETemplateModel> getModels() {
		return models;
	}

	public void setModels(SortedSet<? extends ETemplateModel> models) {
		this.models = models;
	}

}