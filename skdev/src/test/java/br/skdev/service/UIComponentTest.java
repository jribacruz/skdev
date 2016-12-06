package br.skdev.service;

import br.skdev.core.component.ActionDialog;
import br.skdev.core.component.SelectOneEJavaClass;

public class UIComponentTest {

	public static void main(String[] args) {
		ActionDialog actionDialog = new ActionDialog("dialog1", "Action");
		actionDialog.add(new SelectOneEJavaClass("selectJavaClass1", "Selecione a classe de domínio"));

		System.out.println(actionDialog.buildTemplate());
	}

}
