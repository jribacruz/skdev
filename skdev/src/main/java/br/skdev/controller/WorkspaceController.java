package br.skdev.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.skdev.context.WorkspaceContext;

/**
 * 
 * @author jcruz
 *
 */
@Controller
public class WorkspaceController {

	@Autowired
	private WorkspaceContext workspaceContext;

	/**
	 * Seleciona o diretório de workspace.
	 * 
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, path = "/")
	public String select() {
		return "workspace";
	}

	@RequestMapping(method = RequestMethod.POST, path = "/setup")
	public String setup(@ModelAttribute("path") String path) {
		return "redirect:projects";
	}
}
