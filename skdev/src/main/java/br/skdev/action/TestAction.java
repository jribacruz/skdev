package br.skdev.action;

import org.springframework.beans.factory.annotation.Autowired;

import br.skdev.core.Action;
import br.skdev.core.MavenFolder;
import br.skdev.core.component.builder.ActionDialogBuilder;
import br.skdev.core.context.WorkspaceContext;

public class TestAction extends Action {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private WorkspaceContext workspaceContext;

	@Override
	public void execute() {
	}

	@Override
	public void createActionDialog(ActionDialogBuilder actionDialog) {
		actionDialog
			.selectOneEJavaClass("selectDomainClass", "Selecione a classe de domínio.")
				.options(workspaceContext.getJavaProject().getEJavaClasses(MavenFolder.SRC_MAIN_JAVA))
				.updateOnChange("selectDomainClassAttribues", workspaceContext.getJavaProject().getEJavaClasses(MavenFolder.SRC_MAIN_JAVA))
				.required()
			.build();
	}

}
