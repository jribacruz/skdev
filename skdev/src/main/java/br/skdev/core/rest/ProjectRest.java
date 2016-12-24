package br.skdev.core.rest;

import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.skdev.core.context.WorkspaceContext;
import br.skdev.core.model.EAttribute;
import br.skdev.core.model.EClass;
import br.skdev.core.model.EMavenProject;
import br.skdev.core.model.EModel;
import br.skdev.core.service.ProjectService;

@RestController
public class ProjectRest {

	@Autowired
	private WorkspaceContext workspaceContext;

	@Autowired
	private ProjectService projectService;

	/**
	 * Retorna as classes do projeto.
	 * 
	 * @return
	 * @throws InterruptedException
	 */
	@RequestMapping(method = RequestMethod.GET, path = "/api/projects/{projectName}/classes", produces = "application/json")
	public ResponseEntity<?> findAllEClasses(@PathVariable("projectName") String projectName) {
		EMavenProject eMavenProject = projectService.findByName(projectName);
		SortedSet<EClass> entities = projectService.findAllEClasses(eMavenProject);
		return ResponseEntity.ok(entities);
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/api/templates")
	public ResponseEntity<?> findTemplates() {
		//EMavenProject eMavenProject = projectService.findByName(projectName);
		//SortedSet<EClass> entities = projectService.findAllEClasses(eMavenProject);
		EMavenProject  eMavenProject = new EMavenProject();
		Set<EModel> models = new HashSet<>();
		EClass class1 = new EClass();
		class1.setName("Atividade");
		class1.setFullyQualifiedName("br.jus.Atividade");
		
		EAttribute attribute = new EAttribute();
		attribute.setName("name");
		
		
		models.add(class1);
		models.add(attribute);
		eMavenProject.setModels(models);
		return ResponseEntity.ok(eMavenProject);
	}

}
