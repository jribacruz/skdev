package br.skdev.core;

import java.io.Serializable;

import org.jtwig.JtwigModel;
import org.jtwig.JtwigTemplate;

/**
 * 
 * @author jcruz
 *
 */
public class TemplateUIFragment implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private StringBuilder templateBuilder = new StringBuilder();

	public TemplateUIFragment add(String fragment) {
		templateBuilder.append(fragment);
		templateBuilder.append("\n");
		return this;
	}

	public <T extends UIComponent> String merge(T componentModel) {
		JtwigTemplate jtwigTemplate = JtwigTemplate.inlineTemplate(templateBuilder.toString());
		JtwigModel model = JtwigModel.newModel().with("component", componentModel);
		return jtwigTemplate.render(model);
	}

}
