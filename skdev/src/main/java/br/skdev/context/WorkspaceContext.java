package br.skdev.context;

import java.io.Serializable;

import br.skdev.model.EJavaProject;
import br.skdev.model.EWorkspace;

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

	void setJavaProject(EJavaProject project);

	EJavaProject getJavaProject();
}
