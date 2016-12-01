package br.skdev.model;

import java.io.Serializable;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.skdev.util.FS;

/**
 * 
 * Modelo do workspace eclipse.
 * 
 * @author jcruz
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Workspace implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	private String path;

	/**
	 * 
	 */
	private SortedSet<Project> projects;

	@JsonIgnore
	private Map<String, Project> projectMap;

	public Workspace(String path) {
		super();
		this.path = path;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public SortedSet<Project> getProjects() {
		if (this.projects == null) {
			// @formatter:off
			this.projects = new TreeSet<>();
			Optional<Stream<Path>> directories = FS.listDirectories(this.path);
			if (directories.isPresent()) {
				this.projects = directories.get()
						.filter(path -> FS.hasFile(path, "pom.xml"))
						.map(Project::new)
						.collect(Collectors.toCollection(TreeSet::new));
			}
			// @formatter:on
		}
		return projects;
	}

	public void setProjects(SortedSet<Project> projects) {
		this.projects = projects;
	}

	public Map<String, Project> getProjectMap() {
		if (this.projectMap == null) {
			this.projectMap = new HashMap<>();
			this.projects.forEach(p -> projectMap.put(p.getName(), p));
		}
		return projectMap;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		Workspace other = (Workspace) obj;
		if (path == null) {
			if (other.path != null)
				return false;
		} else if (!path.equals(other.path))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "WorkspaceModel [path=" + path + "]";
	}

}
