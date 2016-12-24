package br.skdev.core.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXTERNAL_PROPERTY)
// @formatter:off
@JsonSubTypes({
	@JsonSubTypes.Type(value=EClass.class, name = "EClass"),
	@JsonSubTypes.Type(value = EAttribute.class, name = "EAttribute"),
	@JsonSubTypes.Type(value = EMethod.class, name = "EMethod") 
})
// @formatter:on
public class EModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
