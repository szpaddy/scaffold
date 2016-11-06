package com.scaffold.demo.service;

import java.util.List;

import com.scaffold.common.vo.User;

public interface IUserService {

	public List<User> getUserList();

	public User getUserByUid(String userId);
}
