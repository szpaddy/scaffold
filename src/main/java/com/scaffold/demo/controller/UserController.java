package com.scaffold.demo.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.scaffold.common.vo.User;
import com.scaffold.demo.service.IUserService;

@RestController
@RequestMapping("/users")
public class UserController {
	@Resource
	private IUserService userService;

	@RequestMapping("userList")
	public List<User> getUserList() {
		return userService.getUserList();
	}

	@RequestMapping(value = "getUserByUid/{userId}", method = RequestMethod.GET)
	public User getUserByUid(@PathVariable("userId") String userId) {
		return userService.getUserByUid(userId);
	}

}