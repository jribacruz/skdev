package br.skdev.core.context;

import java.io.Serializable;
import java.util.Optional;

import br.skdev.core.component.SelectOneEJavaClass;
import br.skdev.core.model.EClass;

public interface UIComponentContext extends Serializable {

	public Optional<EClass> getValue(String id, Class<SelectOneEJavaClass> componentClass);
}
