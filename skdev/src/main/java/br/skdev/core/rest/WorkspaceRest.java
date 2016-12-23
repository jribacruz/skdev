package br.skdev.core.rest;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.skdev.core.context.WorkspaceContext;
import br.skdev.core.model.EWorkspace;
import br.skdev.core.service.WorkspaceService;

@RestController
public class WorkspaceRest {

	@Autowired
	private WorkspaceService workspaceService;

	@Autowired
	private WorkspaceContext workspaceContext;

	@RequestMapping(method = RequestMethod.POST, path = "/api/workspace", consumes="application/json")
	public ResponseEntity<?> load(@RequestBody Map<String, String> workspaceMap) {
		EWorkspace eWorkspace = workspaceService.load(workspaceMap.get("path"));
		workspaceContext.setWorkspace(eWorkspace);
		return ResponseEntity.ok(eWorkspace);
	}
}
