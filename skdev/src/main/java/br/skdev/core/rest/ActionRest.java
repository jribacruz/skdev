package br.skdev.core.rest;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.skdev.core.Action;
import br.skdev.core.ActionInfo;

@RestController
public class ActionRest {

	@Autowired
	private Map<String, Action> actions;

	@RequestMapping(method = RequestMethod.GET, path = "api/actions")
	public ResponseEntity<?> findAllActions() {
		// @formatter:off
		List<ActionInfo> actionConfigs = actions
					.values()
					.stream()
					.map(action -> action.getActionConfig())
					.collect(Collectors.toList());
		// @formatter:on
		return ResponseEntity.ok(actionConfigs);
	}

}
