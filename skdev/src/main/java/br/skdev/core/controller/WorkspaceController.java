package br.skdev.core.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.skdev.core.context.WorkspaceContext;
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

	@Autowired
	private WorkspaceContext workspaceContext;

	/**
	 * Seleciona o diretório de workspace.
	 * 
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, path = "/")
	public String index() {
		Optional<EWorkspace> eWorkspaceOpt = workspaceService.findWorkspace();
		if (eWorkspaceOpt.isPresent()) {
			log.info("Workspace encontrado: "+eWorkspaceOpt.get());
			workspaceContext.setWorkspace(eWorkspaceOpt.get());
			return "projects";
		}
		return "workspace";
	}

	@RequestMapping(method = RequestMethod.POST, path = "/workspace/setup")
	public String setup(@ModelAttribute("path") String path) {
		workspaceService.insert(path);
		Optional<EWorkspace> eWorkspaceOpt = workspaceService.findWorkspace();
		if (eWorkspaceOpt.isPresent()) {
			workspaceContext.setWorkspace(eWorkspaceOpt.get());
		}
		return "redirect:projects";
	}

	@RequestMapping("/workspace/projects")
	public String projects() {
		return "projects";
	}
}
