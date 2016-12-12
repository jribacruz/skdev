package br.skdev.core.service;

import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.skdev.core.action.ActionRegistry;
import br.skdev.core.component.ActionDialog;

@Service
public class ActionService {

	private Logger log = LoggerFactory.getLogger(ActionService.class);

	@Autowired
	private ActionRegistry actionRegistry;

	public Set<Map<String, String>> findAllActionsHeaders() {
		log.info("[findAllActions] Buscando actions do sistema");
		return actionRegistry.findAllActionHeaders();

	}

	public ActionDialog findActionDialog(String id) {
		return this.actionRegistry.findActionDialogById(id);
	}
	
	public void executeAction(String id, Map<String, Object> data) {
	}
}
