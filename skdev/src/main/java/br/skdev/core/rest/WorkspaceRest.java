package br.skdev.core.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.skdev.core.model.EWorkspace;
import br.skdev.core.service.WorkspaceService;

@RestController
public class WorkspaceRest {

	@Autowired
	private WorkspaceService workspaceService;

	/**
	 * Lista de projetos do workspace.
	 * 
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, path = "/api/projects")
	public ResponseEntity<?> getProjects(@RequestParam("workspace") String workspace) {
		EWorkspace eWorkspace = workspaceService.load(workspace);
		return ResponseEntity.ok(eWorkspace.getMavenProjects());
	}
}
