package br.skdev.proxy;

import com.thoughtworks.qdox.model.Annotation;

import br.skdev.model.EAnnotation;

public class EAnnotationProxy extends EAnnotation {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Annotation annotation;

	public EAnnotationProxy(Annotation annotation) {
		super();
		this.annotation = annotation;
	}

	@Override
	public String getName() {
		if (this.name == null) {
			this.name = annotation.getType().getValue();
		}
		return this.name;
	}

}
