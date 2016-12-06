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

	private ActionInfo actionConfig;

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

	public ActionInfo getActionConfig() {
		if (actionConfig == null) {
			this.actionConfig = new ActionInfo();
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

	protected abstract void configure(ActionInfo actionConfig);

}
