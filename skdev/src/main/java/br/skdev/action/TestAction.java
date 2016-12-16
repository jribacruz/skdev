package br.skdev.action;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.skdev.core.action.ActionHandler;
import br.skdev.core.annotation.Action;
import br.skdev.core.annotation.Endpoint;
import br.skdev.core.context.ActionComponentContext;

/**
 * 
 * @author jcruz
 *
 */
@Action(description = "Ação de Teste", endpoints = { @Endpoint(id = "selectDomainClassId", path = "/api/project/domain/classes") })
public class TestAction implements ActionHandler {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Logger log = LoggerFactory.getLogger(TestAction.class);

	/**
	 * 
	 */
	@Override
	public void execute(ActionComponentContext ctx) {

		log.info("[execute] ctx={}", ctx);
		// System.out.println(ctx);

		/*
		 * ClassPathResource classPathResource = new
		 * ClassPathResource("file.fm");
		 * 
		 * try { File file = classPathResource.getFile(); FileReader fileReader
		 * = new FileReader(file); BufferedReader in = new
		 * BufferedReader(fileReader); System.out.println(in.readLine());
		 * 
		 * } catch (IOException e) { e.printStackTrace(); } finally {
		 * 
		 * }
		 */

	}

}
