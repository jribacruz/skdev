package br.skdev.core.component.builder;

import java.io.Serializable;

import br.skdev.core.component.SelectOneEJavaClass;

/**
 * 
 * @author jcruz
 *
 */
public class ActionDialogBuilder implements Serializable {

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
