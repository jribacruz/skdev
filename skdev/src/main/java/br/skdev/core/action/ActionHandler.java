package br.skdev.core.action;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;

import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;
import org.springframework.core.io.ClassPathResource;

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
