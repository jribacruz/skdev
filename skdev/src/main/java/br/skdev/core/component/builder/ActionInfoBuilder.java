package br.skdev.core.component.builder;

import java.io.Serializable;

import br.skdev.core.ActionInfo;

/**
 * 
 * @author jcruz
 *
 */
public class ActionInfoBuilder implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ActionInfo actionInfo;

	public ActionInfoBuilder(ActionInfo actionInfo) {
		super();
		this.actionInfo = actionInfo;
	}

	public ActionInfoBuilder title(String text) {
		this.actionInfo.setTitle(text);
		return this;
	}

	public ActionInfoBuilder description(String text) {
		this.actionInfo.setDescription(text);
		return this;
	}

}
