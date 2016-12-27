package br.skdev.core.repository;

import java.nio.file.Files;
import java.nio.file.Paths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import br.skdev.core.exception.WorkspaceNotFoundException;
import br.skdev.core.model.EWorkspace;
import br.skdev.core.proxy.EWorkspaceProxy;

@Repository
public class WorkspaceRepository {

	private Logger log = LoggerFactory.getLogger(WorkspaceRepository.class);

	public EWorkspace load(String path) {
		if (Files.notExists(Paths.get(path))) {
			throw new WorkspaceNotFoundException();
		}
		return new EWorkspaceProxy(path);
	}

}
