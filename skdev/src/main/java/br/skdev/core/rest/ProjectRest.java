package br.skdev.core.rest;

import java.io.IOException;
import java.util.Set;
import java.util.SortedSet;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.skdev.core.model.EClass;
import br.skdev.core.model.EDirectory;
import br.skdev.core.model.EMavenProject;
import br.skdev.core.model.EWorkspace;
import br.skdev.core.model.request.EDirectoryRequest;
import br.skdev.core.model.response.EClassesResponse;
import br.skdev.core.model.response.EDirectoriesResponse;
import br.skdev.core.service.ProjectService;
import br.skdev.core.service.TemplateService;
import br.skdev.core.service.WorkspaceService;
import freemarker.template.TemplateException;

@RestController
public class ProjectRest {

	@Autowired
	private ProjectService projectService;

	@Autowired
	private WorkspaceService workspaceService;

	@Autowired
	private TemplateService templateService;

	/**
	 * Lista todas as classe do src/main/java do projeto.
	 * 
	 * @param projectName
	 *            Nome do projeto
	 * @param workspace
	 *            Caminho do workspace
	 * @return Lista de EClasses
	 */
	@RequestMapping(method = RequestMethod.GET, path = "/api/projects/{projectName}/main/classes", produces = "application/json")
	public ResponseEntity<?> findMainEClasses(@PathVariable("projectName") String projectName,
			@RequestParam("workspace") String workspace) {
		EWorkspace eWorkspace = workspaceService.load(workspace);
		EMavenProject eMavenProject = projectService.findByName(eWorkspace, projectName);
		SortedSet<EClass> entities = projectService.findMainEClasses(eMavenProject);
		return ResponseEntity.ok(new EClassesResponse(entities));
	}

	/**
	 * 
	 * 
	 * Lista todos os diretórios do projeto.
	 * 
	 * @param projectName
	 * @param workspace
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, path = "/api/projects/{projectName}/directories", produces = "application/json")
	public ResponseEntity<?> findDirectories(@PathVariable("projectName") String projectName, @RequestParam("workspace") String workspace) {
		EWorkspace eWorkspace = workspaceService.load(workspace);
		EMavenProject eMavenProject = projectService.findByName(eWorkspace, projectName);
		Set<EDirectory> directories = projectService.findDirectories(eMavenProject);
		return ResponseEntity.ok(new EDirectoriesResponse(directories));
	}

	/**
	 * 
	 * @param projectName
	 * @param workspace
	 * @param eDirectory
	 * @return
	 * @throws IOException
	 * @throws TemplateException
	 */
	@RequestMapping(method = RequestMethod.POST, path = "/api/projects/{projectName}/directories", produces = "application/json")
	public ResponseEntity<?> createDirectory(@PathVariable("projectName") String projectName, @RequestParam("workspace") String workspace,
			@RequestBody @Valid EDirectory eDirectory) throws TemplateException, IOException {
		EWorkspace eWorkspace = workspaceService.load(workspace);
		EMavenProject eMavenProject = projectService.findByName(eWorkspace, projectName);
		projectService.createDirectory(eMavenProject, eDirectory);
		return ResponseEntity.ok().build();
	}

}
