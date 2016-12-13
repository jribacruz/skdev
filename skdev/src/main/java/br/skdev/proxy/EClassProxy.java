package br.skdev.proxy;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import com.thoughtworks.qdox.model.JavaClass;

import br.skdev.model.EAttribute;
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

	@Override
	public Set<EAttribute> getAttributes() {
		// @formatter:off
		return Arrays.asList(javaClass.getFields())
				.stream()	
				.map(EAttributeProxy::new)
				.collect(Collectors.toSet());
		// @formatter:on

	}

}
