package br.skdev.core.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import br.skdev.core.Action;
import br.skdev.core.ActionInfo;

@Service
public class ActionService {

	private Logger log = LoggerFactory.getLogger(ActionService.class);

	@Autowired
	@Qualifier("actionMap")
	private Map<String, Action> actions;

	public List<ActionInfo> findAllActions() {
		log.info("[findAllActions] Buscando actions do sistema");
		// @formatter:off
		return actions
				.values()
				.stream()
				.map(action -> action.getActionInfo())
				.collect(Collectors.toList());
		// @formatter:on

	}

	public ActionInfo findAction(String id) {
		System.out.println(actions);
		Action action = actions.get(id);
		action.prepareActionDialog();
		return action.getActionInfo();
	}
}
