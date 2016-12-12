package br.skdev.core.config;

import java.util.Set;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.skdev.core.action.Action;
import br.skdev.core.action.ActionRegistry;
import br.skdev.core.impl.ActionRegistryImpl;

@Configuration
public class ActionConfig {

	private Logger log = LoggerFactory.getLogger(ActionConfig.class);

	@Inject
	private Set<Action> actions;

	@Bean
	public ActionRegistry createActionRegistry() {
		log.info("[createActionRegistry] {} actions econtradas", actions.size());
		ActionRegistry actionRegistry = new ActionRegistryImpl(actions);
		return actionRegistry;
	}

}
