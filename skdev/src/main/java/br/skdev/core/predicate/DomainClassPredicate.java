package br.skdev.core.predicate;

import java.util.Arrays;
import java.util.function.Predicate;

import org.apache.commons.lang3.StringUtils;

import br.skdev.core.model.EClass;

public class DomainClassPredicate implements Predicate<EClass> {

	@Override
	public boolean test(EClass t) {
		return Arrays.asList(StringUtils.split(t.getPackageName(), ".")).contains("domain")
				|| t.hasAnnotationByName("Entity");
	}

}
