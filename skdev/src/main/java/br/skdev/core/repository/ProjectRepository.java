package br.skdev.core.repository;

import java.io.Serializable;
import java.util.Set;
import java.util.SortedSet;

import org.springframework.stereotype.Repository;

import br.skdev.core.exception.ProjectNotFoundException;
import br.skdev.core.model.EClass;
import br.skdev.core.model.EDirectory;
import br.skdev.core.model.EFile;
import br.skdev.core.model.EMavenProject;
import br.skdev.core.model.EWorkspace;
import br.skdev.core.util.FS;

@Repository
public class ProjectRepository implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private FS fs = new FS();

	public EMavenProject findByName(EWorkspace eWorkspace, String projectName) {
		//// @formatter:off
		return eWorkspace.getMavenProjects()
			.stream()
			.filter(mavenProject -> mavenProject.getName().equals(projectName))
			.findAny()
			.orElseThrow(ProjectNotFoundException::new);
	}

	public SortedSet<EClass> findAllEClasses(EMavenProject eMavenProject) {
		return eMavenProject.getClasses();
	}

	
	public Set<EDirectory> findDirectories(EMavenProject eMavenProject) {
		return eMavenProject.getDirectories();
	}
	
	
	public void createDirectory(EMavenProject eMavenProject, EDirectory eDirectory) {
		fs.mkdir(eMavenProject.getAbsolutePath(), eDirectory.getPath());
	}
	
	public void createFile(EMavenProject eMavenProject, EFile eFile) {
		fs.createFile(eMavenProject.getAbsolutePath().concat("/").concat(eFile.getPath()), eFile.getContent());
	}
}
