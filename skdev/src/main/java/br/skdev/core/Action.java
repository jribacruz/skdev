package br.skdev.core;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public abstract class Action implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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

	/**
	 * 
	 */
	public abstract void execute();

}
