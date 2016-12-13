package br.skdev.action;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import br.skdev.core.MavenFolder;
import br.skdev.core.action.Action;
import br.skdev.core.builder.ActionDialogBuilder;
import br.skdev.core.builder.ActionHeaderBuilder;
import br.skdev.core.component.SelectOneEJavaClass;
import br.skdev.core.context.UIComponentContext;
import br.skdev.core.context.WorkspaceContext;
import br.skdev.core.model.EJavaClass;
import br.skdev.core.util.OptionsEndpoint;

/**
 * 
 * @author jcruz
 *
 */
@Component
public class TestAction extends Action {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private WorkspaceContext workspaceContext;

	/**
	 * 
	 */
	@Override
	public void configureActionHeader(ActionHeaderBuilder actionHeader) {
		// @formatter:off
		actionHeader
			.title("Ação de Teste");
		// @formatter:on
	}

	/**
	 * 
	 */
	@Override
	public void configureActionDialog(ActionDialogBuilder actionDialog) {
		// @formatter:off
		actionDialog.title("Geração de Teste")
			.selectOneEJavaClass("selectJavaClass", "Selecione a classe java")
				.options(OptionsEndpoint.findAllDomainClasses())
				.required()
				.build()
			.inputText("daoName", "Nome do DAO")
				.build()
			.selectManyEJavaClass("selectJavaClases", "Selecione as entidades")
				.options(workspaceContext.getJavaProject().getEJavaClasses(MavenFolder.SRC_MAIN_JAVA))
				.build()
		.buildActionDialog();
		// @formatter:on
	}

	/**
	 * 
	 */
	@Override
	public void execute(UIComponentContext ctx) {
		
		ClassPathResource classPathResource = new ClassPathResource("file.fm");
		
		try {
			File file = classPathResource.getFile();
			FileReader fileReader = new FileReader(file);
			BufferedReader in = new BufferedReader(fileReader);
			System.out.println(in.readLine());
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		Optional<EJavaClass> eJavaClass = ctx.getValue("selectJavaClass", SelectOneEJavaClass.class);
		if (eJavaClass.isPresent()) {
			System.out.println("JavaClass: " + eJavaClass.get().getFullyQualifiedName());
		}

	}

}
