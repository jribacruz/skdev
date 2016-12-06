package br.skdev.core.rest;

import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.skdev.core.Action;
import br.skdev.core.ActionConfig;

@RestController
public class ActionRest {

	@Inject
	private List<Action> actions;

	@RequestMapping(method = RequestMethod.GET, path = "api/actions")
	public ResponseEntity<?> findAllActions() {
		// @formatter:off
		List<ActionConfig> actionConfigs = actions
					.stream()
					.map(action -> action.getActionConfig())
					.collect(Collectors.toList());
		// @formatter:on
		return ResponseEntity.ok(actionConfigs);
	}

}
