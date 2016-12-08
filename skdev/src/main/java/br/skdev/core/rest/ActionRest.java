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
		List<ActionInfo> actionsInfo = actionService.findAllActions();
		log.info("[findAllActions] {} actions encontradas", actionsInfo.size());
		return ResponseEntity.ok(actionsInfo);
	}
	

	@RequestMapping(method = RequestMethod.GET, path = "api/actions/{id}")
	public ResponseEntity<?> findAction(@PathVariable("id") String id) {
		ActionInfo actionInfo = actionService.findAction(id);
		return ResponseEntity.ok(actionInfo);
	}

	@RequestMapping(method = RequestMethod.POST, path = "api/execute/action/{id}")
	public ResponseEntity<?> executeAction(@PathVariable("id") String id) {
		log.info("[executeAction] Iniciando ");
		return ResponseEntity.ok().build();
	}

}
