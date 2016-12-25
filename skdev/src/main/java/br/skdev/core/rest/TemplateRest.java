package br.skdev.core.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.skdev.core.model.request.ETemplateModelRequest;

@RestController
public class TemplateRest {

	private Logger log = LoggerFactory.getLogger(TemplateRest.class);

	@RequestMapping(method = RequestMethod.POST, path = "/api/templates/{id}/_merge")
	public ResponseEntity<?> merge(@PathVariable("id") Long templateIds, @RequestBody ETemplateModelRequest eTemplateModelRequest) {
		log.info("[merge] {}", eTemplateModelRequest);
		return ResponseEntity.ok().build();
	}
}
