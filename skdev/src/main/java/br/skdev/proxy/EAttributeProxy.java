package br.skdev.proxy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

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

	@Override
	public String getType() {
		return this.javaField.getType().getFullyQualifiedName();
	}

	@Override
	public Set<String> getModifiers() {
		return new HashSet<>(Arrays.asList(this.javaField.getModifiers()));
	}

}
