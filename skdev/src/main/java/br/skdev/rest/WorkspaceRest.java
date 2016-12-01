package br.skdev.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.skdev.context.WorkspaceContext;
import br.skdev.model.Workspace;

@RestController
public class WorkspaceRest {

	@Autowired
	private WorkspaceContext workspaceContext;

	@RequestMapping(method = RequestMethod.GET, path = "/api/workspace")
	public Workspace getWorkspace() {
		return workspaceContext.getWokspace();
	}
}
