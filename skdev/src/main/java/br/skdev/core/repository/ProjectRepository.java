package br.skdev.core.repository;

import java.io.Serializable;
import java.util.SortedSet;

import org.springframework.stereotype.Repository;

import br.skdev.core.exception.ProjectNotFoundException;
import br.skdev.core.model.EClass;
import br.skdev.core.model.EMavenProject;
import br.skdev.core.model.EWorkspace;

@Repository
public class ProjectRepository implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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

}
