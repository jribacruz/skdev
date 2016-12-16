package br.skdev.core.context;

import java.io.Serializable;

import br.skdev.core.model.EMavenProject;
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
	void setMavenProject(EMavenProject project);

	/**
	 * 
	 * @return
	 */
	EMavenProject getMavenProject();
}
