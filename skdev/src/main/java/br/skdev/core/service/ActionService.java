package br.skdev.core.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.skdev.core.repository.ActionRepository;

@Service
public class ActionService {

	private Logger log = LoggerFactory.getLogger(ActionService.class);

	@Autowired
	private ActionRepository actionRepository;

}
