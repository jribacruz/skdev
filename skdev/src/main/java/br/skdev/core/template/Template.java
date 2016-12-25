package br.skdev.core.template;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Serializable;
import java.io.StringReader;
import java.io.Writer;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import br.skdev.core.model.ETemplateModel;
import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.TemplateException;

/**
 * 
 * @author jcruz
 *
 */
@Component
public class Template implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Configuration cfg;

	@PostConstruct
	public void init() {
		this.cfg = new Configuration();
		this.cfg.setObjectWrapper(new DefaultObjectWrapper());
		this.cfg.setClassForTemplateLoading(Template.class, "/static/actions/templates/");
		this.cfg.setDefaultEncoding("UTF-8");
	}

	public String merge(String template, Map<String, ETemplateModel> model) throws TemplateException, IOException {
		freemarker.template.Template inlineTemplate = new freemarker.template.Template("inlineTemplate", new StringReader(template),
				new Configuration());
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		Writer out = new OutputStreamWriter(outputStream);
		inlineTemplate.process(model, out);
		return outputStream.toString();
	}

}
