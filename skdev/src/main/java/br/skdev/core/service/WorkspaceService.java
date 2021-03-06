package br.skdev.core.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.skdev.core.model.EMavenProject;
import br.skdev.core.model.EWorkspace;
import br.skdev.core.repository.WorkspaceRepository;

@Service
public class WorkspaceService {

	@Autowired
	private WorkspaceRepository workspaceRepository;

	private Logger log = LoggerFactory.getLogger(WorkspaceRepository.class);

	public EWorkspace load() {
		EWorkspace eWorkspace = workspaceRepository.load();
		log.info("[load] Total de projetos do workspace: {}", eWorkspace.getMavenProjects().size());
		return eWorkspace;
	}
	
	public EMavenProject createProject(EMavenProject project) {
		return workspaceRepository.createProject(project);
	}

}
