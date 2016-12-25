package br.skdev.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.skdev.core.model.ETemplate;
import br.skdev.core.repository.TemplateRepository;

@Service
public class TemplateService {

	@Autowired
	private TemplateRepository templateRepository;

	public ETemplate findById(Integer id) {
		return templateRepository.findById(id);
	}
}
