package br.skdev.repository;

import java.io.Serializable;
import java.util.Optional;
import java.util.Set;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import br.skdev.core.action.Action;

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
	private Set<Action> actions;

	/**
	 * Retorna uma action pelo nome.
	 * 
	 * @param name
	 *            Name da action.
	 * @return
	 */
	public Optional<Action> findByClassName(String name) {
		log.info("[findByClassName] name={}", name);
		//// @formatter:off
		return actions
				.stream()
				.filter(action -> action.getClass().getSimpleName().equals(name))
				.findFirst();
		// @formatter:on
	}
}
