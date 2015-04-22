package com.hogan.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.hogan.dao.UserDao;
import com.hogan.exception.ParameterException;
import com.hogan.exception.ServiceException;
import com.hogan.model.User;
import com.hogan.service.UserService;
import com.hogan.util.StringUtil;

public class UserServiceImpl implements UserService {

	private UserDao userDao;

	@Autowired
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public UserServiceImpl() {
	}

	@Override
	public User login(String userId, String password)
			throws ParameterException, ServiceException {
		ParameterException parameterException = new ParameterException();

		if (StringUtil.isEmpty(userId)) {
			parameterException.addErrorField("userName", "User id is required");
		}
		if (StringUtil.isEmpty(password)) {
			parameterException.addErrorField("password", "Password is require");
		}
		if (parameterException.isErrorField()) {
			throw parameterException;
		}

		User loginUser = new User();
		loginUser.setUserId(userId);

		User dbUser = userDao.getByUserId(loginUser);

		if (dbUser == null) {
			throw new ServiceException(1000, "用户不存在");
		}

		if (!password.equals(dbUser.getPassword())) {
			throw new ServiceException(1001, "密码不对");
		}

		return dbUser;
	}

}
