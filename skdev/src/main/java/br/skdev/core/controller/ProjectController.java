package br.skdev.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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

	@RequestMapping("/workspace")
	public String projects() {
		return "projects/index";
	}

}
