package br.skdev.core;

import java.io.Serializable;

import br.skdev.core.component.ActionDialog;
import br.skdev.core.component.builder.ActionDialogBuilder;
import br.skdev.core.component.builder.ActionHeaderBuilder;

/**
 * 
 * @author jcruz
 *
 */
public abstract class Action implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ActionInfo actionInfo = new ActionInfo();;

	public void prepareActionHeader() {
		if (actionInfo.getHeader() == null) {
			this.actionInfo.setHeader(new ActionHeader());
			this.configureActionHeader(new ActionHeaderBuilder(this.actionInfo.getHeader()));
		}
	}

	public void prepareActionDialog() {
		this.prepareActionHeader();
		this.actionInfo.setDialog(
				new ActionDialog(this.actionInfo.getHeader().getId(), this.actionInfo.getHeader().getTitle()));
		this.configureActionDialog(new ActionDialogBuilder(this.actionInfo.getDialog()));
	}

	public ActionInfo getActionInfo() {
		return this.actionInfo;
	}

	/**
	 * 
	 */
	public abstract void execute();

	/**
	 * 
	 * @param actionDialog
	 */
	protected abstract void configureActionDialog(ActionDialogBuilder actionDialog);

	/**
	 * 
	 * @param actionHeader
	 */
	protected abstract void configureActionHeader(ActionHeaderBuilder actionHeader);

}
