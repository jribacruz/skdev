package br.skdev.action;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.core.io.ClassPathResource;

import br.skdev.core.action.ActionHandler;
import br.skdev.core.annotation.Action;
import br.skdev.core.annotation.Endpoint;

/**
 * 
 * @author jcruz
 *
 */
@Action(description = "Ação de Teste", endpoints = {
		@Endpoint(id = "selectDomainClassId", path = "/api/project/domain/classes") })
public class TestAction implements ActionHandler {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@Override
	public void execute() {

		ClassPathResource classPathResource = new ClassPathResource("file.fm");

		try {
			File file = classPathResource.getFile();
			FileReader fileReader = new FileReader(file);
			BufferedReader in = new BufferedReader(fileReader);
			System.out.println(in.readLine());

		} catch (IOException e) {
			e.printStackTrace();
		} finally {

		}

	}

}
