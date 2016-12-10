package br.skdev.core.component.builder;

import java.io.Serializable;

import br.skdev.core.component.ActionDialog;
import br.skdev.core.component.SelectOneEJavaClass;

/**
 * 
 * @author jcruz
 *
 */
public class ActionDialogBuilder implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ActionDialog actionDialog;

	public ActionDialogBuilder(ActionDialog actionDialog) {
		super();
		this.actionDialog = actionDialog;
	}

	public SelectOneEJavaClassBuilder selectOneEJavaClass(String id, String label) {
		return new SelectOneEJavaClassBuilder(this, actionDialog, new SelectOneEJavaClass(id, label));
	}

	public void buildActionDialog() {
		actionDialog.setTemplate(actionDialog.buildUIComponentTemplateFragment());
	}

}
