package br.skdev.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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

	@RequestMapping("/projects")
	public String select() {
		return "projects";
	}
}
