package br.skdev.model;

import java.io.Serializable;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EAttribute implements Serializable, Comparable<EAttribute> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String name;

	private String type;

	private Set<String> modifiers;

	public EAttribute() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Set<String> getModifiers() {
		return modifiers;
	}

	public void setModifiers(Set<String> modifiers) {
		this.modifiers = modifiers;
	}

	@Override
	public int compareTo(EAttribute o) {
		return this.getName().compareTo(o.getName());
	}

}
