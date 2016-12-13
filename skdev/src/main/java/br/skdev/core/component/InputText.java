package br.skdev.core.component;

import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import br.skdev.core.TemplateUIFragment;
import br.skdev.core.component.base.UIComponentData;
import br.skdev.core.model.EMavenProject;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class InputText extends UIComponentData<Optional<String>> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InputText(String id, String label) {
		super(id, label);
	}

	@Override
	public Optional<String> getValue(EMavenProject eJavaProject, Object data) {
		String value = (String) data;
		if (!value.isEmpty()) {
			return Optional.of(value);
		}
		return Optional.empty();
	}

	@Override
	public String buildUIComponentTemplateFragment() {
		TemplateUIFragment fragment = new TemplateUIFragment();
		// @formatter:off
		fragment
			.add("		<md-input-container class='md-block'>")
			.add("			<label>${component.label}</label>")
			.add("			<input ng-model=\"actionCT.values['${component.id}']\">")
			.add("		</md-input-container>");
		// @formatter:on
		return fragment.merge(this);
	}

}
