package br.skdev.core.impl;

import java.util.Optional;

import br.skdev.core.component.SelectOneEJavaClass;
import br.skdev.core.context.UIComponentContext;
import br.skdev.core.model.EJavaClass;
import br.skdev.core.model.EJavaProject;

public class UIComponentContextImpl implements UIComponentContext {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private EJavaProject eJavaProject;

	@Override
	public Optional<EJavaClass> getValue(String id, Class<SelectOneEJavaClass> componentClass) {
		return Optional.empty();
	}

}
