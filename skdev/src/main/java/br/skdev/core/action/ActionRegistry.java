package br.skdev.core.action;

import java.io.Serializable;
import java.util.Map;
import java.util.Set;

import br.skdev.core.component.ActionDialog;

/**
 * 
 * @author jcruz
 *
 */
public interface ActionRegistry extends Serializable {

	public Map<String, String> findActionHeaderById(String id);

	public Set<Map<String, String>> findAllActionHeaders();

	public ActionDialog findActionDialogById(String id);

	public ActionHandler findActionById(String id);

}
