package br.skdev.core.action;

import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import br.skdev.core.annotation.Action;
import br.skdev.core.annotation.Endpoint;
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
	 * Retorna os endpoints Rest.
	 * 
	 * @return
	 * @throws IOException
	 */
	public default Map<String, String> getEndpoints() throws IOException {
		Map<String, String> endpointMap = new HashMap<>();
		if (this.getClass().isAnnotationPresent(Action.class)) {
			if (this.getClass().getAnnotation(Action.class).endpoints().length > 0) {
				for (int i = 0; i < this.getClass().getAnnotation(Action.class).endpoints().length; i++) {
					Endpoint endpoint = this.getClass().getAnnotation(Action.class).endpoints()[i];
					endpointMap.put(endpoint.id(), endpoint.path());
				}
			}
		}
		return endpointMap;
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
