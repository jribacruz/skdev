package br.skdev.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.skdev.core.context.WorkspaceContext;
import br.skdev.core.model.EWorkspace;

@Service
public class WorkspaceService {

	@Autowired
	private WorkspaceContext workspaceContext;

	public void load(String path) {
		EWorkspace workspace = new EWorkspace(path);
		workspaceContext.setWorkspace(workspace);
	}
}
