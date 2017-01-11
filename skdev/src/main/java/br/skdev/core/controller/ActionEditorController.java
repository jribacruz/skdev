package br.skdev.core.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 
 * @author jcruz
 *
 */
@Controller
public class ActionEditorController {

	@RequestMapping(method = RequestMethod.GET, path = "/actions/{id}")
	public String action(@PathVariable(value = "id") Integer id) {
		return "actions/index";
	}

	@RequestMapping(method = RequestMethod.GET, path = "/actions")
	public String action() {
		return "actions/index";
	}

}
