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
	public String buildUIComponentTemplateFragment() {
		TemplateUIFragment fragment = new TemplateUIFragment();
		fragment.add("<md-dialog>");
		fragment.add("	<md-dialog-content>");
		this.buildUIComponentsTemplateFragments(fragment);
		fragment.add("	</md-dialog-content>");
		fragment.add("<md-dialog>");
		return fragment.merge(this);
	}

	private void buildUIComponentsTemplateFragments(TemplateUIFragment fragment) {
		this.components.forEach(component -> fragment.add(component.buildUIComponentTemplateFragment()));
	}

}
