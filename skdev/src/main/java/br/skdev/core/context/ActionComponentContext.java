package br.skdev.core.context;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ActionComponentContext implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Map<String, Object> values;

	public ActionComponentContext(Map<String, Object> values) {
		super();
		this.values = values;
	}

	public List<String> getValuesById(String id) {
		return null;
	}

	public String getValueIdId(String id) {
		return null;
	}

	@Override
	public String toString() {
		return "ActionComponentContext [values=" + values + "]";
	}

}
