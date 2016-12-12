package br.skdev.core;

import java.io.IOException;
import java.io.Serializable;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import br.skdev.core.component.UIComponent;
import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;

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
		Map<String, T> model = new HashMap<>();
		model.put("component", componentModel);
		
		Configuration cfg = new Configuration();
		cfg.setObjectWrapper(new DefaultObjectWrapper());
		try {
			Template t = new Template("templateName", new StringReader(templateBuilder.toString()), cfg);
			Writer out = new StringWriter();
			t.process(model, out);
			return out.toString();
		} catch (IOException | TemplateException e) {
			e.printStackTrace();
		}
		return "";
	}

}
