package br.skdev.core;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

public abstract class UIComponent implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@JsonIgnore
	private String id;

	@JsonIgnore
	private String label;

	public abstract String buildUIComponentTemplateFragment();

	public UIComponent(String id, String label) {
		super();
		this.id = id;
		this.label = label;
	}

	public String getId() {
		return id;
	}

	public String getLabel() {
		return label;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UIComponent other = (UIComponent) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UIComponent [id=" + id + "]";
	}

}
