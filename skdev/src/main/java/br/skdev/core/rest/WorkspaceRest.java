package br.skdev.core.rest;

import java.util.Map;
import java.util.SortedSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.skdev.core.context.WorkspaceContext;
import br.skdev.core.model.EMavenProject;
import br.skdev.core.model.EWorkspace;
import br.skdev.core.service.WorkspaceService;

@RestController
public class WorkspaceRest {

	@Autowired
	private WorkspaceService workspaceService;

	@Autowired
	private WorkspaceContext workspaceContext;

	/**
	 * 
	 * Define o workspae
	 * 
	 * @param workspaceMap
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST, path = "/api/workspace", consumes = "application/json")
	public ResponseEntity<?> load(@RequestBody Map<String, String> workspaceMap) {
		EWorkspace eWorkspace = workspaceService.load(workspaceMap.get("path"));
		workspaceContext.setWorkspace(eWorkspace);
		return ResponseEntity.ok(eWorkspace);
	}

	/**
	 * Lista de projetos do workspace.
	 * 
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, path = "/api/workspace/projects")
	public SortedSet<EMavenProject> getProjects() {
		return workspaceContext.getWokspace().getMavenProjects();
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/api/workspace/projects", consumes="application/json")
	public ResponseEntity<?> getProject(@RequestBody EMavenProject eMavenProject) { 
		eMavenProject.getClasses().forEach(eClass -> System.out.println(eClass.getName()));
		return ResponseEntity.ok().build();
		//return workspaceContext.getWokspace().getMavenProjects();
	}
}
