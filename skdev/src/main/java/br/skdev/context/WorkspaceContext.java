package br.skdev.context;

import java.io.Serializable;

public interface WorkspaceContext extends Serializable {

	void setProject(String name);

	String getProject();
}
