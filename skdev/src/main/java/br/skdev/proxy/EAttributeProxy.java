package br.skdev.proxy;

import com.thoughtworks.qdox.model.JavaField;

import br.skdev.model.EAttribute;

public class EAttributeProxy extends EAttribute {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JavaField javaField;

	public EAttributeProxy(JavaField javaField) {
		super();
		this.javaField = javaField;
	}

	@Override
	public String getName() {
		return this.javaField.getName();
	}

}
