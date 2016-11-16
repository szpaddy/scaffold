package com.scaffold.common.aop.aspect;

import org.apache.commons.lang3.time.StopWatch;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MethodTimeAspect {
	private static final Logger logger = LoggerFactory.getLogger(MethodTimeAspect.class);

	@Around("execution(* *..controller..*(..)) || execution(* *..service..*(..))")
	public Object around(ProceedingJoinPoint joinPoint) {
		Object result = null;
		StopWatch clock = new StopWatch();
		clock.start();
		try {
			result = joinPoint.proceed();
		} catch (Throwable e) {
		}
		clock.stop();

		long time = clock.getTime();
		String timeInfo = time + "ms";
		if (time > 1000) {
			timeInfo = time / 1000 + "s + " + time % 1000 + "ms";
		}

		logger.debug(joinPoint.toLongString() + " Takes:" + timeInfo);
		return result;
	}
}