package br.skdev.core;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import br.skdev.core.component.builder.ActionDialogBuilder;

public abstract class Action implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ActionConfig actionConfig;

	private Map<String, UIComponent> components = new HashMap<>();

	/**
	 * 
	 * Retorna um componente pelo id.
	 * 
	 * @param id
	 * @param componentClass
	 * @return
	 */
	@SuppressWarnings("unchecked")
	protected <T extends UIComponent> T findById(String id, Class<T> componentClass) {
		return (T) components.get(id);
	}

	public ActionConfig getActionConfig() {
		if (actionConfig == null) {
			this.actionConfig = new ActionConfig();
			configure(this.actionConfig);
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

	protected abstract void configure(ActionConfig actionConfig);

}
