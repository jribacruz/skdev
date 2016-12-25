package br.skdev.core.model;

import java.io.Serializable;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import br.skdev.core.deserializer.ETemplateModelMapDeserializer;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ETemplate implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;

	@JsonDeserialize(using = ETemplateModelMapDeserializer.class)
	private Map<String, ETemplateModel> models;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Map<String, ETemplateModel> getModels() {
		return models;
	}

	public void setModels(Map<String, ETemplateModel> models) {
		this.models = models;
	}

	@Override
	public String toString() {
		return "ETemplate [id=" + id + ", models=" + models + "]";
	}
	
	

}
