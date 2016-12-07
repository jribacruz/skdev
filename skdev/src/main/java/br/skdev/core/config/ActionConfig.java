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

	@Bean
	public Map<String, Action> createActionMap() {
		Map<String, Action> acMap = new HashMap<>();
		actions.forEach(action -> acMap.put(action.getActionConfig().getId(), action));
		return acMap;
	}

}
