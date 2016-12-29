package br.skdev.core.cache;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import br.skdev.core.model.EWorkspace;

@Component
public class EWorkspaceCache implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private EWorkspace workspace;

	public EWorkspace getWorkspace() {
		return workspace;
	}

	public void setWorkspace(EWorkspace workspace) {
		this.workspace = workspace;
	}

}
