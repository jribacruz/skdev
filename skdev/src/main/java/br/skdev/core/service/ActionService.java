package br.skdev.core.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.skdev.core.model.EAction;
import br.skdev.core.repository.ActionRepository;

@Service
public class ActionService {

	private Logger log = LoggerFactory.getLogger(ActionService.class);

	@Autowired
	private ActionRepository actionRepository;

	public List<EAction> findAll() {
		return actionRepository.findAll();
	}

	public EAction find(Integer id) {
		return actionRepository.find(id);
	}

}
