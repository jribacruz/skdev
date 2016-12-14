package br.skdev.proxy;

import com.thoughtworks.qdox.model.JavaPackage;

import br.skdev.model.EPackage;

public class EPackageProxy extends EPackage {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JavaPackage javaPackage;

	public EPackageProxy(JavaPackage javaPackage) {
		super();
		this.javaPackage = javaPackage;
	}

	@Override
	public String getName() {
		if (this.name == null) {
			this.name = javaPackage.getName();
		}
		return this.name;
	}

}
