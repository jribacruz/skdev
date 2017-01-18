package br.skdev.core.service;

import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.skdev.core.model.EClass;
import br.skdev.core.model.EDirectory;
import br.skdev.core.model.EFile;
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
	
	public SortedSet<EClass> findMainDomainEClasses(EMavenProject eMavenProject) {
		//// @formatter:off
		return projectRepository.findAllEClasses(eMavenProject)
					.stream()
					.filter(eClass -> eClass.getSourceFolder().equals(ESourceFolder.SRC_MAIN_JAVA))
					.filter(eClass -> eClass.getAnnotations().stream().anyMatch(ann -> ann.getName().endsWith("Entity")))
					.collect(Collectors.toCollection(TreeSet::new));
		// @formatter:on
	}

	
	public Set<EDirectory> findDirectories(EMavenProject eMavenProject) {
		return projectRepository.findDirectories(eMavenProject);
	}
	
	/**
	 * 
	 * @param eMavenProject
	 * @param eDirectory
	 */
	public void createDirectory(EMavenProject eMavenProject, EDirectory eDirectory) {
		projectRepository.createDirectory(eMavenProject, eDirectory);
	}
	
	
	public void createFile(EMavenProject eMavenProject, EFile eFile) {
		projectRepository.createFile(eMavenProject, eFile);
	}
}
