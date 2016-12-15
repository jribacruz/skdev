package br.skdev.core.action;

import java.io.Serializable;

import br.skdev.core.annotation.Action;
import br.skdev.core.context.UIComponentContext;
import strman.Strman;

/**
 * 
 * @author jcruz
 *
 */
public interface ActionHandler extends Serializable {

	/**
	 * 
	 */
	public abstract void execute(UIComponentContext ctx);

	public default String getId() {
		if (this.getClass().isAnnotationPresent(Action.class)) {
			if (!this.getClass().getAnnotation(Action.class).id().isEmpty()) {
				return this.getClass().getAnnotation(Action.class).id();
			}
		}
		return Strman.toDecamelize(this.getClass().getSimpleName(), ".");
	}

}
