package br.skdev.core.component.base;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class UIComponentContainer extends UIComponent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Map<String, UIComponent> componentMap = new HashMap<>();

	private List<UIComponent> components = new ArrayList<>();

	public UIComponentContainer(String id) {
		super(id);
	}

	public void add(String id, UIComponent component) {
		this.componentMap.put(id, component);
		this.components.add(component);
	}

	public Map<String, UIComponent> getComponentMap() {
		return Collections.unmodifiableMap(this.componentMap);
	}

	public List<UIComponent> getComponents() {
		return Collections.unmodifiableList(this.components);
	}

}
