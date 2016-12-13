package br.skdev.model;

import java.io.Serializable;
import java.util.Map;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.EqualsAndHashCode;

@JsonIgnoreProperties(ignoreUnknown = true)
@EqualsAndHashCode(of = "name")
public class EAttribute implements Serializable, Comparable<EAttribute> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected String name;

	protected String type;

	protected Set<String> modifiers;

	protected Map<Integer, String> genericTypes;

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

	public Map<Integer, String> getGenericTypes() {
		return genericTypes;
	}

	public void setGenericTypes(Map<Integer, String> genericTypes) {
		this.genericTypes = genericTypes;
	}

	@Override
	public int compareTo(EAttribute o) {
		return this.getName().compareTo(o.getName());
	}

}
