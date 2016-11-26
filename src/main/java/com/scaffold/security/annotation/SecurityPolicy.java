package com.scaffold.security.annotation;

public enum SecurityPolicy {
	/**
	 * 所有人都可访问，即无权限控制
	 */
	ALL,
	/**
	 * 任何已登录的用户
	 */
	USER_LOGGED_IN,
	/**
	 * 拥有特定角色的用户
	 */
	USER_ROLE
}
