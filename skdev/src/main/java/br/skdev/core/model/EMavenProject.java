package br.skdev.core.model;

import java.io.Serializable;
import java.util.SortedSet;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EMavenProject implements Serializable, Comparable<EMavenProject> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected String name;

	protected String absolutePath;

	protected EPom pom;

	@JsonIgnore
	protected SortedSet<EClass> classes;

	public EMavenProject() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAbsolutePath() {
		return absolutePath;
	}

	public void setAbsolutePath(String absolutePath) {
		this.absolutePath = absolutePath;
	}

	public EPom getPom() {
		return pom;
	}

	public void setPom(EPom pom) {
		this.pom = pom;
	}

	public SortedSet<EClass> getClasses() {
		return classes;
	}

	public void setClasses(SortedSet<EClass> classes) {
		this.classes = classes;
	}

	@Override
	public int compareTo(EMavenProject o) {
		return this.getName().compareTo(o.getName());
	}

}
