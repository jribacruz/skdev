package br.skdev.core.rest;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.skdev.core.model.ETemplate;
import br.skdev.core.model.request.ETemplateModelRequest;
import br.skdev.core.service.TemplateService;
import freemarker.template.TemplateException;

@RestController
public class TemplateRest {

	private Logger log = LoggerFactory.getLogger(TemplateRest.class);

	@Autowired
	private TemplateService templateService;

	@RequestMapping(method = RequestMethod.POST, path = "/api/templates/{id}/_merge")
	public ResponseEntity<?> merge(@PathVariable("id") Integer templateId, @RequestBody ETemplateModelRequest eTemplateModelRequest)
			throws TemplateException, IOException {
		ETemplate template = templateService.findById(templateId);
		String merged = templateService.merge(template, eTemplateModelRequest.getModels());
		log.info("[merge] {}", eTemplateModelRequest);
		return ResponseEntity.ok(merged);
	}

	@RequestMapping(method = RequestMethod.GET, path = "/api/templates/{id}")
	public ResponseEntity<?> findById(@PathVariable("id") Integer templateId) {
		ETemplate template = templateService.findById(templateId);
		return ResponseEntity.ok(template);
	}
}
