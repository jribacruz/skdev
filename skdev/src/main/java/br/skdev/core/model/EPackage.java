package br.skdev.core.model;

import java.io.Serializable;

import org.apache.commons.io.FilenameUtils;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.thoughtworks.qdox.model.JavaPackage;

import br.skdev.core.Selectable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EPackage implements Serializable, Comparable<EPackage>, Selectable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@JsonIgnore
	private EMavenProject project;

	/**
	 * 
	 */
	private String name;

	/**
	 * 
	 */
	private String sourceFolderName;

	/**
	 * 
	 */
	private JavaPackage qdoxJavaPackage;

	/**
	 * 
	 */
	private String path;

	public EPackage(EMavenProject project, JavaPackage qdoxJavaPackage, String sourceFolderName) {
		super();
		this.project = project;
		this.qdoxJavaPackage = qdoxJavaPackage;
		this.sourceFolderName = sourceFolderName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see sk4j.model.EJavaPackage#getName()
	 */
	public String getPackageName() {
		if (this.name == null) {
			this.name = this.qdoxJavaPackage.getName();
		}
		return this.name;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see sk4j.model.EJavaPackage#getSourceFolderName()
	 */
	public String getSourceFolderName() {
		return this.sourceFolderName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see sk4j.model.EJavaPackage#getQdoxJavaPackage()
	 */
	public JavaPackage getQdoxJavaPackage() {
		return this.qdoxJavaPackage;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see sk4j.model.EJavaPackage#getProject()
	 */
	public EMavenProject getEJavaProject() {
		return this.project;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see sk4j.model.EJavaPackage#getPath()
	 */
	public String getPathName() {
		if (this.path == null) {
			String packageDir = this.qdoxJavaPackage.getName().replaceAll("\\.", "/");
			this.path = FilenameUtils
					.normalize(project.getPath().concat(this.sourceFolderName).concat("/").concat(packageDir));
		}
		return this.path;
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
		EPackage other = (EPackage) obj;
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
		return "EJavaPackageImpl [project=" + project + ", name=" + name + "]";
	}

	@Override
	public int compareTo(EPackage o) {
		return this.getPackageName().compareTo(o.getPackageName());
	}

	@Override
	public String getId() {
		return this.getPackageName();
	}

	@Override
	public String getLabel() {
		return this.getPackageName();
	}

}
