package br.skdev.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.skdev.core.MavenFolder;
import br.skdev.core.action.Action;
import br.skdev.core.builder.ActionDialogBuilder;
import br.skdev.core.builder.ActionHeaderBuilder;
import br.skdev.core.context.UIComponentContext;
import br.skdev.core.context.WorkspaceContext;

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
	}

}
