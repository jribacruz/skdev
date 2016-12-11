package br.skdev.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.skdev.core.Action;
import br.skdev.core.component.builder.ActionDialogBuilder;
import br.skdev.core.component.builder.ActionHeaderBuilder;
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

	@Override
	protected void configureActionHeader(ActionHeaderBuilder actionInfo) {
		// @formatter:off
		actionInfo
			.title("Ação de Teste")
			.description("Descrição do Teste.");
		// @formatter:on
	}

	@Override
	protected void configureActionDialog(ActionDialogBuilder actionDialog) {
		// @formatter:off
		actionDialog
			.selectOneEJavaClass("selectJavaClass", "Selecione a classe java")
			.build()
		.buildActionDialog();
		// @formatter:on
	}

	@Override
	public void execute() {
	}

}
