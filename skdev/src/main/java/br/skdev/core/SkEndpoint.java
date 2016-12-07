package br.skdev.core;

public class SkEndpoint {

	private String url;

	private SkEndpoint(String url) {
		super();
		this.url = url;
	}

	public String getUrl() {
		return url;
	}

	public static SkEndpoint of(String url) {
		return new SkEndpoint(url);
	}

}
