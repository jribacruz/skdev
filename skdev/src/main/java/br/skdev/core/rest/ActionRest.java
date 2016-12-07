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

import br.skdev.core.ActionInfo;
import br.skdev.core.service.ActionService;

@RestController
public class ActionRest {

	private Logger log = LoggerFactory.getLogger(ActionRest.class);

	@Autowired
	private ActionService actionService;

	@RequestMapping(method = RequestMethod.GET, path = "api/actions")
	public ResponseEntity<?> findAllActions() {
		List<ActionInfo> actionConfigs = actionService.findAllActions();
		log.info("[findAllActions] {} actions encontradas", actionConfigs.size());
		return ResponseEntity.ok(actionConfigs);
	}

	@RequestMapping(method = RequestMethod.POST, path = "api/execute/action/{id}")
	public ResponseEntity<?> executeAction(@PathVariable("id") String id) {
		log.info("[executeAction] Iniciando ");
		return ResponseEntity.ok().build();
	}

}
