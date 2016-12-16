package com.scaffold.security.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.scaffold.security.vo.User;

@Repository("securityUserDao")
public interface UserDao {

	/**
	 * 创建用户
	 * 
	 * @param user
	 */
	public User createUser(User user);

	/**
	 * 更新用户
	 * 
	 * @param user
	 * @return
	 */
	public User updateUser(User user);

	/**
	 * 删除用户
	 * 
	 * @param userId
	 */
	public void deleteUser(Long userId);

	/**
	 * 根据ID得到对象
	 * 
	 * @param userId
	 * @return
	 */
	public User findOne(Long userId);

	/**
	 * 返回所有用户列表
	 * 
	 * @return
	 */
	public List<User> findAll();

	/**
	 * 根据用户名查找用户
	 * 
	 * @param username
	 * @return
	 */
	public User findByUsername(String username);

}
