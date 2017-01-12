package br.skdev.core.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.skdev.core.model.ETemplate;
import br.skdev.core.repository.TemplateRepository;

@Service
public class TemplateService {

	private Logger log = LoggerFactory.getLogger(TemplateService.class);

	@Autowired
	private TemplateRepository templateRepository;

	public ETemplate insert(ETemplate eTemplate) {
		return templateRepository.insert(eTemplate);
	}

	public void update(Integer id, ETemplate eTemplate) {
		templateRepository.update(id, eTemplate);
	}
	
	public void delete(Integer id) {
		templateRepository.delete(id);
	}

}
