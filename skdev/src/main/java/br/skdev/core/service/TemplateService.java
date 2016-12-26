package br.skdev.core.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.io.Writer;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.skdev.core.model.ETemplate;
import br.skdev.core.model.ETemplateModel;
import br.skdev.core.repository.TemplateRepository;
import freemarker.template.Configuration;
import freemarker.template.TemplateException;

@Service
public class TemplateService {

	@Autowired
	private TemplateRepository templateRepository;

	public ETemplate findByName(String name) {
		return templateRepository.findByName(name);
	}

	public String merge(ETemplate etemplate, Map<String, ETemplateModel> models) throws TemplateException, IOException {
		return merge(etemplate.getContent(), models);
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
