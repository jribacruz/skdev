package br.skdev.core.context;

import java.io.Serializable;

import br.skdev.core.model.EJavaProject;
import br.skdev.core.model.EWorkspace;

/**
 * 
 * @author jcruz
 *
 */
public interface WorkspaceContext extends Serializable {

	/**
	 * 
	 * @return
	 */
	EWorkspace getWokspace();

	/**
	 * 
	 * @param workspace
	 */
	void setWorkspace(EWorkspace workspace);

	/**
	 * 
	 * @param project
	 */
	void setJavaProject(EJavaProject project);

	/**
	 * 
	 * @return
	 */
	EJavaProject getJavaProject();
}
