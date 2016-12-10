package br.skdev.core.config;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.skdev.core.Action;

@Configuration
public class ActionConfig {

	@Inject
	private List<Action> actions;

	/**
	 * Cria mapa com as ações por chave.
	 * 
	 * @return
	 */
	@Bean(name="actionMap")
	public Map<String, Action> createActionMap() {
		Map<String, Action> acMap = new HashMap<>();
		actions.forEach(action -> {
			action.prepareActionHeader();
			acMap.put(action.getActionInfo().getHeader().getId(), action);
		});
		return acMap;
	}

}
