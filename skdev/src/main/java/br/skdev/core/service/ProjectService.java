package br.skdev.core.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.SortedSet;

import org.apache.commons.io.FilenameUtils;
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
	 * @param name
	 * @return
	 */
	public Optional<EMavenProject> findByName(String name) {
		return projectRepository.findByName(name);
	}

	/**
	 * 
	 * @param mavenProject
	 * @param path
	 * @throws IOException
	 */
	public void createDir(EMavenProject mavenProject, String path) throws IOException {
		String npath = FilenameUtils.normalize(String.format("%s/%s", mavenProject.getAbsolutePath(), path));
		if (Files.notExists(Paths.get(npath))) {
			log.info("Criando diretório: {}", npath);
			Files.createDirectories(Paths.get(path));
			return;
		}
		log.info("Diretório já existe: {}", npath);
	}

}
