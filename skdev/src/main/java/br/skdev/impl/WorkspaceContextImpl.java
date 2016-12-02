package br.skdev.impl;

import org.springframework.stereotype.Component;

import br.skdev.context.WorkspaceContext;
import br.skdev.model.EJavaProject;
import br.skdev.model.EWorkspace;

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
