package br.skdev.model;

import java.io.Serializable;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class Foo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String name;

	private Set<Bar> bars;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Bar> getBars() {
		return bars;
	}

	public void setBars(Set<Bar> bars) {
		this.bars = bars;
	}

}
