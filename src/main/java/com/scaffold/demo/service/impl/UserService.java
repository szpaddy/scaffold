package com.scaffold.demo.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.scaffold.common.vo.User;
import com.scaffold.demo.dao.IUserDao;
import com.scaffold.demo.service.IUserService;

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
