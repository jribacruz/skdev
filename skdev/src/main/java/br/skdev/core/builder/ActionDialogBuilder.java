package br.skdev.core.builder;

import java.io.Serializable;

import br.skdev.core.component.ActionDialog;
import br.skdev.core.component.InputText;
import br.skdev.core.component.SelectManyEJavaClass;
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

	public ActionDialogBuilder title(String title) {
		this.actionDialog.setTitle(title);
		return this;
	}

	public SelectOneEJavaClassBuilder selectOneEJavaClass(String id, String label) {
		return new SelectOneEJavaClassBuilder(this, actionDialog, new SelectOneEJavaClass(id, label));
	}
	
	public SelectManyEJavaClassBuilder selectManyEJavaClass(String id, String label) {
		return new SelectManyEJavaClassBuilder(this, actionDialog, new SelectManyEJavaClass(id, label));
	}

	public InputTextBuilder inputText(String id, String label) {
		return new InputTextBuilder(this, actionDialog, new InputText(id, label));
	}

	public void buildActionDialog() {
		actionDialog.setTemplate(actionDialog.buildUIComponentTemplateFragment());
	}

}
