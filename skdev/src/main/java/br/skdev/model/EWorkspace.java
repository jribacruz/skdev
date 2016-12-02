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
public class EWorkspace implements Serializable {

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
	@JsonIgnore
	private SortedSet<EJavaProject> javaProjects;

	/**
	 * 
	 */
	@JsonIgnore
	private Map<String, EJavaProject> projectMap;

	public EWorkspace(String path) {
		super();
		this.path = path;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public SortedSet<EJavaProject> getJavaProjects() {
		if (this.javaProjects == null) {
			// @formatter:off
			this.javaProjects = new TreeSet<>();
			Optional<Stream<Path>> directories = FS.listDirectories(this.path);
			if (directories.isPresent()) {
				this.javaProjects = directories.get()
						.filter(path -> FS.hasFile(path, "pom.xml"))
						.map(EJavaProject::new)
						.collect(Collectors.toCollection(TreeSet::new));
			}
			// @formatter:on
		}
		return javaProjects;
	}

	public void setJavaProjects(SortedSet<EJavaProject> projects) {
		this.javaProjects = projects;
	}

	public Map<String, EJavaProject> getProjectMap() {
		if (this.projectMap == null) {
			this.projectMap = new HashMap<>();
			this.javaProjects.forEach(p -> projectMap.put(p.getName(), p));
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
		EWorkspace other = (EWorkspace) obj;
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
