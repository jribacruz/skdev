package br.skdev.core.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.skdev.core.model.EWorkspace;
import br.skdev.core.repository.WorkspaceRepository;

@Service
public class WorkspaceService {

	@Autowired
	private WorkspaceRepository workspaceRepository;

	public Optional<EWorkspace> findWorkspace() {
		EWorkspace workspace = workspaceRepository.findWorkspace();
		return Optional.ofNullable(workspace);
	}

	public void insert(String path) {
		workspaceRepository.insertWorkspace(path);
	}

	public EWorkspace load(String path) {
		return workspaceRepository.load(path);
	}

}
