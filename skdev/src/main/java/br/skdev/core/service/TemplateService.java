package br.skdev.core.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.skdev.core.domain.Action;
import br.skdev.core.domain.Template;
import br.skdev.core.repository.TemplateRepository;

@Service
public class TemplateService {

	private Logger log = LoggerFactory.getLogger(TemplateService.class);

	@Autowired
	private TemplateRepository templateRepository;

	public Optional<Template> findById(Integer id) {
		return templateRepository.findById(id);
	}

	public Template insert(Action action, Template eTemplate) {
		eTemplate.setAction(action);
		return templateRepository.save(eTemplate);
	}

	public Template update(Optional<Template> opTemplate, Template rTemplate) {
		Template template = opTemplate.get();
		template.setContent(rTemplate.getContent());
		template.setDescription(rTemplate.getDescription());
		template.setName(rTemplate.getName());
		return templateRepository.save(template);
	}

	public void delete(Integer id) {
		templateRepository.delete(id);
	}

}
