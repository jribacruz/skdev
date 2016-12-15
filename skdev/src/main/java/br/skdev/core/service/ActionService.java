package br.skdev.core.service;

import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.skdev.core.annotation.Action;
import br.skdev.repository.ActionRepository;

@Service
public class ActionService {

	private Logger log = LoggerFactory.getLogger(ActionService.class);

	@Autowired
	private ActionRepository actionRepository;

	public Map<String, String> findAllActionDescription() {
		//// @formatter:off
		return this.actionRepository.findAll()
					.stream()
					.collect(Collectors.toMap(
							action -> action.getId(), 
							action -> action.getClass().getAnnotation(Action.class).description()));
		// @formatter:on
	}
}
