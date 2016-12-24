package br.skdev.core.model;

import java.io.Serializable;
import java.util.Map;

public class ETemplate implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Map<String, ETemplateModel> templateModels;

	public Map<String, ETemplateModel> getTemplateModels() {
		return templateModels;
	}

	public void setTemplateModels(Map<String, ETemplateModel> templateModels) {
		this.templateModels = templateModels;
	}

}
