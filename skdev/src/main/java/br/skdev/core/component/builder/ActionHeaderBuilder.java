package br.skdev.core.component.builder;

import java.io.Serializable;

import br.skdev.core.ActionHeader;

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

	private ActionHeader actionHeader;

	public ActionHeaderBuilder(ActionHeader actionHeader) {
		super();
		this.actionHeader = actionHeader;
	}

	public ActionHeaderBuilder title(String text) {
		this.actionHeader.setTitle(text);
		return this;
	}

	public ActionHeaderBuilder description(String text) {
		this.actionHeader.setDescription(text);
		return this;
	}

}
