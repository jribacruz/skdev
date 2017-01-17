package br.skdev.core.rest;

import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
		//// @formatter:off
		Map<String,Fragment> fragments = fragmentService.findAll()
												.stream()
												.collect(Collectors
															.toMap(fragment -> fragment.getName() , 
																   fragment -> fragment));
		// @formatter:on
		return ResponseEntity.ok(fragments);
	}

	@RequestMapping(method = RequestMethod.GET, path = "/api/fragments/_search")
	public ResponseEntity<?> findByName(@RequestParam("name") String name) {
		Optional<Fragment> fragment = fragmentService.findByName(name);
		if (fragment.isPresent()) {
			return ResponseEntity.ok(fragment.get());
		}
		return ResponseEntity.notFound().build();
	}

}
