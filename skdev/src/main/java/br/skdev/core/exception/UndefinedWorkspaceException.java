package br.skdev.core.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Workspace não definido")
public class UndefinedWorkspaceException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
