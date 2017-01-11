package br.skdev.core.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.skdev.core.model.EAction;
import br.skdev.core.service.ActionService;

@RestController
public class ActionRest {

	private Logger log = LoggerFactory.getLogger(ActionRest.class);

	@Autowired
	private ActionService actionService;

	@RequestMapping(method = RequestMethod.GET, path = "/api/actions")
	public ResponseEntity<?> findAll() {
		List<EAction> actions = actionService.findAll();
		return ResponseEntity.ok(actions);
	}

	@RequestMapping(method = RequestMethod.GET, path = "/api/actions/{id}")
	public ResponseEntity<?> find(@PathVariable("id") Integer id) {
		EAction action = actionService.find(id);
		return ResponseEntity.ok(action);
	}

}
