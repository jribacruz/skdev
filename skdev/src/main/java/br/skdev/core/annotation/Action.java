package br.skdev.core.annotation;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import org.springframework.stereotype.Component;

/**
 * 
 * @author jcruz
 *
 */
@Retention(RUNTIME)
@Target(TYPE)
@Component
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
	String group() default "";

	/**
	 * 
	 * @return
	 */
	String id() default "";

	/**
	 * 
	 * @return
	 */
	br.skdev.core.annotation.Endpoint[] endpoints() default {};

}
