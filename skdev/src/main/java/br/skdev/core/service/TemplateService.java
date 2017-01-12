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
	private TemplateRepository actionRepository;

	public ETemplate insert(ETemplate eTemplate) {
		return actionRepository.insert(eTemplate);
	}

	public void update(Integer id, ETemplate eTemplate) {
		actionRepository.update(id, eTemplate);
	}

}
