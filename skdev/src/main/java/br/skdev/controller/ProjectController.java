package br.skdev.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.skdev.context.WorkspaceContext;

/**
 * 
 * @author jcruz
 *
 */
@Controller
public class ProjectController {

	@Autowired
	private WorkspaceContext workspaceContext;

	@RequestMapping(method = RequestMethod.GET, path = "/project/{name}")
	public String index(@PathVariable("name") String name, Model model) {
		model.addAttribute("project", name);
		workspaceContext.setJavaProject(workspaceContext.getWokspace().getProjectMap().get(name));
		return "project";
	}

}
