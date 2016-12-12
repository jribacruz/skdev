package br.skdev.core.impl;

import java.util.Map;
import java.util.Optional;

import br.skdev.core.component.SelectOneEJavaClass;
import br.skdev.core.component.base.UIComponent;
import br.skdev.core.context.UIComponentContext;
import br.skdev.core.model.EJavaClass;
import br.skdev.core.model.EJavaProject;

public class UIComponentContextImpl implements UIComponentContext {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private EJavaProject eJavaProject;

	private Map<String, UIComponent> components;

	private Map<String, Object> data;

	public UIComponentContextImpl(EJavaProject eJavaProject, Map<String, UIComponent> components,
			Map<String, Object> data) {
		super();
		this.eJavaProject = eJavaProject;
		this.components = components;
		this.data = data;
	}

	@Override
	public Optional<EJavaClass> getValue(String id, Class<SelectOneEJavaClass> componentClass) {
		UIComponent component = components.get(id);
		if (component instanceof SelectOneEJavaClass) {
			SelectOneEJavaClass selectOneEJavaClass = (SelectOneEJavaClass) component;
			Object value = data.get(id);
			return selectOneEJavaClass.getValue(eJavaProject, value);
		}
		return Optional.empty();
	}

}
