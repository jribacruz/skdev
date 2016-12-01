package br.skdev.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.skdev.service.WorkspaceService;

/**
 * 
 * @author jcruz
 *
 */
@Controller
public class WorkspaceController {

	@Autowired
	private WorkspaceService workspaceService;

	/**
	 * Seleciona o diretório de workspace.
	 * 
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, path = "/")
	public String index() {
		return "workspace";
	}

	@RequestMapping(method = RequestMethod.POST, path = "/workspace/setup")
	public String setup(@ModelAttribute("path") String path) {
		workspaceService.load(path);
		return "redirect:projects";
	}

	@RequestMapping("/workspace/projects")
	public String projects() {
		return "projects";
	}
}
