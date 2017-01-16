package br.skdev.core.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.skdev.core.domain.Fragment;
import br.skdev.core.service.FragmentService;

@RestController
public class FragmentRest {

	private Logger log = LoggerFactory.getLogger(FragmentRest.class);

	@Autowired
	private FragmentService fragmentService;

	@RequestMapping(method = RequestMethod.GET, path = "/api/fragments")
	public ResponseEntity<?> findAll() {
		Iterable<Fragment> fragments = fragmentService.findAll();
		return ResponseEntity.ok(fragments);
	}

}
