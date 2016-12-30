package br.skdev.core.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 
 * @author jcruz
 *
 */
@Controller
public class ActionEditorController {

	@RequestMapping(method = RequestMethod.GET, path = "/action/editor")
	public String actionEditor() {
		return "action/index";
	}

}
