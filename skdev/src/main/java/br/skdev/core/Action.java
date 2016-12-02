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
	 * Retorna o componente pelo id.
	 * 
	 * @param id
	 *            Id com componente.
	 * @return
	 */
	protected UIComponent findById(String id) {
		return components.get(id);
	}

	/**
	 * 
	 */
	public abstract void execute();

}
