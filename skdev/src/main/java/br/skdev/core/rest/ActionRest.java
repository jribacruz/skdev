package br.skdev.core.rest;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.skdev.core.domain.Action;
import br.skdev.core.service.ActionService;

@RestController
public class ActionRest {

	private Logger log = LoggerFactory.getLogger(ActionRest.class);

	@Autowired
	private ActionService actionService;

	@RequestMapping(method = RequestMethod.GET, path = "/api/actions")
	public ResponseEntity<?> findAll() {
		Iterable<Action> actions = actionService.findAll();
		return ResponseEntity.ok(actions);
	}

	@RequestMapping(method = RequestMethod.GET, path = "/api/actions/{id}")
	public ResponseEntity<?> find(@PathVariable("id") Integer id) {
		Optional<Action> action = actionService.findById(id);
		if (action.isPresent()) {
			return ResponseEntity.ok(action.get());
		}
		return ResponseEntity.noContent().build();
	}

	@RequestMapping(method = RequestMethod.POST, path = "/api/actions")
	public ResponseEntity<?> insert(@RequestBody Action eAction) {
		log.info("Insert EAction {}", eAction);
		eAction = actionService.insert(eAction);
		return ResponseEntity.ok(eAction);
	}

	@RequestMapping(method = RequestMethod.PUT, path = "/api/actions/{id}")
	public ResponseEntity<?> udpate(@PathVariable("id") Integer id, @RequestBody Action rAction) {
		log.info("Insert EAction {}", rAction);
		Optional<Action> opAction = actionService.findById(id);
		if (opAction.isPresent()) {
			Action updatedAction = actionService.update(opAction, rAction);
			return ResponseEntity.ok(updatedAction);
		}
		return ResponseEntity.notFound().build();
	}

}
