package br.skdev.core.component;

import java.util.SortedSet;
import java.util.TreeSet;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.skdev.core.Selectable;
import br.skdev.core.TemplateUIFragment;

/**
 * 
 * @author jcruz
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SelectOneEJavaClass extends UIComponent {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@JsonIgnore
	private boolean required;

	private SortedSet<? extends Selectable> options;

	public SelectOneEJavaClass(String id, String label) {
		super(id, label);
	}

	public boolean isRequired() {
		return required;
	}

	public void setRequired(boolean required) {
		this.required = required;
	}

	public SortedSet<? extends Selectable> getOptions() {
		if (this.options == null) {
			this.options = new TreeSet<>();
		}
		return options;
	}

	public void setOptions(SortedSet<? extends Selectable> options) {
		this.options = options;
	}

	@Override
	public String buildUIComponentTemplateFragment() {
		TemplateUIFragment fragment = new TemplateUIFragment();
		// @formatter:off
		fragment
			.add("		<md-input-container class='md-block'>")
			.add("			<label>${component.label}</label>")
			.add("			 <md-select ng-model=\"actionCT.components['${component.id}'].value\">")
			.add("				 <md-option ng-repeat=\"option in actionCT.components['${component.id}'].options | orderBy:'label' \" ng-value=\"option.id\" >")
			.add(" 					{{option.label}}")		
			.add("				 </md-option>")
			.add("			 </md-select>")
			.add("		</md-input-container>");
		// @formatter:on
		return fragment.merge(this);
	}

}
