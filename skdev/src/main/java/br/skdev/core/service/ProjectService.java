package br.skdev.core.service;

import java.util.Optional;
import java.util.SortedSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

	private Logger log = LoggerFactory.getLogger(ProjectService.class);

	/**
	 * 
	 * @param projectName
	 * @return
	 */
	public SortedSet<EClass> findAllClasses(String projectName) {
		return projectRepository.findAllClasses(projectName);
	}

	/**
	 * 
	 * @param projectName
	 * @return
	 */
	public Optional<EMavenProject> findByName(String projectName) {
		return projectRepository.findByName(projectName);
	}

}
