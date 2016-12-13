package br.skdev.core.model;

import java.io.File;
import java.io.Serializable;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;

import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import com.thoughtworks.qdox.JavaDocBuilder;
import com.thoughtworks.qdox.parser.ParseException;

import br.skdev.core.MavenFolder;

/**
 * Modelo dos projetos do workspace eclipse.
 * 
 * @author jcruz
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class EMavenProject implements Serializable, Comparable<EMavenProject> {

	private Logger log = LoggerFactory.getLogger(EMavenProject.class);

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

	/**
	 * 
	 */
	@JsonIgnore
	private Multimap<MavenFolder, EClass> cacheEJavaClassesMMap = HashMultimap.create();

	/**
	 * 
	 */
	@JsonIgnore
	private Multimap<MavenFolder, EPackage> cacheEJavaPackagesMMap = HashMultimap.create();

	public EMavenProject(Path path) {
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

	public SortedSet<EClass> getEJavaClasses(MavenFolder mf) {
		if (!cacheEJavaClassesMMap.containsKey(mf)) {
			// @formatter:off
			SortedSet<EClass> eJavaClasses = getEJavaPackages(mf).stream()
					.map(javaPackage -> javaPackage.getQdoxJavaPackage().getClasses())
					.flatMap(qdoxJavaClasses -> Arrays.asList(qdoxJavaClasses).stream())
					.map(qdoxJavaClass -> new EClass(this, mf.getPath(), qdoxJavaClass))
					.filter(javaClass -> !javaClass.getQdoxJavaClass().isInterface()
							&& !javaClass.getQdoxJavaClass().isEnum())
					.collect(Collectors.toCollection(TreeSet::new));
			// @formatter:on
			cacheEJavaClassesMMap.putAll(mf, eJavaClasses);
		}
		return new TreeSet<>(this.cacheEJavaClassesMMap.get(mf));
	}

	public SortedSet<EPackage> getEJavaPackages(MavenFolder mf) {
		if (!cacheEJavaPackagesMMap.containsKey(mf)) {
			JavaDocBuilder builder = createJavaDocBuilder(mf);
			// @formatter:off
			SortedSet<EPackage> eJavaPackages = Arrays.asList(builder.getPackages()).stream()
					.map(javaPackage -> new EPackage(this, javaPackage, mf.getPath()))
					.collect(Collectors.toCollection(TreeSet::new));
			// @formatter:on
			this.cacheEJavaPackagesMMap.putAll(mf, eJavaPackages);
		}
		return new TreeSet<>(this.cacheEJavaPackagesMMap.get(mf));
	}

	private JavaDocBuilder createJavaDocBuilder(MavenFolder mf) {
		JavaDocBuilder builder = new JavaDocBuilder();
		try {
			File javaDir = new File(FilenameUtils.normalize(getPath().concat(mf.getPath())));
			builder.addSourceTree(javaDir);
		} catch (ParseException e) {
			log.error("Erro ao realizar parser: {}", e.getMessage());
		}
		return builder;
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
		EMavenProject other = (EMavenProject) obj;
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
	public int compareTo(EMavenProject o) {
		return this.name.compareTo(o.getName());
	}

}
