package br.skdev.proxy;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import com.thoughtworks.qdox.model.JavaClass;

import br.skdev.model.EAnnotation;
import br.skdev.model.EAttribute;
import br.skdev.model.EClass;
import br.skdev.model.EMethod;
import br.skdev.model.EPackage;

/**
 * Classe de proxy de EClass
 * 
 * @author jcruz
 *
 */
public class EClassProxy extends EClass {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JavaClass javaClass;

	public EClassProxy(JavaClass javaClass) {
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
	public EPackage getClassPackage() {
		if (this.classPackage == null) {
			this.classPackage = new EPackageProxy(javaClass.getPackage());
		}
		return this.classPackage;
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

	@Override
	public Set<EMethod> getMethods() {
		if (this.methods == null) {
			// @formatter:off
			this.methods = Arrays.asList(javaClass.getMethods())
					.stream()
					.map(EMethodProxy::new)
					.collect(Collectors.toSet());
			// @formatter:on

		}
		return this.methods;
	}

	@Override
	public Set<EAnnotation> getAnnotations() {
		if (this.annotations == null) {
			//// @formatter:off
			this.annotations = Arrays.asList(javaClass.getAnnotations())
					.stream()
					.map(EAnnotationProxy::new)
					.collect(Collectors.toSet());
			// @formatter:on
		}
		return this.annotations;
	}

}
