package br.skdev.core.component;

import br.skdev.core.UIComponent;

/**
 * Componente de entrada de dados.
 * 
 * @author jcruz
 *
 */
public class InputString extends UIComponent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String value;

	public InputString(String id) {
		super(id);
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
