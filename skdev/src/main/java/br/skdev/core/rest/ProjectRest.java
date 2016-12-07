package br.skdev.core.rest;

import java.util.SortedSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.skdev.core.context.WorkspaceContext;
import br.skdev.core.model.EJavaClass;
import br.skdev.core.model.EJavaProject;
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
	public SortedSet<EJavaProject> getProjects() {
		return workspaceContext.getWokspace().getJavaProjects();
	}

	/**
	 * Retorna a lista de classes de dominio.
	 * 
	 * @return
	 * @throws InterruptedException
	 */
	@RequestMapping(method = RequestMethod.GET, path = "/api/project/domain/classes")
	public ResponseEntity<?> findAllDomainEJavaClasses() {
		SortedSet<EJavaClass> entities = projectService.findAllDomainEJavaClasses();
		return ResponseEntity.ok(entities);

	}
}
