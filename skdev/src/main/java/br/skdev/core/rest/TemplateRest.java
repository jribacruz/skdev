package br.skdev.core.rest;

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

@RestController
public class TemplateRest {

	private Logger log = LoggerFactory.getLogger(TemplateRest.class);

	@Autowired
	private TemplateService templateService;

	@RequestMapping(method = RequestMethod.POST, path = "/api/templates/{id}/_merge")
	public ResponseEntity<?> merge(@PathVariable("id") Long templateId, @RequestBody ETemplateModelRequest eTemplateModelRequest) {
		log.info("[merge] {}", eTemplateModelRequest);
		return ResponseEntity.ok().build();
	}

	@RequestMapping(method = RequestMethod.GET, path = "/api/templates/{id}")
	public ResponseEntity<?> findById(@PathVariable("id") Integer templateId) {
		ETemplate template = templateService.findById(templateId);
		return ResponseEntity.ok(template);
	}
}
