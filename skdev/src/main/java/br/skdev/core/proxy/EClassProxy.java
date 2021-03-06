package br.skdev.core.proxy;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.thoughtworks.qdox.JavaDocBuilder;
import com.thoughtworks.qdox.model.JavaClass;
import com.thoughtworks.qdox.model.JavaSource;
import com.thoughtworks.qdox.parser.ParseException;

import br.skdev.core.model.EAnnotation;
import br.skdev.core.model.EAttribute;
import br.skdev.core.model.EClass;
import br.skdev.core.model.EMethod;
import br.skdev.core.model.EPackage;
import br.skdev.core.model.ESourceFolder;

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

	private static final Logger log = LoggerFactory.getLogger(EClassProxy.class);

	private JavaClass javaClass;

	public EClassProxy(JavaClass javaClass) {
		super();
		this.javaClass = javaClass;
	}

	@Override
	public ESourceFolder getSourceFolder() {
		if (this.sourceFolder == null) {
			this.sourceFolder = Arrays.asList(ESourceFolder.values()).stream()
					.filter(eSourceFolder -> javaClass.getSource().getURL().toString().contains(eSourceFolder.getPath())).findFirst().get();
		}
		return this.sourceFolder;
	}

	@Override
	public String getPath() {
		if (this.path == null) {
			this.path = javaClass.getSource().getURL().getPath();
		}
		return this.path;
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

	public static Optional<JavaClass> createJavaClass(Path path) {
		try {
			JavaDocBuilder doc = new JavaDocBuilder();
			JavaSource source = doc.addSource(new File(path.toFile().getAbsolutePath()));
			return Optional.of(source.getClasses()[0]);
		} catch (ParseException | IOException e) {
			log.error(e.getMessage());
		}
		return Optional.empty();
	}

	public static Optional<JavaClass> createJavaClass(String path) {
		try {
			JavaDocBuilder doc = new JavaDocBuilder();
			JavaSource source = doc.addSource(new File(path));
			return Optional.of(source.getClasses()[0]);
		} catch (ParseException | IOException e) {
			log.error(e.getMessage());
		}
		return Optional.empty();
	}

}
