package br.skdev.proxy;

import java.io.File;
import java.io.FileNotFoundException;
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

	private File javaFile;

	private JavaClass javaClass;

	public EClassProxy(File javaFile) throws FileNotFoundException, IOException {
		super();
		this.javaFile = javaFile;
		init();
	}

	private void init() throws FileNotFoundException, IOException {
		JavaDocBuilder doc = new JavaDocBuilder();
		JavaSource source = doc.addSource(this.javaFile);
		this.javaClass = source.getClasses()[0];
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
