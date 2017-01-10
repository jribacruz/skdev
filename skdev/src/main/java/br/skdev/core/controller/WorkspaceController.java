package br.skdev.core.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.skdev.core.model.EWorkspace;
import br.skdev.core.service.WorkspaceService;

/**
 * 
 * @author jcruz
 *
 */
@Controller
public class WorkspaceController {

	private Logger log = LoggerFactory.getLogger(WorkspaceController.class);

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

	@RequestMapping(method = RequestMethod.POST, path = "/workspace")
	public String setup(@ModelAttribute("path") String path, RedirectAttributes redirectAttributes) {
		EWorkspace eWorkspace = workspaceService.load(path);
		redirectAttributes.addAttribute("workspace", eWorkspace.getPath());
		return "redirect:workspace/projects";
	}

	@RequestMapping("/workspace/projects")
	public String projects() {
		return "projects/index";
	}
}
