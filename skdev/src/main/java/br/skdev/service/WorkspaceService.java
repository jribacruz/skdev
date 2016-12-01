package br.skdev.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.skdev.context.WorkspaceContext;
import br.skdev.model.Workspace;

@Service
public class WorkspaceService {

	@Autowired
	private WorkspaceContext workspaceContext;

	public void load(String path) {
		Workspace workspace = new Workspace(path);
		workspaceContext.setWorkspace(workspace);
	}
}
