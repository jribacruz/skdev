package br.skdev.rest;

import java.util.SortedSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.skdev.context.WorkspaceContext;
import br.skdev.model.EJavaProject;

@RestController
public class ProjectRest {

	@Autowired
	private WorkspaceContext workspaceContext;

	@RequestMapping(method = RequestMethod.GET, path = "/api/projects")
	public SortedSet<EJavaProject> getProjects() {
		return workspaceContext.getWokspace().getJavaProjects();
	}
}
