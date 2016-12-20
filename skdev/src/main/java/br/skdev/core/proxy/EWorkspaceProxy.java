package br.skdev.core.proxy;

import java.nio.file.Path;
import java.util.Optional;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;

import br.skdev.core.model.EMavenProject;
import br.skdev.core.model.EWorkspace;
import br.skdev.core.util.FS;

public class EWorkspaceProxy extends EWorkspace {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private FS fs;

	public EWorkspaceProxy(String path) {
		super();
		this.path = path;
	}

	@Override
	public SortedSet<EMavenProject> getMavenProjects() {
		if (this.mavenProjects == null) {
			Optional<Stream<Path>> directories = fs.listDirectories(this.path);
			if (directories.isPresent()) {
				//// @formatter:off
				this.mavenProjects = directories.get()
						.filter(path -> fs.hasFile(path, "pom.xml"))
						.map(EMavenProjectProxy::new)
						.collect(Collectors.toCollection(TreeSet::new));
				// @formatter:on
			}
		}
		return this.mavenProjects;
	}

}
