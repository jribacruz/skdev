package br.skdev.model;

import java.io.Serializable;

import org.apache.commons.io.FilenameUtils;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.thoughtworks.qdox.model.JavaPackage;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EJavaPackage implements Serializable, Comparable<EJavaPackage> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@JsonIgnore
	private EJavaProject project;

	private String name;

	private String sourceFolderName;

	private JavaPackage qdoxJavaPackage;

	private String path;

	public EJavaPackage(EJavaProject project, JavaPackage qdoxJavaPackage, String sourceFolderName) {
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
	public EJavaProject getEJavaProject() {
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
		EJavaPackage other = (EJavaPackage) obj;
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
	public int compareTo(EJavaPackage o) {
		return this.getPackageName().compareTo(o.getPackageName());
	}

}
