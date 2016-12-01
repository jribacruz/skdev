package br.skdev.context;

import java.io.Serializable;

import br.skdev.model.Project;
import br.skdev.model.Workspace;

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
	Workspace getWokspace();

	/**
	 * 
	 * @param workspace
	 */
	void setWorkspace(Workspace workspace);

	void setProject(Project project);

	Project getProject();
}
