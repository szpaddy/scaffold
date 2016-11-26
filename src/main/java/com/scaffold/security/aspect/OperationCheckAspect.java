package com.scaffold.security.aspect;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.scaffold.security.annotation.Operation;
import com.scaffold.security.annotation.SecurityPolicy;

@Component
@Aspect
public class OperationCheckAspect {
	private static final Logger logger = LoggerFactory.getLogger(OperationCheckAspect.class);

	/** 类上注解情形 */
	@Pointcut("execution(* *..controller..*(..)) && @within(com.scaffold.security.annotation.Operation)")
	public void classAspect() {

	}

	/** 方法上注解情形 */
	@Pointcut("execution(* *..controller..*(..)) && @annotation(com.scaffold.security.annotation.Operation)")
	public void methodAspect2() {

	}

	/**
	 * aop实际拦截两种情形
	 * 
	 * @throws Throwable
	 */
	@Before("classAspect() || methodAspect2()")
	public void doBefore(JoinPoint point) {
		Class<?> classz = point.getTarget().getClass();
		Method m = ((MethodSignature) point.getSignature()).getMethod();
		if (classz != null && m != null) {
			boolean isClzAnnotation = classz.isAnnotationPresent(Operation.class);
			boolean isMethondAnnotation = m.isAnnotationPresent(Operation.class);
			Operation operation = null;
			// 如果方法和类声明中同时存在这个注解，那么方法中的会覆盖类中的设定。
			if (isMethondAnnotation) {
				operation = m.getAnnotation(Operation.class);
			} else if (isClzAnnotation) {
				operation = classz.getAnnotation(Operation.class);
			}
			if (operation != null && operation.security() != null) {
				// 此处进行权限检查
				logger.debug("method:{} operation:{} security:{}", point.getSignature().toShortString(),
						operation.name(), operation.security());
				if (operation.security() != SecurityPolicy.ALL) {
					throw new SecurityException("security check failed");
				}
			}
		}
	}
}