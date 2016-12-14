package br.skdev.model;

import java.io.Serializable;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonAppend.Attr;

@JsonIgnoreProperties(ignoreUnknown = true)
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

	public void setName(@Attr("name1") String name) {
		this.name = name;
	}

	@JsonIgnore
	public Set<Bar> getBars() {
		return bars;
	}

	public void setBars(Set<Bar> bars) {
		this.bars = bars;
	}

}
