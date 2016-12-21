package br.skdev.core.rest;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.skdev.core.action.ActionHandler;
import br.skdev.core.service.ActionService;

@RestController
public class ActionRest {

	private Logger log = LoggerFactory.getLogger(ActionRest.class);

	@Autowired
	private ActionService actionService;

	
	@RequestMapping(method = RequestMethod.GET, path = "api/all/actions")
	public ResponseEntity<?> findAllActions() {
		Set<ActionHandler> actions = actionService.findAllActions();
		log.info("[findAllActions] {} actions encontradas", actions.size());
		return ResponseEntity.ok(actions);
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "api/actions")
	public ResponseEntity<?> findAllActionsDescriptionByGroup(@RequestParam("group") String group) {
		Map<String, String> actionDescriptionMap = actionService.findAllActionDescriptionByGroup(group);
		log.info("[findAllActions] {} actions encontradas", actionDescriptionMap.size());
		return ResponseEntity.ok(actionDescriptionMap);
	}

	@RequestMapping(method = RequestMethod.GET, path = "api/actions/{id}")
	public ResponseEntity<?> findActionById(@PathVariable("id") String actionId) throws IOException {
		Optional<ActionHandler> action = actionService.findById(actionId);
		if (action.isPresent()) {
			Map<String, Object> actionMap = new HashMap<>();
			actionMap.put("dialogTemplatePath", action.get().getDialogTemplatePath());
			log.info("[findActionById] body={}", actionMap);
			return ResponseEntity.ok(actionMap);

		}
		return ResponseEntity.notFound().build();
	}

	@RequestMapping(method = RequestMethod.POST, path = "api/actions/{id}")
	public ResponseEntity<?> executeActionById(@PathVariable("id") String actionId, @RequestBody Map<String, Object> values)
			throws IOException {
		log.info("[executeActionById] id={}, values={}", actionId, values);
		actionService.executeAction(actionId, values);
		return ResponseEntity.ok().build();
	}

}
