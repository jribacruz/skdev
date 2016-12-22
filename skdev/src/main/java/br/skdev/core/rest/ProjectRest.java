package br.skdev.core.rest;

import java.util.SortedSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.skdev.core.context.WorkspaceContext;
import br.skdev.core.model.EClass;
import br.skdev.core.model.EMavenProject;
import br.skdev.core.service.ProjectService;

@RestController
public class ProjectRest {

	@Autowired
	private WorkspaceContext workspaceContext;

	@Autowired
	private ProjectService projectService;

	/**
	 * Lista de projetos do workspace.
	 * 
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, path = "/api/projects")
	public SortedSet<EMavenProject> getProjects() {
		return workspaceContext.getWokspace().getMavenProjects();
	}

	/**
	 * Retorna as classes do projeto.
	 * 
	 * @return
	 * @throws InterruptedException
	 */
	@RequestMapping(method = RequestMethod.GET, path = "/api/projects/{projectName}/classes", produces = "application/json")
	public ResponseEntity<?> findAllEClasses(@PathVariable("projectName") String projectName) {
		EMavenProject eMavenProject = projectService.findByName(projectName);
		SortedSet<EClass> entities = projectService.findAllEClasses(eMavenProject);
		return ResponseEntity.ok(entities);
	}

}
