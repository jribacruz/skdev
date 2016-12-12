package br.skdev.core.context;

import java.io.Serializable;

import com.google.common.base.Optional;

import br.skdev.core.component.SelectOneEJavaClass;
import br.skdev.core.model.EJavaClass;

public interface UIComponentContext extends Serializable {

	public Optional<EJavaClass> getValue(String id, Class<SelectOneEJavaClass> componentClass);
}
