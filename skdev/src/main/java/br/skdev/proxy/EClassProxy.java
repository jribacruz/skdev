package br.skdev.proxy;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.thoughtworks.qdox.model.JavaClass;

import br.skdev.model.EClass;

public class EClassProxy extends EClass {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JavaClass javaClass;

	public EClassProxy(JavaClass javaClass) throws FileNotFoundException, IOException {
		super();
		this.javaClass = javaClass;
	}

	@Override
	public String getName() {
		return this.javaClass.getName();
	}

	@Override
	public String getFullyQualifiedName() {
		return this.javaClass.getFullyQualifiedName();
	}

	@Override
	public String getPackageName() {
		return this.javaClass.getPackageName();
	}

}
