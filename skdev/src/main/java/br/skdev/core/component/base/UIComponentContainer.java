package br.skdev.core.component.base;

import java.util.HashMap;
import java.util.Map;

public abstract class UIComponentContainer extends UIComponent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Map<String, UIComponent> components = new HashMap<>();

	public UIComponentContainer(String id) {
		super(id);
	}

	public void add(String id, UIComponent component) {
		this.components.put(id, component);
	}

	public Map<String, UIComponent> getComponents() {
		if (this.components == null) {
			this.components = new HashMap<>();
		}
		return components;
	}

	public void setComponents(Map<String, UIComponent> components) {
		this.components = components;
	}

}
