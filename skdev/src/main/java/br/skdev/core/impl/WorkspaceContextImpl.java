package br.skdev.core.impl;

import org.springframework.stereotype.Component;

import br.skdev.core.context.WorkspaceContext;
import br.skdev.core.model.EJavaProject;
import br.skdev.core.model.EWorkspace;

@Component
public class WorkspaceContextImpl implements WorkspaceContext {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private EWorkspace workspace;

	private EJavaProject project;

	@Override
	public EWorkspace getWokspace() {
		return this.workspace;
	}

	@Override
	public void setWorkspace(EWorkspace workspace) {
		this.workspace = workspace;
	}

	@Override
	public void setJavaProject(EJavaProject project) {
		this.project = project;
	}

	@Override
	public EJavaProject getJavaProject() {
		return this.project;
	}

}
