package com.scaffold.demo.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.scaffold.core.aop.tx.ISelfInject;
import com.scaffold.demo.dao.IDemoDao;
import com.scaffold.demo.service.IDemoService;
import com.scaffold.demo.vo.User;

@Service
public class DemoService implements IDemoService, ISelfInject {
	// 解决Spring AOP在同一个类里自身方法相互调用时无法拦截问题
	private IDemoService self;

	@Resource
	private IDemoDao userDao;

	@Override
	public List<User> getUserList() {
		return userDao.getUserList();
	}

	@Override
	public User getUserByUid(String userId) {
		return userDao.getUserByUid(userId);
	}

	@Override
	public void addUser(User user) {
		userDao.addUser(user);
		userDao.addUser(user);
	}

	@Override
	public void editUser(User user) {
		userDao.editUser(user);
	}

	@Override
	public void delUser(String userId) {
		userDao.delUser(userId);
	}

	@Override
	public void selfInjectDemo() {
		// 插入一条正常数据，也可能是日志或数据状态修改
		// noTxDemo();// 最终结果noTxDemo操作的数据被回滚
		self.noTxDemo();// 最终结果noTxDemo操作的数据不会被回滚

		// 插入一条ID重复的异常数据
		addUser(new User(30, "aa", 10, "xx"));

	}

	@Override
	public void noTxDemo() {
		// 不在事务中执行，执行后数据马上提交到数据库
		userDao.addUser(new User(32, "aa", 10, "xx"));
	}

	@Override
	public void setSelf(Object bean) {
		self = (IDemoService) bean;
	}

}
