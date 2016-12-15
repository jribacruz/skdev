package br.skdev.core.context;

import java.util.List;

import br.skdev.core.component.SelectManyEClass;
import br.skdev.core.component.SelectOneEClass;

public class ComponentContext {

	public String value(String id, SelectOneEClass selectOneEClass) {
		return "";
	}

	public List<String> value(String id, SelectManyEClass selectManyEClass) {
		return null;
	}
}
