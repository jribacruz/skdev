package br.skdev.core.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY)
// @formatter:off
@JsonSubTypes({
	@JsonSubTypes.Type(value=EClass.class, name = "EClass"),
	@JsonSubTypes.Type(value = EAttribute.class, name = "EAttribute"),
	@JsonSubTypes.Type(value = EMethod.class, name = "EMethod"),
	@JsonSubTypes.Type(value = EString.class, name = "EString") 
})
// @formatter:on
public class ETemplateModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
