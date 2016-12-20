package br.skdev.core.action;

import java.io.IOException;
import java.io.Serializable;

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
	
	
	public default String getGroup() {
		if (this.getClass().isAnnotationPresent(Action.class)) {
			if (!this.getClass().getAnnotation(Action.class).group().isEmpty()) {
				return this.getClass().getAnnotation(Action.class).group();
			}
		}
		return "";
	}
}
