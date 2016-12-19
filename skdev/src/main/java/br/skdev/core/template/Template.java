package br.skdev.core.template;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Serializable;
import java.io.StringReader;
import java.io.Writer;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

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

	public String merge(TemplateModel model, String templatePath) throws IOException, TemplateException {
		freemarker.template.Template template = cfg.getTemplate(templatePath);
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		Writer out = new OutputStreamWriter(outputStream);
		template.process(model.getContext(), out);
		return outputStream.toString();
	}

	public String mergeInline(TemplateModel templateModel, String strTemplate) throws TemplateException, IOException {
		freemarker.template.Template inlineTemplate = new freemarker.template.Template("inlineTemplate",
				new StringReader(strTemplate), new Configuration());
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		Writer out = new OutputStreamWriter(outputStream);
		inlineTemplate.process(templateModel.getContext(), out);
		return outputStream.toString();
	}

}
