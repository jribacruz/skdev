package br.skdev.core.template;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author jcruz
 *
 */
public class TemplateModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Map<String, Object> context = new HashMap<>();

	private TemplateModel() {
		super();
	}

	public TemplateModel add(String key, Object value) {
		this.context.put(key, value);
		return this;
	}

	public Map<String, Object> getContext() {
		return context;
	}

	public static TemplateModel of() {
		return new TemplateModel();
	}

}
