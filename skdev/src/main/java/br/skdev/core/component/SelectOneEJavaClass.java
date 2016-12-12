package br.skdev.core.component;

import java.util.Optional;
import java.util.SortedSet;
import java.util.TreeSet;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.skdev.core.MavenFolder;
import br.skdev.core.Selectable;
import br.skdev.core.TemplateUIFragment;
import br.skdev.core.component.base.UIComponentData;
import br.skdev.core.model.EJavaClass;
import br.skdev.core.model.EJavaProject;

/**
 * 
 * @author jcruz
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SelectOneEJavaClass extends UIComponentData<Optional<EJavaClass>> {
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
			.add("			 <md-select ng-model=\"actionCT.components['${component.id}'].value\"")
			.add("				required=''", this.required)
			.add("				>")
			.add("				 <md-option ng-repeat=\"option in actionCT.components['${component.id}'].options | orderBy:'label' \" ng-value=\"option.id\" >")
			.add(" 					{{option.label}}")		
			.add("				 </md-option>")
			.add("			 </md-select>")
			.add("		</md-input-container>");
		// @formatter:on
		return fragment.merge(this);
	}

	@Override
	public Optional<EJavaClass> getValue(EJavaProject eJavaProject, Object data) {
		String className = (String) data;
		if (eJavaProject.getEJavaClasses(MavenFolder.SRC_MAIN_JAVA).stream()
				.anyMatch(eJavaClass -> eJavaClass.getName().equals(className))) {
			return eJavaProject.getEJavaClasses(MavenFolder.SRC_MAIN_JAVA).stream()
					.filter(eJavaClass -> eJavaClass.getName().equals(className)).findFirst();
		}
		return Optional.empty();
	}

}
