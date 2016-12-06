package br.skdev.core.component;

import java.util.SortedSet;
import java.util.TreeSet;

import br.skdev.core.UIComponent;
import br.skdev.core.model.EJavaClass;

/**
 * 
 * @author jcruz
 *
 */
public class SelectOneEJavaClass extends UIComponent {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private boolean required;

	private SortedSet<EJavaClass> options;

	public SelectOneEJavaClass(String id, String label) {
		super(id, label);
	}

	public boolean isRequired() {
		return required;
	}

	public void setRequired(boolean required) {
		this.required = required;
	}

	public SortedSet<EJavaClass> getOptions() {
		if (this.options == null) {
			this.options = new TreeSet<>();
		}
		return options;
	}

	public void setOptions(SortedSet<EJavaClass> options) {
		this.options = options;
	}

}
