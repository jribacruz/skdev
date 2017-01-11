package br.skdev.core.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EAction implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;

	private String name;

	private String description;

	private String dialogHTML;

	private String executeJS;

	private Date createdAt;

	private Map<String, ETemplate> templates;

	private Set<EGroup> groups;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDialogHTML() {
		return dialogHTML;
	}

	public void setDialogHTML(String dialogHTML) {
		this.dialogHTML = dialogHTML;
	}

	public String getExecuteJS() {
		return executeJS;
	}

	public void setExecuteJS(String executeJS) {
		this.executeJS = executeJS;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Map<String, ETemplate> getTemplates() {
		if (this.templates == null) {
			this.templates = new HashMap<>();
		}
		return templates;
	}

	public void setTemplates(Map<String, ETemplate> templates) {
		this.templates = templates;
	}

	public Set<EGroup> getGroups() {
		if (this.groups == null) {
			this.groups = new HashSet<>();
		}
		return groups;
	}

	public void setGroups(Set<EGroup> groups) {
		this.groups = groups;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		EAction other = (EAction) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "EAction [id=" + id + ", name=" + name + "]";
	}

}
