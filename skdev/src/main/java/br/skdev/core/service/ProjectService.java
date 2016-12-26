package br.skdev.core.service;

import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.skdev.core.model.EClass;
//github.com/jribacruz/skdev.git
import br.skdev.core.model.EMavenProject;
import br.skdev.core.model.ESourceFolder;
import br.skdev.core.model.EWorkspace;
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
	public EMavenProject findByName(EWorkspace eWorkspace, String projectName) {
		return projectRepository.findByName(eWorkspace, projectName);
	}

	/**
	 * 
	 * @param eMavenProject
	 * @return
	 */

	public SortedSet<EClass> findMainEClasses(EMavenProject eMavenProject) {
		//// @formatter:off
		return projectRepository.findAllEClasses(eMavenProject)
					.stream()
					.filter(eClass -> eClass.getSourceFolder().equals(ESourceFolder.SRC_MAIN_JAVA))
					.collect(Collectors.toCollection(TreeSet::new));
		// @formatter:on
	}

}
