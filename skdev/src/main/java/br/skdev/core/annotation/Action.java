package br.skdev.core.annotation;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonAnyGetter;

/**
 * 
 * @author jcruz
 *
 */
@Retention(RUNTIME)
@Target(TYPE)
@Component
@JsonAnyGetter
public @interface Action {
	/**
	 * 
	 * @return
	 */
	String description();

	/**
	 * 
	 * @return
	 */
	String dialogTemplatePath() default "";

	/**
	 * 
	 * @return
	 */
	String[] groups();

	/**
	 * 
	 * @return
	 */
	String id() default "";

}
