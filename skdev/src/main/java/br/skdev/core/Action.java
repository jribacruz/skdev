package br.skdev.core;

import java.io.Serializable;

import br.skdev.core.component.builder.ActionDialogBuilder;
import br.skdev.core.component.builder.ActionInfoBuilder;

public abstract class Action implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ActionInfo actionConfig;

	public ActionInfo getActionConfig() {
		if (actionConfig == null) {
			this.actionConfig = new ActionInfo();
			configure(new ActionInfoBuilder(this.actionConfig));
		}
		return actionConfig;
	}

	/**
	 * 
	 */
	public abstract void execute();

	/**
	 * 
	 * @param builder
	 */
	public abstract void createActionDialog(ActionDialogBuilder builder);

	protected abstract void configure(ActionInfoBuilder builder);

}
