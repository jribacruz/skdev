package br.skdev.core.action;

import java.io.Serializable;

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

	/**
	 * 
	 */
	public abstract void execute();

	/**
	 * 
	 * @param actionDialog
	 */
	public abstract void configureActionDialog(ActionDialogBuilder actionDialog);

	/**
	 * 
	 * @param actionHeader
	 */
	public abstract void configureActionHeader(ActionHeaderBuilder actionHeader);

}
