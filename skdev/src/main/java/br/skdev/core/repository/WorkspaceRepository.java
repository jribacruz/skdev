package br.skdev.core.repository;

import java.nio.file.Files;
import java.nio.file.Paths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.skdev.core.cache.EWorkspaceCache;
import br.skdev.core.exception.WorkspaceNotFoundException;
import br.skdev.core.model.EWorkspace;
import br.skdev.core.proxy.EWorkspaceProxy;

@Repository
public class WorkspaceRepository {

	private Logger log = LoggerFactory.getLogger(WorkspaceRepository.class);

	@Autowired
	private EWorkspaceCache cache;

	public EWorkspace load(String path) {
		if (Files.notExists(Paths.get(path))) {
			throw new WorkspaceNotFoundException();
		}
		if (cache.getWorkspace() != null && cache.getWorkspace().getPath().equals(path)) {
			log.info("Retornando Workspace do Cache.");
			return cache.getWorkspace();
		}
		cache.setWorkspace(new EWorkspaceProxy(path));
		return cache.getWorkspace();
	}

}
