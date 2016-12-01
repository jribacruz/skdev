package br.skdev.model;

import java.io.Serializable;
import java.nio.file.Path;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Modelo dos projetos do workspace eclipse.
 * 
 * @author jcruz
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Project implements Serializable, Comparable<Project> {

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
	private String path;

	public Project(Path path) {
		super();
		this.name = path.toFile().getName();
		this.path = path.toFile().getAbsolutePath();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((path == null) ? 0 : path.hashCode());
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
		Project other = (Project) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (path == null) {
			if (other.path != null)
				return false;
		} else if (!path.equals(other.path))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ProjectModel [name=" + name + ", path=" + path + "]";
	}

	@Override
	public int compareTo(Project o) {
		return this.name.compareTo(o.getName());
	}

}
