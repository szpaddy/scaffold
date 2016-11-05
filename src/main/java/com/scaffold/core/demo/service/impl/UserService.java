package com.scaffold.core.demo.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.scaffold.core.demo.dao.IUserDao;
import com.scaffold.core.demo.entity.User;
import com.scaffold.core.demo.service.IUserService;

@Service
public class UserService implements IUserService {
	@Resource
	private IUserDao userDao;

	@Override
	public List<User> getUserList() {
		return userDao.getUserList();
	}

	@Override
	public User getUserByUid(String userId) {
		return userDao.getUserByUid(userId);
	}

}
