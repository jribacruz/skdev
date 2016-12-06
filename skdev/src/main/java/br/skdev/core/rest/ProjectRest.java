package br.skdev.core.rest;

import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.skdev.core.MavenFolder;
import br.skdev.core.context.WorkspaceContext;
import br.skdev.core.model.EJavaClass;
import br.skdev.core.model.EJavaProject;
import br.skdev.core.predicate.DomainClassPredicate;

@RestController
public class ProjectRest {

	@Autowired
	private WorkspaceContext workspaceContext;

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
	 */
	@RequestMapping(method = RequestMethod.GET, path = "/api/project/domain/classes")
	public ResponseEntity<?> getDomainEJavaClasses() {
		// @formatter:off
		SortedSet<EJavaClass> entities = workspaceContext.getJavaProject().getEJavaClasses(MavenFolder.SRC_MAIN_JAVA)
					.stream()
					.filter(new DomainClassPredicate())
					.collect(Collectors.toCollection(TreeSet::new));
		// @formatter:on
		return ResponseEntity.ok(entities);

	}
}
