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
		if (this.name == null) {
			this.name = this.javaClass.getName();
		}
		return this.name;
	}

	@Override
	public String getFullyQualifiedName() {
		if (this.fullyQualifiedName == null) {
			this.fullyQualifiedName = this.javaClass.getFullyQualifiedName();
		}
		return this.fullyQualifiedName;
	}

	@Override
	public String getPackageName() {
		if (this.packageName == null) {
			this.packageName = this.javaClass.getPackageName();
		}
		return this.packageName;
	}

	@Override
	public Set<EAttribute> getAttributes() {
		if (this.attributes == null) {
			// @formatter:off
			this.attributes = Arrays.asList(javaClass.getFields())
				.stream()	
				.map(EAttributeProxy::new)
				.collect(Collectors.toSet());
			// @formatter:on
		}
		return this.attributes;

	}

}
