package br.skdev.core.impl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.UUID;

import br.skdev.core.action.Action;
import br.skdev.core.action.ActionRegistry;
import br.skdev.core.component.ActionDialog;
import br.skdev.core.component.builder.ActionDialogBuilder;
import br.skdev.core.component.builder.ActionHeaderBuilder;

/**
 * 
 * @author jcruz
 *
 */
public class ActionRegistryImpl implements ActionRegistry {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Map<String, Action> actionMap = new HashMap<>();

	public ActionRegistryImpl(Set<Action> actions) {
		super();
		actions.forEach(action -> actionMap.put(getActionId(action.getClass().getSimpleName()), action));
	}

	/**
	 * 
	 */
	@Override
	public Map<String, String> findActionHeaderById(String id) {
		Map<String, String> headers = new HashMap<>();
		this.actionMap.get(id).configureActionHeader(new ActionHeaderBuilder(headers, id));
		return headers;
	}

	/**
	 * 
	 */
	@Override
	public ActionDialog findActionDialogById(String id) {
		ActionDialog actionDialog = new ActionDialog(id);
		this.actionMap.get(id).configureActionDialog(new ActionDialogBuilder(actionDialog));
		return actionDialog;
	}

	/**
	 * 
	 */
	@Override
	public Set<Map<String, String>> findAllActionHeaders() {
		Set<Map<String, String>> actionsHeaders = new HashSet<>();
		actionMap.forEach((id, action) -> actionsHeaders.add(this.findActionHeaderById(id)));
		return actionsHeaders;
	}

	public String getActionId(String actionName) {
		return UUID.nameUUIDFromBytes(actionName.getBytes()).toString();
	}

}
