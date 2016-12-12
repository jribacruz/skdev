package br.skdev.core.impl;

import com.google.common.base.Optional;

import br.skdev.core.component.SelectOneEJavaClass;
import br.skdev.core.context.UIComponentContext;
import br.skdev.core.model.EJavaClass;

public class UIComponentContextImpl implements UIComponentContext {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public Optional<EJavaClass> getValue(String id, Class<SelectOneEJavaClass> componentClass) {
		return null;
	}

}
