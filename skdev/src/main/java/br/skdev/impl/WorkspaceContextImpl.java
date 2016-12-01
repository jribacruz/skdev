package br.skdev.impl;

import org.springframework.stereotype.Component;

import br.skdev.context.WorkspaceContext;

@Component
public class WorkspaceContextImpl implements WorkspaceContext {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String projectName;

	@Override
	public void setProject(String name) {
		this.projectName = name;
	}

	@Override
	public String getProject() {
		return this.projectName;
	}

}
