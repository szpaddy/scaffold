package com.scaffold.core.demo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.scaffold.core.demo.entity.User;

@Repository("userDao")
public interface IUserDao {
	public int checkUserExits(User user);

	public void addUser(User user);

	public void editUser(User user);

	public void delUser(String userId);

	public List<User> getUserList();

	public User getUserByUid(String userId);
}
