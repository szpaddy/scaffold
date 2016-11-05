package com.scaffold.core.demo.service;

import java.util.List;

import com.scaffold.core.demo.entity.User;

public interface IUserService {

	public List<User> getUserList();

	public User getUserByUid(String userId);
}
