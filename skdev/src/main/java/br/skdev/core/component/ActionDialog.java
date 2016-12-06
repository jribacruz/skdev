package br.skdev.core.component;

import java.util.ArrayList;
import java.util.List;

import br.skdev.core.TemplateUIFragment;
import br.skdev.core.UIComponent;

/**
 * 
 * @author jcruz
 *
 */
public class ActionDialog extends UIComponent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<UIComponent> components = new ArrayList<>();

	public ActionDialog(String id, String label) {
		super(id, label);
	}

	public void add(UIComponent component) {
		this.components.add(component);
	}

	@Override
	public String buildTemplateUIFragment() {
		TemplateUIFragment fragment = new TemplateUIFragment();
		fragment.add("<md-dialog>");
		this.components.forEach(component -> fragment.add(component.buildTemplateUIFragment()));
		fragment.add("</md-dialog>");
		return fragment.merge(this);
	}

}
