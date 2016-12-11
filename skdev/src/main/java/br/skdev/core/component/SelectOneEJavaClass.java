package br.skdev.core.component;

import java.util.SortedSet;
import java.util.TreeSet;

import br.skdev.core.TemplateUIFragment;
import br.skdev.core.UIComponent;
import br.skdev.core.model.EJavaClass;

/**
 * 
 * @author jcruz
 *
 */
public class SelectOneEJavaClass extends UIComponent {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private boolean required;

	private SortedSet<EJavaClass> options;

	public SelectOneEJavaClass(String id, String label) {
		super(id, label);
	}

	public boolean isRequired() {
		return required;
	}

	public void setRequired(boolean required) {
		this.required = required;
	}

	public SortedSet<EJavaClass> getOptions() {
		if (this.options == null) {
			this.options = new TreeSet<>();
		}
		return options;
	}

	public void setOptions(SortedSet<EJavaClass> options) {
		this.options = options;
	}

	@Override
	public String buildUIComponentTemplateFragment() {
		TemplateUIFragment fragment = new TemplateUIFragment();
		// @formatter:off
		fragment
			.add("		<md-input-container>")
			.add("			<label>{{component.label}}</label>")
			.add("			 <md-select ng-model=\"actionCT.values['{{component.id}}']\">")
			.add("				 <md-option><em>None</em></md-option>")
			.add("			 </md-select>")
			.add("		</md-input-container>");
		// @formatter:on
		return fragment.merge(this);
	}

}
