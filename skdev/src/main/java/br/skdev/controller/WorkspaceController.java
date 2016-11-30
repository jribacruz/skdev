package br.skdev.controller;

import org.springframework.stereotype.Controller;
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
	
	@RequestMapping(method = RequestMethod.GET, path = "/setup")
	public String setup() {
		System.out.println("Setup");
		return "redirect:projects";
	}
}
