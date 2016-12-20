package br.skdev.core.context;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ActionContext implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Map<String, Object> values;

	public ActionContext(Map<String, Object> values) {
		super();
		this.values = values;
	}

	public List<String> getValues(String key) {
		return null;
	}

	public String getValue(String key) {
		return null;
	}

	@Override
	public String toString() {
		return "ActionComponentContext [values=" + values + "]";
	}

}
