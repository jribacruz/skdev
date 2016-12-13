package br.skdev.proxy;

import java.io.File;
import java.io.IOException;

import com.thoughtworks.qdox.JavaDocBuilder;
import com.thoughtworks.qdox.model.JavaClass;
import com.thoughtworks.qdox.model.JavaSource;

import br.skdev.model.EClass;

public class EClassProxy extends EClass {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String absolutePath;

	private JavaClass javaClass;

	public EClassProxy(String absolutePath) {
		super();
		this.absolutePath = absolutePath;
		init();
	}

	private void init() {
		JavaDocBuilder doc = new JavaDocBuilder();
		try {
			JavaSource source = doc.addSource(new File(this.absolutePath));
			this.javaClass = source.getClasses()[0];
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String getName() {
		return this.javaClass.getName();
	}

}
