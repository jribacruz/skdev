package br.skdev.core.action;

import java.io.IOException;
import java.io.Serializable;

import br.skdev.core.annotation.Action;
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
	public abstract void execute();

	public default String getId() {
		if (this.getClass().isAnnotationPresent(Action.class)) {
			if (!this.getClass().getAnnotation(Action.class).id().isEmpty()) {
				return this.getClass().getAnnotation(Action.class).id();
			}
		}
		return Strman.toCamelCase(this.getClass().getSimpleName());
	}

	public default String getConfig() throws IOException {
		return String.format("/actions/%s/config.json", getId());
	}

	public default String getComponent() throws IOException {
		return String.format("/actions/%s/component.html", getId());
	}

}
