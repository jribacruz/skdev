package br.skdev.action;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.skdev.core.action.ActionHandler;
import br.skdev.core.annotation.Action;
import br.skdev.core.context.ActionContext;

/**
 * 
 * @author jcruz
 *
 */
@Action(description = "Teste Action Archetype2", group="archetypes")
public class TestArchetype2Action implements ActionHandler {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Logger log = LoggerFactory.getLogger(TestArchetype2Action.class);

	/**
	 * 
	 */
	@Override
	public void execute(ActionContext ctx) {
		log.info("[execute] ctx={}", ctx);
		System.out.println(ctx.getValues("selectClassId"));
	}

}
