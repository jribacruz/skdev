package br.skdev.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.skdev.core.model.EWorkspace;
import br.skdev.core.repository.WorkspaceRepository;

@Service
public class WorkspaceService {

	@Autowired
	private WorkspaceRepository workspaceRepository;

	public EWorkspace load(String path) {
		return workspaceRepository.load(path);
	}

}
