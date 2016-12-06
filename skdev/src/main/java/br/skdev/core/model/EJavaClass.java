package br.skdev.core.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.thoughtworks.qdox.model.JavaClass;

import br.skdev.core.Selectable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EJavaClass implements Serializable, Comparable<EJavaClass>, Selectable {

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
		if (this.path == null) {
			String packageDir = this.qdoxJavaClass.getPackage().getName().replaceAll("\\.", "/");
			this.path = FilenameUtils
					.normalize(project.getPath().concat(this.sourceFolderName).concat("/").concat(packageDir));
		}
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getPackageName() {
		if (this.packageName == null) {
			this.packageName = this.qdoxJavaClass.getPackageName();
		}
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public Optional<String> getParentPackageName() {
		if (this.parentPackageName == null) {
			List<String> packageTokens = Arrays.asList(getQdoxJavaClass().getPackageName().split("\\."));
			this.parentPackageName = StringUtils.join(packageTokens.subList(0, packageTokens.size() - 1), ".");
		}
		return Optional.ofNullable(parentPackageName);
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

	/**
	 * 
	 * @param name
	 * @return
	 */
	public boolean hasAnnotationByName(String name) {
		//@formatter:off
		return Arrays.asList(qdoxJavaClass.getAnnotations())
					.stream()
					.anyMatch(p -> p.getType().getValue().endsWith(name));
		//@formatter:on
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

	@Override
	public String getId() {
		return this.getName();
	}

}
