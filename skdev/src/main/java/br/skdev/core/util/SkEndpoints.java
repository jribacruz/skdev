package br.skdev.core.util;

public class SkEndpoints {

	public static final SkEndpoint findAllDomainEJavaClasses = endpoint("/api/project/domain/classes");

	private static SkEndpoint endpoint(String url) {
		return SkEndpoint.of(url);
	}
}
