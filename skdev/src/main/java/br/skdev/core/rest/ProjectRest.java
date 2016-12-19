package br.skdev.core.rest;

import java.util.SortedSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	 * Retorna a lista de classes de dominio.
	 * 
	 * @return
	 * @throws InterruptedException
	 */
	@RequestMapping(method = RequestMethod.GET, path = "/api/project/classes")
	public ResponseEntity<?> findAllEClasses(@RequestParam("name") String projectName) {
		SortedSet<EClass> entities = projectService.findAllClasses(projectName);
		return ResponseEntity.ok(entities);

	}
}
