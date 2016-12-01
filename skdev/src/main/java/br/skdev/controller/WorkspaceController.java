package br.skdev.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 
 * @author jcruz
 *
 */
@Controller
public class WorkspaceController {

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
		System.out.println("Path: " + path);
		return "redirect:projects";
	}
}
