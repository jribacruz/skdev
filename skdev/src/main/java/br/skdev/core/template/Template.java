package br.skdev.core.template;

import java.io.File;
import java.io.Serializable;
import java.io.StringReader;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;

/**
 * 
 * @author jcruz
 *
 */
public class Template implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private File file;

	public Template(File file) {
		super();
		this.file = file;
	}

	public String merge(TemplateModel model) {
		Configuration cfg = new Configuration();
		cfg.setObjectWrapper(new DefaultObjectWrapper());
		//Template t = new Template(this.templateName, new StringReader(templateBuilder.toString()), cfg);
		return null;
	}

}
