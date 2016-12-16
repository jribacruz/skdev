package br.skdev.core.action;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;
import org.springframework.core.io.ClassPathResource;

import br.skdev.core.annotation.Action;
import br.skdev.core.annotation.Endpoint;
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

	public default String getDialogTemplateURL() throws IOException {
		return String.format("/actions/%s/component.html", getId());
	}

	public default String getSuccess() throws IOException {
		ClassPathResource classPathResource = new ClassPathResource(String.format("/static/actions/%s/success.md", getId()));
		File file = classPathResource.getFile();
		FileReader fileReader = new FileReader(file);
		Parser parser = Parser.builder().build();
		Node document = parser.parseReader(fileReader);
		HtmlRenderer renderer = HtmlRenderer.builder().build();
		return renderer.render(document);
	}

}
