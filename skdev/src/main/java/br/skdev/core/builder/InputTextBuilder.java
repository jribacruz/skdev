package br.skdev.core.builder;

import java.io.Serializable;

import br.skdev.core.component.ActionDialog;
import br.skdev.core.component.InputText;

/**
 * 
 * @author jcruz
 *
 */
public class InputTextBuilder implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ActionDialogBuilder actionDialogBuilder;

	private ActionDialog actionDialog;

	private InputText inputText;

	public InputTextBuilder(ActionDialogBuilder actionDialogBuilder, ActionDialog actionDialog, InputText inputText) {
		super();
		this.actionDialogBuilder = actionDialogBuilder;
		this.actionDialog = actionDialog;
		this.inputText = inputText;
	}

	public ActionDialogBuilder build() {
		this.actionDialog.add(inputText.getId(), inputText);
		return actionDialogBuilder;
	}

}
