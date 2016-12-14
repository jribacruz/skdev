package br.skdev.core.action;

import java.io.Serializable;

import br.skdev.core.context.UIComponentContext;

/**
 * 
 * @author jcruz
 *
 */
public interface ActionHandler extends Serializable {

	/**
	 * 
	 */
	public abstract void execute(UIComponentContext ctx);

}
