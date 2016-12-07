package br.skdev.core.service;

import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.skdev.core.MavenFolder;
import br.skdev.core.context.WorkspaceContext;
import br.skdev.core.model.EJavaClass;
import br.skdev.core.predicate.DomainClassPredicate;

/**
 * 
 * @author jcruz
 *
 */
@Service
public class ProjectService {

	@Autowired
	private WorkspaceContext workspaceContext;

	/**
	 * 
	 * @return
	 */
	public SortedSet<EJavaClass> findAllDomainEJavaClasses() {
		// @formatter:off
		return workspaceContext.getJavaProject().getEJavaClasses(MavenFolder.SRC_MAIN_JAVA)
				.stream()
				.filter(new DomainClassPredicate())
				.collect(Collectors.toCollection(TreeSet::new));
		// @formatter:on
	}

}
