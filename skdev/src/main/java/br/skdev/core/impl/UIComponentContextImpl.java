package br.skdev.core.impl;

import java.util.Map;

import com.google.common.base.Optional;

import br.skdev.core.component.SelectOneEJavaClass;
import br.skdev.core.context.UIComponentContext;
import br.skdev.core.model.EJavaClass;

public class UIComponentContextImpl implements UIComponentContext {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Map<String, Object> componentValues;

	@Override
	public Optional<EJavaClass> getValue(String id, Class<SelectOneEJavaClass> componentClass) {
		return null;
	}

}
