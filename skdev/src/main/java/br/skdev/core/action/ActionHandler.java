package br.skdev.core.action;

import java.io.IOException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import br.skdev.core.annotation.Action;
import br.skdev.core.context.ActionContext;
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
	public abstract void execute(ActionContext ctx);

	/**
	 * Retorna o Id da Action.
	 * 
	 * @return
	 */
	public default String getId() {
		if (this.getClass().isAnnotationPresent(Action.class)) {
			if (!this.getClass().getAnnotation(Action.class).id().isEmpty()) {
				return this.getClass().getAnnotation(Action.class).id();
			}
		}
		return Strman.toCamelCase(this.getClass().getSimpleName());
	}

	/**
	 * 
	 * @return
	 * @throws IOException
	 */
	public default String getDialogTemplatePath() throws IOException {
		if (this.getClass().isAnnotationPresent(Action.class)) {
			if (!this.getClass().getAnnotation(Action.class).dialogTemplatePath().isEmpty()) {
				return this.getClass().getAnnotation(Action.class).dialogTemplatePath();
			}
		}
		return String.format("/actions/%s/dialogTemplate.html", getId());
	}

	/**
	 * 
	 * @return
	 */
	public default Set<String> getGroup() {
		if (this.getClass().isAnnotationPresent(Action.class)) {
			return new HashSet<>(Arrays.asList(getClass().getAnnotation(Action.class).groups()));
		}
		return new HashSet<>();
	}
}
