package br.skdev.model;

import java.io.Serializable;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Modelo de uma classe Java.
 * 
 * @author jcruz
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class EClass implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	private String name;

	/**
	 * 
	 */
	private String fullyQualifiedName;

	/**
	 * 
	 */
	private Set<EAttribute> attributes;

	/**
	 * 
	 */
	private Set<EMethod> methods;

	public EClass() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFullyQualifiedName() {
		return fullyQualifiedName;
	}

	public void setFullyQualifiedName(String fullyQualifiedName) {
		this.fullyQualifiedName = fullyQualifiedName;
	}

	public Set<EAttribute> getAttributes() {
		return attributes;
	}

	public void setAttributes(Set<EAttribute> attributes) {
		this.attributes = attributes;
	}

	public Set<EMethod> getMethods() {
		return methods;
	}

	public void setMethods(Set<EMethod> methods) {
		this.methods = methods;
	}

}
