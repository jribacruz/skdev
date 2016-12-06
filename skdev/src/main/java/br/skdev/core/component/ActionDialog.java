package br.skdev.core.component;

import java.io.Serializable;

import br.skdev.core.component.builder.SelectOneEJavaClassBuilder;

/**
 * 
 * @author jcruz
 *
 */
public class ActionDialog implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SelectOneEJavaClassBuilder selectOneEJavaClass(String id, String label) {
		SelectOneEJavaClass selectOneEJavaClass = new SelectOneEJavaClass(id, label);
		SelectOneEJavaClassBuilder builder = new SelectOneEJavaClassBuilder(this, selectOneEJavaClass);
		return builder;
	}

}
