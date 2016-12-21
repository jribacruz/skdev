package br.skdev.core.service;

import java.util.Optional;
import java.util.SortedSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.skdev.core.model.EClass;
import br.skdev.core.model.EMavenFolder;
import br.skdev.core.model.EMavenProject;
import br.skdev.core.model.EPackage;
import br.skdev.core.repository.ProjectRepository;
import br.skdev.core.util.FS;

/**
 * 
 * @author jcruz
 *
 */
@Service
public class ProjectService {

	@Autowired
	private ProjectRepository projectRepository;

	@Autowired
	private FS fs;

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

	/**
	 * Cria um diretório no projeto.
	 * 
	 * @param eMavenProject
	 * @param eMavenFolder
	 * @param path
	 */
	public void mkdir(EMavenProject eMavenProject, EMavenFolder eMavenFolder, String path) {
		String finalPath = fs.normalize(eMavenProject.getAbsolutePath(), eMavenFolder.getPath(), path);
		log.info("[mkdir] path={}", finalPath);
		fs.mkdir(finalPath);
	}

	/**
	 * Cria um diretório no projeto.
	 * 
	 * @param eMavenProject
	 * @param mavenFolder
	 * @param ePackage
	 * @param path
	 */
	public void mkdir(EMavenProject eMavenProject, EMavenFolder eMavenFolder, EPackage ePackage, String path) {
		String finalPath = fs.normalize(eMavenProject.getAbsolutePath(), eMavenFolder.getPath(), ePackage.getDirectory(), path);
		log.info("[mkdir] path={}", finalPath);
		fs.mkdir(finalPath);
	}

}
