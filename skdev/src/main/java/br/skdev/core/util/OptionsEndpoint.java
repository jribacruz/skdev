package br.skdev.core.util;

public class OptionsEndpoint {

	private String url;

	private OptionsEndpoint(String url) {
		super();
		this.url = url;
	}

	public String getUrl() {
		return url;
	}

	public static OptionsEndpoint of(String url) {
		return new OptionsEndpoint(url);
	}

	public static OptionsEndpoint findAllDomainClasses() {
		return new OptionsEndpoint("/skdev/api/project/domain/classes");
	}

}
