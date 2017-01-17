package br.skdev.core.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.skdev.core.domain.Action;
import br.skdev.core.repository.ActionRepository;

@Service
public class ActionService {

	private Logger log = LoggerFactory.getLogger(ActionService.class);

	@Autowired
	private ActionRepository actionRepository;

	public Iterable<Action> findAll() {
		return actionRepository.findAll();
	}

	public Action findOne(Integer id) {
		return actionRepository.findOne(id);
	}

	public Optional<Action> findById(Integer id) {
		return actionRepository.findById(id);
	}

	public Action insert(Action eAction) {
		return actionRepository.save(eAction);
	}

	public Action update(Integer id, Action eAction) {
		return actionRepository.save(eAction);
	}

}
