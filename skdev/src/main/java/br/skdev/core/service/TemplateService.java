package br.skdev.core.service;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.skdev.core.model.ETemplate;
import br.skdev.core.model.ETemplateModel;
import br.skdev.core.repository.TemplateRepository;
import br.skdev.core.template.Template;
import freemarker.template.TemplateException;

@Service
public class TemplateService {

	@Autowired
	private TemplateRepository templateRepository;

	@Autowired
	private Template template;

	public ETemplate findById(Integer id) {
		return templateRepository.findById(id);
	}

	public String merge(ETemplate etemplate, Map<String, ETemplateModel> models) throws TemplateException, IOException {
		return template.merge(etemplate.getContent(), models);
	}
}
