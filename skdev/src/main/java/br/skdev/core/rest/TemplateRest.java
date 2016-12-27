package br.skdev.core.rest;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.skdev.core.model.ETemplate;
import br.skdev.core.model.request.ETemplateRequest;
import br.skdev.core.service.TemplateService;
import freemarker.template.TemplateException;

@RestController
public class TemplateRest {

	private Logger log = LoggerFactory.getLogger(TemplateRest.class);

	@Autowired
	private TemplateService templateService;

	@RequestMapping(method = RequestMethod.POST, path = "/api/templates/_merge")
	public ResponseEntity<?> merge(@RequestBody ETemplateRequest eTemplateRequest) throws TemplateException, IOException {
		String merged = templateService.merge(eTemplateRequest.getTemplate().getContent(), eTemplateRequest.getModels());
		log.info("[merge] {}", eTemplateRequest);
		return ResponseEntity.ok(merged);
	}

	@RequestMapping(method = RequestMethod.GET, path = "/api/templates")
	public ResponseEntity<?> findById(@RequestParam("name") String name) {
		ETemplate template = templateService.findByName(name);
		return ResponseEntity.ok(template);
	}

}
