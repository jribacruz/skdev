package br.skdev.core.component;

import java.io.Serializable;

public class ComponentType implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final SelectOneEClass SelectOneEClass = new SelectOneEClass();

	public static final SelectManyEClass SelectManyEClass = new SelectManyEClass();


}
