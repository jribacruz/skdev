package br.skdev.core.service;

import java.util.Optional;
import java.util.SortedSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.skdev.core.model.EClass;
import br.skdev.core.model.EMavenProject;
import br.skdev.core.repository.ProjectRepository;

/**
 * 
 * @author jcruz
 *
 */
@Service
public class ProjectService {

	@Autowired
	private ProjectRepository projectRepository;

	public SortedSet<EClass> findAllClasses(String projectName) {
		return projectRepository.findAllClasses(projectName);
	}

	public Optional<EMavenProject> findByName(String name) {
		return projectRepository.findByName(name);
	}

}
