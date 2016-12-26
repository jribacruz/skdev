package br.skdev.core.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import br.skdev.core.service.ActionService;

@RestController
public class ActionRest {

	private Logger log = LoggerFactory.getLogger(ActionRest.class);

	@Autowired
	private ActionService actionService;

}
