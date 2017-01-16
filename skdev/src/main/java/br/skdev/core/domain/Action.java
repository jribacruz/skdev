package br.skdev.core.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name = "SK_ACTION")
public class Action implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column
	private String name;

	@Column
	private String description;

	@Column
	private String dialogHTML;

	@Column
	private String executeJS;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt;

	@OneToMany
	@JoinColumn(name = "ACTION_ID")
	private Set<Template> templates;

	@ManyToMany
	@JoinTable(name = "SK_ACTION_GROUP", joinColumns = @JoinColumn(name = "ACTION_ID"), inverseJoinColumns = @JoinColumn(name = "GROUP_ID"))
	private Set<Group> groups;

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

	public Set<Template> getTemplates() {
		if (this.templates == null) {
			this.templates = new HashSet<>();
		}
		return templates;
	}

	public void setTemplates(Set<Template> templates) {
		this.templates = templates;
	}

	public Set<Group> getGroups() {
		if (this.groups == null) {
			this.groups = new HashSet<>();
		}
		return groups;
	}

	public void setGroups(Set<Group> groups) {
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
		Action other = (Action) obj;
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
