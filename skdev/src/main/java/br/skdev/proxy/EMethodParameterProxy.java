package br.skdev.proxy;

import com.thoughtworks.qdox.model.JavaParameter;

import br.skdev.model.EMethodParameter;

public class EMethodParameterProxy extends EMethodParameter {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JavaParameter javaParameter;

	public EMethodParameterProxy(JavaParameter javaParameter) {
		super();
		this.javaParameter = javaParameter;
	}

	@Override
	public String getName() {
		if (this.name == null) {
			this.name = javaParameter.getName();
		}
		return this.name;
	}

	@Override
	public String getType() {
		if (this.type == null) {
			this.type = javaParameter.getType().getValue();
		}
		return this.type;
	}

}
