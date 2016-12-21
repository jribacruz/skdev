package br.skdev.core.rest;

import java.io.IOException;
import java.util.List;
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

	@RequestMapping(method = RequestMethod.GET, path = "api/actions")
	public ResponseEntity<?> findActions(@RequestParam(name = "group", required = false) List<String> groups) {
		if (!groups.isEmpty()) {
			Set<ActionHandler> actions = actionService.findActionsByGroups(groups);
			log.info("[findAllActions] {} actions encontradas", actions.size());
			return ResponseEntity.ok(actions);
		}
		Set<ActionHandler> actions = actionService.findAllActions();
		log.info("[findAllActions] {} actions encontradas", actions.size());
		return ResponseEntity.ok(actions);

	}

	/**
	 * 
	 * @param actionId
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(method = RequestMethod.GET, path = "api/actions/{id}")
	public ResponseEntity<?> findActionById(@PathVariable("id") String actionId) throws IOException {
		Optional<ActionHandler> action = actionService.findById(actionId);
		if (action.isPresent()) {
			log.info("[findActionById] body={}", action.get());
			return ResponseEntity.ok(action.get());

		}
		return ResponseEntity.notFound().build();
	}

	/**
	 * 
	 * @param actionId
	 * @param values
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(method = RequestMethod.POST, path = "api/actions/{id}")
	public ResponseEntity<?> executeActionById(@PathVariable("id") String actionId, @RequestBody Map<String, Object> values)
			throws IOException {
		log.info("[executeActionById] id={}, values={}", actionId, values);
		actionService.executeAction(actionId, values);
		return ResponseEntity.ok().build();
	}

}
