package br.skdev.impl;

import org.springframework.stereotype.Component;

import br.skdev.context.WorkspaceContext;
import br.skdev.model.Workspace;

@Component
public class WorkspaceContextImpl implements WorkspaceContext {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Workspace workspace;

	@Override
	public Workspace getWokspace() {
		return this.workspace;
	}

	@Override
	public void setWorkspace(Workspace workspace) {
		this.workspace = workspace;
	}

}
