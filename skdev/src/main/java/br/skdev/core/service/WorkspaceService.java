package br.skdev.core.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.skdev.core.context.WorkspaceContext;
import br.skdev.core.model.EWorkspace;
import br.skdev.core.proxy.EWorkspaceProxy;
import br.skdev.core.repository.WorkspaceRepository;

@Service
public class WorkspaceService {

	@Autowired
	private WorkspaceContext workspaceContext;

	@Autowired
	private WorkspaceRepository workspaceRepository;

	public void load(String path) {
		EWorkspace workspace = new EWorkspaceProxy(path);
		workspaceContext.setWorkspace(workspace);
	}

	public Optional<EWorkspace> findWorkspace() {
		EWorkspace workspace = workspaceRepository.findWorkspace();
		return Optional.ofNullable(workspace);
	}
	
	public void insert(String path) {
		workspaceRepository.insertWorkspace(path);
	}
	

}
