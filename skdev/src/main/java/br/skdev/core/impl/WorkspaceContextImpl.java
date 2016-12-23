package br.skdev.core.impl;

import org.springframework.stereotype.Component;

import br.skdev.core.context.WorkspaceContext;
import br.skdev.core.exception.UndefinedWorkspaceException;
import br.skdev.core.model.EWorkspace;

@Component
public class WorkspaceContextImpl implements WorkspaceContext {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private EWorkspace workspace;

	@Override
	public EWorkspace getWokspace() {
		if (this.workspace == null) {
			throw new UndefinedWorkspaceException();
		}
		return this.workspace;
	}

	@Override
	public void setWorkspace(EWorkspace workspace) {
		this.workspace = workspace;
	}

}
