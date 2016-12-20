package br.skdev.core.proxy;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Optional;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.xml.sax.SAXException;

import com.thoughtworks.qdox.JavaDocBuilder;
import com.thoughtworks.qdox.model.JavaClass;
import com.thoughtworks.qdox.model.JavaSource;
import com.thoughtworks.qdox.parser.ParseException;

import br.skdev.core.model.EClass;
import br.skdev.core.model.EMavenProject;
import br.skdev.core.model.EPom;
import br.skdev.core.util.FS;

public class EMavenProjectProxy extends EMavenProject implements ApplicationContextAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final Logger log = LoggerFactory.getLogger(EMavenProjectProxy.class);
	
	private ApplicationContext applicationContext;
	
	private FS fs = this.applicationContext.getBean(FS.class);
	
	private Path path;

	public EMavenProjectProxy(Path path) {
		super();
		this.path = path;
	}

	@Override
	public String getName() {
		if (this.name == null) {
			this.name = path.toFile().getName();
		}
		return this.name;
	}

	@Override
	public String getAbsolutePath() {
		if (this.absolutePath == null) {
			this.absolutePath = path.toFile().getAbsolutePath();
		}
		return this.absolutePath;
	}

	@Override
	public SortedSet<EClass> getClasses() {
		if (this.classes == null) {
			this.classes = new TreeSet<>();
			Optional<Stream<Path>> files = fs.listFilesRecursively(this.path);
			if (files.isPresent()) {
				//// @formatter:off
				this.classes = files.get()
									.filter(_path -> _path.toFile().getName().endsWith("java"))
									.map(this::createJavaClass)
									.filter(javaClass -> javaClass.isPresent())
									.map(javaClass -> javaClass.get())
									.map(EClassProxy::new)
									.collect(Collectors.toCollection(TreeSet::new));
				// @formatter:on

			}

		}
		return this.classes;
	}

	@Override
	public EPom getPom() {
		if (this.pom == null) {
			try {
				this.pom = new EPomProxy(
						new File(FilenameUtils.normalize(String.format("%s/pom.xml", this.getAbsolutePath()))));
			} catch (SAXException | IOException | ParserConfigurationException e) {
				log.error(e.getMessage());
			}
		}
		return this.pom;
	}

	public Optional<JavaClass> createJavaClass(Path path) {
		try {
			JavaDocBuilder doc = new JavaDocBuilder();
			JavaSource source = doc.addSource(new File(path.toFile().getAbsolutePath()));
			return Optional.of(source.getClasses()[0]);
		} catch (ParseException |IOException e) {
			log.error(e.getMessage());
		}
		return Optional.empty();
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}

}
