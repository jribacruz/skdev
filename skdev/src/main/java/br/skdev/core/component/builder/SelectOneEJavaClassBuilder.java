package br.skdev.core.component.builder;

import java.io.Serializable;
import java.util.Set;

import br.skdev.core.Selectable;
import br.skdev.core.component.ActionDialog;
import br.skdev.core.component.SelectOneEJavaClass;

/**
 * 
 * @author jcruz
 *
 */
public class SelectOneEJavaClassBuilder implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ActionDialog actionDialog;

	private SelectOneEJavaClass selectOneEJavaClass;

	public SelectOneEJavaClassBuilder(ActionDialog actionDialog, SelectOneEJavaClass selectOneEJavaClass) {
		super();
		this.actionDialog = actionDialog;
		this.selectOneEJavaClass = selectOneEJavaClass;
	}

	public SelectOneEJavaClassBuilder required() {
		this.selectOneEJavaClass.setRequired(true);
		return this;
	}

	public <S extends Selectable> SelectOneEJavaClassBuilder options(Set<S> selectables) {
		return this;
	}
	
	public <S extends Selectable> SelectOneEJavaClassBuilder updateOnChange(String targetId, Set<S> selectables) {
		return this;
	}

	public ActionDialog build() {
		return actionDialog;
	}

}
