package com.scaffold.demo.service;

import java.util.List;

import com.scaffold.common.vo.User;

public interface IUserService {

	public void addUser(User user);

	public void editUser(User user);

	public void delUser(String userId);

	public List<User> getUserList();

	public User getUserByUid(String userId);
}
