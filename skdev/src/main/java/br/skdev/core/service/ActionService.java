package br.skdev.core.service;

import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.skdev.core.action.Action;
import br.skdev.core.action.ActionRegistry;
import br.skdev.core.component.ActionDialog;
import br.skdev.core.context.UIComponentContext;
import br.skdev.core.context.WorkspaceContext;
import br.skdev.core.impl.UIComponentContextImpl;

@Service
public class ActionService {

	private Logger log = LoggerFactory.getLogger(ActionService.class);

	@Autowired
	private ActionRegistry actionRegistry;

	@Autowired
	private WorkspaceContext workspaceContext;

	public Set<Map<String, String>> findAllActionsHeaders() {
		log.info("[findAllActions] Buscando actions do sistema");
		return actionRegistry.findAllActionHeaders();

	}

	public ActionDialog findActionDialog(String id) {
		return this.actionRegistry.findActionDialogById(id);
	}

	public void executeAction(String id, Map<String, Object> data) {
		Action action = actionRegistry.findActionById(id);
		UIComponentContext ctx = new UIComponentContextImpl(workspaceContext.getJavaProject(),
				actionRegistry.findActionDialogById(id).getComponentMap(), data);
		action.execute(ctx);
	}
}
