package br.skdev.model;

import java.io.Serializable;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.EqualsAndHashCode;

/**
 * Modelo de uma classe Java.
 * 
 * @author jcruz
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@EqualsAndHashCode(of = "fullyQualifiedName")
public class EClass implements Serializable, Comparable<EClass> {

	/**
	 * 
	 */
	protected static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	protected String name;

	/**
	 * 
	 */
	protected String fullyQualifiedName;

	/**
	 * 
	 */
	protected String packageName;

	/**
	 * 
	 */
	protected Set<EAttribute> attributes;

	/**
	 * 
	 */
	protected Set<EMethod> methods;

	/**
	 * 
	 */
	protected Set<EAnnotation> annotations;

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

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
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

	public Set<EAnnotation> getAnnotations() {
		return annotations;
	}

	public void setAnnotations(Set<EAnnotation> annotations) {
		this.annotations = annotations;
	}

	@Override
	public int compareTo(EClass o) {
		return this.fullyQualifiedName.compareTo(o.fullyQualifiedName);
	}

}
