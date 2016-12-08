package br.skdev.core;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import br.skdev.core.component.ActionDialog;

/**
 * 
 * @author jcruz
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
public class ActionInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ActionHeader header;

	private ActionDialog dialog;

	public ActionHeader getHeader() {
		return header;
	}

	public void setHeader(ActionHeader header) {
		this.header = header;
	}

	public ActionDialog getDialog() {
		return dialog;
	}

	public void setDialog(ActionDialog dialog) {
		this.dialog = dialog;
	}

}
