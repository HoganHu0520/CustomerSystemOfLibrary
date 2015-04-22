package com.hogan.service;

import com.hogan.exception.ParameterException;
import com.hogan.exception.ServiceException;
import com.hogan.model.User;

public interface UserService {
	public User login(String username, String password) throws ParameterException, ServiceException;
}
