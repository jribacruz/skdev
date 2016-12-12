package br.skdev.core.rest;

import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.skdev.core.component.ActionDialog;
import br.skdev.core.service.ActionService;

@RestController
public class ActionRest {

	private Logger log = LoggerFactory.getLogger(ActionRest.class);

	@Autowired
	private ActionService actionService;

	@RequestMapping(method = RequestMethod.GET, path = "api/actions")
	public ResponseEntity<?> findAllActionsHeaders() {
		Set<Map<String, String>> actionsHeaders = actionService.findAllActionsHeaders();
		log.info("[findAllActions] {} actions encontradas", actionsHeaders.size());
		return ResponseEntity.ok(actionsHeaders);
	}

	@RequestMapping(method = RequestMethod.GET, path = "api/actions/{id}")
	public ResponseEntity<?> findActionDialog(@PathVariable("id") String id) {
		ActionDialog actionDialog = actionService.findActionDialog(id);
		return ResponseEntity.ok(actionDialog);
	}

	@RequestMapping(method = RequestMethod.POST, path = "api/execute/action/{id}")
	public ResponseEntity<?> executeAction(@PathVariable("id") String id) {
		log.info("[executeAction] Iniciando ");
		return ResponseEntity.ok().build();
	}

}
