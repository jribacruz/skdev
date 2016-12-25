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
import org.xml.sax.SAXException;

import br.skdev.core.model.EClass;
import br.skdev.core.model.EMavenProject;
import br.skdev.core.model.EPom;
import br.skdev.core.util.FS;

public class EMavenProjectProxy extends EMavenProject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final Logger log = LoggerFactory.getLogger(EMavenProjectProxy.class);

	private Path path;

	private FS fs = new FS();

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
									.map(EClassProxy::createJavaClass)
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
				this.pom = new EPomProxy(new File(FilenameUtils.normalize(String.format("%s/pom.xml", this.getAbsolutePath()))));
			} catch (SAXException | IOException | ParserConfigurationException e) {
				log.error(e.getMessage());
			}
		}
		return this.pom;
	}

}
