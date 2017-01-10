package br.skdev.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.skdev.core.service.ProjectService;

/**
 * 
 * @author jcruz
 *
 */
@Controller
public class ProjectController {

	@Autowired
	private ProjectService projectService;

	@RequestMapping(method = RequestMethod.GET, path = "/project")
	public String index(@RequestParam("name") String name, Model model) {
		model.addAttribute("project", name);
		// workspaceContext.setMavenProject(projectService.findByName(name));
		return "project";
	}
	
	@RequestMapping("/workspace")
	public String projects() {
		return "projects/index";
	}

}
