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
import br.skdev.core.service.TemplateService;

@RestController
public class TemplateRest {

	private Logger log = LoggerFactory.getLogger(TemplateRest.class);

	@Autowired
	private TemplateService templateService;

	@RequestMapping(method = RequestMethod.POST, path = "/api/templates")
	public ResponseEntity<?> insert(@RequestBody ETemplate eTemplate) {
		log.info("INSERT ETemplate {}", eTemplate);
		eTemplate = templateService.insert(eTemplate);
		return ResponseEntity.ok(eTemplate);
	}

	@RequestMapping(method = RequestMethod.PUT, path = "/api/templates/{id}")
	public ResponseEntity<?> udpate(@PathVariable("id") Integer id, @RequestBody ETemplate eTemplate) {
		log.info("UPDATE ETemplate {}", eTemplate);
		templateService.update(id, eTemplate);
		return ResponseEntity.ok().build();
	}

	@RequestMapping(method = RequestMethod.DELETE, path = "/api/templates/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
		log.info("DELETE ETemplate {}", id);
		templateService.delete(id);
		return ResponseEntity.ok().build();
	}

}
