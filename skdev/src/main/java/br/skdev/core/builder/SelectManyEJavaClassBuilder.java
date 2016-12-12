package br.skdev.core.builder;

import java.io.Serializable;
import java.util.Set;
import java.util.SortedSet;

import br.skdev.core.Selectable;
import br.skdev.core.component.ActionDialog;
import br.skdev.core.component.SelectManyEJavaClass;

/**
 * 
 * @author jcruz
 *
 */
public class SelectManyEJavaClassBuilder implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ActionDialogBuilder actionDialogBuilder;

	private ActionDialog actionDialog;

	private SelectManyEJavaClass selectManyEJavaClass;

	public SelectManyEJavaClassBuilder(ActionDialogBuilder actionDialogBuilder, ActionDialog actionDialog,
			SelectManyEJavaClass selectManyEJavaClass) {
		super();
		this.actionDialogBuilder = actionDialogBuilder;
		this.actionDialog = actionDialog;
		this.selectManyEJavaClass = selectManyEJavaClass;
	}

	public SelectManyEJavaClassBuilder required() {
		this.selectManyEJavaClass.setRequired(true);
		return this;
	}

	public <S extends Selectable> SelectManyEJavaClassBuilder options(SortedSet<S> selectables) {
		this.selectManyEJavaClass.setOptions(selectables);
		return this;
	}

	public <S extends Selectable> SelectManyEJavaClassBuilder updateOnChange(String targetId, Set<S> selectables) {
		return this;
	}

	public ActionDialogBuilder build() {
		this.actionDialog.add(selectManyEJavaClass.getId(), selectManyEJavaClass);
		return actionDialogBuilder;
	}

}
