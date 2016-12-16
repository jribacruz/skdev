package br.skdev.core.service;

import java.util.SortedSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.skdev.core.context.WorkspaceContext;
import br.skdev.core.model.EClass;

/**
 * 
 * @author jcruz
 *
 */
@Service
public class ProjectService {

	@Autowired
	private WorkspaceContext workspaceContext;

	public SortedSet<EClass> findAllClasses() {
		return workspaceContext.getMavenProject().getClasses();
	}

}
