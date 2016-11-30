package br.skdev.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * @author jcruz
 *
 */
@Controller
public class ProjectController {
	
	@RequestMapping("projects")
	public String select() {
		return "projects";
	}
}
