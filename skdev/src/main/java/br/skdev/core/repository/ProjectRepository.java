package br.skdev.core.repository;

import java.io.Serializable;
import java.util.SortedSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.skdev.core.context.WorkspaceContext;
import br.skdev.core.exception.ProjectNotFoundException;
import br.skdev.core.model.EClass;
import br.skdev.core.model.EMavenProject;

@Repository
public class ProjectRepository implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private WorkspaceContext workspaceContext;

	public EMavenProject findByName(String projectName) {
		//// @formatter:off
		return workspaceContext.getWokspace().getMavenProjects()
			.stream()
			.filter(mavenProject -> mavenProject.getName().equals(projectName))
			.findAny()
			.orElseThrow(ProjectNotFoundException::new);
	}

	public SortedSet<EClass> findAllEClasses(EMavenProject eMavenProject) {
		return eMavenProject.getClasses();
	}

}
