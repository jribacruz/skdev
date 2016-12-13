package br.skdev.core.component;

import java.util.Optional;
import java.util.SortedSet;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import br.skdev.core.MavenFolder;
import br.skdev.core.Selectable;
import br.skdev.core.TemplateUIFragment;
import br.skdev.core.component.base.UIComponentData;
import br.skdev.core.model.EClass;
import br.skdev.core.model.EMavenProject;

/**
 * 
 * @author jcruz
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SelectOneEJavaClass extends UIComponentData<Optional<EClass>> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@JsonIgnore
	private boolean required;

	private SortedSet<? extends Selectable> options;

	private String optionsEndpoint;

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
		return options;
	}

	public void setOptions(SortedSet<? extends Selectable> options) {
		this.options = options;
	}

	public String getOptionsEndpoint() {
		return optionsEndpoint;
	}

	public void setOptionsEndpoint(String optionsEndpoint) {
		this.optionsEndpoint = optionsEndpoint;
	}

	@Override
	public String buildUIComponentTemplateFragment() {
		TemplateUIFragment fragment = new TemplateUIFragment();
		// @formatter:off
		fragment
			.add("		<md-input-container class='md-block'>")
			.add("			<label>${component.label}</label>")
			.add("			 <md-select ng-model=\"actionCT.values['${component.id}']\"")
			.add("				required=''", this.required)
			.add("				>")
			.add("				 <md-option ng-repeat=\"option in actionCT.options['${component.id}'] | orderBy:'label' \" ng-value=\"option.id\" >")
			.add(" 					{{option.label}}")		
			.add("				 </md-option>")
			.add("			 </md-select>")
			.add("		</md-input-container>");
		// @formatter:on
		return fragment.merge(this);
	}

	@Override
	public Optional<EClass> getValue(EMavenProject eJavaProject, Object data) {
		String className = (String) data;
		if (eJavaProject.getEJavaClasses(MavenFolder.SRC_MAIN_JAVA).stream()
				.anyMatch(eJavaClass -> eJavaClass.getName().equals(className))) {
			return eJavaProject.getEJavaClasses(MavenFolder.SRC_MAIN_JAVA).stream()
					.filter(eJavaClass -> eJavaClass.getName().equals(className)).findFirst();
		}
		return Optional.empty();
	}

}
