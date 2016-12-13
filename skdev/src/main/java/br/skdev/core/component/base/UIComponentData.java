package br.skdev.core.component.base;

import br.skdev.core.model.EMavenProject;

public abstract class UIComponentData<R> extends UIComponent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UIComponentData(String id) {
		super(id);
	}

	public UIComponentData(String id, String label) {
		super(id, label);
	}

	public abstract R getValue(EMavenProject eJavaProject, Object data);

}
