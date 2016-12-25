package br.skdev.core.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EString extends ETemplateModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String value;

	public EString() {
		super();
	}

	public EString(String value) {
		super();
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
