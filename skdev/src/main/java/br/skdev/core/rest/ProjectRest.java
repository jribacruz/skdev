package br.skdev.core.rest;

import java.util.SortedSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.skdev.core.context.WorkspaceContext;
import br.skdev.core.model.EJavaProject;

@RestController
public class ProjectRest {

	@Autowired
	private WorkspaceContext workspaceContext;

	@RequestMapping(method = RequestMethod.GET, path = "/api/projects")
	public SortedSet<EJavaProject> getProjects() {
		return workspaceContext.getWokspace().getJavaProjects();
	}
}
