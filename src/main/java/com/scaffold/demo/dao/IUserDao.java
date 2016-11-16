package com.scaffold.demo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.scaffold.common.vo.User;

@Repository("userDao")
public interface IUserDao {

	public void addUser(User user);

	public void editUser(User user);

	public void delUser(String userId);

	public List<User> getUserList();

	public User getUserByUid(String userId);
}
