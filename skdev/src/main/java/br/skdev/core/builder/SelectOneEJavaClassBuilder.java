package br.skdev.core.builder;

import java.io.Serializable;
import java.util.Set;
import java.util.SortedSet;

import br.skdev.core.Selectable;
import br.skdev.core.component.ActionDialog;
import br.skdev.core.component.SelectOneEJavaClass;
import br.skdev.core.util.OptionsEndpoint;

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

	private ActionDialogBuilder actionDialogBuilder;

	private ActionDialog actionDialog;

	private SelectOneEJavaClass selectOneEJavaClass;

	public SelectOneEJavaClassBuilder(ActionDialogBuilder actionDialogBuilder, ActionDialog actionDialog,
			SelectOneEJavaClass selectOneEJavaClass) {
		super();
		this.actionDialogBuilder = actionDialogBuilder;
		this.actionDialog = actionDialog;
		this.selectOneEJavaClass = selectOneEJavaClass;
	}

	public SelectOneEJavaClassBuilder required() {
		this.selectOneEJavaClass.setRequired(true);
		return this;
	}

	public <S extends Selectable> SelectOneEJavaClassBuilder options(SortedSet<S> selectables) {
		this.selectOneEJavaClass.setOptions(selectables);
		return this;
	}

	public SelectOneEJavaClassBuilder options(OptionsEndpoint endpoint) {
		return this;
	}

	public <S extends Selectable> SelectOneEJavaClassBuilder updateOnChange(String targetId, Set<S> selectables) {
		return this;
	}

	public ActionDialogBuilder build() {
		this.actionDialog.add(selectOneEJavaClass.getId(), selectOneEJavaClass);
		return actionDialogBuilder;
	}

}
