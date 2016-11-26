package com.scaffold.security.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Operation {
	/**
	 * 操作名称
	 * 
	 * @return
	 */
	String name() default "";

	/**
	 * 操作权限要求，默认所有人都能操作
	 * 
	 * @return
	 */
	SecurityPolicy security() default SecurityPolicy.ALL;
}
