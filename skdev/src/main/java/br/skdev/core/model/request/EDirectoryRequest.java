package br.skdev.core.model.request;

import java.io.Serializable;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import br.skdev.core.deserializer.ETemplateModelMapDeserializer;
import br.skdev.core.model.EDirectory;
import br.skdev.core.model.ETemplateModel;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EDirectoryRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private EDirectory directory;

	public EDirectory getDirectory() {
		return directory;
	}

	public void setDirectory(EDirectory directory) {
		this.directory = directory;
	}

	@JsonDeserialize(using = ETemplateModelMapDeserializer.class)
	private Map<String, ETemplateModel> models;

	public Map<String, ETemplateModel> getModels() {
		return models;
	}

	public void setModels(Map<String, ETemplateModel> models) {
		this.models = models;
	}
}
