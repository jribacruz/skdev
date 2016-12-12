package br.skdev.core.component;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.skdev.core.TemplateUIFragment;

/**
 * 
 * @author jcruz
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ActionDialog extends UIComponentContainer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String template;

	public ActionDialog(String id) {
		super(id);
	}

	public String getTemplate() {
		return template;
	}

	public void setTemplate(String template) {
		this.template = template;
	}

	public void setTitle(String title) {
		this.label = title;
	}

	@Override
	public String buildUIComponentTemplateFragment() {
		TemplateUIFragment fragment = new TemplateUIFragment();
		fragment.add("<md-dialog aria-label='${component.label}' style='min-width: 30%'>");
		fragment.add("<form name='actionForm' novalidate>");
		fragment.add("  <md-toolbar>");
		fragment.add("  <div class='md-toolbar-tools'>");
		fragment.add("  	<h2>${component.label}</h2>");
		fragment.add("  </div>");
		fragment.add("	</md-toolbar>");
		fragment.add("	<md-dialog-content flex='' class='md-dialog-content'>");
		this.buildUIComponentsTemplateFragments(fragment);
		fragment.add("	</md-dialog-content>");
		fragment.add("<md-dialog-actions>");
		fragment.add(
				"	<md-button class='md-primary' ng-disabled='actionForm.$invalid' ng-click='actionCT.execute()'>");
		fragment.add("		Executar");
		fragment.add("  </md-button>");
		fragment.add("	<md-button ng-click='actionCT.hide()'>");
		fragment.add("		Fechar");
		fragment.add("  </md-button>");
		fragment.add("</md-dialog-actions>");
		fragment.add("</form>");
		fragment.add("</md-dialog>");
		return fragment.merge(this);
	}

	private void buildUIComponentsTemplateFragments(TemplateUIFragment fragment) {
		this.getComponents().forEach((id, component) -> fragment.add(component.buildUIComponentTemplateFragment()));
	}

}
