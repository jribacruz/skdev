package br.skdev.core.component.builder;

import java.io.Serializable;
import java.util.Map;

/**
 * 
 * @author jcruz
 *
 */
public class ActionHeaderBuilder implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Map<String, String> actionHeader;

	public ActionHeaderBuilder(Map<String, String> actionHeader, String id) {
		super();
		this.actionHeader = actionHeader;
		this.actionHeader.put("id", id);
	}

	public ActionHeaderBuilder title(String value) {
		this.actionHeader.put("title", value);
		return this;
	}

}
