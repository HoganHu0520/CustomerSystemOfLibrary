package com.hogan.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.hogan.dao.UserDao;
import com.hogan.model.User;
import com.hogan.service.UserService;

public class UserServiceImpl implements UserService {
	
	private UserDao userDao;
	
	@Autowired
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	public UserServiceImpl() {}

	@Override
	public void login(String userId, String password) {
		User loginUser = new User();
		loginUser.setUserId(userId);
		
		User dbUser = userDao.getByUserId(loginUser);
		if (dbUser.getPassword().equals(password)) {
			System.out.println("Login Successed!");
		} else {
			System.out.println("Login failed!");
		}
	}

}
