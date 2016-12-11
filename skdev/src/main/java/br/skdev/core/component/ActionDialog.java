package br.skdev.core.component;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.skdev.core.TemplateUIFragment;
import br.skdev.core.UIComponent;

/**
 * 
 * @author jcruz
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ActionDialog extends UIComponent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<UIComponent> components = new ArrayList<>();

	private String template;

	public ActionDialog(String id, String label) {
		super(id, label);
	}

	public void add(UIComponent component) {
		this.components.add(component);
	}

	public String getTemplate() {
		return template;
	}

	public void setTemplate(String template) {
		this.template = template;
	}

	@Override
	public String buildUIComponentTemplateFragment() {
		TemplateUIFragment fragment = new TemplateUIFragment();
		fragment.add("<md-dialog aria-label='{{component.label}}'>");
		fragment.add("  <md-toolbar>");
		fragment.add("  <div class='md-toolbar-tools'>");
		fragment.add("  	<h2>{{component.label}}</h2>");
		fragment.add("  </div>");
		fragment.add("	</md-toolbar>");
		fragment.add("	<md-dialog-content>");
		this.buildUIComponentsTemplateFragments(fragment);
		fragment.add("	</md-dialog-content>");
		fragment.add("<md-dialog-actions>");
		fragment.add("	<md-button class='md-primary'>");
		fragment.add("		Fechar");
		fragment.add("  </md-button>");
		fragment.add("</md-dialog-actions>");
		fragment.add("</md-dialog>");
		return fragment.merge(this);
	}

	private void buildUIComponentsTemplateFragments(TemplateUIFragment fragment) {
		this.components.forEach(component -> fragment.add(component.buildUIComponentTemplateFragment()));
	}

}
