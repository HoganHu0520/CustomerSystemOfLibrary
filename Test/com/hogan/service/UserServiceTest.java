package com.hogan.service;

import org.junit.Before;
import org.junit.Test;

import com.hogan.exception.ParameterException;
import com.hogan.exception.ServiceException;
import com.hogan.model.User;
import com.hogan.util.ApplicationContextUtil;

public class UserServiceTest {
	private UserService userService;
	
	@Before
	public void initUserService() {
		userService = ApplicationContextUtil.getBean("userService");
	}
	
	@Test
	public void loginTest() {
		try {
			User user = userService.login("1127160850", "password");
			System.out.println(user);
		} catch (ParameterException e) {
			System.out.println(e);
		} catch (ServiceException e) {
			System.out.println(e);
		}
	}
}
