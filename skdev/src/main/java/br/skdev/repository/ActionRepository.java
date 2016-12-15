package br.skdev.repository;

import java.io.Serializable;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import br.skdev.core.action.ActionHandler;
import br.skdev.core.annotation.Action;

@Repository
public class ActionRepository implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Logger log = LoggerFactory.getLogger(ActionRepository.class);

	/**
	 * Conjunto de todas as ações do sistema.
	 */
	@Inject
	private Set<ActionHandler> actions;

	/**
	 * Retorna uma action pelo nome.
	 * 
	 * @param id
	 *            Name da action.
	 * @return
	 */
	public Optional<ActionHandler> findById(String id) {
		log.info("[findByClassName] name={}", id);
		//// @formatter:off
		return actions
				.stream()
				.filter(action -> action.getClass().isAnnotationPresent(Action.class))
				.filter(action -> action.getId().equals(id))
				.findFirst();
		// @formatter:on
	}

	/**
	 * Retorna todas as actions do sistema.
	 * 
	 * @return
	 */
	public Set<ActionHandler> findAll() {
		//// @formatter:off
		return this.actions
				.stream()
				.filter(action -> action.getClass().isAnnotationPresent(Action.class))
				.collect(Collectors.toSet());
		// @formatter:on
	}
}
