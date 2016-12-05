package br.skdev.core.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.thoughtworks.qdox.model.JavaClass;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EJavaClass implements Serializable, Comparable<EJavaClass> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@JsonIgnore
	private EJavaProject project;

	/**
	 * 
	 */
	private String name;

	/**
	 * 
	 */
	private String fullyQualifiedName;

	/**
	 * 
	 */
	private String sourceFolderName;

	/**
	 * 
	 */
	private String path;

	/**
	 * 
	 */
	private String packageName;

	/**
	 * 
	 */
	private String parentPackageName;
	
	/**
	 * 
	 */
	@JsonIgnore
	private JavaClass qdoxJavaClass;

	public EJavaClass(EJavaProject project, String sourceFolder, JavaClass qdoxJavaClass) {
		super();
		this.project = project;
		this.sourceFolderName = sourceFolder;
		this.qdoxJavaClass = qdoxJavaClass;
	}

	public EJavaProject getProject() {
		return project;
	}

	public void setProject(EJavaProject project) {
		this.project = project;
	}

	public String getName() {
		if (this.name == null) {
			this.name = this.qdoxJavaClass.getName();
		}
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFullyQualifiedName() {
		if (this.fullyQualifiedName == null) {
			this.fullyQualifiedName = this.qdoxJavaClass.getFullyQualifiedName();
		}
		return fullyQualifiedName;
	}

	public void setFullyQualifiedName(String fullyQualifiedName) {
		this.fullyQualifiedName = fullyQualifiedName;
	}

	public String getSourceFolderName() {
		return this.sourceFolderName;
	}

	public void setSourceFolderName(String sourceFolderName) {
		this.sourceFolderName = sourceFolderName;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public String getParentPackageName() {
		return parentPackageName;
	}

	public void setParentPackageName(String parentPackageName) {
		this.parentPackageName = parentPackageName;
	}

	public JavaClass getQdoxJavaClass() {
		return qdoxJavaClass;
	}

	public void setQdoxJavaClass(JavaClass qdoxJavaClass) {
		this.qdoxJavaClass = qdoxJavaClass;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fullyQualifiedName == null) ? 0 : fullyQualifiedName.hashCode());
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
		EJavaClass other = (EJavaClass) obj;
		if (fullyQualifiedName == null) {
			if (other.fullyQualifiedName != null)
				return false;
		} else if (!fullyQualifiedName.equals(other.fullyQualifiedName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "EJavaClass [fullyQualifiedName=" + fullyQualifiedName + "]";
	}

	@Override
	public int compareTo(EJavaClass o) {
		return this.getFullyQualifiedName().compareTo(o.getFullyQualifiedName());
	}

}