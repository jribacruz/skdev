package br.skdev.core.repository;

import java.io.Serializable;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.skdev.core.context.WorkspaceContext;
import br.skdev.core.model.EMavenProject;

@Repository
public class ProjectRepository implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private WorkspaceContext workspaceContext;
	
	public Optional<EMavenProject> findByName(String name) {
		//// @formatter:off
		return workspaceContext.getWokspace().getMavenProjects()
			.stream()
			.filter(mavenProject -> mavenProject.getName().equals(name))
			.findAny();
		// @formatter:on
	}
	
	
}
