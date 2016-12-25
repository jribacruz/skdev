package br.skdev.core.model.request;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import br.skdev.core.deserializer.ETemplateModelMapDeserializer;
import br.skdev.core.model.ETemplateModel;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ETemplateModelRequest {

	@JsonDeserialize(using = ETemplateModelMapDeserializer.class)
	private Map<String, ETemplateModel> models;

	public Map<String, ETemplateModel> getModels() {
		return models;
	}

	public void setModels(Map<String, ETemplateModel> models) {
		this.models = models;
	}

}
