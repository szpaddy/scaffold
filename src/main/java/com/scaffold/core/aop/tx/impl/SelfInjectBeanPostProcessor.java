package com.scaffold.core.aop.tx.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import com.scaffold.core.aop.tx.ISelfInject;

@Component
public class SelfInjectBeanPostProcessor implements BeanPostProcessor {
	private static final Logger logger = LoggerFactory.getLogger(SelfInjectBeanPostProcessor.class);

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		if (bean instanceof ISelfInject) {
			logger.debug("ISelfInject bean:" + beanName);
			((ISelfInject) bean).setSelf(bean);
		}
		return bean;
	}

}
