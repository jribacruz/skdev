package br.skdev.core.rest;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.skdev.core.action.ActionHandler;
import br.skdev.core.service.ActionService;

@RestController
public class ActionRest {

	private Logger log = LoggerFactory.getLogger(ActionRest.class);

	@Autowired
	private ActionService actionService;

	@RequestMapping(method = RequestMethod.GET, path = "api/actions")
	public ResponseEntity<?> findAllActionsDescription() {
		Map<String, String> actionDescriptionMap = actionService.findAllActionDescription();
		log.info("[findAllActions] {} actions encontradas", actionDescriptionMap.size());
		return ResponseEntity.ok(actionDescriptionMap);
	}

	@RequestMapping(method = RequestMethod.GET, path = "api/actions/{id}")
	public ResponseEntity<?> findActionById(@PathVariable("id") String actionId) throws IOException {
		Optional<ActionHandler> action = actionService.findById(actionId);
		if (action.isPresent()) {
			Map<String, String> actionMap = new HashMap<>();
			actionMap.put("config", action.get().getConfig());
			actionMap.put("component", action.get().getComponent());
			log.info("[findActionById] body={}", actionMap);
			return ResponseEntity.ok(actionMap);

		}
		return ResponseEntity.notFound().build();
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "api/actions/{id}/success", produces="text/html")
	public ResponseEntity<?> findActionSucceddById(@PathVariable("id") String actionId) throws IOException {
		Optional<ActionHandler> action = actionService.findById(actionId);
		if (action.isPresent()) {
			return ResponseEntity.ok(action.get().getSuccess());
		}
		return ResponseEntity.notFound().build();
	}

}
