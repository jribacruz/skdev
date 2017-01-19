package br.skdev.core.repository;

import java.nio.file.Files;
import java.nio.file.Paths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.skdev.core.cache.EWorkspaceCache;
import br.skdev.core.configuration.SKDevConfig;
import br.skdev.core.exception.WorkspaceNotFoundException;
import br.skdev.core.model.EMavenProject;
import br.skdev.core.model.EWorkspace;
import br.skdev.core.proxy.EWorkspaceProxy;
import br.skdev.core.util.FS;

@Repository
public class WorkspaceRepository {

	private Logger log = LoggerFactory.getLogger(WorkspaceRepository.class);

	@Autowired
	private EWorkspaceCache cache;
	
	@Autowired
	private SKDevConfig skDevConfig;
	
	private FS fs = new FS();

	public EWorkspace load() {
		if (Files.notExists(Paths.get(skDevConfig.getWorkspace()))) {
			throw new WorkspaceNotFoundException();
		}
		if (cache.getWorkspace() != null && cache.getWorkspace().getPath().equals(skDevConfig.getWorkspace())) {
			log.info("Retornando Workspace do Cache.");
			return cache.getWorkspace();
		}
		cache.setWorkspace(new EWorkspaceProxy(skDevConfig.getWorkspace()));
		return cache.getWorkspace();
	}
	
	public EMavenProject createProject(EMavenProject project) {
		project.setAbsolutePath(skDevConfig.getWorkspace().concat("/").concat(project.getName()));
		fs.mkdir(project.getAbsolutePath());
		cache.setWorkspace(null);
		return project;
	}
	
}
