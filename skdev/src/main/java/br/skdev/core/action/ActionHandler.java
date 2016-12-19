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

	//// @formatter:off
	/*
	public default String getSuccess() throws IOException {
		ClassPathResource classPathResource = new ClassPathResource(String.format("/static/actions/%s/success.md", getId()));
		File file = classPathResource.getFile();
		FileReader fileReader = new FileReader(file);
		Parser parser = Parser.builder().build();
		Node document = parser.parseReader(fileReader);
		HtmlRenderer renderer = HtmlRenderer.builder().build();
		return renderer.render(document);
	}
	*/
	// @formatter:on
}
