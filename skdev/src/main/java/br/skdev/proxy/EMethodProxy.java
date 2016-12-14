package br.skdev.proxy;

import java.util.HashMap;
import java.util.Map;

import com.thoughtworks.qdox.model.JavaMethod;

import br.skdev.model.EMethod;
import br.skdev.model.EMethodParameter;
import lombok.ToString;

@ToString(callSuper = true)
public class EMethodProxy extends EMethod {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JavaMethod javaMethod;

	public EMethodProxy(JavaMethod javaMethod) {
		super();
		this.javaMethod = javaMethod;
	}

	@Override
	public String getName() {
		if (this.name == null) {
			this.name = javaMethod.getName();
		}
		return this.name;
	}

	@Override
	public String getBody() {
		if (this.body == null) {
			this.body = javaMethod.getCodeBlock();
		}
		return this.body;
	}

	@Override
	public Map<Integer, EMethodParameter> getParameters() {
		if (this.parameters == null) {
			this.parameters = new HashMap<>();
			if (this.javaMethod.getParameters() != null && this.javaMethod.getParameters().length > 0) {
				for (int i = 0; i < this.javaMethod.getParameters().length; i++) {
					this.parameters.put(i, new EMethodParameterProxy(this.javaMethod.getParameters()[i]));
				}
			}
		}
		return this.parameters;
	}

}
