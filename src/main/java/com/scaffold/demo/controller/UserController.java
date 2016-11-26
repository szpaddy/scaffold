package com.scaffold.demo.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.scaffold.common.vo.User;
import com.scaffold.demo.service.IUserService;
import com.scaffold.security.annotation.Operation;
import com.scaffold.security.annotation.SecurityPolicy;

@RestController
@RequestMapping("/users")
public class UserController {
	@Resource
	private IUserService userService;

	@RequestMapping("userList")
	public List<User> getUserList() {
		return userService.getUserList();
	}

	@Operation(name = "根据用户ID查询用户信息", security = SecurityPolicy.USER_LOGGED_IN)
	@RequestMapping(value = "getUserByUid/{userId}")
	public User getUserByUid(@PathVariable("userId") String userId) {
		return userService.getUserByUid(userId);
	}

	@Operation(name = "事务测试", security = SecurityPolicy.ALL)
	@RequestMapping(value = "txTest")
	public void txTest() {
		User user = new User(32, "aa", 10, "xx");
		userService.addUser(user);
	}

	@RequestMapping(value = "selfInjectDemo")
	public void selfInjectDemo() {
		userService.selfInjectDemo();
	}

}